package bao;
import java.lang.String;

public class Block
{
	public int id;//分区编号,freeBlocks里分区可用则置为1未分配则置为0，usedBlocks里面分配后表示编号
	public String name;//作业（分区）名
	public float address;//起始地址
	public float length;//分区长度
	//public int flag;//标记: 1时可用
	//构造方法
	public Block() {}
	public Block(int id, String na,float add,float len)
	{
		this.id=id;
		this.name=na;
		this.address=add;
		this.length=len;
	}
}
