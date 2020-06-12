

public class TranWater {
    /**
     *  Time: O(n) Space: O(1)
     *  leftMax: represents max value before left pointer (left)
     *  rightMax: represents max value after right pointer (right)
     *  each time we compare height at left pointer and height at right pointer.
     *  if height[left] < height[right]: means that how many water this cell (pointed by left)
     *  can trap depends on max(height[left], leftMax). if leftMax <= height[left], no water 
     *  can be trapped in this cell, we update leftMax. if leftMax > height[left], we can 
     *  trap (leftMax - height[left]) water in this cell.
     *  
     *  if height[right] >= height[right]: we use rightMax to do the same thing as above.
     */
    public int trap1(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else if (height[left] < leftMax) {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else if (height[right] < rightMax) {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
    /**
     * 
     * Dynamic Programming.
     * Time: O(n) Space: O(n)
     * we use int[] leftMax and int[] rightMax to store leftMax value and rightMax value for each
     * position. And add them as result.
     * 
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; j >= 0 && i < n; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            res += water > 0 ? water : 0;
        }
        return res;
    }
    /**
     * 
     * Monolithic Stack:
     * Time: O(n) Space: O(n)
     * We store index of each elements in this stack. In this stack, all elements to which those indexes
     * in stack point to are in descending order. When we meet the top of that stack is smaller than
     * the current height, we can calculate how many water can the cell in the top of stack trap.
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                res += (Math.min(height[stack.peek()], height[i]) - height[cur]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }
}