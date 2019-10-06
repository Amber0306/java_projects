package test2;
public class Area//一个分区
{
    public int number;//分区号，表示第几个空闲分区，非空闲为0
    public int start;//起始地址
    public int length;//区间长度
    public String using;//是否空闲，Yes表示空闲，No表示在使用
    public Area perior;//前一个分区
    public Area next;//后一个分区

    public Area getPerior() {
        return perior;
    }

    public Area setPerior(Area perior)
    {
        this.perior=perior;
        return this;
    }

    public Area getNext()
    {
        return next;
    }

    public Area setNext(Area next)
    {
        this.next=next;
        return this;
    }


}
