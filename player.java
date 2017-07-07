import java.util.Random;

public class player {

	public final static int SIZE = 2; //lets assume 2 Roless
	private int[] Roless = new int[SIZE];
	
	public player(){}
	
	public int getRoles(int index){				//get role
		return Roless[index];
	}
	public void setRoles(int index, int Roles) {	//set role
        this.Roless[index] = Roles;
    }
	public void randRoless() {					//random roles 0-4
        Random rand = new Random();
        for(int i=0; i<=1; i++) {
        	int temp = rand.nextInt(100);
        	if(temp<10){
        		 this.setRoles(i, 0);
        	}
        	else if(temp>=10 && temp <35){
        		 this.setRoles(i, 1);
        	}
        	else if(temp>=35 && temp<65){
        		 this.setRoles(i, 2);        		 
        	}
        	else if(temp>=65 && temp<90){
        		 this.setRoles(i, 3);        		 
        	}
        	else{
        		 this.setRoles(i, 4);
        	}           
        }
    }
	
	 public double evaluate(int team_slot) {					//evaluate fitness
	        double fitness = 0;
	        for(int i=0; i<=1; i++) {
	        	if(i==0){
	        		if(team_slot == this.getRoles(i)){
	        			fitness += 2;
	        			//System.out.println(team_slot + "=" + this.getRoles(i));
	        		}
	        	}
	        	else{
	        		if(team_slot == this.getRoles(i)){
	        			fitness += 1;
	        			//System.out.println(team_slot + "=" + this.getRoles(i));
	        		}
	        	}	        		           
	        }	       
	        //System.out.println(fitness);
	        return fitness;	        
	    }
	 
}
