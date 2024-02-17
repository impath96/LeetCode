class Solution {
    public int romanToInt(String s) {
        
        // 5, 1, 100, 10, 1000, 100, 1000
        Map<Character, Integer> symbols = new HashMap();
        
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);    
        symbols.put('M', 1000);
        
        int result = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            
            char symbol = s.charAt(i);
            
            if (symbol == 'I') {
                result += 1;
            }
            
            if (symbol == 'V' || symbol == 'X') {
                if (i > 0 && s.charAt(i-1) == 'I') {
                    result += symbols.get(symbol) - 1;
                    i--;
                }else {
                    result += symbols.get(symbol);
                }
            }
            
            if (symbol == 'L' || symbol == 'C') {
                if (i > 0 && s.charAt(i-1) == 'X') {
                    result += symbols.get(symbol) - 10;
                    i--;
                } else {
                     result += symbols.get(symbol);
                }
            }
            
            if (symbol == 'D' || symbol == 'M') {
                if (i > 0 && s.charAt(i-1) == 'C') {
                    result += symbols.get(symbol) - 100;
                    i--;
                } else {
                     result += symbols.get(symbol);
                }
            }
            
        }
        
        return result;
        
        
    }
}