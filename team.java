import java.util.Random;

public class team
{
    final static int TEAM_SIZE = 5;
    final static int POP_SIZE = 200 + TEAM_SIZE;  // team size
    final static double CROSSOVER_RATE = 0.7;     // probability of crossover
    private static Random m_rand = new Random();  // random-number generator
    private player[] m_team;
    public static team pop;

    public team() {
        m_team = new player[POP_SIZE];
        // init team
        for (int i = 0; i < POP_SIZE; i++) {			
            m_team[i] = new player();
            m_team[i].randRoless();
        }

    }
    public player[] getteam() {
        return this.m_team;
    }

    public double evaluate(int index, int team_slot) {
        //for (int i = index; i < index+4; i++) {
            return m_team[index].evaluate(team_slot);
       // }
    }

    public double findBestTeam() {
    	int team_slot;
    	double fitness;
    	double fitness2 = 0;
    	//int location;
    	for (int iter = 0; iter < POP_SIZE-10; iter++) {
            team_slot = 0;
            fitness = 0;
            //find best team
            for (int i=iter; i<(iter+5); ++i) {           	
        		//evaluate team fitness
        		fitness += evaluate(i,team_slot);
        		//System.out.println(fitness);
        	} 
            if(fitness>5){
            	System.out.println(fitness);
        	}
            if(fitness>=fitness2){
            	fitness2 = fitness;
            	//location = iter;
            }
           
        }
    	return fitness2;
    }

    public void crossover(int team1, int team2) {
    	player temp = m_team[team1];
    	m_team[team1] =  m_team[team1+5];
    	m_team[team1+5] =  temp;
    	
    	player temp2 = m_team[team2];
    	m_team[team2] =  m_team[team1+3];
    	m_team[team1+3] =  temp2;
    	
    	player temp3 = m_team[team2+1];
    	m_team[team2+1] =  m_team[team2+2];
    	m_team[team2+2] =  temp3;
    	        
    }
    public void swap(int tracker){
    	for(int k = 0;k<=4;k++){
    		player temp = m_team[k];
    		m_team[k] = m_team[tracker+k];
    		m_team[tracker+k] = temp;
    	}
    }


    public static void main(String[] args) {    	
        pop = new team();
        int team_slot;
        double fitness = 0;
        double fitness2 = 0;
        double fitness3 = 0;
        int tracker = 0;
        
        for(int k = 0; k<500; k++){
        	fitness2 = 0;
        for (int iter = 0; iter < POP_SIZE-10; iter++) {
            team_slot = 0;
            fitness = 0;
            //fitness2 = 0;
            //find best team
            for (int i=iter; i<(iter+5); ++i) {           	
        		//evaluate team fitness
        		fitness += pop.evaluate(i,team_slot);
        		//System.out.println(fitness);
        		team_slot++;
        	}                                               	           
            	if(fitness >= fitness2){
            		fitness2=fitness;
            		tracker=iter;
            	}
            
        }
        	if(fitness2 > fitness3){
        		fitness3=fitness2;
        		pop.swap(tracker);        		
        	}        	
        	for (int iter = 5; iter < POP_SIZE-10; iter++) {
        		if ( m_rand.nextDouble() < CROSSOVER_RATE ) {
            		pop.crossover(iter, iter+1);
            	}
            }
        }
        System.out.print("best team fitness evaluated is: ");
        System.out.println(pop.evaluate(0,0)+pop.evaluate(1,1)+pop.evaluate(2,2)+pop.evaluate(3,3)+pop.evaluate(4,4));


        	
    }
}