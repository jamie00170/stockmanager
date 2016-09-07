package com.stock.main;

import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockData {
	
	public BigDecimal getStockPrice(String tickerSymbol){
		
		try{
			Stock stock = YahooFinance.get(tickerSymbol);
			return stock.getQuote().getPrice();
		}catch (Exception e){
			System.out.println("Ticker symbol not found!");
		}
		
		return new BigDecimal(0.0);		
	}

}
