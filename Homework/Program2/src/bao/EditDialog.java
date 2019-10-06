package bao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditDialog extends Dialog implements ActionListener{
//定义域
	Button btnYes=new Button("确定");
	Button btnNo=new Button("取消");
	public boolean isOK=false;
	String type;
	//Label lblType=new Label("修改新的"+type+"为：");
	TextField txt=new TextField();
	public EditDialog(Frame parent,String title,String s) {
		super(parent,title,true);
		type=s;
		Label lblType=new Label("修改新的"+type+"为：");
		//TextField txt=new TextField();
		
		Panel buttons=new Panel();
		buttons.setLayout(new FlowLayout());
		buttons.add(btnYes);
		buttons.add(btnNo);
		Panel pType=new Panel();
		pType.setLayout(new GridLayout(2,1));
		pType.add(lblType);
		pType.add(txt);
		setLayout(new BorderLayout());
		add("Center",pType);
		add("South",buttons);
		
		btnYes.addActionListener(this);
		btnNo.addActionListener(this);
		addWindowListener(new WindowCloser());
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
			EditDialog.this.hide();
		}
	}
}
