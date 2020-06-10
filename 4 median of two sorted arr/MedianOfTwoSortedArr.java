/**
 * We use a modified binary search to solve this problem.
 * 
 * Thoughts: If we can split two arrays into two parts such that all numbers in
 * smaller part are smaller than all numbers in larger part. we can calculate
 * the median.
 * 
 * Solution: Use binary search to select a position(i = left + (right - left) / 2) in the first array. And then
 * we can use (j = half - i) to locate the boundary in the second array. 
 * 
 *          i
 * E.g.:  1 2 3 4
 *        2 3 4 5 
 *            j
 * 
 * And then we check if the boundary meets the requirements such that all numbers in
 * smaller part are smaller than all numbers in larger part. i.e. check if arr1[i] < arr2[j]
 * and if arr[i + 1] > arr2[j - 1]
 * 
 * 
 * if all requirements are satisfied, calculate the median (as described in the code).
 * if arr1[i + 1] <= arr2[j - 1] ==> left = mid + 1
 * if arr1[i] >= arr2[j] ==> right = mid - 1
 * 
 * Keep doing this until the end of binary search
 */
public class MedianOfTwoSortedArr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1); // make sure that j will > 0, because if m > n , it is possible half < i
        }
        // make sure that when smaller part is always larger than or equal to larger part
        // so we use half = (m + n + 1) / 2
        int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2; 

        double maxLeft = 0;
        double minRight = 0;
        while (imin <= imax) {
            i = (imin + imax) / 2; // i should point to the smallest element in the larger part and first array
            j = half - i; // j should point to the smallest element in the larger part and second array
            // we need to make sure j - 1 and i are in the range of array2 and array1
            if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            // if all requirements are satisfied, we start to calculate median
            // we choose maxLeft as max number from smaller part and minRight as min number from larger part
            // and median = (maxLeft + minRight) / 2;
            } else {  
                if (i == 0) {
                    maxLeft = (double) nums2[j - 1];  // if all elements in the smaller part are from second array.
                } else if (j == 0) {
                    maxLeft = (double) nums1[i - 1];  // if all elements in the smaller part are from first array.
                } else {
                    maxLeft = (double) Math.max(nums1[i - 1], nums2[j - 1]); // if elements in smaller part are from both arrays.
                }
                break;
            }
        }
        // if there are odd number of numbers in both arrays. directly return maxLeft;
        if ((m + n) % 2 == 1) {
            return maxLeft;
        }

        if (i == m) {
            minRight = (double) nums2[j];
        } else if (j == n) {
            minRight = (double) nums1[i];
        } else {
            minRight = (double) Math.min(nums1[i], nums2[j]);
        }
        return (maxLeft + minRight) / 2;

    }
}