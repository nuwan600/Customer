/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CustomerEntityFacade;
import ejb.OrdersEntityFacade;
import ejb.CustomerEntity;
import ejb.OrdersEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viraji
 */
@WebServlet(name = "InsertCustomerOrderServlet", urlPatterns = {"/InsertCustomerOrderServlet"})
public class InsertCustomerOrderServlet extends HttpServlet {
    @EJB
    private OrdersEntityFacade ordersEntityFacade;
    @EJB
    private CustomerEntityFacade customerEntityFacade;
    OrdersEntity order;


    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
        List<CustomerEntity> cusList = customerEntityFacade.findAll();
        
        String id = request.getParameter("id");
        String amount = request.getParameter("amount");
        String date = request.getParameter("date");
        String comment = request.getParameter("comment");
        
         if ((id != null) && (date != null) && (comment != null) && (amount != null)) {

            if (date.length() > 0 && comment.length() > 0 && id.length() > 0 && amount.length() > 0) {
                order = new OrdersEntity();
                order.setAmount(Double.parseDouble(amount));
                order.setComment(comment);
                order.setDueDate(date);

                order.setCustomer(customerEntityFacade.find(Long.parseLong(id)));

                ordersEntityFacade.create(order);
                response.sendRedirect("ListOrdersServlet");

            }
        }
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCustomerOrderServlet</title>");            
            out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<h1>Insert Order</h1>");
            
            out.println("<form class='pure-form pure-form-aligned'>");
            
            out.println("<fieldset><div class='pure-control-group'>");
            out.println("<label for='id'>Customer ID: </label><select name='id'>");
            for (CustomerEntity cus : cusList) {
                out.println("<option>" + cus.getId() + "</option>");

            }
            out.println("</select></div>");
           
            out.println("<div class='pure-control-group'>");
            out.println("<label for='amount'>Amount : </label><input type='text' name='amount' placeholder='Amount'> </div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='date'>Due Date: </label><input type='text' name='date' placeholder='Due Date'></div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='comment'>Comments :</label><input type='text' name='comment' placeholder='Comments'> </div>");

            out.println("<div class='pure-controls'>");
            out.println("<input type='submit' value='Add Order'></div>");

            out.println("</fieldset></form>");
            out.println("<div>");
            out.println("<center></br></br></br><a href='index.jsp'>Back to Home</a></center>");
             out.println("<br/>");
            out.println("<br/>");

            out.println("<center><p style='margin-left: 20' align='center'><font face='Arial' color='#000000' size='1'>Copyright © 2013 Viraji Isurika. All Rights Reserved.</font></p></center>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
