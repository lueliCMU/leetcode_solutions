class StringCompression {
    public int compress(char[] chars) {
        int loc = 0;
        int count = 1;
        char curChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (curChar == chars[i]) {
                count++;
            } else {
                chars[loc++] = curChar;
                if (count != 1) {
                    char[] numberChars = String.valueOf(count).toCharArray();
                    for (char num : numberChars) {
                        chars[loc++] = num;
                    }
                }
                curChar = chars[i];
                count = 1;
            }
        }
        // handle last number
        chars[loc++] = curChar;
        if (count != 1) {
            char[] numberChars = String.valueOf(count).toCharArray();
            for (char num : numberChars) {
                chars[loc++] = num;
            }
        }
        return loc;  
    }
}