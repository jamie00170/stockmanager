<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="yahoofinance.histquotes.HistoricalQuote" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Stock History</title>
</head>
<%@ include file="header.jsp" %>
<body>
	<%
	
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");	
	
		ArrayList<HistoricalQuote> history = (ArrayList<HistoricalQuote>) request.getAttribute("history");
		if (history != null){
			for (HistoricalQuote hq : history){
				String formatted = format1.format(hq.getDate().getTime());
				out.print("Closing price of " + hq.getSymbol() + " on " + formatted + " was " + hq.getClose());
				out.print("<br/>");
			}
		}
	%>
</body>
</html>