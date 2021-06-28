<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>


<script>
	$(document).ready(function(){
		$("#test1").click(function(){
			$.ajax({
				url:'${appRoot}/rest05/sub01',
				type: 'post',
				data: '{"id":"korea", "age":30}',
				contentType : 'application/json',
				success : function(data){
					console.log(data);
				},
				error: function(){
					console.log("fail");
				}
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<button id="test1">BUTTON</button>
	
</div>
</body>
</html>