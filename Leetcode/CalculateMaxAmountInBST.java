
/**
 * @see <a href=
 *      "https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3541/">some
 *      other link</a>
 * 
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

class Solution {

    public static int utilMaxValueForUnIncludedNode(TreeNode root, HashMap<TreeNode, Integer> cachedNodeCountedMap,
            HashMap<TreeNode, Integer> cachedNodeUnCountedMap) {
        return

        // Math.max(

        // ((cachedNodeCountedMap.get(root.left) == null
        // ? calculateMaxAmount(root.left, true, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeCountedMap.get(root.left))
        // + (cachedNodeUnCountedMap.get(root.right) == null
        // ? calculateMaxAmount(root.right, false, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeUnCountedMap.get(root.right))),

        // Math.max(

        // ((cachedNodeUnCountedMap.get(root.left) == null
        // ? calculateMaxAmount(root.left, false, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeUnCountedMap.get(root.left))
        // + (cachedNodeUnCountedMap.get(root.right) == null
        // ? calculateMaxAmount(root.right, false, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeUnCountedMap.get(root.right))),

        // Math.max(

        // ((cachedNodeCountedMap.get(root.right) == null

        // ? calculateMaxAmount(root.right, true, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeCountedMap.get(root.right))
        // + (cachedNodeUnCountedMap.get(root.left) == null
        // ? calculateMaxAmount(root.left, false, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeUnCountedMap.get(root.left))),

        // ((cachedNodeCountedMap.get(root.left) == null

        // ? calculateMaxAmount(root.left, true, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeCountedMap.get(root.left))
        // + (cachedNodeCountedMap.get(root.right) == null
        // ? calculateMaxAmount(root.right, true, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeCountedMap.get(root.right)

        // )

        // )

        // )

        // )

        // );

        Math.max(

                ((calculateMaxAmount(root.left, true, cachedNodeCountedMap, cachedNodeUnCountedMap))
                        + (calculateMaxAmount(root.right, false, cachedNodeCountedMap, cachedNodeUnCountedMap))),

                Math.max(

                        ((calculateMaxAmount(root.left, false, cachedNodeCountedMap, cachedNodeUnCountedMap))
                                + (calculateMaxAmount(root.right, false, cachedNodeCountedMap,
                                        cachedNodeUnCountedMap))),

                        Math.max(

                                ((calculateMaxAmount(root.right, true, cachedNodeCountedMap, cachedNodeUnCountedMap))
                                        + (calculateMaxAmount(root.left, false, cachedNodeCountedMap,
                                                cachedNodeUnCountedMap))),

                                ((calculateMaxAmount(root.left, true, cachedNodeCountedMap, cachedNodeUnCountedMap))
                                        + (calculateMaxAmount(root.right, true, cachedNodeCountedMap,
                                                cachedNodeUnCountedMap)

                                        )

                                )

                        )

                )

        );
    }

    public static int utilMaxValueForIncludedNode(TreeNode root, HashMap<TreeNode, Integer> cachedNodeCountedMap,
            HashMap<TreeNode, Integer> cachedNodeUnCountedMap) {
        return
        // root.val + (cachedNodeUnCountedMap.get(root.left) == null
        // ? calculateMaxAmount(root.left, false, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeUnCountedMap.get(root.left) +

        // (cachedNodeUnCountedMap.get(root.right) == null
        // ? calculateMaxAmount(root.right, false, cachedNodeCountedMap,
        // cachedNodeUnCountedMap)
        // : cachedNodeUnCountedMap.get(root.right)));

        root.val + (calculateMaxAmount(root.left, false, cachedNodeCountedMap, cachedNodeUnCountedMap) +

                (calculateMaxAmount(root.right, false, cachedNodeCountedMap, cachedNodeUnCountedMap)));
    }

    public static int calculateMaxAmount(TreeNode root, boolean isNodeIncludedInMaxAmount,
            HashMap<TreeNode, Integer> cachedNodeCountedMap, HashMap<TreeNode, Integer> cachedNodeUnCountedMap) {

        if (root == null) {
            return 0;
        } else {
            int maxAmountAtCurrNode = 0;
            if (isNodeIncludedInMaxAmount) {
                if (cachedNodeCountedMap.get(root) == null) {
                    maxAmountAtCurrNode = utilMaxValueForIncludedNode(root, cachedNodeCountedMap,
                            cachedNodeUnCountedMap);
                } else {
                    maxAmountAtCurrNode = cachedNodeCountedMap.get(root);
                }
            } else {
                if (cachedNodeUnCountedMap.get(root) == null) {
                    maxAmountAtCurrNode = utilMaxValueForUnIncludedNode(root, cachedNodeCountedMap,
                            cachedNodeUnCountedMap);
                    cachedNodeUnCountedMap.put(root, maxAmountAtCurrNode);
                } else {
                    maxAmountAtCurrNode = cachedNodeUnCountedMap.get(root);
                }
            }
            return maxAmountAtCurrNode;
        }
    }

    public int rob(TreeNode root) {
        if (root != null) {
            HashMap<TreeNode, Integer> cachedNodeCountedMap = new HashMap<TreeNode, Integer>();
            HashMap<TreeNode, Integer> cachedNodeUnCountedMap = new HashMap<TreeNode, Integer>();
            return Math.max(utilMaxValueForIncludedNode(root, cachedNodeCountedMap, cachedNodeUnCountedMap),
                    utilMaxValueForUnIncludedNode(root, cachedNodeCountedMap, cachedNodeUnCountedMap)

            );
        }
        return 0;
    }
}