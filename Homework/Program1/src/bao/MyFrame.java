package bao;

import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{
	//������
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
	private Button btnClear=new Button("���");
	private Panel buttons=new Panel();
	//private Button btnQuit=new Button("�˳�");
	//���幹�췽��
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
		//����¼�������
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
	//������Ӧ�¼��ķ���
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
	/*flag�ж�֮ǰ�Ƿ���һ������������
	 * ���flagΪ0�����ֲ�������flagΪ1����������
	 * flagΪ2���������ո�
	 * ���������ֺ����ǿո�
	 
	
	//������ʽ
	public double count(String s) {
		//��׺���ʽת��׺���ʽ
		//��ʼ��ջ
		s="#"+s+"#";
		Stack<Character> st1=new Stack<>();//�����ջ
		String postfix=new String();//�����׺���ʽ
		for(int i=0;(i<s.length())&&(s!=null);i++) {
			char ch=s.charAt(i);//��ȡ��ǰ�ַ�
			if(' '!=ch){
				if(isOperator(ch)){
					//����ջ�ǿգ�ȡ��ջ�����ȼ��ߵ������
					if(!st1.empty()){
						char ar=st1.pop();
						//ջȡ�����ַ����ȼ���c��
						while(!st1.isEmpty()&&priority(ar)>=priority(ch)){
							postfix=postfix.concat(String.valueOf(ar));
							ar=st1.pop();
						}
						//ջȡ�����ַ����ȼ���c�ͣ���ȡ�����ַ�������ջ
						if(ar!=' '){
							st1.push(ar);
						}
					}
					st1.push(ch);    //��ch�������ջ
				}
				//Ϊ��������ֱ�Ӵ�����postfix��
				else {
					postfix=postfix.concat(String.valueOf(ch));
				}
			}
		}
		while(!st1.isEmpty()){//���ʽ���꽫�������ջ��������׺���ʽ
			postfix=postfix.concat(String.valueOf(st1.pop()));
		}
		//postfix+="#";
		System.out.println(postfix);
		//��׺���ʽpostfix������
		String str[];
		str=postfix.split("#");
		System.out.println(str[0]+str[1]+str[2]);
		//����һ��������ջ
		Stack st2=new Stack();
		for(int j=0;postfix!=null&&j<postfix.length();j++) {
			char c=postfix.charAt(j);//��ȡ��ǰ�ַ�
			if(isOperator(c)&&!st2.isEmpty()){
				//ȡ������ʱ������ȡһλ��#֮ǰΪһ����������
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
				//��������ѹ�������ջ��
				st2.push(res);
			}else{//Ϊ������ʱֱ��ѹ�������ջ
			st2.push(c);			
			}
		}
		return (double) st2.pop();
	}
	//�ж���������ȼ�
	public int priority(char c){
		if(c=='*'||c=='/'){
			return 2;
		}
		else if(c=='+'||c=='-'){
			return 1;
		}
		else return 0;
	}
	//�ж��ַ�Ϊ�����
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
			strings = input.split(" ");//�Կո�Ϊ�ָ�����������Ͳ�ͬ���ָ���
			Stack<Double> st = new Stack<Double>();//��ʼ��������ջ
			double m = Double.parseDouble(strings[0]);
			st.push(m);//��һ����������ջ
			for(int i=1;i<strings.length;i++)	{
				if(i%2==1){  //�������Ϊż��λ����������Ϊ����λ������������
	                if(strings[i].compareTo("+")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    st.push(temp);  //����һ����������ջ
	                }  	                  
	                if(strings[i].compareTo("-")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    st.push(-temp);  //��������ת��Ϊ��������
	                }  	                  
	                if(strings[i].compareTo("*")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    double res = st.peek();//ȡ��ջ��Ԫ��  
	                    st.pop();
	                    res*=temp;  //����*ǰ���������˺��ٴ���ջ
	                    st.push(res);  
	                }  	                  
	                if(strings[i].compareTo("/")==0){  
	                    double temp = Double.parseDouble(strings[i+1]);  
	                    double res = st.peek();  
	                    st.pop();  
	                    res/=temp;  
	                    st.push(res);  
	                }  
	            } //ȫ��ת���ӷ����� 
	        }  
	        double res = 0d;  
	        while(!st.isEmpty()){  
	            res+=st.peek();  
	            st.pop();  //ջ������Ԫ����Ӽ�Ϊ���ս��
	        }  
	        String result = String.valueOf(res);
	        return result;
		}
}
