<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h2>Check exchange courses:</h2>
<form:form action="/kantor/list" method="get">
    <input list="basecurrency" name="base">
    <datalist id="basecurrency">
        <c:forEach var="tempKey" items="${keysList}">
            <option value="${tempKey}"/>
        </c:forEach>
    </datalist>
    <input type="submit" value="Submit">
</form:form>

Calculate how much money you can get money!
<form:form action="/kantor/exchange/buy" method="get">
    <tr>
        <td>FROM:
            <input list="basecurrency1" name="base">
            <datalist id="basecurrency1">
                <c:forEach var="tempKey" items="${keysList}">
                    <option value="${tempKey}"/>
                </c:forEach>

            </datalist>
        </td>
        <td> TO:
            <input list="outcurrency1" name="out">
            <datalist id="outcurrency1">
                <c:forEach var="tempKey" items="${keysList}">
                    <option value="${tempKey}"/>
                </c:forEach>
            </datalist>
        </td>
        <td>
            <input type="number" name="amount" step="any" min="5" max="100000">
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Buy!">
        </td>
        <td>
        <input type="submit" value="Sell!" formaction="/kantor/exchange/sell">
        </td>
    </tr>
</form:form>
</body>
</html>
