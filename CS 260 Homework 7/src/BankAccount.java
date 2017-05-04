/** A bank account has a current balance which can be changed by
  * making deposits and withdrawals.
  */
public abstract class BankAccount
{
   // The current balance of the account.
   private double balance;

	/** Deduct a fee from the balance.
	  * @param fee the fee
     */
	public void deductFee (double fee)
	{
		balance -= fee;
	}
   
	/** Deduct the fees associated with making a deposit from 
  	  * the balance */
   public abstract void deductDepositFees ();

	/** Deduct the fees associated with making a withdrawal from
	  * the balance
	  */   
   public abstract void deductWithdrawalFees ();
   
	/** Create a new bank account and initialize the balance to $0.00.
	  */
   public BankAccount ()
   {
      balance = 0.0;
   }
   
	/** Create a new bank account and initialize the balance to
	  * the specified amount.
	  * @param initialBalance the initialBalance of the account
	  */
   public BankAccount (double initialBalance)
   {
      balance = initialBalance;
   }
   
	/** Make a deposit into the account, and deduct any fees 
	  * associated with the deposit.
	  * @param amount the amount to deposit
	  */
   public final void deposit (double amount)
   {
   		balance += amount;
		deductDepositFees ();
   }
   
	/** Make a withdrawal from the account, and deduct any fees
	  * associated with the withdrawal.
	  * @param amount to withdraw.
	  */
   public final void withdrawal (double amount)
   {
   		balance -= amount;
		deductWithdrawalFees ();
 	}	
   
	/** Get the balance of the account.
	  * @return the balance
	  */
   public double getBalance ()
   {
      return balance;
   }
}