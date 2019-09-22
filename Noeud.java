public class Noeud {
    protected int[] Val ;

    public Noeud(int [] vals  ) {
        this.Val =vals;
    }
 
    public int[] getVal() {
        return Val;
    }

    public void setEnsVal(int[] vals) {
        this.Val = vals;
    }
    
    public String toString(){
        String s = "[";
        if(Val.length>0) s+=Val[0];
        for (int i = 1; i < Val.length; i++) {
            s+=","+Val[i];
        }
        return s+"]";
    }
    
    @Override
    public boolean equals(Object o) {
        if(o==null) return false ;
        if( !(o instanceof Noeud)) return false ;
        Noeud n =(Noeud) o ;
        for (int i = 0; i < Val.length && i< n.Val.length; i++) {
            if(n.Val[i]!=Val[i]) return false ;
        }
        return Val.length == n.Val.length;
    }

    


}