class Solution {
    //OPTIMISE APPROACH:MATHEMATICS
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
       ArrayList<Integer> ans = new ArrayList<>();
       long Sn = ((long)n*(n+1))/2;
       long S2n = ((long)n*(n+1)*(2*n+1))/6;
        long arrS=0;
        long arr2S=0;
        for(int i =0;i<n;i++){
            long val = arr[i];
            arrS += val;
            arr2S += val*val;
        }
        long val1 =  Sn- arrS;
        long val2 = S2n - arr2S ;
        long  val3 = val2/val1;
        long x = (val1+val3)/2;
        long y = x-val1;
         
         ans.add((int)y);
         ans.add((int)x);
         return ans;
         
    }
}
//Tn = O(n)
//Sc = O(1) 

/*class Solution {
    //BRUTE FORCE APPROACH:WAY01
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int missing = -1;
         int repeating = -1;
         for(int i = 1; i<=n;i++){
             int count = 0;
              for(int j = 0; j<n;j++){
                 if(arr[j] == i){
                     count = count +1;
                 } 
              }
              if(count == 2){
                  repeating = i;
              }
              else if(count == 0){
                  missing = i;
              }
         }
         ans.add(repeating);
        ans.add(missing);
        return ans;
    }
}
//Tn = O(n^2)
//Sc = O(1)

class Solution {
    //BETTER APPROACH:HASHING
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num:arr){
           map.put(num,map.getOrDefault(num,0)+1);
        }
        int missing = -1;
         int repeating = -1;
         for(int i= 1; i<=n;i++){
            int count = map.getOrDefault(i,0);
            if(count == 2){
                repeating = i;
            }
          else if(count == 0){
             missing = i;
         }
         }
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }
}
//Tn = O(2n)
//Sc = O(n) Extra space used

*/