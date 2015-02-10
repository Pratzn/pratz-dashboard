<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="data1" value="${requestScope['data1']}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loading Screen</title>
<style>
#loading-screen {
	background: none repeat scroll 0 0 rgba(0, 0, 0, 0.85);
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	opacity: 0.7;
	cursor: wait;
}

#loading-indicator {
	clear: both;
	position: absolute;
	display: block;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.loading-images {
	clear: both;
	position: relative;
	display: block;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

#loadingImageContainer {
	width: 400px;
	height: 400Px;
	-webkit-flex-flow: row wrap; /* Safari 6.1+ */
	-webkit-align-content: space-around; /* Safari 7.0+ */
	display: flex;
	flex-flow: row wrap;
	align-content: space-around;
	display: -webkit-flex;
}
</style>
<script type="text/javascript" language="javascript"
	src="resources/js/jquery.js"></script>
</head>
<body>
	<p>Form - loading screen</p>
	<form action="${pageContext.request.contextPath}/loading1"
		method="post">
		<input type="text" name="data1" value="${data1}" />


		<button type="submit" name="btnSubmit" value="btnSubmit">btnSubmit</button>


		<button type="reset" name="btnReset" value="btnReset">btnReset</button>


		<input type="submit" name="inputSubmit" value="inputSubmit" /> <input
			type="reset" name="inputReset" value="inputReset" />
	</form>

	
	<!-- Start Loading Screen -->
	<div id="loading-screen">
		<div id="loading-indicator">
			<div id="loadingImageContainer">
				<div class="loading-images">
					<img src="resources/images/TTFL_LOGO_Blue.png"></img>
				</div>
				<div class="loading-images">
					<img src="resources/images/loading3.gif"></img>
				</div>
			</div>
		</div>
	</div>
	<!-- End Loading Screen -->
	<script>
		$(function() {
			$('#loading-screen').hide();
			$(':submit').click(function(event) {
				event.preventDefault();
				$('#loading-screen').show();
				setTimeout(function() {
					//$('form').submit();
					$('#loading-screen').hide();
				}, 3000);
				
				
			});
		});
	</script>

</body>
</html>