class quickSort {
    public static void quickSorting(int[] arr, int low, int high) {
        // code here
        if(low < high){
            
            int pi = partition(arr, low, high);
        
            quickSorting(arr, low, pi-1);
            quickSorting(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // code here
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++){ 
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int [] arr = {1,5,3,7,2,9};
        int low = 0;
        int high = 5;
         quickSorting(arr, low, high);

         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
         }
         
    }
}