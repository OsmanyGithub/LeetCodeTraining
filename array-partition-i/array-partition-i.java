class Solution {
    public int arrayPairSum(int[] nums) {
        // The idea is to sort the array to make pair of adjacent element to maximize the sum
        
        // Sort the arr using mergeSort
        mergeSort(nums, 0, nums.length - 1);
        
        // Sum of mininum
        int sum = 0;
        
        // Loop through the sorted array for every other element and add element to sum
        for (int i = 0; i < nums.length; i+= 2){
            sum += nums[i]; 
        }
        
        // Answer
        return sum;
    }
    
    // MergeSort implementation
    private void mergeSort(int[] arr, int left, int right){
        if (left < right){
            int mid = left + (right - left) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge elements in sorted order into the array            
            merge(arr, left, mid, right);
        }
    }
    
    // Merge implementation
    private void merge(int[] arr, int left, int mid, int right){
        // Size of left and right halves
        int n1 = mid - left + 1; // left half
        int n2 = right - mid; // right half
        
        // Temporary left and right arrays
        int [] leftArray = new int[n1];
        int [] rightArray = new int [n2];
        
        // Populate left and right arrays        
        for (int i = 0; i < n1; i ++){
            leftArray[i] = arr[left + i];
        }
        
        for (int j = 0; j < n2; j ++){
            rightArray[j] = arr[mid + 1 + j];
        }
        
        // sort Array in place in non decreasing order
        int i = 0, j = 0, k = left; // i & j pointers in left and right array respectively, k arr[index]
        while (i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++; // move to the next element
            }
            else {
                arr[k] = rightArray[j];
                j++; // move to the next element 
            }
            // increment index in array
            k++;
        }
        
        // If there is any remaining element in one of the array put it all
        while (i < n1){
            arr[k++] = leftArray[i++]; // move both pointers
        }
        while(j < n2){
            arr[k++] = rightArray[j++]; // move both pointers
        }   
        
    }
}