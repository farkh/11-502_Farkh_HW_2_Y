<%@ page import="ru.itis.inform.dao.User"%>
<%@ page import="java.util.LinkedList"%>

<%--
  Created by IntelliJ IDEA.
  User: farkh
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Users - JDBC</title>
    </head>
    <body>
        <h1>Here Is The List Of Users:</h1>
        <table>
            <tr>
                <th>user_id</th>
                <th>user_name</th>
                <th>age</th>
                <th>city</th>
            </tr>

            <%
                LinkedList<User> users = (LinkedList)request.getAttribute("userlist");
                for (int i = 0; i < users.size(); i++) {
            %>

            <tr>
                <td>
                    <%= users.get(i).getId() %>
                </td>
                <td>
                    <%= users.get(i).getName() %>
                </td>
                <td>
                    <%= users.get(i).getAge() %>
                </td>
                <td>
                    <%= users.get(i).getCity() %>
                </td>
            </tr>

            <% } %>
        </table>
        <a href="/">Back</a>
    </body>
</html>
