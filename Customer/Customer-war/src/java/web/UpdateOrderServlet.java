/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.OrdersEntity;
import ejb.OrdersEntityFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viraji
 */
@WebServlet(name = "UpdateOrderServlet", urlPatterns = {"/UpdateOrderServlet"})
public class UpdateOrderServlet extends HttpServlet {
    @EJB
    private OrdersEntityFacade orderEntityFacade;

     String value = "";
     OrdersEntity orders;
    
     String ID = null, Amount = null, Duedate = null, Comment = null;


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
          String id = request.getParameter("orderid");
        String amount = request.getParameter("amount");
        String duedate = request.getParameter("duedate");
        String comment = request.getParameter("comment");
        
        if ((id != null) && (amount != null) && (duedate != null) && (comment != null)) {
            orders = orderEntityFacade.find(Long.parseLong(id));
            orders.setAmount(Double.parseDouble(amount));
            orders.setDueDate(duedate);
            orders.setComment(comment);

            orderEntityFacade.edit(orders);
            response.sendRedirect("ListOrdersServlet");
        }
        
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            value = request.getParameter("orderid");
            
            if (value != null) {
                Long val = Long.parseLong(value);
                ID = String.valueOf(orderEntityFacade.find(val).getId());
                Amount = String.valueOf(orderEntityFacade.find(val).getAmount());
                Duedate = orderEntityFacade.find(val).getDueDate();
                Comment = orderEntityFacade.find(val).getComment();

            }
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateOrderServlet</title>");            
           out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            out.println("</head>");
            out.println("<body>");
             out.println("<div align='center'>");
            out.println("<h1>Update Order</h1>");
 
            
             out.println("<form class='pure-form pure-form-aligned' action='UpdateOrderServlet'>");
            
            out.println("<fieldset><div class='pure-control-group'>");
            out.println("<label for='cusid'>Order ID: </label><input type='text' name='orderid'  placeholder='Order ID' value="+ID+" readonly> </div>");
           
            out.println("<div class='pure-control-group'>");
            out.println("<label for='name'>Amount : </label><input type='text' name='amount' placeholder='Amount' value="+Amount+"> </div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='address'>DueDate : </label><input type='text' name='duedate' placeholder='Due date' value="+Duedate+"></div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='contact'>Comment :</label><input type='text' name='comment' placeholder='Comment' value="+Comment+"> </div>");

            out.println("<div class='pure-controls'>");
            out.println("<input type='submit' value='Update Order'></div>");

            out.println("</fieldset></form>");
            
            out.println("</div>");
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
