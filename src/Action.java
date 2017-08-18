import java.util.ArrayList;

public class Action {
	
	private String name;
	private Block arg1;
	private Block arg2;
	
	public static String UNSTACK = "unstack";
	public static String STACK = "stack";
	public static String PICKUP = "pickup";
	public static String PUTDOWN = "putdown";
	
	public Action(String name, Block arg1, Block arg2)
	{
		this.name = name;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public Action(String name, Block arg1)
	{
		this.name = name;
		this.arg1 = arg1;
	}
	
	public Pair<ArrayList<Predicate>, ArrayList<Predicate>> apply()
	{
		ArrayList<Predicate> toRemove = new ArrayList<Predicate>();
		ArrayList<Predicate> toAdd = new ArrayList<Predicate>();
		
		if(name.equals(UNSTACK))
		{
			toRemove.add(new Predicate(Predicate.ON, arg1, arg2));
			toRemove.add(new Predicate(Predicate.ARMEMPTY));
			toRemove.add(new Predicate(Predicate.CLEAR, arg1));
			toAdd.add(new Predicate(Predicate.HOLD, arg1));
			toAdd.add(new Predicate(Predicate.CLEAR, arg2));
		}
		else if(name.equals(STACK))
		{
			toRemove.add(new Predicate(Predicate.CLEAR, arg2));
			toRemove.add(new Predicate(Predicate.HOLD, arg1));
			toAdd.add(new Predicate(Predicate.ON, arg1, arg2));
			toAdd.add(new Predicate(Predicate.ARMEMPTY));
			toAdd.add(new Predicate(Predicate.CLEAR, arg1));
		}
		else if(name.equals(PICKUP))
		{
			toRemove.add(new Predicate(Predicate.ARMEMPTY));
			toRemove.add(new Predicate(Predicate.ONTABLE, arg1));
			toRemove.add(new Predicate(Predicate.CLEAR, arg1));
			toAdd.add(new Predicate(Predicate.HOLD, arg1));
		}
		else if(name.equals(PUTDOWN))
		{
			toRemove.add(new Predicate(Predicate.HOLD, arg1));
			toAdd.add(new Predicate(Predicate.ARMEMPTY));
			toAdd.add(new Predicate(Predicate.ONTABLE, arg1));
			toAdd.add(new Predicate(Predicate.CLEAR, arg1));
		}
		
		return new Pair(toRemove, toAdd);
			
		
	}
	
	public String toString()
	{
		if(arg2 != null)
			return new String(name + " " + arg1 + " " + arg2);
		return new String(name + " " + arg1);
			
			
	}

}
