public class Backtracking {


    public static void changeArr(int arr[], int i, int val){
       //base case
        if(i == arr.length){
          printArr(arr);
          return;
          }

        //recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i]-2;     //backtracking
        }

    public static void printArr(int arr[]){
      for (int i = 0; i<arr.length; i++){
        System.out.print(arr[i] + " ");
      } 
      System.out.println();  
      }

    public static void Makesubsets(String str, String ans, int i){
      //basecase
      if(i == str.length()){
        if(ans.length()==0){
         System.out.println("null");
         }
         else{
       System.out.println(ans);
      }
       return;
       }
       //choosing yes
       Makesubsets(str, ans+str.charAt(i), i+1);
       //choosing no
       Makesubsets(str, ans, i+1);
    }
    public static void MakePermutations(String str, String ans){
      //base case
      if(str.length()==0){
       System.out.println(ans);
       return;
       }
       //recursion function
       for(int i =0 ; i<str.length(); i++){
       char curr = str.charAt(i);
       String NewStr = str.substring(0, i) + str.substring(i+1);
       MakePermutations(NewStr, ans+curr);
       }
      
    }

    public static boolean isSafe(char board[][], int row, int col){
      //vertical up
      for( int i=row-1; i>=0 ; i--){
       if (board[i][col]=='Q'){
       return false;
       }
      }
       //diagonal left up
       for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
        if(board[i][j] == 'Q'){
         return false; 
         
        }
       }
       //diagonal right up
       for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
        if(board[i][j]=='Q'){
         return false;
         }
       }
       return true;
    }
    public static void Nqueens (char board[][], int row){
      if(row==board.length){
        printBoard(board);
        count ++;
        return;
       }
        for (int j=0; j<board.length; j++){
        if  (isSafe(board, row, j)){
          board[row][j] = 'Q';
          Nqueens(board, row+1);
          board[row][j] = 'X'; 
         }
               
        }
     }
     public static void printBoard(char board[][]){
        System.out.println("_______Chess Board______");
        for(int i=0; i<board.length; i++){
          for(int j=0; j<board.length; j++){
           System.out.print(board[i][j] + " ");
           }
           System.out.println();
         }
     }

     static int count = 0;



    public static void main(String[] args) throws Exception {
        int n = 7 ;
        char board[][] = new char[n][n];
        for(int i = 0; i<n; i++ ){
          for(int j=0; j<n; j++){
           board[i][j] = 'X'; 
           }
        }
        Nqueens(board, 0);
        System.out.println("total ways to solve n queens = "+ count);
    }
}
