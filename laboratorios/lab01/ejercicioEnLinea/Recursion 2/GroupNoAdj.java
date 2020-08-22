public class GroupNoAdj {
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start > nums.length-1) return target == 0;
        return (groupNoAdj(start + 2, nums, target - nums[start])) ||  (groupNoAdj(start + 1, nums, target));
    }   
}