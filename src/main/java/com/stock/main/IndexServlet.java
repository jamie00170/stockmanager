package com.stock.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockData stocks = new StockData();
		
		String ticker = (String) request.getParameter("ticker");
		BigDecimal price = stocks.getStockPrice(ticker);
			
		response.getWriter().append("ticker: " + ticker + "price: " + price.toString());
		request.setAttribute("requestedticker", ticker);
		request.setAttribute("requestedprice", price);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}
}
