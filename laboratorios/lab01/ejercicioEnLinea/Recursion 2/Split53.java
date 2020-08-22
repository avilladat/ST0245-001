public class Split53 {
    public boolean split53(int[] nums) {
        return this.split(nums, 0, 0, 0);
    }
      
    public boolean split(int[] nums, int s1, int s2, int start) {
        if (start==nums.length) return s2 == s1;
        if (nums[start]%5==0) return split(nums, s1, s2 + nums[start], start + 1);
        if (nums[start]%3==0) return split(nums, s1 + nums[start], s2, start + 1);
        return (split(nums, s1 + nums[start], s2, start + 1) || split(nums, s1, s2 + nums[start], start + 1));
    }   
}