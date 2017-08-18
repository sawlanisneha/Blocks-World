import java.util.ArrayList;

public class ProblemState implements Comparable{
	
	private ProblemState parent;
	private ArrayList<Predicate> world;
	private Action actionTaken;
	private int g, h;
	
	public ProblemState(ProblemState parent, ArrayList<Predicate> world, Action actionTaken, int g, int h)
	{
		this.parent = parent;
		this.world = world;
		this.actionTaken = actionTaken;
		this.g = g;
		this.h = h;
	}
	
	public int getG()
	{
		return g;
	}
	
	public int getH()
	{
		return h;
	}
	
	public int getF()
	{
		return g + h;
	}
	
	public ProblemState getParent()
	{
		return parent;
	}
	
	public Action getActionTaken()
	{
		return actionTaken;
		
	}
	
	public ArrayList<Predicate> getWorld()
	{
		return world;
	}
	
	@Override
	public int compareTo(Object o)
	{
		ProblemState other = (ProblemState) o;
		return Integer.valueOf(this.getF()).compareTo(other.getF());
	}

}
