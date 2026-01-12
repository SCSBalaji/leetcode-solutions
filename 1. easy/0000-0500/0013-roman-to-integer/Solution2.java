import java.util.*;
// LeetCode #0013: Roman To Integer
// Approach: Left To Right Pass Improved
// Status: ✅ Accepted
// Time: O(1)  |  Space: O(1)

class Solution {
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
        values.put("CM", 900);
        values.put("CD", 400);
        values.put("XC", 90);
        values.put("XL", 40);
        values.put("IX", 9);
        values.put("IV", 4);
    }
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while(i < s.length()) {
            if(i < s.length() - 1) {
                String doubleSymbol = s.substring(i, i + 2);
                if(values.containsKey(doubleSymbol)) {
                    sum += values.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }
            String singleSymbol = s.substring(i, i + 1);
            sum += values.get(singleSymbol);
            i++;
        }
        return sum;
    }
}