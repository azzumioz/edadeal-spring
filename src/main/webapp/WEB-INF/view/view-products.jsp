<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Товары со скидкой: ${seg.title}</h2>
<br>

<c:url var="urlButton" value="product-request">
    <c:param name="segmentId" value="${segment}"/>
    <c:param name="shopId" value="${shop}"/>
</c:url>

<input type="button" value="Запросить информацию" onclick="window.location.href='${urlButton}'">
<table>
    <tr>
        <th>Описание</th>
        <th>Объем</th>
        <th>Цена по скидке</th>
        <th>Цена старая</th>
        <th>Размер скидки</th>
        <th>Действует до</th>
        <th>Магазин</th>
        <th>Категория</th>
    </tr>
    <c:forEach var="product" items="${allProducts}">
        <tr>
            <td>${product.title}</td>
            <td>${product.quantity}</td>
            <td>${product.priceNew}</td>
            <td>${product.priceOld}</td>
            <td>${product.discount}</td>
            <td>${product.discountDate}</td>
            <td>${product.shop.title}</td>
            <td>${product.segment.title}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
