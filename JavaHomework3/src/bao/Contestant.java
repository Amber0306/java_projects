package bao;

public class Contestant {
	String name;
	 int tickets;
	
	public Contestant(String n)
	{
		name=n;
		tickets=0;
	}
	
	public String toString()
	{
		String s=name+"     "+"所得总票数为："+tickets+" ；";
		return s;
	}
}
