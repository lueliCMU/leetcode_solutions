
class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        genParen(res, new StringBuilder(), n, 0, 0);
        return res;
    }
    
    private void genParen(List<String> res, StringBuilder sb, int total, int left, int right) {
        if (left == total && right == total) {
            res.add(sb.toString());
            return;
        }
        if (left > right) {
            sb.append(')');
            genParen(res, sb, total, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < total) {
            sb.append('(');
            genParen(res, sb, total, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}