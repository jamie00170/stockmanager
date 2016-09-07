package com.stock.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

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
	
	public ArrayList<HistoricalQuote> getStockHistory(String tickerSymbol) throws IOException{
		
		Calendar from = new GregorianCalendar(2016,7,1);
		Calendar to = new GregorianCalendar(2016, 7, 31);
		Stock stock = YahooFinance.get(tickerSymbol);
		ArrayList<HistoricalQuote> HistQuotes = (ArrayList<HistoricalQuote>) stock.getHistory(from, to, Interval.DAILY);
		return HistQuotes;
		
	}

}
