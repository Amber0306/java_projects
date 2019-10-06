package homework1;
import java.util.Arrays;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class excercise {
	
         public static void main(String[] args) {
        
          practice1();
          practice3();
           practice4();
           practice5();
        	 practice7();
         
         System.exit(0);
    }
         //习题1
       public static void practice1(){
    	   /*
    	    * Java的基本数据类型：
    	    * 1，简单类型：整型：byte型；int型；short型；long型；
    	    *                                实数型：float型；double型；
    	    *                                字符型：char型；
    	    *                                布尔型：boolean型；
    	    *         引用类型：数组；类与对象；接口；
    	    */
    	   byte by = 127;
    	   System.out.println("byte类型例子："+by);
    	   int in= 200;
    	   System.out.println("int类型例子："+in);
    	   short sh = 32767;
    	   System.out.println("short类型例子："+sh);
    	   long lo=233333333;
    	   System.out.println("long类型例子："+lo);
    	   float fl = 1.2E-4f;
    	   System.out.println("float类型例子："+fl);
    	   double dou = 1.6E30;
    	   System.out.println("double类型例子："+dou);
    	   char ch = 'A';
    	   System.out.println("char类型例子："+ch);
    	   boolean bo = true;
    	   System.out.println("boolean类型例子："+bo);
    	//引用类型举例略   
       }
     
       //习题2
       /*比较break和continue语句的区别：
        * break语句: 1）无标号：控制从该语句所在的switch分支或循环跳转出来，执行其后继语句。
        *                        2）有标号：终止当前的执行并跳出这个标号所标识的语句块。
        *  continue语句：1）无标号：终止当前这一轮循环，即跳过continue语句后面剩余的语句，
        *                                                            并计算和判断循环条件，决定是否进入下一轮循环。
        *                                  2）有标号：使程序执行流程转入标号所标识的循环层次，继续执行。
        *  无标号的两种语句，break跳出循环，continue终止当前一轮循环、并未跳出循环。
        */
         
       //习题3
       public static void practice3() {
    	   int n = 1678;
    	   int[] s;
    	   s = new int[4];
    	   for(int i=0;i<4;i++)
    	   {
    		   s[i] = n%10;
    		   n = n/10;
    	   }
    	   	System.out.println("n = "+s[3]+", "+s[2]+", "+s[1]+", "+s[0]);
       }
       
       //习题4
       public static void practice4() {
    	 Scanner input = new Scanner(System.in);
    	 System.out.println("请输入一个月份");
    	 int month = input.nextInt();
    	 while(month<1 ||month>12) {
    		 System.out.println("输入错误，重新输入：");
    		 month = input.nextInt();
    	 }
    	 switch(month) {
    	 case 1:System.out.println("1月有31天"); break;
    	 case 2:System.out.println("2月有28天或29天"); break;
    	 case 3:System.out.println("3月有31天"); break;
    	 case 4:System.out.println("4月有30天"); break;
    	 case 5:System.out.println("5月有31天"); break;
    	 case 6:System.out.println("6月有30天"); break;
    	 case 7:System.out.println("7月有31天"); break;
    	 case 8:System.out.println("8月有31天"); break;
    	 case 9:System.out.println("9月有30天"); break;
    	 case 10:System.out.println("10月有31天"); break;
    	 case 11:System.out.println("11月有30天"); break;
    	 case 12:System.out.println("12月有31天"); break;
    	 }
       }
       
       //习题5
       public static void practice5() {
    	   Scanner input = new Scanner(System.in);
      	   System.out.println("请输入一个整数：");
      	    int number = input.nextInt();
      	  System.out.println("该整数之内的素数有：");
      	 
      		 for(int i=2;i<=number;i++) {
      			 boolean prime = true;
      			 for(int j=2;j<i;j++) {
      				 if(i%j==0) {
      					 prime=false;
      					 break;
      				 }
      			 }
      			 if(prime) {
      				System.out.println(i);
      			 }
      		 }
      		 
       }
       
       //习题6
       /*
        * 数组特点：
        *     固定长度（在数组创建时确定），存储相同类型的数值；
        *     数组元素是数组的成员，通过数组的位置来访问它；
        *     下标从零开始
        * 创建和使用对象数组：
        *      对象数组：由同类型的对象为数组元素组成的数组
        *      创建与使用步骤：
        *                 声明数组：     元素类型 数组名【】；
        *                 创建数组空间：数组名 = new 类型【元素个数】；
        *                 （前两步可同时进行）如：point p[] = new point[7];
        *                 创建数组元素并初始化：使用构造函数进行初始化
        *                           如：for(int i = 0;i<p.length;i++)
        *                           {
        *                                    p[i] = new point(0,0);
        *                           }
        *     通过数组元素（对象），访问类的成员变量及类的方法
        *                         如：p[2] .location();
        */
       
       //习题7
       public static void practice7() {
    	//获取数据
    	   System.out.println("请输入个数：");
    	   Scanner reader = new Scanner(System.in);
    	   int number = reader.nextInt();
    	   int [] array = new int[number];
    	   for(int i = 0; i<number;i++) {
        	   System.out.println("请输入第" +( i+1) + "个数：");
        	   array[i] = reader.nextInt();
    	   }
    	   System.out.println("数组为：");
    	   String arr = Arrays.toString(array);
    	   System.out.println(arr);
    	   //排序
    	   for(int j = 0;j<number;j++) {
    		   for(int k = 0;k<number-j-1;k++) {
    			   if(array[k]>array[k+1]) {
    				   int temp = array[k];
        			   array[k] = array[k+1];
        			   array[k+1] = temp;
    			   }
    		   }
    	   }
    	   //输出
    	   System.out.println("数组中最小的数是："+array[0]);
    	   System.out.println("数组中最大的数是："+array[number-1]);
    	   System.out.println("重新排序后输出为：");
    	   arr = Arrays.toString(array);
    	   System.out.println(arr);
       }
       
}
