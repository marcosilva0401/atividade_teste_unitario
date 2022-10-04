package br.ufrn.imd.models;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private final BankAccountTestFixture fixture = new BankAccountTestFixture();
    private BankAccount bankAccount;

    @BeforeEach
    public void Setup() {
        bankAccount = fixture.getNewBankAccount();
    }

    @Test
    @Description("Bank Account should have an account number and agency number")
    public void testBankAccountShouldHaveAccountNumberAndAgency() {
        assertNotNull(bankAccount.getAccountNumber());
        assertNotNull(bankAccount.getAgency());
    }

    @Test
    public void testDepositShouldChangeTheBalance() {
        bankAccount.deposit(200);
        assertEquals(200, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {-35, -10, 0, -3, -15})
    public void testDepositShouldNotBeZeroOrNegativeValue(double value) {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-35, -10, 0, -3, -15})
    public void testWithdrawShouldNotBeZeroOrNegativeValue(double value) {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-35, -10, 0, -3, -15})
    public void testTransferShouldNotBeZeroOrNegativeValue(double value) {
        BankAccount beneficiaryAccount = new BankAccount(2022515, 90485, 150);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(beneficiaryAccount, value));
    }

    @Test
    public void testWithdrawShouldNotBePlusThenBalance() {
        double value = bankAccount.getBalance() + 1;
        assertThrows(ArithmeticException.class, () -> bankAccount.withdraw(value));
    }

    @Test
    public void testTransferShouldNotBePlusThenBalance() {
        double value = bankAccount.getBalance() + 1;
        BankAccount beneficiaryAccount = new BankAccount(2022515, 90485, 150);
        assertThrows(ArithmeticException.class, () -> bankAccount.transfer(beneficiaryAccount, value));
    }
}

