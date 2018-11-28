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

<h1>BASE:<b>${baseCurrency}</b></h1>
<table>
    <tr>
        <th>Currency</th>
        <th>Exchange</th>
    </tr>
    <c:forEach var="tempKey" items="${currencyKeysList}" varStatus="Count">
    <td>${tempKey}</td>
    <td>${currencyValuesList[Count.index]}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
