class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        //specify start and end point
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        int i = rowBegin;
        int j = colBegin;
        //each loop complete 4 boundries for left matrix
        //each for loop change the ending points
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin += 1;
            for (i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd -= 1;
            //be careful for last loop, if
            if (rowBegin <= rowEnd) {
                for (j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }   
            }
            rowEnd -= 1;
            if (colBegin <= colEnd) {
                for (i = rowEnd; i >=rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin += 1;
        }
        return res;
    }
}