/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CustomerEntityFacade;
import ejb.CustomerEntity;
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
@WebServlet(name = "ViewCustomerServlet", urlPatterns = {"/ViewCustomerServlet"})
public class ViewCustomerServlet extends HttpServlet {
    @EJB
    private CustomerEntityFacade customerEntityFacade;

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
        request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            String ID = null, Name = null, Address = null, ContactNo = null;
            String value = "";
            value = request.getParameter("cusid");
            System.out.print(value);
            if (value != null) {
                Long val = Long.parseLong(value);
                

                ID = String.valueOf(customerEntityFacade.find(val).getId());
                Name = customerEntityFacade.find(val).getName();
                Address = customerEntityFacade.find(val).getAddress();
                ContactNo = customerEntityFacade.find(val).getContactNo();

            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewCustomerServlet</title>");    
             out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<h1>View Customer</h1>");
 
            
             out.println("<form class='pure-form pure-form-aligned' action='UpdateCustomerServlet'>");
            
            out.println("<fieldset><div class='pure-control-group'>");
            out.println("<label for='cusid'>Customer ID: </label><input type='text' name='customerid'  placeholder='Customer ID' value="+ID+" readonly> </div>");
           
            out.println("<div class='pure-control-group'>");
            out.println("<label for='name'>Customer Name: </label><input type='text' name='name' placeholder='Name' value="+Name+" readonly> </div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='address'>Address: </label><input type='text' name='address' placeholder='Address' value="+Address+" readonly></div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='contact'>Contact No:</label><input type='text' name='contact' placeholder='Telephone' value="+ContactNo+" readonly> </div>");

            out.println("<div class='pure-controls'>");
            out.println("<a href='ListCustomerServlet'>Back to list</a>");

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
