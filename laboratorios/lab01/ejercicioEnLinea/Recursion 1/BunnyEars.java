public class BunnyEars {
    public int bunnyEars(int bunnies) {
        if (bunnies <= 1) return bunnies * 2;
        return bunnyEars(bunnies - 1) + 2;
    }
}