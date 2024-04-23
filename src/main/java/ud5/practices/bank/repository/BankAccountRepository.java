package ud5.practices.bank.repository;

import ud5.practices.bank.BankAccount;

import java.util.List;

public interface BankAccountRepository {
    /**
     * Get all bank accounts
     * @return a list with all bank accounts
     */
    List<BankAccount> getAll();
    /**
     * Get a bank account by its account number
     * @param accontNumber the account number
     * @return the bank account; null if does not exist a bank account with the given account number
     */
    BankAccount getBankAccountByNumber(String accontNumber);

    /**
     * Update the account holder name of a bank account
     * @param bankAccount the bank account
     */
    void updateAccountHolder(BankAccount bankAccount);
}

