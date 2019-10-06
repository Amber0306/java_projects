package bao;

import java.util.Scanner;

public class program1 {

	public static void main(String[] args) {
         Fibonacci(20);
         Rank(5);
	}
	//斐波那契数列
   public static void  Fibonacci(int n) {
	  int []array= new int[n];
	  array[0]=1;System.out.print(array[0]+", ");
	  array[1]=2;System.out.print(array[1]+", ");
	  for(int i=2;i<n;i++) {
		  array[i]=array[i-1]+array[i-2];
		  System.out.print(array[i]+", ");
	  }	  
	  System.out.println();
   }
	  //冒泡排序
	  public static void Rank(int n) {
		  //接收用户输入
		  Scanner input=new Scanner(System.in);
		  int []array=new int[n];
		  for(int i=0;i<n;i++) {
			    int temp=input.nextInt();
			    array[i]=temp;
		  }
		  //进行排序
			  for(int j=0;j<array.length-1;j++) {
		            for(int k=j+1;k<array.length;k++) {
		                  if(array[j]>array[k]){
		                	  int t=array[j];
		                      array[j]=array[k];
		                      array[k]=t;
		                  }         
		            }
	       }
			  //输出
			  for(int i=0;i<array.length;i++) {
				  System.out.print(array[i]+",");
			  }
	  }
}
