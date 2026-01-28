import java.util.*;
// LeetCode #1249: Minimum Remove to Make Valid Parentheses
// Approach: Stack + Index Set
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            }
            else if(c == ')') {
                if(stack.isEmpty()) {
                    toRemove.add(i);
                }
                else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!toRemove.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}