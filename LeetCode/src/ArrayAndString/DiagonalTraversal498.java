package ArrayAndString;

public class DiagonalTraversal498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int index = 0;
        boolean flag = true;
        int i = 0, j = 0;
        while (index < m * n){
            if (flag){
                while (i > 0 && j < n - 1){
                    res[index++] = matrix[i--][j++];
                }
                res[index++] = matrix[i][j];
                if (j == n - 1){
                    i++;
                }else {
                    j++;
                }
                flag = false;
            }else {
                while (j > 0 && i < m - 1){
                    res[index++] = matrix[i++][j--];
                }
                res[index++] = matrix[i][j];
                if (i == m - 1){
                    j++;
                }else {
                    i++;
                }
                flag = true;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int[] res = new DiagonalTraversal498().findDiagonalOrder(nums);
        for (int i : res){
            System.out.println(i);
        }
    }
}
