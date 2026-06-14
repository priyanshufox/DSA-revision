package bit_manipulation;

public class CountingBits {
    
    public int[] countBits(int n) {
        int dp [] = new int[n+1];
        dp[0] = 0;
        for(int i=0 ; i<=n ; i++){
            dp[i]=dp[i/2]+i%2;
        }
        return dp;
    }
    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        int n = 5; // Example input
        int[] result = solution.countBits(n);
        System.out.print("Count of bits for numbers from 0 to " + n + ": ");
        for (int i = 0; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
