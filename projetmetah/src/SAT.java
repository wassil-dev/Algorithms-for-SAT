import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SAT {
	
	private int clausesNumber, variablesNumber, clausesLength;
	private int[][] SATMatrix;
	
	public SAT(int clausesNumber, int variablesNumber, int clausesLength) {
		this.clausesNumber = clausesNumber;
		this.variablesNumber = variablesNumber;
		this.clausesLength = clausesLength;
		SATMatrix = new int[clausesNumber][variablesNumber];
		
		for(int i=0;i<clausesNumber;i++) {
			for(int j=0;j<variablesNumber;j++) {
				SATMatrix[i][j] = 0;
			}
		}
	}
	
	public static SAT loadFromFile(String path) throws IOException{
		final List<String> lines = Files.readAllLines(Paths.get(path),Charset.defaultCharset());
		List<String[]> clauses = new ArrayList<>(); 
		
		int clausesNumber = 0;
		int clausesLength = 0;
		int variablesNumber = 0;
		
		for(String line : lines) {
			if(line.length()>0) {
                           
				char firstChar = line.charAt(0);
				if(firstChar == '-'|| (firstChar>='0' && firstChar<='9')) {
					String[] tempClause = line.split(" ");
					clauses.add(Arrays.copyOfRange(tempClause,0,tempClause.length-1));
				}else if(firstChar == 'p') {
					String[] fileInfos = line.split(" +");
					clausesNumber = Integer.parseInt(fileInfos[3]);
					variablesNumber = Integer.parseInt(fileInfos[2]);
				}
			}
		}
		
		if(!clauses.isEmpty()) {
			clausesLength = clauses.get(0).length;
                        
			int[][] SATMat = new int[clausesNumber][variablesNumber];
			
			for(int i=0;i<clausesNumber;i++) {
				for(int j=0;j<variablesNumber;j++) {
					SATMat[i][j] = -1;
				}
			}
			               
			for(int i=0;i<clausesNumber;i++) {
				String[] clause = clauses.get(i);
                                
				for(int j=0;j<clausesLength;j++) {
                                    
                                     
					int literal = Integer.parseInt(clause[j]);
                                        
					SATMat[i][Math.abs(literal)-1] = literal < 0 ? 0 : 1;
				}
			}
			
			SAT sat = new SAT(clausesNumber,variablesNumber,clausesLength);
			
			sat.setSATMatrix(SATMat);
			
			return sat;
			
		}else {
			return null;
		}

	}
	
	public int[] generateRandomSolution() {
		int solution[] = new int[variablesNumber];
		
		for(int i=0;i<variablesNumber;i++) {
			solution[i] = (int) Math.floor(Math.random() * 2);
		}
		
		return solution;
	}

	public int getClausesNumber() {
		return clausesNumber;
	}

	public void setClausesNumber(int clausesNumber) {
		this.clausesNumber = clausesNumber;
	}

	public int getVariablesNumber() {
		return variablesNumber;
	}

	public void setVariablesNumber(int variablesNumber) {
		this.variablesNumber = variablesNumber;
	}

	public int getClausesLength() {
		return clausesLength;
	}

	public void setClausesLength(int clausesLength) {
		this.clausesLength = clausesLength;
	}

	public int[][] getSATMatrix() {
		return SATMatrix;
	}

	public void setSATMatrix(int[][] sATMatrix) {
		SATMatrix = sATMatrix;
	}
	
        public  int getNumberClausesSatisfied(SAT sat, int literal) {
		int nb = 0;

		if(literal > 0) {

			for(int[] clause : sat.getSATMatrix()) {
				if(clause[Math.abs(literal)-1] == 1) {
					nb++;
				}
			}

		}else {

			for(int[] clause : sat.getSATMatrix()) {
				if(clause[Math.abs(literal)-1] == 0) {
					nb++;
				}
			}

		}

		return nb;
	}
        	public  int getNumberClausesSatisfied(int[] literals) {
		int nb = 0;
                int i=0;
		for(int[] clause : this.getSATMatrix()) {
			for(int l : literals) {
                            
				if(l>0 && clause[Math.abs(l)-1] == 1) {
					nb++;
					break;
				}else if(l<0 && clause[Math.abs(l)-1] == 0) {
					nb++;
					break;
				}

			}
		}
                    
		return nb;
	}
	public  int getNumberClausesSatisfied2( int[] literals) {
		
        int nbr=0 ; boolean b ;int j ;int signedVar,var ;
        for (int i = 0; i < this.clausesNumber; i++) {
            j=0; b = false ;
            while(!b && j<this.variablesNumber){
                signedVar = this.getSATMatrix()[i][j] ;
                var=Math.abs(signedVar);
               
                if(var<=literals.length){
                    if(var-1>=0)
                b=resultOf(signedVar, literals[var-1]) ;}
                
                j++;
            }
            if(b){ nbr ++ ;}
        }
            System.out.println(nbr);
        return nbr ;
    }
        
        
        
	 public  int nbclausesverif(int[] solution){
     	boolean[] b = new boolean[this.getSATMatrix().length];
     	int i = 0;
     	int nbtrue = 0;
     	int nbfalse=0;
     	Boolean result=true;
     	for(int [] clause : this.getSATMatrix()){
     		int cpt = 0;
            
     		for (int x : clause){
     		
                    if(x == solution[cpt]){
     					b[i] = true;
     			}
     			cpt++;	
                
     				
     		}
     		i++;
     	}
    
     	for (boolean bool : b){

     		
     		if(!bool) {
     			nbfalse++;
     			result=false;
     		}
     		else {
     			nbtrue++;
     		}
     		}
     	return nbtrue;
     }
public  int nbclausesverify(int[] solution){
     	boolean[] b = new boolean[this.getSATMatrix().length];
     	int i = 0;
     	int nbtrue = 0;
     	int nbfalse=0;
     	Boolean result=true;
        if (solution.length==0){return 0;}
     	for(int [] clause : this.getSATMatrix()){
     		int cpt = 0;
            
     		for (int x : clause){
     		if (cpt < solution.length){
                    if(x == solution[cpt]){
     					b[i] = true;
     			}
     			cpt++;	
                
     				
     		}}
     		i++;
     	}
    
     	for (boolean bool : b){

     		
     		if(!bool) {
     			nbfalse++;
     			result=false;
     		}
     		else {
     			nbtrue++;
     		}
     		}
     	return nbtrue;
     }
    private boolean resultOf(int signedVar, int literal) {
       if  (signedVar>0){
        if (literal == 1){
            return true;
        }
        else if (literal ==0){
            return false;
        }
        
    }
       else if (signedVar<0){
           if (literal == 1){
            return false;
        }
        else if (literal ==0){
            return true;
        }
       }
       return false ;
    }
         
         

}
