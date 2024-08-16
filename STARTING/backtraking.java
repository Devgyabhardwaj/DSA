public class backtraking {

    public static void changeArr(int arr[],int i,int val){
       
        //base case
        if(i == arr.length){
            printArr(arr);
            return;  
        }



        //recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i]-2;

    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+ " ");
        }
        System.out.println();
    }


    public static void findSubsets(String str, String ans , int i){
        //base case
        if(i==str.length()){
            System.out.println(ans);
            return;
        }



        //yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        // no choice
        findSubsets(str, ans, i+1);

    }

  //  public static void (){

    
     public static void main(String[] args) {
        ///int arr[] =new int[5];
        String str = "abc";
       // changeArr(arr,0,1);
        findSubsets(str,"" , 0);
       //   printArr(arr);
     }
    
}
