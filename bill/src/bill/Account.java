package bill;

import java.util.List;

public abstract class Account {
	public static final int FeeInState=75;
	public static final int FeeOutState=200;//使用最终成员变量
	//为每个学生分配账户，每个账户里有若干账单
	protected static final String SchoolName="Java州立大学";//学校名称
	protected String StudentName;//学生姓名
	protected int CountOfBill;//账单数目
	public List<Bill>  bills;//账单list
	public  void getCount() {
		CountOfBill=bills.size();
	};//计算账单总数
	public int FeeNumber;//学分数
	public int sum;//总学分费
	public abstract void getSum();//计算总学分费
}
