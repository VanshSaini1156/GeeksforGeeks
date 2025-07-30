class Solution {
    //OPTIMAL SOLUTIION: MERGE SORT HELPER
    private int merge(int[] arr,int low,int mid,int high){
        int i = low;
        int j = mid+1;
        int count = 0;
        int index = 0;
        int[] temp = new int[high-low+1];
        while(i<= mid && j<= high){
            if(arr[i]<=arr[j]){
                temp[index++]  = arr[i++];
            }else{
                temp[index++] = arr[j++];
                count += (mid-i+1);
            }
        }
        while(i<=mid){
             temp[index++]  = arr[i++];
        }
        while(j<=high){
            temp[index++] = arr[j++];
        }
        
        for(int k = 0; k<temp.length;k++){
            arr[low+k] = temp[k];
        }
        return count;
    }
    private int mergeSort(int[] arr,int low,int high){
        int count = 0;
        if(low<high){
            int mid = (low+high)/2;
           count += mergeSort(arr,low,mid);
            count += mergeSort(arr,mid+1,high);
            count += merge(arr,low,mid,high);
        }
        return count;
    }
    static int inversionCount(int arr[]) {
       int n = arr.length;
       return new Solution().mergeSort(arr,0,n-1);
        
    }
}
//Tc = O(nlogn)
//Sc = O(n)


/*class Solution {
//BRUTE FORCE APPROACH
    static int inversionCount(int arr[]) {
       int n = arr.length;
       int count = 0;
       for(int i =0; i<n;i++){
           for(int j = i+1;j<n;j++){
               if(arr[i]>arr[j]){
                   count = count+1;
               }
           }
       }
        return count;
    }
}

//Tc = O(n^2)
//Sc = O(1)
*/