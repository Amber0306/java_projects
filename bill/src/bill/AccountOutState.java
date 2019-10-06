package bill;

public class AccountOutState extends Account {
	public int fee=FeeOutState;
	public void getSum() {
		sum=fee*FeeNumber;
	}
}
