package bill;

public class AccountInState extends Account {
	public int fee=FeeInState;
	public void getSum() {
		sum=fee*FeeNumber;
	}
}
