<%-- 
    Document   : index
    Created on : Augest 01, 2013, 12:39:00 PM
    Author     : Isurika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='pure-min.css'>
        <title>Customer Order Handling</title>
    </head>
    <body>
    <div class="pure-g">
    <div class="pure-u-1-5">
        <!--
        By default, grid units don't have any margin/padding.
        If you want to add these, put them in a child container.
        -->
        
    </div>

        <div class="pure-u-1-2" style="font-family:Times New Roman">
         <div class="pure-menu pure-menu-open pure-menu-horizontal">
        <a href="#" class="pure-menu-heading" style="font-family:Tahoma; font-size: 30px ; color: black" >Customer Order</a>

        <ul>
            <li class="pure-menu-selected" style="font-family:Times New Roman"><a href="#">Home</a></li>
            <li><a href="InsertNewCustomerServlet">Add Customer</a></li>
            <li><a href="ListCustomerServlet">View Customers</a></li>
            <li><a href="InsertCustomerOrderServlet">Add Orders</a></li>
            <li><a href="ListOrdersServlet">View Orders</a></li>
            
            
            
        </ul>
    </div>
    </div>

    <div class="pure-u-1-5">
        
    </div>
</div>
        <div class="pure-g">
    <div class="pure-u-1-5">
        <!--
        By default, grid units don't have any margin/padding.
        If you want to add these, put them in a child container.
        -->
        
    </div>

    <div class="pure-u-1-2" align='center'>
        <br><br><br><img src="home.jpg">
    </div>

    <div class="pure-u-1-5">
        
    </div>
</div>
       <center><p style="margin-left: 20" align="center"><font face="Arial" color="#000000" size="1">Copyright © 2013 Viraji Isurika. All Rights Reserved.</font></p></center>

   
    </body>
</html>
