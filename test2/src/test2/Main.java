package test2;
import java.util.Scanner;

public class Main {

    public static Area areaList=new Area();//头结点

    public static Area findUnuse(int leng)//找到一个满足需求长度的空闲区间，若没有，返回false
    {
        Area p=areaList.next;
        while (p!=null)
        {
            if(p.using=="Yes"&&p.length>=leng)
            {
                return p;
            }
            p=p.next;
        }
        return null;
    }

    public static void distribute(Area head,int leng)//分配分区，从head里划分
    {
        if(head.length==leng)
        {
            head.using="No";
            head.number=0;
        }
        else
        {
            Area afterhead=new Area();//分配后剩余的分区
            afterhead.length=head.length-leng;
            afterhead.number=head.number;
            afterhead.using="Yes";
            afterhead.start=head.start+leng;
            afterhead.setPerior(head);
            afterhead.setNext(head.next);
            if(head.next!=null)
            {
                head.next.setPerior(afterhead);
            }
            head.setNext(afterhead);
            head.using="No";
            head.number=0;
            head.length=leng;
        }
    }

    public static boolean recycle(int n)//回收第n个非空闲分区，如果前后有相连的，合并
    {
        int m=1;
        Area p=areaList.next;
        while (p!=null&&m!=n)
        {
            if(p.using=="No")
            {
                m++;
            }
            p=p.next;
        }
        if(m!=n)
        {
            System.out.println("无法回收第"+n+"个非空闲分区");
            return false;
        }
        else
        {
            if(p.next.using=="Yes"&&p.perior.using=="No")//后面一个分区空闲，前面不空闲
            {
                p.using="Yes";
                p.length=p.length+p.next.length;
                p.number=p.next.number;
                p.next.setPerior(p);
                p.setNext(p.next.next);
            }
            if(p.perior.using=="Yes"&&(p.next.using=="No"||p.next==null))//前面一个分区空闲，后面不空闲
            {
                p.perior.length=p.perior.length+p.length;
                p.next.setPerior(p.perior);
                p.perior.setNext(p.next);
            }
            if(p.perior.using=="No"&&(p.next.using=="No"||p.next==null))//前后都不空闲
            {
                p.using="Yes";
                Area beyondNull=p.perior;
                while(beyondNull.using!="Yes"&&beyondNull!=areaList)
                {
                    beyondNull=beyondNull.perior;
                }
                if(beyondNull==areaList)
                {
                    p.number=1;
                }
                else {
                    p.number = beyondNull.number + 1;
                }
                beyondNull=p.next;
                while (beyondNull!=null)
                {
                    if(beyondNull.using=="Yes")
                    {
                        beyondNull.number++;
                    }
                    beyondNull=beyondNull.next;
                }
            }

            if(p.perior.using=="Yes"&&p.next.using=="Yes")//前后都空闲
            {
                p.perior.length=p.perior.length+p.length+p.next.length;
                p.next.next.setPerior(p.perior);
                p.perior.setNext(p.next.next);
                Area behind=p.perior;
                while (behind.next!=null)
                {
                    if(behind.using=="Yes")
                    {
                        behind.number--;
                    }
                    behind=behind.next;
                }
            }
            return true;
        }
    }

    public static void information()//输出分区情况
    {
        Area p=areaList.next;
        while (p!=null)
        {
            if(p.using=="Yes")
            {
                System.out.println("第"+p.number+"个空闲分区，起始地址"+p.start+"，长度"+p.length);
            }
            else
            {
                System.out.println("非空闲分区，起始地址"+p.start+"，长度"+p.length);
            }
            p=p.next;
        }
    }

    //public void running(){}//模拟运行，初始时，一个总区128K，using为Yes

    public static void main(String[] args)
    {
        Area first=new Area();
        first.number=1;
        first.using="Yes";
        first.length=128;
        first.start=0;
        first.setPerior(areaList);
        first.setNext(null);
        areaList.setPerior(null);
        areaList.setNext(first);
        while (true)
        {
            System.out.println("请输入要求：D（分配）、R（回收）");
            Scanner scanner=new Scanner(System.in);
            String operate=scanner.next();
            switch (operate)
            {
                case "D":
                    System.out.println("请输入需求空间（1~128）");
                    int length=scanner.nextInt();
                    Area can=findUnuse(length);
                    if(can!=null)
                    {
                        distribute(can,length);
                        System.out.println("分配成功！分区情况：");
                        information();
                    }
                    else
                    {
                        System.out.println("没有可供分配的空间");
                    }
                    break;
                case "R":
                    System.out.println("请输入需要回收第几个非空闲分区");
                    int n=scanner.nextInt();
                    recycle(n);
                    System.out.println("回收成功！分区情况：");
                    information();
                    break;
            }
        }
    }
}
