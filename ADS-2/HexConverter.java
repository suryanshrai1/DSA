class HexConverter {
    public String toHex(int num) {
        char[] hexas = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        
        if (num == 0) return "0";
        if (num > 0 && num <= 15) return Character.toString(hexas[num]);

        long n = num;  // handle negative values
        if (n < 0) n += (1L << 32);
        
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            result.insert(0, hexas[(int)(n % 16)]);
            n /= 16;
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        HexConverter converter = new HexConverter();
        
        // Test cases
        System.out.println(converter.toHex(26));   // Output: "1a"
        System.out.println(converter.toHex(-1));    // Output: "ffffffff"
        System.out.println(converter.toHex(0));     // Output: "0"
        System.out.println(converter.toHex(255));   // Output: "ff"
        System.out.println(converter.toHex(16));    // Output: "10"
    }
}
