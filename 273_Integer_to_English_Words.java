class Solution {
    //default let all character followed by a space except no character there
    private String[] LESS_TWENTY = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
                                    "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", 
                                    "Eighteen ", "Nineteen "};
    private String[] TENS = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private String[] THOUSANDS = {"", "Thousand ", "Million ", "Billion "};
    public String numberToWords(int num) {
        //corner case
        if (num == 0) {
            return "Zero";
        }

        //divide the number by thousands and use helper function to complete the word of the thousands
        //add corresponding thousands at the end
        int i = 0; //indicates which thousands, start from last three digits
        StringBuilder res = new StringBuilder("");
        while (num > 0) {
            //only attach the string when number is not 0 (caution)
            if (num % 1000 != 0) {
                StringBuilder temp = new StringBuilder("");
                temp.append(helper(num % 1000)).append(THOUSANDS[i]);
                res.insert(0, temp.toString());
            }
            num /= 1000;
            i++;
        }
        //careful with last space
        return res.toString().trim();
    }
    
    private String helper(int num) {
        StringBuilder res = new StringBuilder("");
        if (num < 20) {
            return LESS_TWENTY[num];
        } else if (num < 100) {
            res.append(TENS[num / 10]).append(LESS_TWENTY[num % 10]);
            return res.toString();
        } else {
            res.append(LESS_TWENTY[num / 100]).append("Hundred ").append(helper(num % 100));
            return res.toString();
        }
    }
}