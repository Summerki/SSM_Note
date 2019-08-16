<%--
  Created by IntelliJ IDEA.
  User: Summerki
  Date: 2019/8/15
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${ctx}/login" method="post">
        用户名<input type="text" name="username"><br>
        密码<input type="password" name="password"><br>

        <input type="checkbox" name="hobbies" value="篮球">篮球
        <input type="checkbox" name="hobbies" value="singrap">唱跳
        <input type="checkbox" name="hobbies" value="sleepwin">躺赢

        <input type="submit" value="登陆">
    </form>

${sessionScope.people}
${sessionScope.user}
</body>
</html>
