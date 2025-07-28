

class Solution {
    //BETTER APPROACH:HASHING+PRE-FIX SUM
    int maxLength(int arr[]) {
       int n = arr.length;
       int lengthM = 0;
       int sum = 0;
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0;i<n;i++){
           sum += arr[i];
           if(sum == 0){
               lengthM = Math.max(lengthM,i+1);
           }
           int rem = sum - 0;
           if(map.containsKey(rem)){
               lengthM = Math.max(lengthM,i-map.get(rem));
           }
          if(!map.containsKey(sum)){
              map.put(sum,i);
          }
       }
        return lengthM;
    }
}
//Tn = O(n)
//Sc = O(n)


/*class Solution {
    //BRUTE FORCE APPPROACH:Hit and Trial
    int maxLength(int arr[]) {
       int n = arr.length;
       int lengthM = 0;
       for(int i=0; i<n;i++){
           int sum = 0;
           for(int j= i;j<n;j++){
               sum += arr[j];
               int lengthC = j-i+1;
               if(sum == 0){
                   lengthM = Math.max(lengthM,lengthC);
               }
           }
       }
       return lengthM;
    }
}

//Tn = O(n^2)
//Sc = O(n)
*/
