public class DivideAndConqour {

   public static void PrintArr (int arr[]){
    for(int i = 0; i<arr.length; i++){
     System.out.print(arr[i]+ "  ");
    }
     System.out.println();
   } 
      //recursive function

   public static void mergesort(int arr[],int si,int ei){
    //base case//
     if(si>=ei){
        return;
      }
    int mid =   si+(ei-si)/2;//(si+ei/2) same formula.
    mergesort(arr, si, mid);//left [art ]
  mergesort(arr, mid+1, ei);//right part
    merge(arr,si,ei,mid);//to merge both the parts
    
   }
   
      
   

   public static void merge(int arr[],int si,int mid,int ei){
       // (0,3) (4,6) = total kitne  =  7
      int temp[] = new int [ei-si+1];
      int i = si;//left part
      int j = mid+1;//right part
     int k = 0; //iterator for temp

      while(i<=mid && j<=ei){
         if(arr[i]<arr[j]){
            temp[k] = arr[i];
            i++;
         }else{
            temp[k] = arr[j];
            j++;
         }
         k++;
           

      }
     // if any element is left in left part
      while(i<=mid){
         arr[k++] = arr[i++];
      }
      //if any lleft in right part
      while(j<=ei){
         temp[k++] = arr[j++];
      }

      //cope the temp elements to origional
     for( k = 0,i = si; k<temp.length; k++ ,i++){
         arr[i]=temp[k];
      }

   }

    

   public static void main(String[] args) {
    int arr[] = {6,3,9,5,2,8};
    mergesort(arr, 0, arr.length-1);
    PrintArr(arr);
   }
}
