public class LinearIn {
    public boolean linearIn(int[] outer, int[] inner) {
        for(int i=0;i<inner.length;i++){
          int test = 0;
          for(int j=0;j<outer.length;j++){
            if(inner[i]==outer[j]) test++;
          }
          if(test==0) return false;  
        }
        return true;
      }
}