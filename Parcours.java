import java.util.ArrayList;
import java.util.Collections;

public class Parcours {
    
    public static NoeudParcours largeurDab(SAT m){
        if(m==null)return null;NoeudParcours.setM(m);
        ArrayList <NoeudParcours> list = new ArrayList<>();
        NoeudParcours n,n0,n1;
        n=new NoeudParcours(new int[]{});// etat initial sans var ne peut pas etre sol
        list.add(n);
        while(!list.isEmpty() ){
            n=list.get(0);
            list.remove(0);
            System.out.println(n);
            // tester n si sol--------------------------
             System.out.println(n+" "+" Clauses verifiés :"+m.nbclausesverify(n.getVal()));
            // calculer n0
            n0=n.getFils0();
            if(n0.estSolution()){   System.out.println("Solution trouvée !! :" +n0+" Clauses vérifiées :"+m.nbclausesverify(n0.getVal())); return n0;   }
            //s il a des fils a developper on l ajoute
            if(n0.getVal().length<m.getVariablesNumber())list.add(n0);
            // calculer n1
            n1=n.getFils1();
            if(n1.estSolution()){System.out.println("Solution trouvée !! :" +n1+" Clauses vérifiées :"+m.nbclausesverify(n1.getVal())); return n1;   }
            //s il a des fils a developper on l ajoute
            if(n1.getVal().length<m.getVariablesNumber())list.add(n1);
        }
        
        return null ;
    }
    
    public static NoeudParcours profondeurDab(SAT m ){
        if(m==null)return null;NoeudParcours.setM(m);
        ArrayList <NoeudParcours> list = new ArrayList<>();
        NoeudParcours n,n0,n1;
        n=new NoeudParcours(new int[]{});// etat initial
        list.add(n);
        while(!list.isEmpty() ){
            n=list.get(0);
            list.remove(0);
            System.out.println(n+" "+" Clauses verifiés :"+m.nbclausesverify(n.getVal()));
            // tester n si sol--------------------------
            
            // calculer n0
            n0=n.getFils0();
            if(n0.estSolution()){  System.out.println("Solution trouvée !! :" +n0+" Clauses vérifiées :"+m.nbclausesverify(n0.getVal()));  return n0;   }
            //s il a des fils a developper on l ajoute
            if(n0.getVal().length<m.getVariablesNumber()){list.add(0,n0);}
            // calculer n1
            n1=n.getFils1();
            if(n1.estSolution()){   System.out.println("Solution trouvée !! :" +n1+" Clauses vérifiées :"+m.nbclausesverify(n1.getVal())); return n1;   }
            //s il a des fils a developper on l ajoute
            if(n1.getVal().length<m.getVariablesNumber()){list.add(0,n1);}
        }
        
        return null ;
    }
    
    public static NoeudParcours aEtoile(SAT m){
        
        System.out.println("------------------ Algorithme A* -------------------\n");
        if(m==null)return null;NoeudParcours.setM(m);
        
        ArrayList <NoeudParcours> list = new ArrayList<>();
        NoeudParcours n,n0,n1;
        n=new NoeudParcours(new int[]{});// etat initial
        list.add(n);
        while(!list.isEmpty() ){
            n=list.get(0);
            list.remove(0);
            System.out.println(n+"  Valeur heuristique ="+n.getValHeuristique());
            // calculer n0
            n0=n.getFils0();
            if(n0.estSolution()){   System.out.println("Solution trouvée !! :" +n0+" "+n0.getValHeuristique()); return n0;   }
            //s il a des fils a developper on l ajoute
            if(n0.getVal().length<m.getVariablesNumber())list.add(n0);
            // calculer n1
            n1=n.getFils1();
            if(n1.estSolution()){ System.out.println("Solution trouvée !! :" +n1+" Valeur Heuristique :"+n1.getValHeuristique());   return n1;   }
            //s il a des fils a developper on l ajoute
            if(n1.getVal().length<m.getVariablesNumber())list.add(n1);
            Collections.sort(list);
        }
        
        return null ;
    }
    
    
    
}