
public class CheckingAccount extends BankAccount{
	private double withdrawFee;
	private int freeDepoCount;
	private int freeDepositeCount;
	private double depositeFee;
	private double overdraftFee;
	private double accountBalance;

	public CheckingAccount(double withdrawFee, int freeDepositeCount, double depositeFee, double overdraftFee ){
		this.withdrawFee = withdrawFee;
		this.freeDepoCount = freeDepositeCount;
		this.freeDepositeCount = freeDepoCount;
		this.depositeFee = depositeFee;
		this.overdraftFee = overdraftFee;
		accountBalance = 0.00;
	}
	public CheckingAccount(double initBalance, double withdrawFee, int freeDepositeCount, double depositeFee, double overdraftFee ){
		this.withdrawFee = withdrawFee;
		this.freeDepoCount = freeDepositeCount;
		this.freeDepositeCount = freeDepoCount;
		this.depositeFee = depositeFee;
		this.overdraftFee = overdraftFee;
		this.accountBalance = initBalance;
	}
	public void deductDepositFees(){
		if(freeDepositeCount > 0){
			accountBalance = accountBalance - depositeFee;
		}
		freeDepositeCount --;
	}
	public void deductWithdrawalFees(){
		accountBalance = accountBalance - withdrawFee;
	}
	public void ResetCounters(){
		freeDepositeCount = freeDepoCount;
	}
}
