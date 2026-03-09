import java.util.*;
// LeetCode #0888: Fair Candy Swap
// Approach: Math + HashSet Lookup
// Status: ✅ Accepted
// Time: O(n + m)  |  Space: O(m)

class Solution {
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    	int suma = 0;
    	int sumb = 0;
    	for (int i = 0; i < aliceSizes.length; i++) {
			suma += aliceSizes[i];
		}
    	for (int i = 0; i < bobSizes.length; i++) {
			sumb += bobSizes[i];
		}
    	int diff = (suma - sumb) / 2;
    	HashSet<Integer> setb = new HashSet<Integer>();
    	for (int i = 0; i < bobSizes.length; i++) {	
    		setb.add(bobSizes[i]);
		}
    	for (int i = 0; i < aliceSizes.length; i++) {
            int x = aliceSizes[i];
    		int y = x - diff;
			if(setb.contains(y)) {
				return new int[] {x,y};
			}
		}
    	return new int[0];
    }
}