package bao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

public class VoteFrame extends Frame implements ActionListener{
//test
/*	public void paint(Graphics g) 
	{
		g.drawString("Hello,world!", 20, 20);
	}*/
	//
	//�ݶ�3����ѡ��
	//��̬������ͶƱ������Ʊ������Ʊ������ѡ�ֵ�Ʊ��
	static int AllTickets=0;
	//static int InvalidTickets=0;
	static int AbandonTickets=0;
	//static int Tickets[]= {0,0,0};
	
	//�洢ѡ����Ϣ
	public static List display=new List(2,false);//��������
	public static LinkedList<Contestant> data=new LinkedList<Contestant>();
	Contestant []peoples= {
			new Contestant("С��"),
			new Contestant("С��"),
			new Contestant("С��")
	};
	
	
	//��ť����
	Button isOK=new Button("ȷ��");
	Button clear=new Button("���");
	//��ǩ
	Label hint=new Label("��ͶƱ�����ɶ�ѡ��");
	
	//int n=data.size();
	//ѡ��
	//Checkbox cbxPeoples[]=new Checkbox[]();
	Checkbox cbxPeople1=new Checkbox();
	Checkbox cbxPeople2=new Checkbox();
	Checkbox cbxPeople3=new Checkbox();
	
	
	//��ʼ��
	public VoteFrame()
	{
		setForeground(Color.blue);
	    setBackground(Color.white);
	    
	    //��ʼ���
	    data.add(peoples[0]);
		data.add(peoples[1]);
		data.add(peoples[2]);
		display.add(peoples[0].toString());
		display.add(peoples[1].toString());
		display.add(peoples[2].toString());
		
		//��Ӳ���
		setup();
		
		//��Ӽ�����
		isOK.addActionListener(this);
		clear.addActionListener(this);
		addWindowListener(new WindowCloser());
	}
	
	//����
	public void setup()
	{
		//add(display);
		CheckboxGroup cp=new CheckboxGroup();
		cbxPeople1.setLabel(peoples[0].name);
		cbxPeople2.setLabel(peoples[1].name);
		cbxPeople3.setLabel(peoples[2].name);
		
		Panel pl1=new Panel();
		pl1.setLayout(new FlowLayout());
		pl1.add(isOK);
		pl1.add(clear);
		
		Panel pl2=new Panel();
		pl2.setLayout(new GridLayout(3,1));
		pl2.add(cbxPeople1);
		pl2.add(cbxPeople2);
		pl2.add(cbxPeople3);
		
		this.setLayout(new BorderLayout());
		this.add("Center",pl2);
		this.add("South", pl1);
		
		this.setSize(350, 150);				
		this.setLocation(200, 200);		
		this.setVisible(true);	
	
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==isOK){
			//
			boolean is0=cbxPeople1.getState();
			boolean is1=cbxPeople2.getState();
			boolean is2=cbxPeople3.getState();
			//�ж�
			if(is0) {
				peoples[0].tickets++;AllTickets++;
				data.remove(0);
				data.add(0, peoples[0]);
				display.remove(0);
				display.add(peoples[0].toString(),0);
				System.out.println(peoples[0].tickets);
			}
			if(is1) {
				peoples[1].tickets++;AllTickets++;
				data.remove(1);
				data.add(1, peoples[1]);
				display.remove(1);
				display.add(peoples[1].toString(),1);
				System.out.println(peoples[1].tickets);
			}
			if(is2) {
				peoples[2].tickets++;AllTickets++;
				data.remove(2);
				data.add(2, peoples[2]);
				display.remove(2);
				display.add(peoples[2].toString(),2);
				System.out.println(peoples[2].tickets);
			}
			if(!(is1||is2||is0)) {
				AbandonTickets++;
			}
			System.out.println(AllTickets);
			//��ʾ
			ShowFrame sf=new ShowFrame();
			sf.show();
	}else if(e.getSource()==clear) {
		cbxPeople1.setState(false);
		cbxPeople2.setState(false);
		cbxPeople3.setState(false);
	}		
	}
//�˽ⴰ�ڡ���ť���ı���ѡ��򡢹�����
//���ô��ڲ��֡���ť�¼��Ĵ������ַ���������
/*
 * ֧�ֶ��ͶƱ���ܹ��Զ�ͳ�Ƴ�ͶƱ������Ʊ������ȨƱ��
 * �͸�����ѡ�˵ĵ�Ʊ��
 * �����յ�Ʊ��Ϊ��ѡ��������ʾ
 */	
	public static void rank() {
		for(int i=0;i<data.size()-1;i++) {
            for(int j=i+1;j<data.size();j++) {
                  if(data.get(i).tickets<data.get(j).tickets){
                	  
                	  Contestant t=data.get(i);
                      data.set(i, data.get(j));
                      data.set(j, t);
                      
                     /* String s=display.getItem(i);
                      display.remove(i);
                      display.add(display.getItem(j), i);
                      display.remove(j);
                      display.add(s, j);*/
                  }         
            }
       }
	}
	private class WindowCloser extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			VoteFrame.this.hide();
		}
	}
}