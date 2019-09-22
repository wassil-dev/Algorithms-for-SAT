import java.util.*;

public class Genetique {

	  private double cr,mr;
	  private int population ;
	  private static SAT m ;
	  
	  
	   public static void setM(SAT m) {
	        Genetique.m = m;
	        NoeudG.setSAT(m);
	    }
	    
	    public Genetique(double cr, double mr, int population) {
	        this.cr = cr;
	        this.mr = mr;
	        this.population = population;
	    }

	    public double getCR() {
	        return cr;
	    }

	    public double getMR() {
	        return mr;
	    }
	
	    
	    public int[] run(int max){

	        /* generation de la population */
	            int nbrVar = m.getVariablesNumber();
	            ArrayList <NoeudG> a = new ArrayList <NoeudG> ();
	            for (int i = 0; i < population; i++) {
	                a.add(NoeudG.generateRandomSol(nbrVar));
	            }
	            
	            System.out.println("------------------ ALGO GENETIQUE -------------------\n");
	            System.out.println("Population de " + a.size());
	            System.out.println("Conversion rate [CR]="+this.cr);
	            System.out.println("Mutation Rate [MR]="+this.mr);
	            System.out.println("\n");
	           
	                
	            Collections.sort(a);
	         
	            int [] solution =a.get(0).getVal();
	            int l ,k ;
	        /* traitement */
	            for (int i = 0; i < max; i++) {
	                /*CR*/
	            	//System.out.println("\nIteration "+(i+1));
	                for(int m=0;m<(int)(population*cr);m++ ){
	                	//System.out.print(".");
	                	
	                    k = (int)(Math.random()*population);
	                    do{
	                        l = (int)(Math.random()*population);
	                    }while(l==k);
	                    int r =(int)(Math.random()*(nbrVar+2)-1);
	                    int [] vals = new int[nbrVar];
	                    int [] kVal=a.get(k).getVal();
	                    int [] lVal=a.get(l).getVal();
	                    
	                    for(int j =0;j <r;j++){
	                        vals[j]=kVal[j];
	                    }
	                    for(int j =r;j <nbrVar;j++){
	                        vals[j]=lVal[j];
	                    }
	                    NoeudG n = new NoeudG(vals);
	                    a.add(n);
	                    Collections.sort(a);
	                }
	                
	                if(m.nbclausesverif(a.get(0).getVal())==m.getClausesNumber()){ return a.get(0).getVal();}
	                /*MR*/
	                for(int m=0;m<(int)(population*mr);m++ ){
	                l=(int)(Math.random()*population);
	               a.get(l).inverserRandomBit();
	                }
	                Collections.sort(a);
	                //supression de la population
	                for(int m=0;m<(int)(cr*population);m++){
	                    a.remove(0);
	                }
	                
	                solution =a.get(a.size()-1).getVal();
	                
	            }
	            
	        return solution ;
	        }
	        
	       
}
