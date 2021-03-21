<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Выберите категорию</h2>
<form:form action="product" modelAttribute="selectForm">

    Раздел <form:select path="segment">
    <form:options items="${segments}" itemValue="id" itemLabel="title"/>
</form:select>

    Магазин <form:select path="shop">
    <form:options items="${shops}" itemValue="id" itemLabel="title"/>
</form:select>

    <input type="submit" value="OK">
</form:form>
</body>
</html>
