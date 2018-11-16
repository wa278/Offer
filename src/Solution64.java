/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，
每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
路径不能再次进入该格子。
 */
public class Solution64 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        char[][] mat = new char[rows][cols];
        int k = 0;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                mat[i][j] = matrix[k++];
            }
        }
        boolean[][] flag = new boolean[rows][cols];
        for(int i =0 ; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(hasPath(mat,flag,i,j,str,0)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean hasPath(char[][] matrix, boolean[][] flag,int row, int col,char[] str,int k){
        if(k == str.length){
            return true;
        }
        if(row >= flag.length || row < 0 || col <0 || col >= flag[0].length ){
            return false;
        }
        if(flag[row][col]){
            return false;
        }
        if(matrix[row][col] == str[k]){
            flag[row][col] = true;
            boolean t =  hasPath(matrix,flag,row+1,col,str,k+1)||
                    hasPath(matrix,flag,row-1,col,str,k+1)||
                    hasPath(matrix,flag,row,col+1,str,k+1)||
                    hasPath(matrix,flag,row,col-1,str,k+1);
            if(!t){
                flag[row][col] = false;
            }
            return t;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution64 x = new Solution64();
        char[] matrix= "abcesfcsadee".toCharArray();
        char[] str= "abcb".toCharArray();
        System.out.println(x.hasPath(matrix,3,4,str));

    }
}
