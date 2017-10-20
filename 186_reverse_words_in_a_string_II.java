public class Solution {
    public void reverseWords(char[] s) {
        // reverse all string
        reverse(s, 0, s.length - 1);
        int start = 0;
        // reverse for each words
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        //reverse the last word
        reverse(s, start, s.length - 1);
    }
    
    private void reverse(char[] s, int b, int e) {
        while (b < e) {
            char temp = s[b];
            s[b] = s[e];
            s[e] = temp;
            b++;
            e--;
        }
    }
}