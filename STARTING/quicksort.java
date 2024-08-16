public class quicksort{

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr+" ");
        }
        System.out.println();
    } 
    public static void Quicksort(int arr[],int si,int ei){
         if(si>=ei){
            return;
         }
        //last element pivot
        int pidx =  partition(arr,si,ei);
        Quicksort(arr,si,pidx-1);//left part
        Quicksort(arr,pidx+1,ei);//right part

    
    }
    public static int partition(int arr[],int si,int ei){
           int pivot = arr[ei];
           int i = si-1;//to make place for els smaller than pivot

           for(int j=0;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr [j] =  arr[i];
                arr [i]=temp;
        
            }

           }
           i++;
           int temp = pivot;
                arr[ei] =  arr[i];
                arr [i]=temp;
                return i;
    }
    

    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        Quicksort(arr,0,arr.length-1);
        printArr(arr);

    
    }
}