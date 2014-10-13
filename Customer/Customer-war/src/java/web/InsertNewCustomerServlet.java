/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CustomerEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viraji
 */
@WebServlet(name = "InsertNewCustomerServlet", urlPatterns = {"/InsertNewCustomerServlet"})
public class InsertNewCustomerServlet extends HttpServlet {

    @Resource(mappedName = "jms/NewMessage1Factory")
    private ConnectionFactory connectionFactory;
    
    @Resource(mappedName = "jms/NewMessage1")
    private Queue queue;
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
            throws ServletException, IOException, JMSException {
        response.setContentType("text/html;charset=UTF-8");
        Long cusid = 0L;
        if(request.getParameter("cusid") != null){
            String cus = request.getParameter("cusid");
            System.out.print(cus);
            cusid = Long.parseLong(cus);
        }
        else{
            cusid =0L;
        }
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        
        if ((name != null) && (address != null) && (cusid != null) && (contact != null)) {
            try {
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false,
                        Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer =
                        session.createProducer(queue);

                ObjectMessage message = session.createObjectMessage();
                // here we create NewsEntity, that will be sent in JMS message
                CustomerEntity e = new CustomerEntity();
                e.setId(cusid);
                e.setName(name);
                e.setAddress(address);
                e.setContactNo(contact);

                message.setObject(e);
                messageProducer.send(message);
                messageProducer.close();
                connection.close();
                response.sendRedirect("ListCustomerServlet");

            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertNewCustomerServlet</title>");  
           out.println("<link rel='stylesheet' href='pure-min.css'>"); 
            
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<h1>Insert Customer</h1>");
            
            out.println("<form class='pure-form pure-form-aligned'>");
            
            out.println("<fieldset><div class='pure-control-group'>");
            out.println("<label for='cusid'>Customer ID: </label><input type='text' name='cusid' placeholder='Customer ID'> </div>");
           
            out.println("<div class='pure-control-group'>");
            out.println("<label for='name'>Customer Name: </label><input type='text' name='name' placeholder='Name'> </div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='address'>Address: </label><input type='text' name='address' placeholder='Address'></div>");

            out.println("<div class='pure-control-group'>");
            out.println("<label for='contact'>Contact No:</label><input type='text' name='contact' placeholder='Telephone'> </div>");

            out.println("<div class='pure-controls'>");
            out.println("<input type='submit' value='Add Customer'></div>");

            out.println("</fieldset></form>");
            out.println("<div>");
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
        try {
            processRequest(request, response);
        } catch (JMSException ex) {
            Logger.getLogger(InsertNewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (JMSException ex) {
            Logger.getLogger(InsertNewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
