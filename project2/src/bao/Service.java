package bao;

import java.util.Scanner;

public class Service {
	
	public static final int M=10;
	public static final int N=10;
	public static final int minisize=15;
	public static int UCount=0;//对已分配区计数
	public static int FCount=0;//对空闲区计数
	static Scanner sc=new Scanner(System.in);
	static byte a;	//声明分区表
	static Block[] usedBlocks=new Block[M];
	static Block[] freeBlocks=new Block[N];
		
	public static void main(String[] args) {
		//初始化
		Block initBlock=new Block(1,"QI", 100,128);
		freeBlocks[0]=initBlock;
		for(int i=1;i<N;i++)         
		{
			freeBlocks[i]=new Block();//对象实例化
			freeBlocks[i].id=0;
			freeBlocks[i].name="0";
			freeBlocks[i].address=0;
			freeBlocks[i].length=0;
		}
		for(int i=0;i<M;i++)
		{
			usedBlocks[i]=new Block();
			usedBlocks[i].id=0;
			usedBlocks[i].name="#";
			usedBlocks[i].address=0;
			usedBlocks[i].length=0;
		}
		//选择操作
		while(true)
		{
			System.out.println("退出请按0，分配内存请按1，回收内存请按2，显示内存布局请按3：");
			a=sc.nextByte();
			switch(a)
			{
			case 0: System.exit(0);
			case 1:
				System.out.println("请输入作业名称：");
				String name=sc.next();
				System.out.println("请输入作业"+name+"所需的内存大小：");
				Float length=sc.nextFloat();
				allocate(name,length);
				break;
			case 2:
				System.out.println("请输入需要回收分区的作业名称：");
				name=sc.next();
				reclaim(name);
				break;
			case 3:
				printTable();
				break;
			default:System.out.println("没有该选项！");
			}
			rank();//每次执行完之后对两个表首地址进行排序
		}
	}

	public static void allocate(String na, float need)
	{
		int i;//i用来遍历
		float ad;//首地址
		
		//检查有无可用分区及所在空闲分区表的位置
		int k=-1;//k标记能够分配内存的空闲区
		for(i=0;i<N;i++)
		{//有空闲区判断
			if(freeBlocks[i].length>=need&&freeBlocks[i].id!=0)//有可用分区
				if(k==-1||freeBlocks[i].length<freeBlocks[k].length)//未分配时进行分配
					k=i;
		}
		if(k==-1)
		{
			System.out.println("无可用空闲区！");
			return;
		}
		//有空闲区
		UCount++;//可以分配一个已用分区

		//获得给作业分配的首地址ad，以及对空闲分区表进行操作
		if(freeBlocks[k].length-need<minisize)//如果长度合适
		{
			freeBlocks[k].id=0;
			ad=freeBlocks[k].address;
			need=freeBlocks[k].length;
			
			//修改原先的空闲分区表
			freeBlocks[k].address=0;
			freeBlocks[k].length=0;
			FCount--;//长度合适时直接替代，空闲区数目减一
		}
		else//如果该分区过大，则将前一部分分配给作业后一部分继续作为空闲区
		{
			freeBlocks[k].length=freeBlocks[k].length-need;
			ad=freeBlocks[k].address;
			freeBlocks[k].address=freeBlocks[k].address+need;
			//空闲区数目不变
		}
		
		//对已分配分区表操作
		i=0;
		while(usedBlocks[i].id!=0&&i<M)
			i++;//找到最后一个已经分配的分区（当前分区）
		if(i>=M)//越界检查
		{
			System.out.println("无表目填写已经分配的分区，错误！\n");
			if(freeBlocks[k].id==0)
			{
				freeBlocks[k].id=1;
				//发生越界
				FCount--;
			}
			else
			{
				freeBlocks[k].length=freeBlocks[k].length+need;
				return;
			}
		}
		else//未越界，对已经分配的分区块进行赋值
		
			 usedBlocks[i].address=ad;
			usedBlocks[i].length=need;
			usedBlocks[i].name=na;
			usedBlocks[i].id=UCount;
		
		return;
	}
	
	private static void reclaim(String na)
	{
		int i;
		int j;//记录该分区的后移空闲分区
		int k;//记录该分区的前一空闲分区
		
		int t;
		int I;
		float S,L;//储存该分区的地址及长度
		//在已分配的分区块里找到该分区
		int s=0;//s用来标记找到的那个名字为na的块(已分配的表内）
		while((s<M)&&((!usedBlocks[s].name.equals(na))||(usedBlocks[s].id==0)))
		{
			s++;//未被分配以及分配了名字不是na的，都被排除，最终找到名字为na的分区
		}
		//s--;
		
		if(s>=M)
		{
			System.out.println("找不到该作业！\n");
			return;
		}
		
		//UCount--;//已利用分区数目减一
		//已分配的分区表操作以及找出该分区的首地址及长度
		S=usedBlocks[s].address;
		L=usedBlocks[s].length;
		I=usedBlocks[s].id;
		//修改已利用分区表
		usedBlocks[s].id=0;
		usedBlocks[s].name="#";
		usedBlocks[s].address=0;
		usedBlocks[s].length=0;
		
		j=-1;k=-1;i=0;
		while(i<N&&(j==-1||k==-1))//找到j，k时退出循环
		{
			if(freeBlocks[i].id==1)//如果分区可利用
			{
				if(freeBlocks[i].address+freeBlocks[i].length==S)
					k=i;//找到紧邻该分区的前一空闲分区编号
				if(freeBlocks[i].address==S+L)
					j=i;//找到紧邻该分区的后一空闲分区编号
			}
			i++;
		}
		
		if(k!=-1)//前一分区空闲
		{
			if(j!=-1)//后一分区空闲
			{
				freeBlocks[k].length=freeBlocks[k].length+freeBlocks[j].length+L;
				freeBlocks[j].id=0;
				FCount--;//空闲分区数减一
			}
			else//后一分区不空闲
			{
				freeBlocks[k].length=freeBlocks[k].length+L;
			}
		}
		else//前一分区不空闲
		{
			if(j!=-1)//后一分区空闲
			{
				freeBlocks[j].address=S;
				freeBlocks[j].length=freeBlocks[j].length+L;
			}
			else//前后分区都不空闲
			{
				
				FCount++;
				t=0;
				while(freeBlocks[t].id==1&&t<N)
				{
					t++;//找到没有标记的空闲表分区
				}
				if(t>=N)
				{
					System.out.println("主存空闲表没有空间，回收空间失败！\n");
					usedBlocks[s].name=na;
					usedBlocks[s].id=I;
					usedBlocks[s].address=S;
					usedBlocks[s].length=L;
					return;
				}
				freeBlocks[t].address=S;
				freeBlocks[t].length=L;
				freeBlocks[t].id=1;
			}
		}
		return;	
	}
	
	private static void printTable()
	{
		System.out.println("空闲分区表:");
		System.out.println("标志\t     \t起始地址\t分区长度");
		for(int i=0;i<N;i++)
		{
			if(freeBlocks[i].id!=0) {
			System.out.println(freeBlocks[i].id+"      "
					+ ""+"        "+
					""+freeBlocks[i].address +"       "+freeBlocks[i].length );
			}
		}
		System.out.println("已分配分区表:");
		System.out.println("编号\t名称\t起始地址\t分区长度");
		for(int i=0;i<M;i++)
		{
			if(usedBlocks[i].id!=0) {
			System.out.println(usedBlocks[i].id+"        "+usedBlocks[i].name+
					"         "+usedBlocks[i].address +"    "+usedBlocks[i].length );
			}
		}
	}
	
	public static void rank()
	{
	  //对已利用表
		for(int i=0;i<M-1;i++)
		{
			for(int j=0;j<M-i-1;j++)
			{
					if (usedBlocks[j].address > usedBlocks[j + 1].address) { // 比较相邻元素
						// 下面的三行代码用于交换两个元素
						Block temp=new Block();
						temp = usedBlocks[j];
						usedBlocks[j] = usedBlocks[j + 1];
						usedBlocks[j + 1] = temp;
			        }
		     }
	    }
		//对空闲表
		for(int i=0;i<N-1;i++)
		{
			for(int j=0;j<N-i-1;j++)
			{
					if (freeBlocks[j].address > freeBlocks[j + 1].address) { // 比较相邻元素
						// 下面的三行代码用于交换两个元素
						Block temp=new Block();
						temp = freeBlocks[j];
						freeBlocks[j] = freeBlocks[j + 1];
						freeBlocks[j + 1] = temp;
			        }
		     }
	    }
	}
	
	
}
