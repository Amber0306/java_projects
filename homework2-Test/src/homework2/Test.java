package homework2;

public class Test {
	//int x=30;
	public static void main(String []args)
	{
		/*
		Student student1=new Student("Lily");
		Student student2=new Student("Tom",4.0);
		Student.getCount();
		*/
		/*
		int x=20;
		Test ta = new Test();
		ta.Method(x);
		System.out.println(x);
		System.exit(0);
		*/
		//getIt();
		//test();
		Test t1=new Test();
		t1.print();
		Test t2=new Test();
		t2.print();
	}
	/*
	void Method(int y)
	{
	int x=y*y;
	}
	*/
	/*
	public static Integer getIt()
	{
		Integer rg =new Integer(3);
		Integer dg=rg;
		rg=null;
		return rg;
	}public static void test()
	{
		this.print();
	}
	*/
	static {
		System.out.println("Hi,there");
	}
	public void print() {
		System.out.println("Hello");
	}
}
