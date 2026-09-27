class Solution {
    // new array me poora left multiple hi store karenge then next time usko last se traverse karenge and , dono array ke last element ka multiple new array ke last me fill karte chalenge
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Left product
        int left = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = left;
            left = left * nums[i];
        }

        // Right product
        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }
}