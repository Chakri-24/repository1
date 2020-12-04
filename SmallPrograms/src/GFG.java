// Java program to count number 
// of ways to arrange three 
// types of balls such that no 
// two balls of same color 
// are adjacent to each other 
import java.util.Arrays; 
  
public class GFG  
{ 
  
    static final int MAX = 100; 
      
    // table to store to store results of subproblems 
    static int dp[][][][] = new int[MAX][MAX][MAX][3]; 
      
    // Returns count of arrangements 
    // where last placed ball is 
    // 'last'. 'last' is 0 for 'p', 
    // 1 for 'q' and 2 for 'r' 
    static int countWays(int p, int q, int r, int last) 
    { 
        // if number of balls of any  
        // color becomes less than 0 
        // the number of ways arrangements is 0. 
        if (p < 0 || q < 0 || r < 0) 
        return 0; 
      
        // If last ball required is  
        // of type P and the number 
        // of balls of P type is 1  
        // while number of balls of 
        // other color is 0 the number  
        // of ways is 1. 
        if (p == 1 && q == 0 && r == 0 && last == 0) 
            return 1; 
      
        // Same case as above for 'q' and 'r' 
        if (p == 0 && q == 1 && r == 0 && last == 1) 
            return 1; 
          
        if (p == 0 && q == 0 && r == 1 && last == 2) 
            return 1; 
      
        // If this subproblem is already evaluated 
        if (dp[p][q][r][last] != -1) 
            return dp[p][q][r][last]; 
      
        // if last ball required is P and  
        // the number of ways is the sum 
        // of number of ways to form sequence 
        // with 'p-1' P balls, q Q balss and 
        // r R balls ending with Q and R. 
        if (last == 0) 
        dp[p][q][r][last] = countWays(p - 1, q, r, 1) +  
                            countWays(p - 1, q, r, 2); 
      
        // Same as above case for 'q' and 'r' 
        else if (last == 1) 
        dp[p][q][r][last] = countWays(p, q - 1, r, 0) +  
                            countWays(p, q - 1, r, 2); 
        //(last==2) 
        else 
        dp[p][q][r][last] = countWays(p, q, r - 1, 0) +  
                            countWays(p, q, r - 1, 1); 
      
        return dp[p][q][r][last]; 
    } 
      
    // Returns count of required arrangements 
    static int countUtil(int p, int q, int r) 
    { 
        // Initialize 'dp' array 
        for (int[][][] row : dp) 
        { 
            for (int[][] innerRow : row)  
            { 
                for (int[] innerInnerRow : innerRow) 
                { 
                    Arrays.fill(innerInnerRow, -1); 
                } 
            } 
        }; 
        
        for (int[][][] row : dp) 
        { 
            for (int[][] innerRow : row)  
            { 
                for (int[] innerInnerRow : innerRow) 
                { 
                    for(int i:innerInnerRow) {
                    	
                    	methoddd(i);
                    }
                    
                }
            } 
           
        }; 
      
        // Three cases arise: 
        return countWays(p, q, r, 0) + // Last required balls is type P 
            countWays(p, q, r, 1) +    // Last required balls is type Q 
            countWays(p, q, r, 2);       // Last required balls is type R 
    } 
  
    private static void methoddd(int i) {
		// TODO Auto-generated method stub
		System.out.print(i);
	}

	// Driver code 
    public static void main(String[] args) 
    { 
        int p = 2, q = 1, r = 3; 
        System.out.print(countUtil(p, q, r)); 
    } 
} 