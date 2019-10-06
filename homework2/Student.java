package homework2;
import java.util.*;
import java.io.*;

public class Student
{
	String name;
	double GPA;
	static int Count=0;
	Student(String str,double d)
	{
		name=str;
		GPA=d;
		Count++;
	}
	Student(String str)
	{
		name=str;
        Count++;
	}
	static void getCount()
	{
		System.out.println("The sum of the students is "+Count);
	}	
}

class test
{
	public static void main(String []args)
	{
		Student student1=new Student("Lily");
		Student student2=new Student("Tom",4.0);
		Student.getCount();
	}
}
