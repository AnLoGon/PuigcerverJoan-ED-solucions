package ud5.practices.bank.service.impl;

import ud5.practices.bank.BankAccount;
import ud5.practices.bank.exception.BankAccountNotFoundException;
import ud5.practices.bank.exception.InvalidAccountHolderNameException;
import ud5.practices.bank.repository.BankAccountRepository;
import ud5.practices.bank.service.BankAccountService;
import ud5.practices.bank.service.NotificationService;

import java.util.Comparator;
import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final NotificationService notificationService;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, NotificationService notificationService) {
        this.bankAccountRepository = bankAccountRepository;
        this.notificationService = notificationService;
    }

    public List<BankAccount> getAll() {
        List<BankAccount> bankAccounts = bankAccountRepository.getAll();
        bankAccounts.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return bankAccounts;
    }

    public BankAccount getBankAccountByNumber(String accountNumber) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.getBankAccountByNumber(accountNumber);
        if (bankAccount == null) {
            throw new BankAccountNotFoundException("Invalid account number: " + accountNumber);
        }
        return bankAccount;
    }

    public void updateAccountHolder(BankAccount bankAccount, String accountHolder) throws InvalidAccountHolderNameException {
        if (bankAccount.getAccountHolder().length() < 3) {
            throw new InvalidAccountHolderNameException("Holder name must be at least 3 characters long");
        }
        bankAccount.setAccountHolder(accountHolder);
        notificationService.notifyUpdateAccountHolderChange(bankAccount);
        bankAccountRepository.updateAccountHolder(bankAccount);
    }
}