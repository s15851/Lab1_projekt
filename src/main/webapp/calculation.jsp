<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Calculation</title>
</head>
<body>
    <header class="site-header">
        <div class="vertical">
            <h1 class="page-title"><a href="/">Calculation</a></h1>
        </div>
    </header>

        <table>
            <tr>
                <th width="400">Capital</th>
                <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${credit.capital}" /></td>
            </tr>
            <tr>
                <th>Number of installments</th>
                <td><fmt:formatNumber type="number" value="${credit.installments}" /></td>
            </tr>
            <tr>
                <th>Rate</th>
                <td><fmt:formatNumber type="number" minFractionDigits="2" value="${credit.rate}" /></td>
            </tr>
            <tr>
                <th>Fee</th>
                <td><fmt:formatNumber type="number" minFractionDigits="2" value="${credit.fee}" /></td>
            </tr>   
            <tr>
                <th>Credit Type</th>
                <td>${credit.type}</td>
            </tr>                        
        </table>    
                
        <table border="1">
            <thead>
                <tr>
                    <th>Installment number</th>
                    <th>Installment amount</th>
                    <th>Capital part</th>
                    <th>Interest part</th>
                    <th>Fee part</th>
                    <th>Capital left</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${credit.installmentsList}" var="instalment">
                <tr>
                    <td>${instalment.number}</td>
                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${instalment.installment}" /></td>
                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${instalment.capitalPart}" /></td>
                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${instalment.interestPart}" /></td>
                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${instalment.fee}" /></td>
                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${instalment.capitalLeft}" /></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>        
</body>
</html>