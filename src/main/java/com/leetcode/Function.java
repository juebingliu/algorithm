package com.leetcode;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/8 19:30
 * @description
 */
public class Function {

    //两数之和
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            for (int j = i + 1; j <= nums.length - 1; j++) {
                int m = nums[j];
                if (m + k == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    /**
     * 两数相加(链表)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode p = l1;
       ListNode q = l2;
       ListNode node = new ListNode(0);
       ListNode cur = node;
       int flag = 0;
       while (p!=null || q!=null) {
           int va1 = (p!=null)?p.val:0;
           int va2 = (q!=null)?q.val:0;
           int sum = va1 + va2;
           cur.next = new ListNode(sum + flag -10);
           flag = sum / 10;
           cur = cur.next;
           if(p !=null) {p = p.next;}
           if(q !=null) {q = q.next;}
       }
       if (flag > 0) {
           cur.next = new ListNode(flag);
       }

       return node.next;
    }
}