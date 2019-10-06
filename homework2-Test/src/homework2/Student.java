package homework2;
import java.util.*;
import java.io.*;

public class Student
{
	private String name;
	private double GPA;
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
