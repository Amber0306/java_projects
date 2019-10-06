package bao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ConfirmDialog extends Dialog implements ActionListener {
//定义域
	Button btnYes=new Button("确定");
	Button btnNo=new Button("取消");
	Label lblQuestion=new Label();
	public boolean isOK=false;
	
	public ConfirmDialog(Frame parent,String title,String question) {
		super(parent,title,true);//模态对话框
		lblQuestion.setText(question);
		Panel buttons=new Panel();
		buttons.setLayout(new FlowLayout());
		buttons.add(btnYes);
		buttons.add(btnNo);
		setLayout(new BorderLayout());
		add("Center",lblQuestion);
		add("South",buttons);
		btnYes.addActionListener(this);
		btnNo.addActionListener(this);
		addWindowListener(new WindowCloser());
		setSize(200,200);
		pack();
		show();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		isOK=(e.getSource()==btnYes);
		hide();
	}
	private class WindowCloser extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			isOK=false;
			ConfirmDialog.this.hide();
		}
	}
}
