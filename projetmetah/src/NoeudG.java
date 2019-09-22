
public class NoeudG extends Noeud implements Comparable {
	private static SAT s ;
        private int nbverif;
	
	public NoeudG(int[] vals) {
		super(vals);
                this.nbverif = s.nbclausesverif(this.getVal());
	}
    public static void setSAT(SAT s) {
        NoeudG.s = s;
           }
    
    @Override
    public int compareTo(Object o) {
        if(o== null ) return -1;
        if(!( o instanceof NoeudG)) return -1;
        NoeudG n = (NoeudG )o ;
        /*
        if(s.nbclausesverif(this.getVal())>s.nbclausesverif(n.getVal()))return 1 ;
        if(s.nbclausesverif(this.getVal())<s.nbclausesverif(n.getVal()))return -1 ;
        */
        if(this.nbverif>n.nbverif)return 1 ;
        if(this.nbverif<n.nbverif)return -1;
        return 0 ;
    }
    
    public static NoeudG generateRandomSol(int nbrVar ){
        int[]tab =new int[nbrVar];
        for(int i=0;i<nbrVar;i++){
        tab[i]=(int)(Math.random()*2);
        }
        return new NoeudG(tab);
    } 
       
    public  void inverserRandomBit(){
        if(Val==null) return ;
        if(Val.length==0) return ;
        int i =(int)((Math.random())*Val.length);
        Val[i]=1-Val[i];
    }
    
    
    
}

