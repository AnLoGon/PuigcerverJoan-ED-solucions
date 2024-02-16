package ud5.practices.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Nested
    class Constructors {
        @Test
        @DisplayName("BankAccount(String accountNumber, String holderName) ha d'existir")
        @SuppressWarnings("unused")
        void testBankAccountConstructor() {
            BankAccount bankAccount = new BankAccount("1234", "Pep");
        }

        @Test
        @DisplayName("BankAccount(String accountNumber, String holderName) ha d'establir els paràmetres correctament")
        void testBankAccountConstructorParameters() {
            BankAccount bankAccount = new BankAccount("1234", "Pep");
            assertAll("bankAccount",
                () -> assertEquals("1234", bankAccount.getAccountNumber()),
                () -> assertEquals("Pep", bankAccount.getAccountHolder()),
                () -> assertEquals(0, bankAccount.getBalance())
            );
        }

        @Test
        @DisplayName("BankAccount(String accountNumber, String holderName, double initialBalance) ha d'existir")
        @SuppressWarnings("unused")
        void testBankAccountConstructorWithInitialBalance() {
            BankAccount bankAccount = new BankAccount("1234", "Pep", 100);
        }

        @Test
        @DisplayName("BankAccount(String accountNumber, String holderName, double initialBalance) ha d'establir els paràmetres correctament")
        void testBankAccountConstructorWithInitialBalanceParameters() {
            BankAccount bankAccount = new BankAccount("1234", "Pep", 100);
            assertAll("bankAccount",
                () -> assertEquals("1234", bankAccount.getAccountNumber()),
                () -> assertEquals("Pep", bankAccount.getAccountHolder()),
                () -> assertEquals(100, bankAccount.getBalance())
            );
        }
    }

    @Nested
    class Deposit {
        private BankAccount bankAccount;

        @BeforeEach
        void setUp() {
            bankAccount = new BankAccount("1234", "Pep");
        }
        /*
        @Test
        @DisplayName("deposit() ha d'existir")
        void testDepositMethod() {
            BankAccount bankAccount = new BankAccount("1234", "Pep");
            bankAccount.deposit();
        }
         */

        @Test
        @DisplayName("deposit(double amount) ha d'existir")
        void testDepositMethodWithAmount() {
            bankAccount.deposit(100);
        }

        @Test
        @DisplayName("deposit(double amount) ha de retornar un boolea")
        @SuppressWarnings("unused")
        void testDepositMethodWithAmountReturnsBoolean() {
            boolean result = bankAccount.deposit(100);
        }

        @Test
        @DisplayName("deposit(double amount) ha de sumar l'import al saldo")
        void testDepositMethodWithAmountAddsAmountToBalance() {
            bankAccount.deposit(100);
            assertEquals(100, bankAccount.getBalance());
        }

        @Test
        @DisplayName("deposit(double amount) ha de sumar l'import al saldo")
        void testMultipleDepositMethodWithAmountAddsAmountToBalance() {
            bankAccount.deposit(100);
            bankAccount.deposit(100);
            assertEquals(200, bankAccount.getBalance());
        }

        @Test
        @DisplayName("deposit(double amount) no ha de sumar un import negatiu")
        void testDepositMethodWithNegativeAmountDoesNotAddAmountToBalance() {
            bankAccount.deposit(-100);
            assertEquals(0, bankAccount.getBalance());
        }

        @Test
        @DisplayName("deposit(double amount) ha de retornar true si l'import és positiu")
        void testDepositMethodWithPositiveAmountReturnsTrue() {
            boolean result = bankAccount.deposit(100);
            assertTrue(result);
        }

        @Test
        @DisplayName("deposit(double amount) ha de retornar false si l'import és negatiu")
        void testDepositMethodWithNegativeAmountReturnsFalse() {
            boolean result = bankAccount.deposit(-100);
            assertFalse(result);
        }

        @Test
        @DisplayName("deposit(double amount) ha de retornar false si l'import és 0")
        void testDepositMethodWithZeroAmountReturnsFalse() {
            boolean result = bankAccount.deposit(0);
            assertFalse(result);
        }
    }

    @Nested
    class Withdraw {
        private BankAccount bankAccount;

        @BeforeEach
        void setUp() {
            bankAccount = new BankAccount("1234", "Pep", 100);
        }

        /*
        @Test
        @DisplayName("withdraw() ha d'existir")
        void testWithdrawMethod() {
            BankAccount bankAccount = new BankAccount("1234", "Pep");
            bankAccount.withdraw();
        }
        */

        @Test
        @DisplayName("withdraw(double amount) ha d'existir")
        void testWithdrawMethodWithAmount() {
            bankAccount.withdraw(100);
        }

        @Test
        @DisplayName("withdraw(double amount) ha de retornar un boolea")
        @SuppressWarnings("unused")
        void testWithdrawMethodWithAmountReturnsBoolean() {
            boolean result = bankAccount.withdraw(100);
        }

        @Test
        @DisplayName("withdraw(double amount) ha de poder restar l'import al saldo")
        void testWithdrawMethodWithAmountSubstractsAmountFromBalance() {
            bankAccount.withdraw(50);
            assertEquals(50, bankAccount.getBalance());
        }

        @Test
        @DisplayName("withdraw(double amount) ha de poder restar l'import màxim al saldo")
        void testWithdrawMethodWithMaxAmountSubstractsAmountFromBalance() {
            bankAccount.withdraw(100);
            assertEquals(0, bankAccount.getBalance());
        }

        @Test
        @DisplayName("withdraw(double amount) no pot restar una quantitat negativa")
        void testWithdrawMethodWithNegativeAmountDoesNotSubstractAmountFromBalance() {
            bankAccount.withdraw(-100);
            assertEquals(100, bankAccount.getBalance());
        }

        @Test
        @DisplayName("withdraw(double amount) no pot restar una quantitat superior al saldo")
        void testWithdrawMethodWithAmountGreaterThanBalanceDoesNotSubstractAmountFromBalance() {
            bankAccount.withdraw(200);
            assertEquals(100, bankAccount.getBalance());
        }

        @Test
        @DisplayName("withdraw(double amount) ha de retornar true si l'import és positiu i inferior al saldo")
        void testWithdrawMethodWithPositiveAmountReturnsTrue() {
            boolean result = bankAccount.withdraw(100);
            assertTrue(result);
        }

        @Test
        @DisplayName("withdraw(double amount) ha de retornar false si l'import és negatiu")
        void testWithdrawMethodWithNegativeAmountReturnsFalse() {
            boolean result = bankAccount.withdraw(-100);
            assertFalse(result);
        }

        @Test
        @DisplayName("withdraw(double amount) ha de retornar false si l'import és 0")
        void testWithdrawMethodWithZeroAmountReturnsFalse() {
            boolean result = bankAccount.withdraw(0);
            assertFalse(result);
        }

        @Test
        @DisplayName("withdraw(double amount) ha de retornar false si l'import és superior al saldo")
        void testWithdrawMethodWithAmountGreaterThanBalanceReturnsFalse() {
            boolean result = bankAccount.withdraw(200);
            assertFalse(result);
        }
    }

    @Nested
    class Transfer {
        private BankAccount bankAccount;
        private BankAccount destinationAccount;

        @BeforeEach
        void setUp() {
            bankAccount = new BankAccount("1234", "Pep", 100);
            destinationAccount = new BankAccount("5678", "Pep", 100);
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) ha d'existir")
        void testTransferMethodWithDestinationAndAmount() {
            bankAccount.transfer(destinationAccount, 100);
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) ha de retornar un boolea")
        @SuppressWarnings("unused")
        void testTransferMethodWithDestinationAndAmountReturnsBoolean() {
            boolean result = bankAccount.transfer(destinationAccount, 100);
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) ha de restar l'import al saldo i sumar-lo en el compte destí")
        void testTransferMethodWithDestinationAndAmountSubstractsAmountFromBalanceAndAddsItToDestinationBalance() {
            bankAccount.transfer(destinationAccount, 100);
            assertAll("bankAccount",
                () -> assertEquals(0, bankAccount.getBalance()),
                () -> assertEquals(200, destinationAccount.getBalance())
            );
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) no pot restar una quantitat negativa")
        void testTransferMethodWithNegativeAmountDoesNotSubstractAmountFromBalance() {
            bankAccount.transfer(destinationAccount, -100);
            assertAll("bankAccount",
                () -> assertEquals(100, bankAccount.getBalance()),
                () -> assertEquals(100, destinationAccount.getBalance())
            );
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) no pot restar una quantitat superior al saldo")
        void testTransferMethodWithAmountGreaterThanBalanceDoesNotSubstractAmountFromBalance() {
            bankAccount.transfer(destinationAccount, 200);
            assertAll("bankAccount",
                () -> assertEquals(100, bankAccount.getBalance()),
                () -> assertEquals(100, destinationAccount.getBalance())
            );
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) ha de retornar true si l'import és positiu i inferior al saldo")
        void testTransferMethodWithPositiveAmountReturnsTrue() {
            boolean result = bankAccount.transfer(destinationAccount, 100);
            assertTrue(result);
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) ha de retornar false si l'import és negatiu")
        void testTransferMethodWithNegativeAmountReturnsFalse() {
            boolean result = bankAccount.transfer(destinationAccount, -100);
            assertFalse(result);
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) ha de retornar false si l'import és 0")
        void testTransferMethodWithZeroAmountReturnsFalse() {
            boolean result = bankAccount.transfer(destinationAccount, 0);
            assertFalse(result);
        }

        @Test
        @DisplayName("transfer(BankAccount destination, double amount) ha de retornar false si l'import és superior al saldo")
        void testTransferMethodWithAmountGreaterThanBalanceReturnsFalse() {
            boolean result = bankAccount.transfer(destinationAccount, 200);
            assertFalse(result);
        }
    }
}
