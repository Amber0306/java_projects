package test2;
public class Area//һ������
{
    public int number;//�����ţ���ʾ�ڼ������з������ǿ���Ϊ0
    public int start;//��ʼ��ַ
    public int length;//���䳤��
    public String using;//�Ƿ���У�Yes��ʾ���У�No��ʾ��ʹ��
    public Area perior;//ǰһ������
    public Area next;//��һ������

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
