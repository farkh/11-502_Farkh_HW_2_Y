<%@ page import="ru.itis.inform.dao.Auto"%>
<%@ page import="java.util.LinkedList"%>

<%--
  Created by IntelliJ IDEA.
  User: farkh
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Auto - JDBC</title>
    </head>
    <body>
        <h1>Here Is The List Of Auto:</h1>
        <table>
           <tr>
               <th>auto_id</th>
               <th>auto_name</th>
           </tr>


            <%
                LinkedList<Auto> autos = (LinkedList)request.getAttribute("autolist");
                for (int i = 0; i < autos.size(); i++) {
            %>

           <tr>
               <td>
                   <%= autos.get(i).getId() %>
               </td>
               <td>
                   <%= autos.get(i).getName() %>
               </td>
            </tr>

            <% } %>
        </table>
        <a href="/">Back</a>

    </body>
</html>
