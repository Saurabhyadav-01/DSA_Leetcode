import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            int frequency = map.getOrDefault(num, 0) + 1;
            map.put(num, frequency);

            if (frequency > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
}