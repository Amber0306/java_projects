import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonWritableChannelException;
import java.security.PublicKey;
import java.util.StringTokenizer;

public class voteSystem extends JFrame implements ActionListener
{
    Label hintList;//提示，输入候选人名单
    Label hintLimit;//提示，最多选三人，超出算废票
    Label result;//选举结果
    TextField inCanditate;//输入候选人文本框
    TextField out;//显示选举结果
    Button confirmList;//确认名单
    Button cancelList;//清空已经输入的名单
    Button confirmVote;//确认投票
    Button refresh;//刷新
    Button sort;//排序
    Checkbox canditate[]=new Checkbox[10];//候选人选择框数组
    TextField can1,can2,can3,can4,can5,can6,can7,can8,can9,can10;
    TextField personVote[]={can1,can2,can3,can4,can5,can6,can7,can8,can9,can10};//显示每个人得票数
    String canditateList[]=new String[10];//候选人名单
    int count[]={0,0,0,0,0,0,0,0,0,0};//记录每个人得票数
    int totalCanditate=0;//候选人个数
    int totalCount=0;//总票数
    int everyCount=0;//每票选的人的个数
    int wasteVote=0;//废票数
    int unuseVote=0;//弃权数
    public voteSystem()
    {
        //控件初始化
        hintList=new Label("输入候选人名单，不超过10个人：");
        hintLimit=new Label("选择投票，最多选3个人：");
        result=new Label("选举结果：");
        inCanditate=new TextField(50);
        confirmList=new Button("确定");
        cancelList=new Button("取消");
        confirmVote=new Button("确定");
        refresh=new Button("刷新");
        sort=new Button("排序");
        out=new TextField(50);

        for(int i=0;i<10;i++)
        {
            personVote[i]=new TextField(80);
        }

        //布局
        setLayout(new GridLayout(8,1));

        Panel p0=new Panel();
        p0.setLayout(new GridLayout(2,1));
        p0.add(hintList);
        p0.add(inCanditate);

        Panel p1=new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(confirmList);
        p1.add(cancelList);

        Panel p2= new Panel();
        p2.setLayout(new GridLayout(1,1));
        p2.add(hintLimit);

        Panel p3=new Panel();
        p3.setLayout(new GridLayout(1,5));
        for(int i=0;i<5;i++)
        {
            canditate[i]=new Checkbox(canditateList[i]);
            p3.add(canditate[i]);
        }

        Panel p4=new Panel();
        p4.setLayout(new GridLayout(1,5));
        for(int i=5;i<10;i++)
        {
            canditate[i]=new Checkbox(canditateList[i]);
            p4.add(canditate[i]);
        }

        Panel p5=new Panel();
        p5.setLayout(new FlowLayout());
        p5.add(confirmVote);
        p5.add(refresh);
        p5.add(sort);

        Panel p6=new Panel();
        p6.setLayout(new FlowLayout());
        p6.add(result);
        p6.add(out);

        Panel p7=new Panel();
        p7.setLayout(new GridLayout(10,1));
        for(int i=0;i<10;i++)
            p7.add(personVote[i]);
        ScrollPane sc=new ScrollPane();
        sc.add(p7);

        add(p0);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);

        //添加监听
        confirmList.addActionListener(this);
        cancelList.addActionListener(this);
        confirmVote.addActionListener(this);
        refresh.addActionListener(this);
        sort.addActionListener(this);

        pack();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==confirmList)
        {
            String can=inCanditate.getText();
            StringTokenizer st=new StringTokenizer(can);
            totalCanditate=st.countTokens();
            int i=0;
            while (st.hasMoreTokens())
            {
                canditateList[i]=st.nextToken();
                i++;
            }
            for(int j=0;j<10;j++)
            {
                //canditate[j].setPreferredSize(new Dimension(50,20));
                canditate[j].setLabel(canditateList[j]);
            }
            for(int j=0;j<totalCanditate;j++)
                canditate[j].setEnabled(true);
            for(int j=totalCanditate;j<10;j++)
                canditate[j].setVisible(false);
        }
        if(e.getSource()==cancelList)
        {
            inCanditate.setText("");
        }
        if(e.getSource()==confirmVote)
        {
            totalCount++;
            everyCount=0;
            for(int i=0;i<totalCanditate;i++)
            {
                if(canditate[i].getState())
                    everyCount++;
            }
            if(everyCount==0)
                unuseVote++;
            if(everyCount>3)
                wasteVote++;
            if(everyCount>0&&everyCount<=3)
            {
                for(int i=0;i<totalCanditate;i++)
                    if(canditate[i].getState())
                        count[i]++;
            }
            for(int i=0;i<10;i++)
                canditate[i].setState(false);

            out.setText("共投了"+totalCount+"票，其中有"+wasteVote+"张废票，"+unuseVote+"张弃权票");
            for(int i=0;i<totalCanditate;i++)
            {
                personVote[i].setText(canditateList[i]+"："+count[i]+"票");
            }
        }
        if(e.getSource()==refresh)
        {
            inCanditate.setText("");
            totalCount=0;
            totalCanditate=0;
            everyCount=0;
            wasteVote=0;
            unuseVote=0;
            out.setText("");
            for(int i=0;i<10;i++)
            {
                canditate[i].setState(false);
                canditate[i].setVisible(true);
                canditateList[i]="";
                count[i]=0;
                canditate[i].setLabel(canditateList[i]);
                personVote[i].setText("");
            }
        }
        if(e.getSource()==sort)
        {
            for(int i=0;i<totalCanditate-1;i++) {
                for (int j = i + 1; j < totalCanditate; j++) {
                    if (count[i] < count[j]) {
                        int t = count[j];
                        count[j] = count[i];
                        count[i] = t;
                        String temp = canditateList[j];
                        canditateList[j] = canditateList[i];
                        canditateList[i] = temp;
                    }
                }
            }
            for(int i=0;i<totalCanditate;i++)
            {
                personVote[i].setText(canditateList[i]+"："+count[i]+"票");
            }
        }
    }

    public static void main(String args[])
    {
        voteSystem v=new voteSystem();
        v.setDefaultCloseOperation(3);
    }
}
