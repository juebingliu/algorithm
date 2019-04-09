package com.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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

    static class ListNode {
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode node = new ListNode(0);
        ListNode cur = node;
        int flag = 0;
        while (p != null || q != null) {
            int va1 = (p != null) ? p.val : 0;
            int va2 = (q != null) ? q.val : 0;
            int sum = va1 + va2;
            cur.next = new ListNode(sum + flag - 10);
            flag = sum / 10;
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (flag > 0) {
            cur.next = new ListNode(flag);
        }

        return node.next;
    }

    /**
     * 最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int length = 0;
        StringBuffer sb = new StringBuffer();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            String key = String.valueOf(ch[i]);
            if (map.containsKey(key)) {
                int index = sb.indexOf(key);
                sb.append(key);
                sb = sb.delete(0, index + 1);
                map.remove(key);
                map.put(key, key);
            } else {
                map.put(key, key);
                sb.append(key);
            }
            length = Math.max(sb.length(), length);
        }
        return length;
    }

    /**
     * 寻找两个有序数组的中位数
     * 堆实现
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i<nums1.length; i++) {
            if(mid == 0) {
                mid = nums1[0];
                continue;
            }
            if(nums1[i] <= mid) {
                max.add(nums1[i]);
            }else {
                min.add(nums1[i]);
            }
            if(min.size() - max.size() >= 2) {
                max.add((int) mid);
                mid = min.poll();
            }else if(max.size() - min.size() >= 2) {
                min.add((int) mid);
                mid = max.poll();
            }
        }
        for (int i = 0; i<nums2.length; i++) {
            if(mid == 0) {
                mid = nums2[0];
                continue;
            }
            if(nums2[i] <= mid) {
                max.add(nums2[i]);
            }else {
                min.add(nums2[i]);
            }
            if(min.size() - max.size() >= 2) {
                max.add((int) mid);
                mid = min.poll();
            }else if(max.size() - min.size() >= 2) {
                min.add((int) mid);
                mid = max.poll();
            }
        }
        if((nums1.length + nums2.length) %2 ==0) {
            if(min.size() < max.size()) {
                mid = (mid + max.poll())/2;
            }else {
                mid = (mid + min.poll())/2;
            }
        }
        return mid;
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int length = 0;
        for (int i=0; i<ch.length; i++) {
            
        }
        return null;
    }
}