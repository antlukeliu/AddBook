<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<link type="text/css" href="resources/framework.css" rel="stylesheet" />
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to the library  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="list">Go to Book List</a>
<br>
<br>
<a href="resources/BookForm.html">Add a Book to the List</a>
</body>
</html>
