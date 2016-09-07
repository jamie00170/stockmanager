package com.stock.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import yahoofinance.histquotes.HistoricalQuote;

public class StockHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StockData stockData = new StockData();
		ArrayList<HistoricalQuote> stockHistory = stockData.getStockHistory("GOOG");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("history", stockHistory);
		request.getRequestDispatcher("/history.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
