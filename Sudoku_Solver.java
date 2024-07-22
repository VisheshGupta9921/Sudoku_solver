package Project2;
import java.util.*;
public class Sudoku_Solver {
	public static void main(String args[]) {
        // Your Code Here
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Sudoku Puzzle (Enter '*' in the blank spaces)");
        int n =sc.nextInt();
        int [][]board=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]=sc.nextInt();
            }
        }
        sudoku_solver(board,0,0,n-1,n-1);
        
    }
    public static void sudoku_solver(int [][]board, int row, int col, int last_col, int last_row){
        if(col==last_col+1){
            row++;
            col=0;
        }
        if(row==last_row+1){
            display(board);
            return;
        }

        if(board[row][col]!=0){
            sudoku_solver(board,row,col+1,last_col,last_row);
        }
        else{
            for(int val=1; val<=9; val++){
                if(is_possible(board,row,col,val)==true){
                    board[row][col]=val;
                    sudoku_solver(board,row,col+1,last_col,last_row);
                    board[row][col]=0;
                }
            }
            
        }
    }
    public static void display(int [][]board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean is_possible(int [][]board, int row, int col, int val){
        //row check
        int c=0;
        while(c<board.length){
            if(board[row][c]==val){
                return false;
            }
            c++;
        }
        //col check
        int r=0;
        while(r<board.length){
            if(board[r][col]==val){
                return false;
            }
            r++;
        }

        //matrix check
        r=row-row%3;
        c=col-col%3;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }

        return true;
    }
}
