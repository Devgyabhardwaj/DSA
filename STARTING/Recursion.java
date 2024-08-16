public class Recursion {

    //friends pairing problem//

    public static int friendspairing(int n){
        //base case
        if(n==1 || n==2){
            return n;
        }
         
        //kaam
        //choices
        //single\
        int fnm1 = friendspairing(n-1);

        //double
        int fnm2 = friendspairing(n-2);
        int pairways = (n-1)*fnm2;

        //total ways
        int totalways =  fnm1+pairways;
        return totalways;

    }

    public static void PrintBinStr(int n ,int  lastPlace , String str){
        //base case
        if(n==0){
            System.out.println(str);
            return ;
        }

        //kaam
        PrintBinStr(n-1,0, str+"0");
        if(lastPlace==0){
            PrintBinStr(n-1, 1, str+"1");
        }
    }

    public static void allOccurances(int arr[], int key, int i){
     if(i == arr.length){
        return ;
     }
     if(arr[i]==key){
        System.out.println(i+ " ");

     }
     allOccurances(arr, key, i+1);
    }
    
    static String digits[] = {"zero","one","two","three","four","five","six",
    "seven"," eight" ,"nine" };
    public  static void printdigits(int number){
        if(number ==0){
            return;
        }

        int lastDigit = number%10;
        printdigits(number/10);
        System.out.println(digits[lastDigit]+ " ");

    }
public static void main(String[] args) {
    //friendspairing(3);
   // PrintBinStr(3, 0,new String("") );
   
   //int arr[] = {3,2,4,5,6,2,7,2,2};
    //int key = 2;
  // allOccurances(arr, key, 0);
 //  System.out.println()
   printdigits(1234); 
}
}