package com.stock.main;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockData {
	
	public BigDecimal getStockPrice(String tickerSymbol){
		
		try{
			Stock stock = YahooFinance.get(tickerSymbol);
			return stock.getQuote().getPrice();
		}catch (IOException e){
			System.out.println("Could not retreive data, check that ticker symbol exists!");
		}
		
		return new BigDecimal(0.0);		
	}

}
