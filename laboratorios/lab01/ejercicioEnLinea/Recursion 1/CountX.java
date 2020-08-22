public class CountX {
    public int countX(String str) {
        if(str.length()==0) return 0;
        if(str.charAt(str.length()-1)=='x') return countX(str.substring(0,str.length()-1))+1;
        return countX(str.substring(0,str.length()-1));
    }
}