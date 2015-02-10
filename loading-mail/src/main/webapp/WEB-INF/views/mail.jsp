<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="msg" value="${requestScope['msg']}"></c:set>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-mail</title>
    </head>
    <body>
    	
        <h1>E-mail</h1>
        <p>This is the e-mail service!</p>
        <br/>
        <a href="${pageContext.request.contextPath}/mailSending">Click to send test mail</a>
       
       <c:if test="${not empty msg}">
       		<script>
       			alert('${msg}');
       		</script>
       </c:if>
       
    </body>
</html>
