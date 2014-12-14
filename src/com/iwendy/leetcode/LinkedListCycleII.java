package com.iwendy.leetcode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?

-------->前进方向
X      a       Y
o--------------o-
              -   -   b
             -      -
            -       o Z
        c   -       -
               -  -
  如上图.设：链表头是X，环的第一个节点是Y，slow和fast第一次的交点是Z。各段的长度分别是a,b,c，环的长度是L。
  
  1. 第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。
     也就是说,第一次相遇时,fast比slow多走了一个环的距离
     
  2. 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍.
     有 2(a+b) = a+b+c+b，可以得到a=c
     
  3. 我们发现L=b+c=a+b，也就是说，从一开始到二者第一次相遇，循环的次数就等于环的长度。
 */
public class LinkedListCycleII {
  /**
   * 在网上搜集了一下这个问题相关的一些问题，思路开阔了不少，总结如下：
   * 1. 环的长度是多少？
   *    从一开始到二者第一次相遇，循环的次数就等于环的长度
   *    
   * 2. 如何找到环中第一个节点（即Linked List Cycle II）？
   *    结论a=c，那么让两个指针分别从X和Z开始走，每次走一步，那么正好会在Y相遇！也就是环的第一个节点。
   *    
   * 3. 如何将有环的链表变成单链表（解除环）？
   * 4. 如何判断两个单链表是否有交点？如何找到第一个相交的节点？
   *    首先应判断两个单链表是否含有环.
   *    a. 均不含环,这就是 Y 字形的.
   *    a.1 判断是否相交，可以让两个链表均遍历至尾节点，如果尾节点相同，则说明两链表是有交点的.
   *    a.2 相交后，来寻找第一个相交点.
   *        1>算出两个链表的长度差δ，两个指针从表头出发，
   *        之后较长的链表先移动δ步，之后两链表同时移动，直到遇到相同的节点，该节点即为第一个相交点
   *        
   *        2>将其中一个链表首尾相连，检测另一个环的入口即为相交的第一个点。
   *        
   *    b. 一个有环一个无环，显然两链表此时不可能相交，该情况不考虑
   *    
   *    c. 均有环
   *       分别找到两个环的入环点r1,r2，环1的入环点为r1，从r1开始遍历一圈，每个结点与r2比较,完全相同则相交
   *    
   */
  public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null){
      return null;
    }
    
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(fast == slow)
      {
        break;
      }
    }
    
    if(fast.next != null && fast.next.next != null){//说明有环
      slow = head;    //slow从头开始走，
      while (slow != fast) {    //二者相遇在Y点，则退出
          slow = slow.next;
          fast = fast.next;
      }
      return slow;
    }
    
    return null;
  }
  
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
