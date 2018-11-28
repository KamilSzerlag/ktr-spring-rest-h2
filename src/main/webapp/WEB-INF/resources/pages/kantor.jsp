<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: szerlag
  Date: 2018-11-28
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KANTOR</title>
</head>
<body>
<table>
<tr>Currency</tr>

<c:forEach var="tempKeys" items="${currencyKeysList}">
    <td>${tempKeys}</td>
</c:forEach>
<c:forEach var="tempValues" items="${currencyValuesList}">
    <td>${tempValues}</td>
</c:forEach>

</table>
</body>
</html>
