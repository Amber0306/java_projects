package bao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ShowFrame extends Frame implements ActionListener {
	
	public ShowFrame() {
		super("ͳ����ʾ");
	
		Label label1=new Label("��Ʊ��"+VoteFrame.AllTickets);
		Label label2=new Label("��Ʊ��"+VoteFrame.AbandonTickets);
		Panel p=new Panel();
		p.setLayout(new GridLayout(2,1));
		p.add(label1);p.add(label2);
		setLayout(new BorderLayout());
		
		VoteFrame.rank();
		add("Center",VoteFrame.display);
		add("South",p);
		
		addWindowListener(new WindowCloser());
		setSize(300,400);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
   	private class WindowCloser extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			ShowFrame.this.hide();
		}
   	}	
		//����
}
