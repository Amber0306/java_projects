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
		String s=name+"     "+"������Ʊ��Ϊ��"+tickets+" ��";
		return s;
	}
}
