import java.util.Random;

public class RandomPickWeight {
    int[] preSum;
    Random rand;
    public RandomPickWeight(int[] w) {
        preSum = new int[w.length];
        rand = new Random();
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int idx = rand.nextInt(preSum[preSum.length - 1]) + 1;
        int left = 0;
        int right = preSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] == idx) return mid;
            if (preSum[mid] < idx) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
