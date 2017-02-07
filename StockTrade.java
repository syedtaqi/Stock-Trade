//Imports
import java.util.*;

public class StockTrade {
	//Variables for StockTrade class
	//String variable used to store the stock symbol
		public String tradingSymbol;
	//Integer used to store the day of the trade
		public int tradeDay;
	//Integer used to store the month of the trade
		public int tradeMonth;
	//Integer used to store the year of the trade
		public int tradeYear;
	//Double used to store the highest price of the stock
		public double highPrice;
	//Double used to store the lowest price of the stock
		public double lowPrice;
	//Double used to store the closing price of the stock
		public double closingPrice;
	//Used to hold the number of shares traded on the day specified
		public long volume;
	//Used as a enumerator for the months
		public enum Month {
			Jan, Feb, Mar, Apr,
			May, Jun, Jul, Aug,
			Sep, Oct, Nov, Dec
		}
	
	/**************************************************
	 *   StockTrade Constructor
	 *   +StockTrade (symbol: String, date: String,
	 *	 highPrice: double, lowPrice: double,
	 *   closingPrice: double, volume: long)
	 *   <br>
	 *   Create new Counter
	 *   <br>
	 *   @param symbol Contains the symbol used for the
	 *                 stock in question.
	 *   @param date The date for which the trade applies
	 *   @param highPrice The high price for the day
	 *	 @param lowPrice The low price for the day 
	 *   @param closingPrice The closing for the day
	 *   @param volume The number of shares traded in 
	 *          this stock for the day
	 *   @return n/a
	 **************************************************/
	public StockTrade (String symbol, String date, double highPrice,
					   double lowPrice, double closingPrice, long volume) {
		//Set the symbol of the stock
		this.tradingSymbol = symbol.trim();
		//Set the date of the stock
			String splitDate[];
			splitDate = date.split("-");
			this.tradeMonth = Month.valueOf(splitDate[0]).ordinal() + 1;
			System.out.println();
			this.tradeDay = Integer.parseInt(splitDate[1]);
			this.tradeYear = Integer.parseInt(splitDate[2]);
		//Set the high price of the stock
			this.highPrice = highPrice;
		//Set the low price of the stock
			this.lowPrice = lowPrice;
		//Set the closing price of the stock
			this.closingPrice = closingPrice;
		//Set the volume of the stock
			this.volume = volume;
	}
	
	/**************************************************
	 *   StockTrade Constructor
	 *   <br>
	 *   +StockTrade (aTrade: StockTrade)
	 *   <br>
	 *   Makes a new StockTrade object with the same
	 *   parameters contained in aTrade. In other words
	 *   this is a “copy constructor”.
	 *   <br>
	 *   @param aTrade StockTrade class
	 *   @return n/a
	 **************************************************/
	public StockTrade (StockTrade aTrade) {
		//Copy the values from StockTrade aTrade to current variable
			this.tradingSymbol = aTrade.tradingSymbol;
			this.tradeDay = aTrade.tradeDay;
			this.tradeMonth = aTrade.tradeMonth;
			this.tradeYear = aTrade.tradeYear;
			this.highPrice = aTrade.highPrice;
			this.lowPrice = aTrade.lowPrice;
			this.closingPrice = aTrade.closingPrice;
			this.volume = aTrade.volume;
	}
	/**************************************************
	 *   equals Method
	 *   <br>
	 *   +equals (aTrade: StockTrade): boolean
	 *   <br>
	 *   Returns true if the current StockTrade object
	 *   has identical values to aTrade in all of the
	 *   following variables:
	 *   <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 *   tradingSymbol, tradeDay, tradeMonth, tradeYear.
	 *   @param aTrade StockTrade variable used compare against
	 *   @return Boolean true if identical 
	 **************************************************/
	public boolean equals (StockTrade aTrade) {
		String thisStockInfo[] = null;
		String aTradeStockInfo[] = null;
		String stockInfo = null;
		
		stockInfo = this.toString();
		thisStockInfo = stockInfo.split(" ");
		stockInfo = aTrade.toString();
		aTradeStockInfo = stockInfo.split(" ");
		if(thisStockInfo[0].equals(aTradeStockInfo[0]) &&
				thisStockInfo[1].equals(aTradeStockInfo[1])) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**************************************************
	 *   toString Method
	 *   <br>
	 *   +equals (aTrade: StockTrade): boolean
	 *   <br>
	 *   Returns a string containing selected
	 *   information from the current StockTrade.
	 *   @param StockTrade aTrade to output formatted 
	 *          string from
	 *   @return String of formatted information
	 **************************************************/
	public String toString() {
		String infoString = null;
		//Add stock symbol to information string
			infoString = this.tradingSymbol;
		//Get difference in days and add to informatin string
			Date startDate = new Date(1999,12,31); 
			Date compareDate = new Date(this.tradeYear,this.tradeMonth,this.tradeDay); 
			// mills_per_day = 1000 * 60 * 60 * 24; 
			long dayDifference = (compareDate.getTime() - startDate.getTime()) / 86400000;
			infoString += " " + dayDifference + " ";
		//Add the volume of stock sold to information string
			infoString += this.volume;
		//Return formatted information
			return infoString;
	}
	
	/**************************************************
	 *   main Constructor
	 *   <br>
	 *   Tests the functionality of the StockTrade
	 *   class.
	 *   @param args
	 *   @return n/a
	 **************************************************/
	public static void main(String[] args) {
		//Create new StockTrade object for testing
			StockTrade test = new StockTrade("BCE-T", "Jan-01-2010", 1.01, 1.01, 1.01, 1000);
		//Test toString method
			System.out.println("Testing toString() method:");
			System.out.println(test.toString());
		//Test equals method
			System.out.println("Testing equals method");
			StockTrade test2 = new StockTrade("BCE-T", "Jan-01-2010", 1.01, 1.01, 1.01, 1000);
			System.out.println("Should be equal!");
			if(test.equals(test2) == true) {
				System.out.println("\tYes, they are equal!");
			}
			else {
				System.out.println("\tNo, they are not Equal!");
			}
			test2 = new StockTrade("BCE-T", "Jan-01-2011", 1.01, 1.01, 1.01, 1000);
			System.out.println("Should not be equal!");
			if(test.equals(test2) == true) {
				System.out.println("\tYes, they are equal!");
			}
			else {
				System.out.println("\tNo, they are not Equal!");
			}
	}

}
