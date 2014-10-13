/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.OrdersEntityFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.Convert;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viraji
 */
@WebServlet(name = "ViewOrderServelet", urlPatterns = {"/ViewOrderServelet"})
public class ViewOrderServelet extends HttpServlet {

     @EJB
    private OrdersEntityFacade orderEntityFacade;
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
        
        request.getSession(true);
        PrintWriter out = response.getWriter();
        try {
             String id = null,  date = null, comment = null;
            double amount = 0.0;
             String value = "";
            value = request.getParameter("id");
            System.out.print(value);
            if (value != null) {
                Long val = Long.parseLong(value);
                
                id = String.valueOf(orderEntityFacade.find(val).getId());
                amount = orderEntityFacade.find(val).getAmount();
                date = orderEntityFacade.find(val).getDueDate();
                comment = orderEntityFacade.find(val).getComment();
            }
            
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewOrderServelet</title>");    
             out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<h1>View Order</h1>");
 
            
             out.println("<form class='pure-form pure-form-aligned' action='UpdateOrderServlet'>");
            
            out.println("<fieldset><div class='pure-control-group'>");
            out.println("<label for='orderid'>Order ID: </label><input type='text' name='orderid'  placeholder='Order ID' value="+id+" readonly> </div>");
           
            out.println("<div class='pure-control-group'>");
            out.println("<label for='name'>Order Amount: </label><input type='text' name='name' placeholder='Name' value="+amount+" readonly> </div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='address'>Order Date: </label><input type='text' name='address' placeholder='Date' value="+date+" readonly></div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='contact'>Comment:</label><input type='text' name='contact' placeholder='Comment' value="+comment+" readonly> </div>");

            out.println("<div class='pure-controls'>");
            out.println("<a href='ListOrdersServlet'>Back to list</a>");
            out.println("<br/>");
            out.println("<a href='index.jsp'>Back to Home</a>");

            out.println("</fieldset></form>");
            
            out.println("</div>");
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
