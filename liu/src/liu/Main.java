package liu;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    static PCB readyLine=new PCB(null,0,0,null);//��������ͷ���
    static PCB endLine=new PCB(null,0,0,null);//��������ͷ���
    static PCB[] array=new PCB[5];

    public static void startrunning()//ģ�⴦��������
    {
        do
        {
            PCB pcb=sort(array);
            pcb.priority--;
            pcb.time--;
            System.out.print(pcb.name+"������,");
            System.out.print("��������Ϊ��");
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

    public static PCB sort(PCB[] array)//���ȼ�����
    {
        PCB pReady=new PCB(null,0,0,null);
        PCB pEnd=new PCB(null,0,0,null);
        readyLine.setNext(pReady);
        endLine.setNext(pEnd);
        for(int i=0;i<5;i++)//�ж�ʣ������ʱ�䣬����
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
        if(readyLine.next.next!=null)//�������зǿ�
        {
            if (readyLine.next.next.next == null)//�������н���һ������
            {

            }
            else//�������������������Ͻ���ʱ���������ȼ���������
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
        else//��������Ϊ��
        {
            return null;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("�������������Ҫ�����е�ʱ�估��ʼ����������������1-5�����ȼ�Խ�ߣ�������Խ��");
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<5;i++)//��ʼ���������̣����ھ���������
        {
            array[i]=new PCB("p"+i,scanner.nextInt(),scanner.nextInt(),"R");
        }
        sort(array);
        startrunning();//ģ�⴦��������
    }
}
