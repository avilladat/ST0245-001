public class CountHi {
    public int countHi(String str) {
        if(str.length()<=1) return 0;
        if(str.charAt(str.length()-2)=='h' && str.charAt(str.length()-1)=='i') return countHi(str.substring(0,str.length()-2))+1;
        return countHi(str.substring(0,str.length()-1));
    }
}