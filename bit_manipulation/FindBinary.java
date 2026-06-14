package bit_manipulation;

public class FindBinary {
    public String findBinary(int n) {
        StringBuilder binary = new StringBuilder();
        // Iterate from the most significant bit (31) to the least significant bit (0)
        for (int i = 31; i >= 0; i--) {
            // Extract the bit at position i
            int bit = (n >> i) & 1;
            // Append the bit to the binary string
            binary.append(bit);
        }
        return binary.toString();
    }
    
    public static void main(String[] args) {
        FindBinary solution = new FindBinary();
        int n = 3; // Example input
        String binaryString = solution.findBinary(n);
        System.out.println("Binary representation: " + binaryString);
    }
}
