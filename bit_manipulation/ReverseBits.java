package bit_manipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;
            int reverselsb = lsb << (31 - i);
            result = result | reverselsb;
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        int n = 2; // Example input
        int reversed = solution.reverseBits(n);
        System.out.println("Reversed bits: " + reversed);
    }

}
