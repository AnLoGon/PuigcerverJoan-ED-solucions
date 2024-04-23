package ud5.practices.bank.service;

import ud5.practices.bank.BankAccount;

public interface NotificationService {
    /**
     * Notify the change of the account holder name of a bank account
     * @param bankAccount the bank account
     */
    void notifyUpdateAccountHolderChange(BankAccount bankAccount);
}