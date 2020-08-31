public class CountEvens {
    public int countEvens(int[] nums) {
        int c = 0;
        for(int i:nums) if(i%2==0) c++;
        return c;
    }
}