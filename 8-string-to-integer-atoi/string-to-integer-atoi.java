class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, i = 0;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        return parsedigit(s, i, 0L, sign); // use long
    }

    private int parsedigit(String s, int i, long result, int sign) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign * result);
        }

        int digit = s.charAt(i) - '0';
        result = result * 10 + digit;

        if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return parsedigit(s, i + 1, result, sign);
    }
}
