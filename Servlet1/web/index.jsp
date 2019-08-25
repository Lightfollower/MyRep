<%@ page import="sql.SqlRequester" %>
<%@ page import="java.io.FileWriter" %><%--
  Created by IntelliJ IDEA.
  User: Doom
  Date: 28.05.2018
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Залупа</title>
  </head>
  <body>
  <div>Content</div>
  <form id = "C">
    Создать запись <input type="text" name ="C" id = "first"> <input type="submit" for = "first"><br>
      </form>
  <form id = "U">
    Редактировать запись <input type="text" name ="U"> <input type="submit" id = "bik"><br>
  </form>
  <form >
    Удалить запись <input type="text" name = "D"> <input type="submit"><br>
  </form>
  <form >
    Просмотреть запись <input type="text" name = "R" id = "R"> <input for = "R" type="submit"><br>
  </form>
  <%
      String input = request.getParameter("C");
//      FileWriter fileWriter = new FileWriter();
      if(input!=null)
      input=null;
  %>

  <script src="pagescript.js"></script>
  </body>
</html>
