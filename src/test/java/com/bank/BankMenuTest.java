package com.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bank.service.BankService;

@ExtendWith(MockitoExtension.class)
public class BankMenuTest {
    @Mock
    private BankService bankService;
    
    private BankAccount account = new BankAccount("TestUser", "123");

    @Test
    public void testMenuCallsDeposit() {
        // Simulate user input: 'b' (deposit), '100', then 'e' (exit)
        String input = "b\n100\ne\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        new BankMenu(bankService, account).menu();
        verify(bankService).deposit(account, 100);
    }

    @Test
    public void testMenuCallsWithdraw() {
        // Simulate user input: 'c' (withdraw), '50', then 'e' (exit)
        String input = "c\n50\ne\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        new BankMenu(bankService, account).menu();
        verify(bankService).withdraw(account, 50);
    }
}