public class BigDiff {
    public int bigDiff(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i:nums){
          max = Math.max(max,i);
          min = Math.min(min,i);
        }
        return max-min;
    }
}