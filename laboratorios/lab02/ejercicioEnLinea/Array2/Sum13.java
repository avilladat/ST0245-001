public class Sum13 {
    public int sum13(int[] nums) {
        int c = 0;
        for(int i=0;i<nums.length;i++){ 
          if(nums[i]!=13) c+=nums[i];
          else i++;
        }
        return c;
    }
}