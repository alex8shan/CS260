/**
 * Creating a VIP checking account that inherent from checking account.
 * @author Minghao Shan
 * Collaborated with Brandon Lu, Nirmal Panta and Felix Xie.
 * @version 05/02/2017
 */
public class VIPCheckingAccount extends CheckingAccount{
	private static final double INIT_BALANCE = 100.0;
	private static final double WITHDRAW_FEE = 0.0;
	private static final int FREE_DEPOSITE_COUNT = 30;
	private static final double OVERDRAFT_FEE = 0.0;
	/**
	 * Construct a VIP account with initial balance set to 100.
	 * @param depositFee		The deposit fee
	 */
	public VIPCheckingAccount(double depositFee){
		super(INIT_BALANCE, WITHDRAW_FEE, FREE_DEPOSITE_COUNT, depositFee, OVERDRAFT_FEE);
	}
	/**
	 * Construct a VIP account with initial balance passed as a parameter + 100.
	 * @param initialBalance	The initial balance before 100 is added
	 * @param depositFee		The deposit fee
	 */
	public VIPCheckingAccount(double initialBalance, double depositFee){
		super(INIT_BALANCE + initialBalance, WITHDRAW_FEE, FREE_DEPOSITE_COUNT, depositFee, OVERDRAFT_FEE);
	}
}
