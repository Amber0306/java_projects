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
         //ϰ��1
       public static void practice1(){
    	   /*
    	    * Java�Ļ����������ͣ�
    	    * 1�������ͣ����ͣ�byte�ͣ�int�ͣ�short�ͣ�long�ͣ�
    	    *                                ʵ���ͣ�float�ͣ�double�ͣ�
    	    *                                �ַ��ͣ�char�ͣ�
    	    *                                �����ͣ�boolean�ͣ�
    	    *         �������ͣ����飻������󣻽ӿڣ�
    	    */
    	   byte by = 127;
    	   System.out.println("byte�������ӣ�"+by);
    	   int in= 200;
    	   System.out.println("int�������ӣ�"+in);
    	   short sh = 32767;
    	   System.out.println("short�������ӣ�"+sh);
    	   long lo=233333333;
    	   System.out.println("long�������ӣ�"+lo);
    	   float fl = 1.2E-4f;
    	   System.out.println("float�������ӣ�"+fl);
    	   double dou = 1.6E30;
    	   System.out.println("double�������ӣ�"+dou);
    	   char ch = 'A';
    	   System.out.println("char�������ӣ�"+ch);
    	   boolean bo = true;
    	   System.out.println("boolean�������ӣ�"+bo);
    	//�������;�����   
       }
     
       //ϰ��2
       /*�Ƚ�break��continue��������
        * break���: 1���ޱ�ţ����ƴӸ�������ڵ�switch��֧��ѭ����ת������ִ��������䡣
        *                        2���б�ţ���ֹ��ǰ��ִ�в���������������ʶ�����顣
        *  continue��䣺1���ޱ�ţ���ֹ��ǰ��һ��ѭ����������continue������ʣ�����䣬
        *                                                            ��������ж�ѭ�������������Ƿ������һ��ѭ����
        *                                  2���б�ţ�ʹ����ִ������ת��������ʶ��ѭ����Σ�����ִ�С�
        *  �ޱ�ŵ�������䣬break����ѭ����continue��ֹ��ǰһ��ѭ������δ����ѭ����
        */
         
       //ϰ��3
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
       
       //ϰ��4
       public static void practice4() {
    	 Scanner input = new Scanner(System.in);
    	 System.out.println("������һ���·�");
    	 int month = input.nextInt();
    	 while(month<1 ||month>12) {
    		 System.out.println("��������������룺");
    		 month = input.nextInt();
    	 }
    	 switch(month) {
    	 case 1:System.out.println("1����31��"); break;
    	 case 2:System.out.println("2����28���29��"); break;
    	 case 3:System.out.println("3����31��"); break;
    	 case 4:System.out.println("4����30��"); break;
    	 case 5:System.out.println("5����31��"); break;
    	 case 6:System.out.println("6����30��"); break;
    	 case 7:System.out.println("7����31��"); break;
    	 case 8:System.out.println("8����31��"); break;
    	 case 9:System.out.println("9����30��"); break;
    	 case 10:System.out.println("10����31��"); break;
    	 case 11:System.out.println("11����30��"); break;
    	 case 12:System.out.println("12����31��"); break;
    	 }
       }
       
       //ϰ��5
       public static void practice5() {
    	   Scanner input = new Scanner(System.in);
      	   System.out.println("������һ��������");
      	    int number = input.nextInt();
      	  System.out.println("������֮�ڵ������У�");
      	 
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
       
       //ϰ��6
       /*
        * �����ص㣺
        *     �̶����ȣ������鴴��ʱȷ�������洢��ͬ���͵���ֵ��
        *     ����Ԫ��������ĳ�Ա��ͨ�������λ������������
        *     �±���㿪ʼ
        * ������ʹ�ö������飺
        *      �������飺��ͬ���͵Ķ���Ϊ����Ԫ����ɵ�����
        *      ������ʹ�ò��裺
        *                 �������飺     Ԫ������ ������������
        *                 ��������ռ䣺������ = new ���͡�Ԫ�ظ�������
        *                 ��ǰ������ͬʱ���У��磺point p[] = new point[7];
        *                 ��������Ԫ�ز���ʼ����ʹ�ù��캯�����г�ʼ��
        *                           �磺for(int i = 0;i<p.length;i++)
        *                           {
        *                                    p[i] = new point(0,0);
        *                           }
        *     ͨ������Ԫ�أ����󣩣�������ĳ�Ա��������ķ���
        *                         �磺p[2] .location();
        */
       
       //ϰ��7
       public static void practice7() {
    	//��ȡ����
    	   System.out.println("�����������");
    	   Scanner reader = new Scanner(System.in);
    	   int number = reader.nextInt();
    	   int [] array = new int[number];
    	   for(int i = 0; i<number;i++) {
        	   System.out.println("�������" +( i+1) + "������");
        	   array[i] = reader.nextInt();
    	   }
    	   System.out.println("����Ϊ��");
    	   String arr = Arrays.toString(array);
    	   System.out.println(arr);
    	   //����
    	   for(int j = 0;j<number;j++) {
    		   for(int k = 0;k<number-j-1;k++) {
    			   if(array[k]>array[k+1]) {
    				   int temp = array[k];
        			   array[k] = array[k+1];
        			   array[k+1] = temp;
    			   }
    		   }
    	   }
    	   //���
    	   System.out.println("��������С�����ǣ�"+array[0]);
    	   System.out.println("�������������ǣ�"+array[number-1]);
    	   System.out.println("������������Ϊ��");
    	   arr = Arrays.toString(array);
    	   System.out.println(arr);
       }
       
}
