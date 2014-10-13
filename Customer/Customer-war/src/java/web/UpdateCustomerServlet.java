/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CustomerEntity;
import ejb.CustomerEntityFacade;
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
@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/UpdateCustomerServlet"})
public class UpdateCustomerServlet extends HttpServlet {
    @EJB
    private CustomerEntityFacade customerEntityFacade;

     String value = "";
     CustomerEntity cus;
     
    String ID = null, Name = null, Address = null, ContactNo = null;
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

        String id = request.getParameter("customerid");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String contactNo = request.getParameter("contact");

        if ((id != null) && (name != null) && (address != null) && (contactNo != null)) {
            cus = customerEntityFacade.find(Long.parseLong(id));
            cus.setName(name);
            cus.setAddress(address);
            cus.setContactNo(contactNo);

            customerEntityFacade.edit(cus);
            response.sendRedirect("ListCustomerServlet");
        }
        PrintWriter out = response.getWriter();
        System.out.print("cusid" + request.getParameter("customerid"));

        try {


            value = request.getParameter("cusid");
            //System.out.print(value);
            if (value != null) {
                Long val = Long.parseLong(value);
                ID = String.valueOf(customerEntityFacade.find(val).getId());
                Name = customerEntityFacade.find(val).getName();
                Address = customerEntityFacade.find(val).getAddress();
                ContactNo = customerEntityFacade.find(val).getContactNo();

            }
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCustomerServlet</title>");
             out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            out.println("</head>");
            out.println("<body>");
             out.println("<div align='center'>");
            out.println("<h1>Update Customer</h1>");
 
            
             out.println("<form class='pure-form pure-form-aligned' action='UpdateCustomerServlet'>");
            
            out.println("<fieldset><div class='pure-control-group'>");
            out.println("<label for='cusid'>Customer ID: </label><input type='text' name='customerid'  placeholder='Customer ID' value="+ID+" readonly> </div>");
           
            out.println("<div class='pure-control-group'>");
            out.println("<label for='name'>Customer Name: </label><input type='text' name='name' placeholder='Name' value="+Name+"> </div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='address'>Address: </label><input type='text' name='address' placeholder='Address' value="+Address+"></div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='contact'>Contact No:</label><input type='text' name='contact' placeholder='Telephone' value="+ContactNo+"> </div>");

            out.println("<div class='pure-controls'>");
            out.println("<input type='submit' value='Update Customer'></div>");

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
