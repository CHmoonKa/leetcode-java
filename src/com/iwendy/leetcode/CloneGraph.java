package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	  if(node == null) return node;
	  
	  UndirectedGraphNode cloneRoot = new UndirectedGraphNode(node.label);
	  if(node.neighbors == null)return cloneRoot;
	  
	  // 确保每一个对象只建立一次
	  HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
	  hm.put(node, cloneRoot);
	  
	  LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
	  queue.add(node);
	  
	  while(!queue.isEmpty()){
	    UndirectedGraphNode tmp = queue.poll();
	    List<UndirectedGraphNode> neigs = tmp.neighbors;
	    for(UndirectedGraphNode n : neigs){
	      UndirectedGraphNode tmpClone = hm.get(n);
	      if(tmpClone != null){
	        hm.get(tmp).neighbors.add(tmpClone);
	      }else{
	        tmpClone = new UndirectedGraphNode(n.label);
	        hm.get(tmp).neighbors.add(tmpClone);
	        hm.put(n, tmpClone);
	        queue.add(n);
	      }
	    }
	    
	  }
	  
	  return cloneRoot;
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}
