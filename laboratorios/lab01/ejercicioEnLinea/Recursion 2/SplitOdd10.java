public class SplitOdd10 {
    public boolean splitOdd10(int[] nums) {
        return this.split(nums, 0, 0, 0);
    }
       
    public boolean split(int[] nums, int s1, int s2, int start) {
        if (start==nums.length) return s2%10 == 0 && s1%2!=0;
        return (split(nums, s1 + nums[start], s2, start + 1) || split(nums, s1, s2 + nums[start], start + 1));
    }
}