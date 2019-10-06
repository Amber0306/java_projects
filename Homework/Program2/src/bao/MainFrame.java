package bao;

import java.awt.*;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
//import java.util.List;
import java.awt.List;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {
	
	//定义域
	private MenuItem randomPublic=new MenuItem("添加公有随机地址");
	private MenuItem randomPrivate=new MenuItem("添加私有随机地址");
	private MenuItem myAddress=new MenuItem("添加自定义地址");
	
	private MenuItem addressDelete=new MenuItem("删除当前地址");
	private MenuItem addressClear=new MenuItem("清除所有地址");
	
	private MenuItem editSurname=new MenuItem("修改姓");
	private MenuItem editName=new MenuItem("修改名");
	private MenuItem editEmail=new MenuItem("修改邮箱");
	private MenuItem editPhone= new MenuItem("修改电话号码");
	
	private MenuItem addressSave=new MenuItem("保存当前地址");
	private MenuItem addressLoad=new MenuItem("读取当前地址");
	
	private List display=new List(8,false);
	private LinkedList<AddressPublic>  data=new LinkedList();
	//private List display=Collections.synchronizedList(data);
	//dispaly.Collections.synchronizedList(data);
	private AddressPublic[] addresses= {	
			new AddressPublic("Wuhan","University","whu@163.com"),
			new AddressPrivate("Guo","Ziqi","862268273@qq.com","13245678900")
	};
	
	//构造函数
	public MainFrame() {
		super("地址簿");
		//菜单栏
		Menu addd =new Menu("添加地址");
		addd.add(randomPublic);randomPublic.setEnabled(true);
		addd.add(randomPrivate);randomPrivate.setEnabled(true);
		addd.add(myAddress);         myAddress.setEnabled(true);
		Menu minus=new Menu("删除地址");
		minus.add(addressDelete);addressDelete.setEnabled(true);
		minus.add(addressClear);   addressClear.setEnabled(true);
		Menu edit=new Menu("修改地址");
		edit.add(editSurname);     editSurname.setEnabled(true);
		edit.add(editName);           editName.setEnabled(true);
		edit.add(editEmail);            editEmail.setEnabled(true);
		edit.addSeparator();
		edit.add(editPhone);          editPhone.setEnabled(true);
		Menu addressAbout=new Menu("存取地址");
		addressAbout.add(addressSave); addressSave.setEnabled(true);
		addressAbout.add(addressLoad);addressLoad.setEnabled(true);
		
		MenuBar bar=new MenuBar();
		bar.add(addd);
		bar.add(minus);
		bar.add(edit);
		bar.add(addressAbout);
		bar.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,20));
		setMenuBar(bar);
		
		display.setBackground(Color.PINK);		
		display.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
		add(display);
		//添加事件响应
		randomPublic.addActionListener(this);
		randomPrivate.addActionListener(this);
		myAddress.addActionListener(this);
		addressDelete.addActionListener(this);
		addressClear.addActionListener(this);
		editSurname.addActionListener(this);
		editName.addActionListener(this);
		editEmail.addActionListener(this);
		editPhone.addActionListener(this);
		//edit.addActionListener(this);
		
		addressSave.addActionListener(this);
		addressLoad.addActionListener(this);
		
		//添加初始数据
		data.add(addresses[0]);
		data.add(addresses[1]);
		display.add(addresses[0].toString());
		display.add(addresses[1].toString());
		//
		
		validate();
		pack();
		setSize(500,500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==randomPublic) {
			ConfirmDialog cfm=new ConfirmDialog(this,"确认生成","确定生成公有随机地址吗？");
			if(cfm.isOK) {
				String sur=getRandomString(6);
				String na=getRandomString(6);
				String em=getRandomString(8)+"@"+getRandomString(3)+".com";
				AddressPublic address=new AddressPublic(sur,na,em);
				data.add(address);
				display.add(address.toString());
			}
		}else if(e.getSource()==randomPrivate) {
			ConfirmDialog cfm=new ConfirmDialog(this,"确认生成","确定生成私有随机地址吗？");
			if(cfm.isOK) {
				String sur=getRandomString(6);
				String na=getRandomString(6);
				String em=getRandomString(8)+"@"+getRandomString(3)+".com";
				String ph=randomNum(11);
				AddressPrivate address=new AddressPrivate(sur,na,em,ph);
				data.add(address);
				display.add(address.toString());
			}
		}else if(e.getSource()==myAddress) {
			NewDialog ned=new NewDialog(this,"新建地址");
			if(ned.isOK) {
				String sur=ned.txtSurname.getText();
				String na=ned.txtName.getText();
				String em=ned.txtEmail.getText();
				String ph=ned.txtPhone.getText();
				AddressPrivate address=new AddressPrivate(sur,na,em,ph);
				data.add(address);
				display.add(address.toString());
			}
		}else if(e.getSource()==addressDelete) {
			ConfirmDialog cfm=new ConfirmDialog(this,"确认删除","确定删除当前地址吗？");
			if(cfm.isOK) {
				int n=display.getSelectedIndex();
				data.remove(n);
				display.remove(n);
			}
		}else if(e.getSource()==addressClear) {
			ConfirmDialog cfm=new ConfirmDialog(this,"确认清除","确定清除所有地址吗？");
			if(cfm.isOK) {
				  data.clear();
			      display.removeAll();
			}
		}else if(e.getSource()==editSurname) {		
			EditDialog edt=new EditDialog(this,"修改姓氏","姓氏");
			if(edt.isOK) {
				String temp=edt.txt.getText();
				int n=display.getSelectedIndex();
				AddressPublic  address=data.get(n);
				address.surname=temp;
				data.remove(n);
				data.add(address);
				display.remove(n);
				display.add(address.toString());
			}
		}else if(e.getSource()==editName) {		
			EditDialog edt=new EditDialog(this,"修改名字","名字");
			if(edt.isOK) {
				String temp=edt.txt.getText();
				int n=display.getSelectedIndex();
				AddressPublic  address=data.get(n);
				address. name=temp;
				data.remove(n);
				data.add(address);
				display.remove(n);
				display.add(address.toString());
			}
		}else if(e.getSource()==editEmail) {	
			EditDialog edt=new EditDialog(this,"修改邮箱","邮箱");
			if(edt.isOK) {
				String temp=edt.txt.getText();
				int n=display.getSelectedIndex();
				AddressPublic  address=data.get(n);
				address.email=temp;
				data.remove(n);
				data.add(address);
				display.remove(n);
				display.add(address.toString());
			}
		}else if(e.getSource()==editPhone) {
			EditDialog edt=new EditDialog(this,"修改电话号码","电话号码");
			if(edt.isOK) {
				String temp=edt.txt.getText();
				int n=display.getSelectedIndex();
				AddressPrivate  address=(AddressPrivate) data.get(n);
				address.phone=temp;
				data.remove(n);
				data.add(address);
				display.remove(n);
				display.add(address.toString());
			}
		}else if(e.getSource()==addressSave) {
			  saveAddress();
		}else if(e.getSource()==addressLoad) {
			loadAddress();
		}
	}
	
	public  void saveAddress() {
		try {
			DataOutputStream out = new DataOutputStream(
				new FileOutputStream("addresses.dat"));
		         out.writeInt(data.size());
			for (Iterator iterator = data.iterator(); iterator.hasNext(); ) {
		            ( (AddressPublic) iterator.next()).save(out);
		         }
		         out.close();	
		         } catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void loadAddress() {
		try {
			DataInputStream in;
			in = new DataInputStream(new FileInputStream("addresses.dat"));
			data.clear();
			display.removeAll();
			int counter= in.readInt();
			for (int i = 0; i < counter; i++) {
				String type = in.readUTF();
				if (type.equals("AddressPublic")){
					AddressPublic address = new AddressPublic();
					address.load(in);
					data.add(address);
					display.add(address.toString());
					} else if (type.equals("AddressPrivate")){
						AddressPrivate address = new AddressPrivate();
						address.load(in);
						data.add(address);
						display.add(address.toString());
						}
				}
		in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyz"
	     		+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }

	public static String characters = "0123456789";
    public static String randomNum(int factor){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < factor; i++) {
            // nextInt(10) = [0, 10)
            sb.append(characters.charAt(random.nextInt(10)));
        }
        return sb.toString();
    }
}
