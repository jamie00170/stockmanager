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
		// TODO Auto-generated method stub		
		StockData stocks = new StockData();
		BigDecimal price = stocks.getStockPrice("TSLA");
		if (price != null || price != new BigDecimal(0.0)){
			//response.getWriter().append(" TSLA Stock Price: " + price.toString());
			request.setAttribute("price", price);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
				
	}

}
