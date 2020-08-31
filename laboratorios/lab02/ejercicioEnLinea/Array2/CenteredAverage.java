public class CenteredAverage {
    public int centeredAverage(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i:nums){
          max = Math.max(max,i);
          min = Math.min(min,i);
        }
        int c = -max-min;
        for(int i:nums) c+=i;
        return c/(nums.length-2);
    }
}