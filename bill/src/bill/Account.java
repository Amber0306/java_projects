package bill;

import java.util.List;

public abstract class Account {
	public static final int FeeInState=75;
	public static final int FeeOutState=200;//ʹ�����ճ�Ա����
	//Ϊÿ��ѧ�������˻���ÿ���˻����������˵�
	protected static final String SchoolName="Java������ѧ";//ѧУ����
	protected String StudentName;//ѧ������
	protected int CountOfBill;//�˵���Ŀ
	public List<Bill>  bills;//�˵�list
	public  void getCount() {
		CountOfBill=bills.size();
	};//�����˵�����
	public int FeeNumber;//ѧ����
	public int sum;//��ѧ�ַ�
	public abstract void getSum();//������ѧ�ַ�
}
