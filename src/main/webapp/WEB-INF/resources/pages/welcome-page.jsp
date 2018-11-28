<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: szerlag
  Date: 2018-11-28
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome in Kanotor</title>
</head>
<body>
<form:form action="/kantor/currency" method="get">
    <input list="basecurrency" name="base">
    <datalist id="basecurrency">
        <option value="PLN"/>
        <option value="USD"/>
        <option value="EUR"/>
    </datalist>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
