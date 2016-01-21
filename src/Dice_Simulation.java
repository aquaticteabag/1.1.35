
public class Dice_Simulation {

	public static void main(String[] args) {
		int SIDES = 6; //Number of sides on the dice
		int TRIALS = 800000; //Number of trials simulated
		double[] dist = new double[2*SIDES + 1];
		for (int i = 1; i <= SIDES; i++)
			for (int j = 1; j <= SIDES; j++)
				dist[i+j] += 1.0;
		
		for (int k = 2; k <= 2*SIDES; k++){
			dist[k] /= 36.0;	
		}
		
		//Variables representing the two rolled dice and their sum
		int dieA;
		int dieB;
		int sum;
		//creates test and diff arrays to compare to the distribution
		double [] test = new double[2*SIDES + 1];
		double [] diff = new double[2*SIDES + 1];
		
		//Loop fills test array with number of times a certain number is rolled
		for (int N = TRIALS; N > 0; N--){
			dieA = (int) (1 + (Math.random() * 6));
			dieB = (int) (1 + (Math.random() * 6));
			sum = dieA + dieB;
			test[sum]++;
		}
		
		
		//Walks through the test array modifying totals to reflect probability distribution
		for (int p = 2; p <= 2*SIDES; p++){
			test[p] /= TRIALS;			
		}
		
		boolean accurate = true;
		
		//Checks to see if the test array matches the expected results to .001
		for (int i = 2; i <+ 2*SIDES; i++){
			diff[i] = test[i] - dist[i];
			if (Math.abs(diff[i]) < .001)
				diff[i] = 0;
			if (diff[i] != 0)
				accurate = false;		
			System.out.println(diff[i]);
		}
		System.out.println(accurate);
		
		
	}
}
