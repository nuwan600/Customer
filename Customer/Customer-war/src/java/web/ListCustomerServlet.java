/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CustomerEntity;
import ejb.CustomerEntityFacade;
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
@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/ListCustomerServlet"})
public class ListCustomerServlet extends HttpServlet {
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
        
        String id = request.getParameter("cusid");
        if(id != null){
            customerEntityFacade.remove(customerEntityFacade.find(Long.parseLong(id)));
        }
        
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListCustomerServlet</title>");   
            out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<h1>Customer List</h1>");
             List news = customerEntityFacade.findAll();
            
            out.println("<table class='pure-table pure-table-horizontal'>"); 
            out.println("<thead><tr>");
            out.println("<th>Update</th>");
            out.println("<th>Remove</th>");
            out.println("<th>Customer ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Address</th>");
            out.println("<th>Contact No</th>");
            out.println("<th>View</th>");
            out.println("</tr></thead>");
            for (Iterator it = news.iterator(); it.hasNext();) {
                CustomerEntity elem = (CustomerEntity) it.next();
                out.println("<tr>"); 
                out.println("<td><a href='UpdateCustomerServlet?cusid="+elem.getId()+"'>Update</a></td>"); 
                out.println("<td><a href='?cusid="+elem.getId()+"'>Remove</a></td>"); 
                out.println("<td><b>" + elem.getId() + " </b></td>"); 
                out.println("<td><b>" + elem.getName() + " </b></td>"); 
                out.println("<td>"+ elem.getAddress() + "</td> "); 
                out.println("<td>"+ elem.getContactNo() + "</td> ");
                out.println("<td><a href='ViewCustomerServlet?cusid="+elem.getId()+"'>View</a></td>"); 
                out.println("</tr>"); 
            }
            out.println("</table>"); 
            out.println("<div>");
            out.println("<a href='InsertNewCustomerServlet'>Add new Customer</a>");
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
        
        String value="";
        value = request.getParameter("cusid");
        System.out.print(value);
        if(value != null){
            Long val = Long.parseLong(value);
            customerEntityFacade.remove(customerEntityFacade.find(val));
            //response.sendRedirect("ListCustomerServlet");
            response.setIntHeader("Refresh", 0);
        }
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
