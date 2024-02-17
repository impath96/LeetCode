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
        
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && symbols.get(s.charAt(i)) < symbols.get(s.charAt(i + 1))) {
                result -= symbols.get(s.charAt(i));
            }else {
                result += symbols.get(s.charAt(i));
            }
        }
        
        return result;
        
        
    }
}