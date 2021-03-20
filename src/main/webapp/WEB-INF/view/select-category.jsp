<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Выберите категорию</h2>
<form:form action="product" modelAttribute="segment">
    Раздел <form:select path="id">
    <form:options items="${allSegments}" itemValue="id" itemLabel="title"/>
</form:select>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
