package bao;

import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{
	//定义域
	private TextField  showSpace = new TextField("");
	private Font font=new Font("font1",30,40);
	//showSpace.setFont(font);
	private Button btn0=new Button("0");
	private Button btn1=new Button("1");
	private Button btn2=new Button("2");
	private Button btn3=new Button("3");
	private Button btn4=new Button("4");
	private Button btn5=new Button("5");
	private Button btn6=new Button("6");
	private Button btn7=new Button("7");
	private Button btn8=new Button("8");
	private Button btn9=new Button("9");
	private Button btnAdd=new Button("+");
	private Button btnMinus=new Button("-");
	private Button btnMultiply=new Button("*");
	private Button btnDivide=new Button("/");
	private Button btnEqual=new Button("=");
	private Button btnClear=new Button("清空");
	private Panel buttons=new Panel();
	//private Button btnQuit=new Button("退出");
	//定义构造方法
	public MyFrame() {
		super("Calculator:");
		showSpace.setFont(font);
		buttons.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		setLayout(new BorderLayout());
		add("North",showSpace);
		add("Center",buttons);
		//add("South",btnQuit);
		buttons.setLayout(new GridLayout(4,4));
		buttons.add(btn7);
		buttons.add(btn8);
		buttons.add(btn9);
		buttons.add(btnAdd);
		buttons.add(btn4);
		buttons.add(btn5);
		buttons.add(btn6);
		buttons.add(btnMinus);
		buttons.add(btn1);
		buttons.add(btn2);
		buttons.add(btn3);
		buttons.add(btnMultiply);
		buttons.add(btn0);
		buttons.add(btnEqual);
		buttons.add(btnClear);
		buttons.add(btnDivide);
		//添加事件监听器
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btnAdd.addActionListener(this);
		btnMinus.addActionListener(this);
		btnMultiply.addActionListener(this);
		btnDivide.addActionListener(this);
		btnClear.addActionListener(this);
		btnEqual.addActionListener(this);
		setSize(1000,500);
		setResizable(true);
		pack();
		setVisible(true);	
	}
	//定义响应事件的方法
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn0) {
			String s=showSpace.getText();
			showSpace.setText(s+"0");
		}else if(e.getSource()==btn1) {
			String s=showSpace.getText();
			showSpace.setText(s+"1");
		}else if(e.getSource()==btn2) {
			String s=showSpace.getText();
			showSpace.setText(s+"2");
		}else if(e.getSource()==btn3) {
			String s=showSpace.getText();
			showSpace.setText(s+"3");
		}else if(e.getSource()==btn4) {
			String s=showSpace.getText();
			showSpace.setText(s+"4");
		}else if(e.getSource()==btn5) {
			String s=showSpace.getText();
			showSpace.setText(s+"5");
		}else if(e.getSource()==btn6) {
			String s=showSpace.getText();
			showSpace.setText(s+"6");
		}else if(e.getSource()==btn7) {
			String s=showSpace.getText();
			showSpace.setText(s+"7");
		}else if(e.getSource()==btn8) {
			String s=showSpace.getText();
			showSpace.setText(s+"8");
		}else if(e.getSource()==btn9) {
			String s=showSpace.getText();
			showSpace.setText(s+"9");
		}else if(e.getSource()==btnAdd) {
			String s=showSpace.getText();
			showSpace.setText(s+" "+"+"+" ");
		}else if(e.getSource()==btnMinus) {
			String s=showSpace.getText();
			showSpace.setText(s+" "+"-"+" ");
		}else if(e.getSource()==btnMultiply) {
			String s=showSpace.getText();
			showSpace.setText(s+" "+"*"+" ");
		}else if(e.getSource()==btnDivide) {
			String s=showSpace.getText();
			showSpace.setText(s+" "+"/"+" ");
		}else if(e.getSource()==btnClear) {
			showSpace.setText("");
		}else if(e.getSource()==btnEqual) {
			String s=showSpace.getText();
			String result=compute(s);
			showSpace.setText(s+" = "+result);
		}
	}
	/*flag判断之前是否是一个完整的数字
	 * 如果flag为0，数字不完整，flag为1，数字完整
	 * flag为2，运算符或空格
	 * 完整的数字后面是空格
	 
	
	//计算表达式
	public double count(String s) {
		//中缀表达式转后缀表达式
		//初始化栈
		s="#"+s+"#";
		Stack<Character> st1=new Stack<>();//运算符栈
		String postfix=new String();//储存后缀表达式
		for(int i=0;(i<s.length())&&(s!=null);i++) {
			char ch=s.charAt(i);//获取当前字符
			if(' '!=ch){
				if(isOperator(ch)){
					//运算栈非空，取出栈顶优先级高的运算符
					if(!st1.empty()){
						char ar=st1.pop();
						//栈取出的字符优先级比c高
						while(!st1.isEmpty()&&priority(ar)>=priority(ch)){
							postfix=postfix.concat(String.valueOf(ar));
							ar=st1.pop();
						}
						//栈取出的字符优先级比c低，则将取出的字符重新入栈
						if(ar!=' '){
							st1.push(ar);
						}
					}
					st1.push(ch);    //将ch运算符入栈
				}
				//为操作数，直接串联到postfix内
				else {
					postfix=postfix.concat(String.valueOf(ch));
				}
			}
		}
		while(!st1.isEmpty()){//表达式读完将运算符出栈串联至后缀表达式
			postfix=postfix.concat(String.valueOf(st1.pop()));
		}
		//postfix+="#";
		System.out.println(postfix);
		//后缀表达式postfix计算结果
		String str[];
		str=postfix.split("#");
		System.out.println(str[0]+str[1]+str[2]);
		//创建一个操作数栈
		Stack st2=new Stack();
		for(int j=0;postfix!=null&&j<postfix.length();j++) {
			char c=postfix.charAt(j);//获取当前字符
			if(isOperator(c)&&!st2.isEmpty()){
				//取操作数时不仅仅取一位，#之前为一个完整的数
				String temp1="";
				do{				
					temp1+=st2.pop().toString();
				}while(Integer.valueOf(st2.pop().toString())!='#');
				double a=Double.valueOf(temp1);
				System.out.println(temp1);
			//double a=Integer.valueOf(st2.pop().toString());
			//double b=Integer.valueOf(st2.pop().toString());
				String temp2="";
				do{				
					temp2+=st2.pop().toString();
				}while(Integer.valueOf(st2.pop().toString())!='#');
				double b=Double.valueOf(temp2);
				System.out.println(temp2);
			    double res=0;							
				if('+'==c){
					res=a+b;
				}
				if('-'==c){
					res=a-b;
				}
				if('/'==c){
					res=a/b;
				}
				if('*'==c){
					res=a*b;
				}				
				//将运算结果压入操作数栈中
				st2.push(res);
			}else{//为操作数时直接压入操作数栈
			st2.push(c);			
			}
		}
		return (double) st2.pop();
	}
	//判断运算符优先级
	public int priority(char c){
		if(c=='*'||c=='/'){
			return 2;
		}
		else if(c=='+'||c=='-'){
			return 1;
		}
		else return 0;
	}
	//判断字符为运算符
		public boolean isOperator(char c){
			if('+'==c||'-'==c||'/'==c||'*'==c){
				return true;
			}
			else {
				return false;
			}
		}
		*/
		public static String compute(String input) {
			String strings[];
			strings = input.split(" ");//以空格为分隔符将运算符和不同数字隔开
			Stack<Double> st = new Stack<Double>();//初始化操作数栈
			double m = Double.parseDouble(strings[0]);
			st.push(m);//第一个操作数入栈
			for(int i=1;i<strings.length;i++)	{
				if(i%2==1){  //运算符均为偶数位，操作数均为奇数位。如果是运算符
	                if(strings[i].compareTo("+")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    st.push(temp);  //将下一个操作数入栈
	                }  	                  
	                if(strings[i].compareTo("-")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    st.push(-temp);  //减法运算转化为负数运算
	                }  	                  
	                if(strings[i].compareTo("*")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    double res = st.peek();//取出栈顶元素  
	                    st.pop();
	                    res*=temp;  //本个*前后操作数相乘后再次入栈
	                    st.push(res);  
	                }  	                  
	                if(strings[i].compareTo("/")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    double res = st.peek();  
	                    st.pop();  
	                    res/=temp;  
	                    st.push(res);  
	                }  
	            } //全部转至加法运算 
	        }  
	        double res = 0d;  
	        while(!st.isEmpty()){  
	            res+=st.peek();  
	            st.pop();  //栈中所有元素相加即为最终结果
	        }  
	        String result = String.valueOf(res);
	        return result;
		}
}
