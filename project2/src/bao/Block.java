package bao;
import java.lang.String;

public class Block
{
	public int id;//�������,freeBlocks�������������Ϊ1δ��������Ϊ0��usedBlocks���������ʾ���
	public String name;//��ҵ����������
	public float address;//��ʼ��ַ
	public float length;//��������
	//public int flag;//���: 1ʱ����
	//���췽��
	public Block() {}
	public Block(int id, String na,float add,float len)
	{
		this.id=id;
		this.name=na;
		this.address=add;
		this.length=len;
	}
}
