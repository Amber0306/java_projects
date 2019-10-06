package bao;

import java.awt.*;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

public class NewDialog extends Dialog implements ActionListener{
	private Button btnYes=new Button("确定");
	private Button btnNo=new Button("取消");

	private Label lblSurname=new Label("姓氏：");
	private Label lblName=new Label("名字：");
	private Label lblEmail=new Label("邮箱：");
	private Label lblPhone=new Label("电话号码：");
	TextField txtSurname=new TextField(30);
	TextField txtName=new TextField(30);
	TextField txtEmail=new TextField(30);
	TextField txtPhone=new TextField(30);

	public boolean isOK=false;
	
	public NewDialog(Frame parent,String title){
		super(parent,title,true);
		Panel pName=new Panel();
		pName.setLayout(new FlowLayout());
		pName.add(lblSurname);
		pName.add(txtSurname);

		Panel pAddress=new Panel();
		pAddress.setLayout(new FlowLayout());
		pAddress.add(lblName);
		pAddress.add(txtName);

		Panel pEmail=new Panel();
		pEmail.add(lblEmail);
		pEmail.add(txtEmail);

		Panel pPhone=new Panel();
		pPhone.add(lblPhone);
		pPhone.add(txtPhone);

		Panel texts=new Panel();
		texts.setLayout(new GridLayout(4,1));
		texts.add(pName);
		texts.add(pAddress);
		texts.add(pEmail);
		texts.add(pPhone);

		Panel pButton=new Panel();
		pButton.setLayout(new FlowLayout());
		pButton.add(btnYes);
		pButton.add(btnNo);
		setLayout(new BorderLayout());
		add("Center",texts);
		add("South",pButton);

		btnYes.addActionListener(this);
		btnNo.addActionListener(this);
		addWindowListener(new WindowCloser());
		setSize(400,400);
		setResizable(true);
		pack();
		show();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnYes){
			 isOK=true;
	         this.hide();
		}
		if(e.getSource()==btnNo){
			isOK=false;
			this.hide();
		}
	}
   	private class WindowCloser extends WindowAdapter{
		public void windowClosing(WindowEvent we){
			isOK=false;
			NewDialog.this.hide();
		}
	}
}