public class BunnyEars2 {
    public int bunnyEars2(int bunnies) {
        if(bunnies<=1) return bunnies*2;
        if(bunnies%2==0) return bunnyEars2(bunnies-1)+3;
        return bunnyEars2(bunnies-1)+2;
    }
}