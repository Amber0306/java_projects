package program1;
import java.util.*;

public class LeapYear {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);		
		int year=scanner.nextInt();
		Boolean is=IsLeapYear(year);
		System.out.println(year+"是否为闰年："+is);		
		
		ShowNine();
	}
	
	//判断是否为闰年
	public static Boolean IsLeapYear(int year) {
		Boolean is=false;
		if((year%4==0&&year%100!=0)||(year%400==0)) {
			is=true;
		}
		return is;
	}
	
	//输出九九乘法表
	public static void ShowNine() {
		for(int i=1;i<10;i++)
		{
			for(int j=1;j<=i;j++) {
				System.out.print(i+"*"+j+"="+(i*j));
				System.out.print('\t');
			}
			System.out.print('\n');
		}
	}

}
