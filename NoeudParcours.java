
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class NoeudParcours extends Noeud implements Comparable<Object>{
    private static SAT m ;
    private int valHeuristique ;
    public NoeudParcours(int[] vals) {
        super(vals);
        valHeuristique = m.getClausesNumber()-m.nbclausesverify(vals);
        
     
    }

    public static SAT getM() {
        return m;
    }

    public static void setM(SAT m) {
        NoeudParcours.m = m;
    }

    public int getValHeuristique() {
        return valHeuristique;
    }

    public void setValHeuristique(int valHeuristique) {
        this.valHeuristique = valHeuristique;
    }
    public int compareTo(Object o){
    if(o==null){return 1;}
    if(!( o instanceof NoeudParcours)){return 1;}
    NoeudParcours np = (NoeudParcours)o;
    if(getValHeuristique()>np.getValHeuristique()) return 1;
    if(getValHeuristique()<np.getValHeuristique()) return -1;
    return 0;
    }
    
    public boolean estSolution(){
        return valHeuristique==0 ;
    
    }
    public NoeudParcours getFils0(){
        if(getVal()==null) return new NoeudParcours(new int[]{0});
        int[] a = new int[getVal().length+1];
        for (int i = 0; i <getVal().length; i++) {
            a[i]=getVal()[i];
        }
        a[a.length-1]=0;
    return new NoeudParcours(a);
    }
    
    
    public NoeudParcours getFils1(){
        if(getVal()==null) return new NoeudParcours(new int[]{1});
        int[] a = new int[getVal().length+1];
        for (int i = 0; i <getVal().length; i++) {
            a[i]=getVal()[i];
        }
        a[a.length-1]=1;
        return new NoeudParcours(a);
    }
    
    
    
}