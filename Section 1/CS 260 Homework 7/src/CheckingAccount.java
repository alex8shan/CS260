/**
 * Creating a checking account that inherent from bank account.
 * @author Minghao Shan
 * Collaborated with Brandon Lu, Nirmal Panta and Felix Xie.
 * @version 05/02/2017
 */
public class CheckingAccount extends BankAccount{
	private double withdrawFee;
	private int fixedDepoCount;
	private int freeDepositCount;
	private double DepositFee;
	private double overdraftFee;
	/**
	 * The constructor that initialize the balance to 0.
	 * @param withdrawFee		Withdraw fee
	 * @param freeDepositCount	Number of free deposits
	 * @param DepositFee		Deposit fee
	 * @param overdraftFee		Charge for balance below 0 when withdraw fee is charged
	 */
	public CheckingAccount(double withdrawFee, int freeDepositCount, double DepositFee, double overdraftFee ){
		super();
		this.withdrawFee = withdrawFee;
		this.fixedDepoCount = freeDepositCount;
		this.freeDepositCount = fixedDepoCount;
		this.DepositFee = DepositFee;
		this.overdraftFee = overdraftFee;
	}
	/**
	 * The constructor that sets the balance to the parameter.
	 * @param balance			The account balance
	 * @param withdrawFee		Withdraw fee
	 * @param freeDepositCount	Number of free deposits
	 * @param DepositFee		Deposit fee
	 * @param overdraftFee		Charge for balance below 0 when withdraw fee is charged
	 */
	public CheckingAccount(double balance, double withdrawFee, int freeDepositCount, double DepositFee, double overdraftFee ){
		super(balance);
		this.withdrawFee = withdrawFee;
		this.fixedDepoCount = freeDepositCount;
		this.freeDepositCount = fixedDepoCount;
		this.DepositFee = DepositFee;
		this.overdraftFee = overdraftFee;

	}
	/**
	 * Deducts the balance if there is no free deposit left.
	 */
	public void deductDepositFees(){
		if(freeDepositCount > 0){
			freeDepositCount --;
		}
		else{
			super.deductFee(DepositFee);
		}
	}
	/**
	 * Deducts the withdraw fee and if the balance is below 0,
	 * charge additional overdraft fee.
	 */
	public void deductWithdrawalFees(){
		super.deductFee(withdrawFee);
		if(getBalance()<0.0){
			super.deductFee(overdraftFee);
		}
	}
	/**
	 * Reset the number of free deposit fee
	 */
	public void ResetCounters(){
		freeDepositCount = fixedDepoCount;
	}
}
