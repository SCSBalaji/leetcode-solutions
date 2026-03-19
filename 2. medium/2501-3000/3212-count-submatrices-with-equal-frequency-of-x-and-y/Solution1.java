import java.util.*;
// LeetCode #3212: Count Submatrices With Equal Frequency of X and Y
// Approach: 2D Prefix via Row Prefix + Column Accumulation
// Status: ✅ Accepted
// Time: O(n × m)  |  Space: O(m)

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int x[]=new int[m];
        int y[]=new int[m];
        int count=0;
        for(int i=0;i<n;i++) {
            int sumx=0,sumy=0;
            for(int j=0;j<m;j++) {
                if(grid[i][j]=='X') {
                    sumx++;
                }
                else if(grid[i][j]=='Y') {
                    sumy++;
                }
                x[j]+=sumx;
                y[j]+=sumy;
                if(x[j]==y[j] && x[j]>0) {
                    count++;
                }
            }
        }
        return count;
    }
}