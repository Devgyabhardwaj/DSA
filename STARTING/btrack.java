public class btrack{
     public static boolean isSafe(char board[][],int row,int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false; 
            }
        }



        //daig left up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diag right  up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++ ){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;

     }

 








    public static void nQeens(char board[][],int row){
        //base case
        if(row==board.length){
            printBoard(board);
            return; 
        }
        

        //coloumn loop
     for(int j=0;j<board.length;j++){
        if(isSafe(board,row,j)){

        
        board[row][j]='Q';
        nQeens(board, row+1);//function call
        board[row][j]='.'; //backtracking call
        }  
     }
    }

    public static void printBoard(char board[][]){
        System.out.println("---------chess board-----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.println(board[i][j]+" ");
            }
           // System.out.println();
        }
    }

    public static void main(String[] args) {
        int n =4 ;
        char board[][] = new char[n][n];
        //initilaize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        nQeens(board, 0);

    }
}