<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="/assets/css/home.css">
</head>
<body>

    <form:form modelAttribute="wordObj" method="post" action="/saveWord">
        <form:hidden path="id"/>
        <form:input path="word"/>
        <form:button type="submit">Save</form:button>
    </form:form>

    <c:forEach items="${words}" var="word">
        <form method="get" action="/deleteWord/${word.id}">
            <button class="div">${word.word}</button>
        </form>
    </c:forEach>

</body>
</html>
