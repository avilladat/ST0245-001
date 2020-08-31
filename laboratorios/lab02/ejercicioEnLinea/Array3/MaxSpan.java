public class MaxSpan {
    public int maxSpan(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
          int mt = 0;
          for (int j = nums.length - 1; j > i; j--) {
            if (nums[i] == nums[j]) {
              mt = j - i;
              break;
            }
          }
          m = Math.max(m, mt);
        }
        return nums.length>0 ? m+1 : 0;
      }
}