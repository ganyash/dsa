/**
 * @see <a
 *      href=https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">some
 *      other link</a>
 * 
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int returnLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                count++;
                nums[returnLength] = nums[i];
                returnLength++;
            }

            else if (nums[i] != nums[i - 1]) {
                count = 1;
                nums[returnLength] = nums[i];
                returnLength++;
            } else if (count < 2) {
                nums[returnLength] = nums[i];
                returnLength++;
                count++;
            } else if (count >= 2) {
                count++;
            }
        }
        return returnLength;
    }
}