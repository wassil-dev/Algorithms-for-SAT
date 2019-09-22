
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	


	public static void main(String[] args) {
	try {
         
            	String path = "path-to//uf75-01.cnf";
		SAT s = SAT.loadFromFile(path);
		          
                System.out.println("\nfichier : " +path.substring(44));
                System.out.println("\nSAT  "+s.getClausesNumber() + " " + s.getVariablesNumber());

		
               traitementGA(s,200, 0.8, 0.4, 2500);
               
               //traitementPSO(s,4000,250,0.8,0.5,0.1);
              //Parcours.aEtoile(s);
              //Parcours.largeurDab(s);
               //Parcours.profondeurDab(s);
                

	} catch(Exception e) {
		e.printStackTrace();
	}
}
        public static void traitementPSO(SAT s,int it,int nb,double c1,double c2,double w)
                        {
            NoeudPSO pso=new NoeudPSO(it,nb,c1,c2,w);
            NoeudPSO.setM(s);
            
           int[] ok= pso.run();
                            System.out.println("\n\n Meilleure Solution obtenue : \n");
		for(int x : ok) {   
			System.out.print(x+" ");
		}
               System.out.println("\n Nombre de clauses validées : "+s.nbclausesverif(ok));
                System.out.print(" taux : "+(s.nbclausesverif(ok)*100/s.getClausesNumber())+"% \n");

                
               }
               
        
        public static void traitementGA(SAT s, int pop ,double rc,double mr,int it){
            
            Genetique ag=new Genetique(rc,mr,pop);
		Genetique.setM(s);
              
                System.out.println("\n"+it+" itérations");
		
                int[] ok = ag.run(it);
                
		System.out.println("\n\n Meilleure Solution obtenue : \n");
		for(int x : ok) {
			System.out.print(x+" ");
		}
                
		System.out.println("\n Nombre de clauses validées : "+s.nbclausesverif(ok));
              System.out.print(" taux : "+(s.nbclausesverif(ok)*100/s.getClausesNumber())+"% \n");
                 
   
               
        }

}

