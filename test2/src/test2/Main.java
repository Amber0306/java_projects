package test2;
import java.util.Scanner;

public class Main {

    public static Area areaList=new Area();//ͷ���

    public static Area findUnuse(int leng)//�ҵ�һ���������󳤶ȵĿ������䣬��û�У�����false
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

    public static void distribute(Area head,int leng)//�����������head�ﻮ��
    {
        if(head.length==leng)
        {
            head.using="No";
            head.number=0;
        }
        else
        {
            Area afterhead=new Area();//�����ʣ��ķ���
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

    public static boolean recycle(int n)//���յ�n���ǿ��з��������ǰ���������ģ��ϲ�
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
            System.out.println("�޷����յ�"+n+"���ǿ��з���");
            return false;
        }
        else
        {
            if(p.next.using=="Yes"&&p.perior.using=="No")//����һ���������У�ǰ�治����
            {
                p.using="Yes";
                p.length=p.length+p.next.length;
                p.number=p.next.number;
                p.next.setPerior(p);
                p.setNext(p.next.next);
            }
            if(p.perior.using=="Yes"&&(p.next.using=="No"||p.next==null))//ǰ��һ���������У����治����
            {
                p.perior.length=p.perior.length+p.length;
                p.next.setPerior(p.perior);
                p.perior.setNext(p.next);
            }
            if(p.perior.using=="No"&&(p.next.using=="No"||p.next==null))//ǰ�󶼲�����
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

            if(p.perior.using=="Yes"&&p.next.using=="Yes")//ǰ�󶼿���
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

    public static void information()//����������
    {
        Area p=areaList.next;
        while (p!=null)
        {
            if(p.using=="Yes")
            {
                System.out.println("��"+p.number+"�����з�������ʼ��ַ"+p.start+"������"+p.length);
            }
            else
            {
                System.out.println("�ǿ��з�������ʼ��ַ"+p.start+"������"+p.length);
            }
            p=p.next;
        }
    }

    //public void running(){}//ģ�����У���ʼʱ��һ������128K��usingΪYes

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
            System.out.println("������Ҫ��D�����䣩��R�����գ�");
            Scanner scanner=new Scanner(System.in);
            String operate=scanner.next();
            switch (operate)
            {
                case "D":
                    System.out.println("����������ռ䣨1~128��");
                    int length=scanner.nextInt();
                    Area can=findUnuse(length);
                    if(can!=null)
                    {
                        distribute(can,length);
                        System.out.println("����ɹ������������");
                        information();
                    }
                    else
                    {
                        System.out.println("û�пɹ�����Ŀռ�");
                    }
                    break;
                case "R":
                    System.out.println("��������Ҫ���յڼ����ǿ��з���");
                    int n=scanner.nextInt();
                    recycle(n);
                    System.out.println("���ճɹ������������");
                    information();
                    break;
            }
        }
    }
}
