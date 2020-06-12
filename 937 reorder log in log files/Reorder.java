public class Reorder {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (i, j) -> {
            String[] info1 = i.split(" ");
            String[] info2 = j.split(" ");
            String sub1 = i.substring(info1[0].length() + 1);
            String sub2 = j.substring(info2[0].length() + 1);
            if (isLetter(info1[1].charAt(0)) && isLetter(info2[1].charAt(0))) {
                if (sub1.equals(sub2)) {
                    return i.compareTo(j);
                }
                return sub1.compareTo(sub2);
            } else if (isDigit(info1[1].charAt(0)) && isDigit(info2[1].charAt(0))) {
                return 0;
            } else {
                return isDigit(info1[1].charAt(0)) ? 1 : -1;
            }
        });
        return logs;
    }
    
    private boolean isLetter(char c) {
        return c <= 'z' && c >= 'a';
    }
    
    private boolean isDigit(char c) {
        return c <= '9' && c>= '0';
    }
}