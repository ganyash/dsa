/**
 * @see <a
 *      href=https://leetcode.com/problems/valid-mountain-array/">some
 *      other link</a>
 * 
 */
 class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;
        boolean isIncreasing = true;
        boolean isDecreasing = false;
        for(int i =0;i<arr.length-1;i++){
            if(isIncreasing){
                if(arr[i]>arr[i+1]){
                    isDecreasing = true;
                    isIncreasing = false;
                }
                else if(arr[i]==arr[i+1]) return false;
            }
            if(isDecreasing){
                if(arr[i]<=arr[i+1]) return false;
                if(i ==0 && arr[i]>arr[i+1]) return false;
            }
        }
        if(isIncreasing) return false;
        return true;
    }
}