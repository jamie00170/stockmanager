<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.math.BigDecimal"%>    
<%
	BigDecimal price = (BigDecimal) request.getAttribute("price");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Stock Price Displayer</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/IndexServlet" method="post">
  	Enter a ticker symbol: <br/>
  	<input type="text" name="ticker" ></input>
  	<input type="submit" value="Submit"></input>
  </form>
  <br/>
  <%  if ("POST".equalsIgnoreCase(request.getMethod())) {  
  		if(request.getAttribute("requestedprice") != null){
  	 		out.print("The current price of " + request.getAttribute("requestedticker") + " is: " + request.getAttribute("requestedprice"));
  		} else{
  			out.print("Requested price not specified!");
  		}
  		}
  	%>
</body>
</html>