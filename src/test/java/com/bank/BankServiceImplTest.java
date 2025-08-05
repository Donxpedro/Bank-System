package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.bank.service.impl.BankServiceImpl;

public class BankServiceImplTest {
    private BankServiceImpl bankService = new BankServiceImpl();
    private BankAccount account = new BankAccount("TestUser", "123");

    @Test
    public void testDepositPositiveAmount() {
        account.setBalance(100);
        bankService.deposit(account, 50);
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        account.setBalance(100);
        bankService.deposit(account, -50);
        assertEquals(100, account.getBalance()); // Balance shouldn't change
    }

    @Test
    public void testWithdrawValidAmount() {
        account.setBalance(100);
        bankService.withdraw(account, 30);
        assertEquals(70, account.getBalance());
    }

    @Test
    public void testWithdrawExceedingBalance() {
        account.setBalance(100);
        bankService.withdraw(account, 150);
        assertEquals(100, account.getBalance()); // Balance shouldn't change
    }
}