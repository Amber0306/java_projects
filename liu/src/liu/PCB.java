package liu;

public class PCB {
    public String name;//进程名称
    public PCB next;//链中下一个PCB
    public int time;//要求运行时间
    public int priority;//进程优先数，优先数从1-5，优先级越高，优先数越大
    public String status;//状态，R为就绪，E为结束
    public PCB(String n,int t,int p,String s)//键盘输入要求运行时间、进程初始优先数
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
