/**
 * @see <a
 *      href=https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3543/">some
 *      other link</a>
 * 
 */

class Solution {
    HashMap<Integer, Integer> cachedCalculatedValues = new HashMap<Integer, Integer>();

    public int countNoOfDigits(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public int calMinOneRequired(int k, int dividend, Set<Integer> hash_Set) {
        if (dividend == 0) {
            return 0;
        }
        int noOfDigitsInK = countNoOfDigits(k);
        String noOfOneInString = Integer.toString(dividend);
        int noOfOneRequired = Integer.parseInt(noOfOneInString);

        int countOfOneRequired = 0;
        while (k > noOfOneRequired) {
            noOfOneInString += '1';
            noOfOneRequired = Integer.parseInt(noOfOneInString);
            countOfOneRequired++;
        }
        if (hash_Set.contains(noOfOneRequired % k))
            return -1;
        else
            hash_Set.add(noOfOneRequired % k);
        return countOfOneRequired + calMinOneRequired(k, noOfOneRequired % k, hash_Set);

    }

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        if (cachedCalculatedValues.get(k) != null) {
            return cachedCalculatedValues.get(k);
        }
        Set<Integer> hash_Set = new HashSet<Integer>();
        int ans = calMinOneRequired(k, 1, hash_Set);
        if (ans == -1) {
            return -1;
        }
        cachedCalculatedValues.put(k, ans + 1);
        return ans + 1;
    }
}
