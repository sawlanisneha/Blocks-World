
public class Predicate implements Comparable{
	
	private String name;
	private Block arg1;
	private Block arg2;
	
	public static String ON = "on";
	public static String ONTABLE = "ontable";
	public static String CLEAR = "clear";
	public static String HOLD = "hold";
	public static String ARMEMPTY = "armempty";
	
	public Predicate (String name, Block arg1, Block arg2)
	{
		this.name = name;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public Predicate(String name, Block arg1)
	{
		this.name = name;
		this.arg1 = arg1;
		this.arg2 = null;
	}
	
	public Predicate(String name)
	{
		this.name = name;
		this.arg1 = null;
		this.arg2 = null;
	}

	public String getName()
	{
		return name;
	}
	
	public Block getArg1()
	{
		return arg1;
	}
	
	public Block getArg2()
	{
		return arg2;
	}
	
	@Override
	public int compareTo(Object o)
	{
		Predicate other = (Predicate) o;
		
		int c = name.compareTo(other.getName());
		
		//System.out.println(name + " " + other.getName());
		//System.out.println(other.getArg1());
		
		if(c == 0 && arg1 != null)
		{
			c = arg1.toString().compareTo(other.getArg1().toString());
		}
		
		if(c == 0 && arg2 != null)
		{
			c = arg2.toString().compareTo(other.getArg2().toString());
		}
		
		return c;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(! (obj instanceof Predicate))
			return super.equals(obj);
		
		if(compareTo(obj) == 0)
			return true;
		return false;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name + " ");
		if(arg1 != null)
			sb.append(arg1 + " ");
		if(arg2 != null)
			sb.append(arg2);
		return sb.toString();
			
	}
}
