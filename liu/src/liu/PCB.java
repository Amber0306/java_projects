package liu;

public class PCB {
    public String name;//��������
    public PCB next;//������һ��PCB
    public int time;//Ҫ������ʱ��
    public int priority;//��������������������1-5�����ȼ�Խ�ߣ�������Խ��
    public String status;//״̬��RΪ������EΪ����
    public PCB(String n,int t,int p,String s)//��������Ҫ������ʱ�䡢���̳�ʼ������
    {
        name=n;
        time=t;
        priority=p;
        status=s;
    }
    public PCB setNext(PCB next)
    {
        this.next=next;
        return this;
    }
    public PCB getNext()
    {
        return next;
    }
}
