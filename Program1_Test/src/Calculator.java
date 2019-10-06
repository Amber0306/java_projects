import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame implements ActionListener{
	    private double a=0,b=0,sum=0;
	    int flag=0,count=0,p=1;
    char mode='?';//本次运算的符号
	private TextField display = new TextField();
	private Button one = new Button("1");
	private Button two = new Button("2");
	private Button three = new Button("3");
	private Button four = new Button("4");
	private Button five = new Button("5");
	private Button six = new Button("6");
	private Button seven = new Button("7");
	private Button eight = new Button("8");
	private Button nine = new Button("9");
	private Button zero = new Button("0");
	private Button point = new Button(".");
	private Button add = new Button("+");
	private Button sub = new Button("-");
	private Button mul = new Button("*");
	private Button div = new Button("÷");
	private Button result = new Button("=");
	private Button clr = new Button("CLR");
    private Button quit = new Button("quit");
	private Label label = new Label("计算器");

	private class WindowCloser extends WindowAdapter{
      public void windowClosing(WindowEvent we)
         { System.exit(0); }                      
    }
     //布局
     private void setup() {
       Panel top=new Panel();
       top.setLayout(new GridLayout(2,1));
       top.add(label);
       top.add(display);
       Panel number=new Panel();
       number.setLayout(new GridLayout(6,3));
       number.add(one);
       number.add(four);
       number.add(seven);
       number.add(two);
       number.add(five);
       number.add(eight);
       number.add(three);
       number.add(six);
       number.add(nine);
       number.add(zero);
       number.add(add);
       number.add(sub);
       number.add(point);
       number.add(mul);
       number.add(div);
       number.add(result);
       number.add(clr);
       number.add(quit);
       setLayout(new BorderLayout());
       add("North",top);
       add("South",number);
    }

    //构造方法
    public Calculator(){
        super("计算器");
        setup();
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        point.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clr.addActionListener(this);
        quit.addActionListener(this);
        result.addActionListener(this);
        addWindowListener(new WindowCloser());
        pack();
        setSize(200,220);
        setVisible(true);
    }
	void reset0(){
          a=0;
          b=0;
          count=0;
          sum=0;
          p=1;
          mode='?';
       }
    void setAndDis(char c){
	        count=0;
        	flag=0;
        	a=Double.parseDouble(display.getText());
            mode=c;
	}
    //说明点击按钮以后要采取的行动
    public void actionPerformed(ActionEvent ae) {
        if((ae.getSource()==quit))
           System.exit(0);
        if((ae.getSource()==clr)){
     
          reset0();
          flag=0;
		  display.setText("0");
		  
        }else if((ae.getSource()==zero)){
           if(count!=0){
             reset0();
        	   }
           if(flag==0){
display.setText("0");
             flag=1;
           }else display.setText(display.getText()+"0");
        }
        //输入0～9
        if((ae.getSource()==one)) {
  if(count!=0){

             reset0();
			  } if(flag==0||display.getText().equals("0")){
 display.setText("1");
             flag=1;
          }else display.setText(display.getText()+"1");
        }

        if((ae.getSource()==two))
        { if(count!=0){
           reset0();
    	        }
          if(flag==0||display.getText().equals("0"))
          { display.setText("2");
            flag=1;
          }
          else display.setText(display.getText()+"2");
        }

        if((ae.getSource()==three))
        { if(count!=0){
	       reset0();
		   }
          if(flag==0||display.getText().equals("0"))
          { display.setText("3");
            flag=1;
          }
          else display.setText(display.getText()+"3");
        }

        if((ae.getSource()==four))
        { if(count!=0){
           reset0();
         }
          if(flag==0||display.getText().equals("0"))
          { display.setText("4");
            flag=1;
          }
          else display.setText(display.getText()+"4");
        }
        if((ae.getSource()==five))
        { if(count!=0){
           reset0();
        	        }
          if(flag==0||display.getText().equals("0"))
          { display.setText("5");
            flag=1;
          }
          else display.setText(display.getText()+"5");
        }
        if((ae.getSource()==six))
        { if(count!=0){
           reset0();
		}
          if(flag==0||display.getText().equals("0"))
          { display.setText("6");
            flag=1;
          }
          else display.setText(display.getText()+"6");
        }
        if((ae.getSource()==seven))
        { if(count!=0){
          reset0();
		  }
          if(flag==0||display.getText().equals("0"))
          { display.setText("7");
            flag=1;
          }
          else display.setText(display.getText()+"7");
        }
        if((ae.getSource()==eight))
        { if(count!=0){
  
		reset0();
					}
          if(flag==0||display.getText().equals("0"))
          { display.setText("8");
            flag=1;
          }
          else display.setText(display.getText()+"8");
        }
        if((ae.getSource()==nine))
        { if(count!=0){
      		reset0();
					}
          if(flag==0||display.getText().equals("0"))
          { display.setText("9");
            flag=1;
          }
          else display.setText(display.getText()+"9");
        }

        if((ae.getSource()==point))
        {
          if(flag==1&&p!=0) {
             display.setText(display.getText()+".");
             p=0;
          }
        }
        //输入+,-，×，÷
        if((ae.getSource()==add))
        { 
		    setAndDis('+');
		}
        if((ae.getSource()==sub))
        { 
             setAndDis('-');
		}
        if((ae.getSource()==mul))
        {  setAndDis('*');
        }
        if((ae.getSource()==div))
        {   setAndDis('÷');
        }
        //
        if((ae.getSource()==result)&&mode!='?'){
           	flag=0;
        	if(count==0){
        		b=Double.parseDouble(display.getText());
        		count=1;
	                
        	};
        	
        	sum=run(a,b,mode);
        	a=sum;
        	display.setText(String.valueOf(sum));
        	
        }
   }
   public double run(double a,double b,char mode){
      double sum=0;
      if(mode=='+')
        sum=a+b;
      if(mode=='-')
        sum=a-b;
      if(mode=='*')
        sum=a*b;
      if(mode=='÷')
        sum=a/b;
      return(sum);
 }
    public static void main(String args[]){
      Calculator cal= new Calculator();
     }
}
