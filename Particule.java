
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wassil
 */
public class Particule implements Comparable {
    
    NoeudG position;
    int velocite;
    NoeudG Pbest;
    private static SAT s;
    private int nbverif;
    
   

    public Particule(NoeudG position, int velocite, NoeudG Pbest) {
        this.position = position;
        this.velocite = velocite;
        this.Pbest = Pbest;
        this.nbverif = s.nbclausesverif(this.Pbest.Val);
    }
public static void setSAT(SAT s) {
        Particule.s = s;
           }
    @Override
    public int compareTo(Object o) {
       if(o== null ) return -1;
        if(!( o instanceof Particule)) return -1;
        Particule n = (Particule )o ;
  
        if(this.nbverif>n.nbverif)return 1 ;
        if(this.nbverif<n.nbverif)return -1;
        return 0 ; 
    }
    
    
    public void updateVelocity(NoeudPSO pso,NoeudG Gbest)
    { 
        double r1=(Math.random()*1);
        double r2=(Math.random()*1);
        this.velocite=(int) ((pso.w*velocite)+((pso.c1*r1)*(NoeudPSO.distance(this.Pbest,this.position)))+(pso.c2*r2*(NoeudPSO.distance(Gbest, this.position))));
    }
    
    public void updatePos()
    {
       double ok,k;
        
        int[] bits = this.position.getVal();
       /*for (int i=0;i<20;i++)
       {
       ok= (Math.random()*this.velocite); 
      k=(int)(1/( 1 + Math.pow(Math.E,(-1*ok))));
        System.out.println("Particule.updatePos()"+k);
      }*/
       if(this.velocite>this.position.getVal().length){this.velocite=this.velocite/2;}
       
       else {
       
       for (int i=0;i<this.velocite;i++)
       {
        inverserRandomBit();
       }
       
       
       }
       /*
       for (int i =0;i<(this.position.getVal().length) ; i++) {
        
          
           
           if((this.velocite & (1 << i)) != 0)
        {
            bits[i]=1;
        }
        else {bits[i]=0;}
    }
      
       NoeudG temp=new NoeudG(bits); 
       
       
      this.position=temp;*/
       

    }
    
    public void updatePbest(){
        
        if(1==this.position.compareTo(this.Pbest)){
            this.Pbest=this.position;
        } 
    }
    public  void inverserRandomBit(){
        if(this.position.Val==null) return ;
        if(this.position.Val.length==0) return ;
        int i =(int)((Math.random())*this.position.Val.length);
        this.position.Val[i]=1-this.position.Val[i];
    }
    
}
