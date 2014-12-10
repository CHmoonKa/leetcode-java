package com.iwendy.leetcode;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to 
travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, 
otherwise return -1.

Note:
The solution is guaranteed to be unique.
 */
public class GasStation {
	
	/**
	 * 对每一个点进行判断是否ok，如果ok则返回。
	 * 关键是如果不ok，i则需要调整。
	 */
	public int canCompleteCircuit(int[] gas, int[] cost){
		if(gas == null || cost == null ||
	        	gas.length == 0 || cost.length == 0 || gas.length != cost.length)
	        	return -1;
		int len = gas.length;
		
		for(int i=0; i<len; i++){
			int j = 0;
			if((j = isOk(gas,cost,i)) == -1)return i;
			
			i += j;
		}
		
		return -1;
	}
	
	// 返回值，-1代表找到了
	public int isOk(int[] gas, int[] cost, int s){
		int n = gas.length;
		int left = 0;
		for(int j=s; j<(n+s); j++){
			left += (gas[j%n] - cost[j%n]);
			if(left < 0)return j-s;
		}
		
		return -1;
	}
	
	
	public int canCompleteCircuit_2(int[] gas, int[] cost) {
        if(gas == null || cost == null ||
        	gas.length == 0 || cost.length == 0 || gas.length != cost.length)
        	return -1;
        
        int len = gas.length;
        int index = -1;//注意要从-1开始，因为是index+1
        int left = 0;
        int total = 0;//如果总的剩余小于0，则肯定到不了。
        
        for(int i=0; i<len; i++){
        	left += (gas[i] - cost[i]);
        	total += (gas[i] - cost[i]);
        	
        	/**
        	 * 如果剩余小于0，代表在此之前及其本身都不能作为开始。
        	 * gas:  5, 3, 1, ...
        	 * cost: 3, 3, 4, ...
        	 * 如上从0开始，跑到2，不行了。则 <=2的都不行。所以重新从下一个开始。
        	 * 不会存在，一直迭代到 len-1,因为如果len-1,不行，+1就到了0，但是已经从0开始的。
        	 */
        	if(left < 0){
        		index = i;
        		left = 0;
        	}
        }
        if(total < 0)return -1;
        return index+1;
    }
}
