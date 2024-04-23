package ud5.practices.bank.service;

import ud5.practices.bank.BankAccount;
import ud5.practices.bank.exception.BankAccountNotFoundException;
import ud5.practices.bank.exception.InvalidAccountHolderNameException;

import java.util.List;

public interface BankAccountService {
    /**
     * Get all bank accounts
     * @return a list with all bank accounts
     */
    List<BankAccount> getAll();

    /**
     * Get a bank account by its account number
     * @param accountNumber the account number
     * @return the bank account
     * @throws BankAccountNotFoundException if does not exist a bank account with the given account number
     */
    BankAccount getBankAccountByNumber(String accountNumber) throws BankAccountNotFoundException;

    /**
     * Update the account holder name of a bank account
     * @param bankAccount the bank account
     * @param accountHolder the new account holder name
     * @throws InvalidAccountHolderNameException if the account holder name is invalid (less than 3 characters)
     */
    void updateAccountHolder(BankAccount bankAccount, String accountHolder) throws InvalidAccountHolderNameException;
}