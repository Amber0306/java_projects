package bao;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args){
		MainFrame mf=new MainFrame();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
/*
 * 要求：
 *      用到 窗体、菜单、字体、对话框、监听适配器、继承、多态以及可重用的类
 * 1）能够处理两种类型的地址（公共地址包括姓、名和邮件地址三部分，
 *        私有地址还包括电话号码
 *        //两个类，私有继承公有
 * 2）每种类型都能够添加随机地址
 *         //random
 * 3）能够添加、删除、编辑地址
 * 4）使用菜单而不是按钮完成各种操作
 *          //MenuBar
 * 5）使用对话框添加和编辑地址 
 *          //dialog对话框类
 * 6）可以在列表中显示地址
 * 7）可以清理所有的地址
 * 8）可以保存和读取当前列表的地址
 */
