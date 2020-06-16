class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int curProduct = 1;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            curProduct *= nums[i - 1];
            res[i] = curProduct;
        }
        curProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= curProduct;
            curProduct *= nums[i];
        }
        return res;
    }
}