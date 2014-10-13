/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CustomerEntity;
import ejb.OrdersEntityFacade;
import ejb.OrdersEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(name = "ListOrdersServlet", urlPatterns = {"/ListOrdersServlet"})
public class ListOrdersServlet extends HttpServlet {
    @EJB
    private OrdersEntityFacade ordersEntityFacade;

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
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewOrdersServlet</title>");            
            out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<h1>Order List</h1>");
             List news = ordersEntityFacade.findAll();
            
            out.println("<table class='pure-table pure-table-horizontal'>"); 
            out.println("<thead><tr>");
            out.println("<th>Update</th>");
            out.println("<th>Remove</th>");
            out.println("<th>Order ID</th>");
            out.println("<th>Due Date</th>");
            out.println("<th>Amount</th>");
            out.println("<th>View</th>");
            out.println("</tr></thead>");
            for (Iterator it = news.iterator(); it.hasNext();) {
                OrdersEntity elem = (OrdersEntity) it.next();
                out.println("<tr>"); 
                out.println("<td><a href='UpdateOrderServlet?orderid="+elem.getId()+"'>Update</a></td>"); 
                out.println("<td><a href='?orderid="+elem.getId()+"'>Remove</a></td>"); 
                out.println("<td><b>" + elem.getId() + " </b></td>"); 
                out.println("<td>"+ elem.getDueDate() + "</td> "); 
                out.println("<td>"+ elem.getAmount() + "</td> ");
                out.println("<td><a href='ViewOrderServelet?id="+elem.getId()+"'>View</a></td>"); 
                out.println("</tr>"); 
            }
            out.println("</table>"); 
            out.println("<div>");
            out.println("<a href='InsertCustomerOrderServlet'>Add new Order</a>");
            out.println("<center><p><a href='index.jsp'>Home</a></p></center>");
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
