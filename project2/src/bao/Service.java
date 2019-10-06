package bao;

import java.util.Scanner;

public class Service {
	
	public static final int M=10;
	public static final int N=10;
	public static final int minisize=15;
	public static int UCount=0;//���ѷ���������
	public static int FCount=0;//�Կ���������
	static Scanner sc=new Scanner(System.in);
	static byte a;	//����������
	static Block[] usedBlocks=new Block[M];
	static Block[] freeBlocks=new Block[N];
		
	public static void main(String[] args) {
		//��ʼ��
		Block initBlock=new Block(1,"QI", 100,128);
		freeBlocks[0]=initBlock;
		for(int i=1;i<N;i++)         
		{
			freeBlocks[i]=new Block();//����ʵ����
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
		//ѡ�����
		while(true)
		{
			System.out.println("�˳��밴0�������ڴ��밴1�������ڴ��밴2����ʾ�ڴ沼���밴3��");
			a=sc.nextByte();
			switch(a)
			{
			case 0: System.exit(0);
			case 1:
				System.out.println("��������ҵ���ƣ�");
				String name=sc.next();
				System.out.println("��������ҵ"+name+"������ڴ��С��");
				Float length=sc.nextFloat();
				allocate(name,length);
				break;
			case 2:
				System.out.println("��������Ҫ���շ�������ҵ���ƣ�");
				name=sc.next();
				reclaim(name);
				break;
			case 3:
				printTable();
				break;
			default:System.out.println("û�и�ѡ�");
			}
			rank();//ÿ��ִ����֮����������׵�ַ��������
		}
	}

	public static void allocate(String na, float need)
	{
		int i;//i��������
		float ad;//�׵�ַ
		
		//������޿��÷��������ڿ��з������λ��
		int k=-1;//k����ܹ������ڴ�Ŀ�����
		for(i=0;i<N;i++)
		{//�п������ж�
			if(freeBlocks[i].length>=need&&freeBlocks[i].id!=0)//�п��÷���
				if(k==-1||freeBlocks[i].length<freeBlocks[k].length)//δ����ʱ���з���
					k=i;
		}
		if(k==-1)
		{
			System.out.println("�޿��ÿ�������");
			return;
		}
		//�п�����
		UCount++;//���Է���һ�����÷���

		//��ø���ҵ������׵�ַad���Լ��Կ��з�������в���
		if(freeBlocks[k].length-need<minisize)//������Ⱥ���
		{
			freeBlocks[k].id=0;
			ad=freeBlocks[k].address;
			need=freeBlocks[k].length;
			
			//�޸�ԭ�ȵĿ��з�����
			freeBlocks[k].address=0;
			freeBlocks[k].length=0;
			FCount--;//���Ⱥ���ʱֱ���������������Ŀ��һ
		}
		else//����÷���������ǰһ���ַ������ҵ��һ���ּ�����Ϊ������
		{
			freeBlocks[k].length=freeBlocks[k].length-need;
			ad=freeBlocks[k].address;
			freeBlocks[k].address=freeBlocks[k].address+need;
			//��������Ŀ����
		}
		
		//���ѷ�����������
		i=0;
		while(usedBlocks[i].id!=0&&i<M)
			i++;//�ҵ����һ���Ѿ�����ķ�������ǰ������
		if(i>=M)//Խ����
		{
			System.out.println("�ޱ�Ŀ��д�Ѿ�����ķ���������\n");
			if(freeBlocks[k].id==0)
			{
				freeBlocks[k].id=1;
				//����Խ��
				FCount--;
			}
			else
			{
				freeBlocks[k].length=freeBlocks[k].length+need;
				return;
			}
		}
		else//δԽ�磬���Ѿ�����ķ�������и�ֵ
		
			 usedBlocks[i].address=ad;
			usedBlocks[i].length=need;
			usedBlocks[i].name=na;
			usedBlocks[i].id=UCount;
		
		return;
	}
	
	private static void reclaim(String na)
	{
		int i;
		int j;//��¼�÷����ĺ��ƿ��з���
		int k;//��¼�÷�����ǰһ���з���
		
		int t;
		int I;
		float S,L;//����÷����ĵ�ַ������
		//���ѷ���ķ��������ҵ��÷���
		int s=0;//s��������ҵ����Ǹ�����Ϊna�Ŀ�(�ѷ���ı��ڣ�
		while((s<M)&&((!usedBlocks[s].name.equals(na))||(usedBlocks[s].id==0)))
		{
			s++;//δ�������Լ����������ֲ���na�ģ������ų��������ҵ�����Ϊna�ķ���
		}
		//s--;
		
		if(s>=M)
		{
			System.out.println("�Ҳ�������ҵ��\n");
			return;
		}
		
		//UCount--;//�����÷�����Ŀ��һ
		//�ѷ���ķ���������Լ��ҳ��÷������׵�ַ������
		S=usedBlocks[s].address;
		L=usedBlocks[s].length;
		I=usedBlocks[s].id;
		//�޸������÷�����
		usedBlocks[s].id=0;
		usedBlocks[s].name="#";
		usedBlocks[s].address=0;
		usedBlocks[s].length=0;
		
		j=-1;k=-1;i=0;
		while(i<N&&(j==-1||k==-1))//�ҵ�j��kʱ�˳�ѭ��
		{
			if(freeBlocks[i].id==1)//�������������
			{
				if(freeBlocks[i].address+freeBlocks[i].length==S)
					k=i;//�ҵ����ڸ÷�����ǰһ���з������
				if(freeBlocks[i].address==S+L)
					j=i;//�ҵ����ڸ÷����ĺ�һ���з������
			}
			i++;
		}
		
		if(k!=-1)//ǰһ��������
		{
			if(j!=-1)//��һ��������
			{
				freeBlocks[k].length=freeBlocks[k].length+freeBlocks[j].length+L;
				freeBlocks[j].id=0;
				FCount--;//���з�������һ
			}
			else//��һ����������
			{
				freeBlocks[k].length=freeBlocks[k].length+L;
			}
		}
		else//ǰһ����������
		{
			if(j!=-1)//��һ��������
			{
				freeBlocks[j].address=S;
				freeBlocks[j].length=freeBlocks[j].length+L;
			}
			else//ǰ�������������
			{
				
				FCount++;
				t=0;
				while(freeBlocks[t].id==1&&t<N)
				{
					t++;//�ҵ�û�б�ǵĿ��б����
				}
				if(t>=N)
				{
					System.out.println("������б�û�пռ䣬���տռ�ʧ�ܣ�\n");
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
		System.out.println("���з�����:");
		System.out.println("��־\t     \t��ʼ��ַ\t��������");
		for(int i=0;i<N;i++)
		{
			if(freeBlocks[i].id!=0) {
			System.out.println(freeBlocks[i].id+"      "
					+ ""+"        "+
					""+freeBlocks[i].address +"       "+freeBlocks[i].length );
			}
		}
		System.out.println("�ѷ��������:");
		System.out.println("���\t����\t��ʼ��ַ\t��������");
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
	  //�������ñ�
		for(int i=0;i<M-1;i++)
		{
			for(int j=0;j<M-i-1;j++)
			{
					if (usedBlocks[j].address > usedBlocks[j + 1].address) { // �Ƚ�����Ԫ��
						// ��������д������ڽ�������Ԫ��
						Block temp=new Block();
						temp = usedBlocks[j];
						usedBlocks[j] = usedBlocks[j + 1];
						usedBlocks[j + 1] = temp;
			        }
		     }
	    }
		//�Կ��б�
		for(int i=0;i<N-1;i++)
		{
			for(int j=0;j<N-i-1;j++)
			{
					if (freeBlocks[j].address > freeBlocks[j + 1].address) { // �Ƚ�����Ԫ��
						// ��������д������ڽ�������Ԫ��
						Block temp=new Block();
						temp = freeBlocks[j];
						freeBlocks[j] = freeBlocks[j + 1];
						freeBlocks[j + 1] = temp;
			        }
		     }
	    }
	}
	
	
}
