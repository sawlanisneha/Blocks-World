import java.util.Arrays;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Block A = new Block("A");
		Block B = new Block("B");
		Block C = new Block("C");
		Block D = new Block("D");
		Block E = new Block("E");
		Block F = new Block("F");
		Block G = new Block("G");
		
		//Simple setup
		ArrayList<Predicate> startWorld = new ArrayList<Predicate>(Arrays.asList(
				new Predicate(Predicate.ON, B, A),
				new Predicate(Predicate.ONTABLE, A),
				new Predicate(Predicate.ONTABLE, C),
				new Predicate(Predicate.ONTABLE, D),
				new Predicate(Predicate.CLEAR, B),
				new Predicate(Predicate.CLEAR, C),
				new Predicate(Predicate.CLEAR, D),
				new Predicate(Predicate.ARMEMPTY)
				));
		

		ArrayList<Predicate> targetWorld = new ArrayList<Predicate>(Arrays.asList(
				new Predicate(Predicate.ON, C, A),
				new Predicate(Predicate.ON, B, D),
				new Predicate(Predicate.ONTABLE, A),
				new Predicate(Predicate.ONTABLE, D),
				new Predicate(Predicate.CLEAR, C),
				new Predicate(Predicate.CLEAR, B),
				new Predicate(Predicate.ARMEMPTY)
				));
		
		
		Solver solver = new Solver(startWorld, targetWorld);
		ArrayList<Action> solution = solver.findSolution();
		
		System.out.println("From " + startWorld + " to " + targetWorld);
		
		for(Action a : solution)
		{
			System.out.println(a);
		}
		
	}
	

}
