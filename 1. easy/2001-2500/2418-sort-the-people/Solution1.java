import java.util.*;
// LeetCode #2418: Sort the People
// Approach: HashMap + Sorting
// Status: ✅ Accepted
// Time: O(n log n)  |  Space: O(n)

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;
        Map<Integer, String> heightToNameMap = new HashMap<>();
        for (int i = 0; i < numberOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] sortedNames = new String[numberOfPeople];
        for (int i = numberOfPeople - 1; i >= 0; i--) {
            sortedNames[numberOfPeople - i - 1] = heightToNameMap.get(
                heights[i]
            );
        }
        return sortedNames;
    }
}