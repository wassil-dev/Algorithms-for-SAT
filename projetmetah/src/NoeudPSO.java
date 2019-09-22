
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wassil
 */
public class NoeudPSO {
    
    int maxIter,nbParticles;
    double c1,c2;
    double w;
    private static SAT m ;

    public NoeudPSO(int maxIter, int nbParticles, double c1, double c2, double w) {
        this.maxIter = maxIter;
        this.nbParticles = nbParticles;
        this.c1 = c1;
        this.c2 = c2;
        this.w = w;
    }
     public static void setM(SAT m) {
	        NoeudPSO.m = m;
	        NoeudG.setSAT(m);
	    }
    
    public int[] run(){
        
        int[] x = null;
int nbrVar = m.getVariablesNumber();
        int nb = this.nbParticles;
        Particule.setSAT(m);
	            ArrayList <Particule> a = new ArrayList <Particule> ();
	            for (int i = 0; i < nb; i++) {
                        NoeudG posinit=NoeudG.generateRandomSol(nbrVar);
                        Particule p=new Particule(posinit,(int)(Math.random()*nbrVar),posinit);
	                a.add(p);
	            }
                    /*for (int i=0; i<nb;i++)
                    {   
                        System.out.println(a.get(i).position);
                       
                    }*/
                    Collections.sort(a);
                    
                    
                    NoeudG Gbest=new NoeudG(a.get(nb-1).Pbest.getVal());
                    
                    if (m.nbclausesverif(Gbest.getVal())== m.getClausesNumber())
                    {
                        return Gbest.getVal();
                    }
                    System.out.println("\n\n");
                     
                    
                    
                  
                   /* for (int i=0; i<nb;i++)
                    {  
                        System.out.println(a.get(i).position);
                         System.out.println(m.nbclausesverif(a.get(i).position.getVal()));

                    }*/
                    
                    System.out.println("------------------ ALGO PSO -------------------\n");
	            System.out.println("Nombre de particules " + a.size());
	            System.out.println("C1= "+this.c1);
	            System.out.println("C2= "+this.c2);
                    System.out.println("W= "+this.w);
                    System.out.println("Nombres Iterations  "+ this.maxIter);
	            System.out.println("\n");
	           
                    for (int j=0;j<maxIter;j++)
                    {
                        for (int k=0;k<a.size();k++)
                        {
                            a.get(k).updateVelocity(this, Gbest);
                            a.get(k).updatePos();
                            if (m.nbclausesverif(a.get(k).position.getVal())== m.getClausesNumber())
                    {
                        return a.get(k).position.getVal();
                    }
                             a.get(k).updatePbest();
                            
                        }
                        
                       /* for (int o=0;o<a.size()/2;o++)
                        {
                            for (int m=0;m<a.size();m++)
                            {
                            a.get(o).inverserRandomBit();}
                        }*/
                         int imax=0;
                    int valmax=0;
                    valmax=m.nbclausesverif(a.get(0).position.getVal());
                        for (int i=0; i<nb;i++)
                    {  
                        int x1=m.nbclausesverif(a.get(i).position.getVal());
                        if (valmax<m.nbclausesverif(a.get(i).position.getVal())){valmax=x1;imax=i;}
                       

                    }
                    
                    
                        Gbest.Val=a.get(imax).Pbest.getVal();
                    }
                    
                          
                      
                  
        
                     
        return Gbest.getVal();
    }
    public static int distance(NoeudG x , NoeudG y)
    { int cpt=0;
      int[]  tabx=x.getVal();
      int[] taby=y.getVal();
    for (int i=0;i<tabx.length;i++)
    { 
        if (tabx[i]!= taby[i]){
            cpt++;
        }
    }

   return cpt;
    }
    
}
