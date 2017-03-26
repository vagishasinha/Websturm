<% 
    String s = request.getParameter("state");
    String message= null;
    if(s!=null)
    message="Registation failed.Try again";
    else
    message="";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home</title>
        <link rel="stylesheet" href="styleadmin.css">
    </head>
    <body>
        
        <ul>
  <li><a href="adminhome.jsp">Admin Home</a></li>
  <li><a class="active" href="addadmin.jsp">Add New Admin</a></li>
  <li><a href="verifydocs.jsp">Verify User Documents</a></li>
  <li><a href="userdetails.jsp">Update User</a></li>
  <li><a href="deleteuser.jsp">Delete User</a></li>
  
</ul>

<div style="margin-left:25%;margin-top:10%;padding:1px 16px;height:450px;opacity: 0.8">
  
    <a style="float: right;" href="logout.jsp">Logout</a>   <a style="margin-left: 90%" href="profileadmin.jsp">Profile</a>     
     
    <h1 style="">Register New Admin </h1>
    <br>
    <center> <%=message%> </center><br>
    <form action="AddAdmin" method="get">
        <pre style="font-size:18px;font-family: times_new_roman">
    Name          :  <input type="text" name="name" title="Full Name" required="" autofocus="">

    Id                :  <input type="text" name="id" title="Identification" required="">

    Password    :  <input type="password" name="pass" title="Minimum 6 Characters..." required="">

    Contact       :  <input type="text" name="contact" title="Mobile No." required="">

    Email          :  <input type="text" name="mail" title="Email ID" required="">
                     <br>                           <input type="submit" value="Register">
        </pre>
    </form>
    
</div>
    </body>
</html>
