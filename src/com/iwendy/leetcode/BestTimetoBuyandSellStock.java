package com.iwendy.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)return 0;
        int res = 0;
        int preMax = 0;// the max profit
        for(int i=1; i<prices.length; i++){
        	// the most minor before i is prices[i-1]-preMax
        	preMax = prices[i] - (prices[i-1] - preMax);
        	if(preMax < 0)// the i is most minor
        	{
        		preMax = 0;
        	}
        	if(preMax > res)
        	{
        		res = preMax;
        	}
        }
        
        return res;
    }
}
