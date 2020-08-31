public class CountClumps {
    public int countClumps(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
          if(i==0 && nums[0]==nums[1]) c++;
          else if (nums[i] == nums[i + 1] && nums[i - 1] != nums[i]) c++;
        }
        return c;
    }
}