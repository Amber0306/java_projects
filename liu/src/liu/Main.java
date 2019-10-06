package liu;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    static PCB readyLine=new PCB(null,0,0,null);//就绪队列头结点
    static PCB endLine=new PCB(null,0,0,null);//结束队列头结点
    static PCB[] array=new PCB[5];

    public static void startrunning()//模拟处理器调度
    {
        do
        {
            PCB pcb=sort(array);
            pcb.priority--;
            pcb.time--;
            System.out.print(pcb.name+"在运行,");
            System.out.print("就绪队列为：");
            PCB p=pcb.next;
            while(p!=null)
            {
                System.out.print(p.name+" ");
                p=p.next;
            }
            System.out.println();
            for(int i=0;i<5;i++)
            {
                if(pcb.name==array[i].name)
                {
                    array[i].time = pcb.time;
                    array[i].priority=pcb.priority;
                }
            }
        }
        while (readyLine.next.next!=null);
    }

    public static PCB sort(PCB[] array)//优先级排序
    {
        PCB pReady=new PCB(null,0,0,null);
        PCB pEnd=new PCB(null,0,0,null);
        readyLine.setNext(pReady);
        endLine.setNext(pEnd);
        for(int i=0;i<5;i++)//判断剩余运算时间，链入
        {
            if(array[i].time==0)
            {
                array[i].status="E";
                pEnd.setNext(array[i]);
                pEnd=array[i];
            }
            else
            {
                pReady.setNext(array[i]);
                pReady=array[i];
            }
        }

        //?
        if(readyLine.next.next!=null)//就绪队列非空
        {
            if (readyLine.next.next.next == null)//就绪队列仅有一个进程
            {

            }
            else//就绪队列有两个及以上进程时，按照优先级进行排序
                {
                    for (int i = 0; i < 5; i++)
                    {

                        pReady = readyLine.next;
                        while (pReady.next.next != null)
                        {
                            //System.out.print(1);
                            if (pReady.next.priority < pReady.next.next.priority)
                            {
                                PCB p;
                                p = pReady.next;
                                pReady.setNext(p.next);
                                p.setNext(p.next.next);
                                pReady.next.setNext(p);
                            }
                            //System.out.print(pReady.name+" ");
                            pReady = pReady.next;
                        }

                    }

                }

            return readyLine.next.next;
        }
        else//就绪队列为空
        {
            return null;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("请输入五个进程要求运行的时间及初始优先数（优先数从1-5，优先级越高，优先数越大）");
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<5;i++)//初始化各个进程，都在就绪队列中
        {
            array[i]=new PCB("p"+i,scanner.nextInt(),scanner.nextInt(),"R");
        }
        sort(array);
        startrunning();//模拟处理器调度
    }
}
