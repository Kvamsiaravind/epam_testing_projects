package org.firsttask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.exceptions.DeficientBalanceException;

public class WithdrawCash {

    private static final Logger LOGGER = LogManager.getLogger(WithdrawCash.class);
    private Account account;

    public WithdrawCash(Account account) {
        this.account = account;
    }

    public int getWithdrawnAmount(int amountToBeWithdrawn) throws DeficientBalanceException {
        if (account.getBalance() >= amountToBeWithdrawn) {
            int accountBalance = account.getBalance() - amountToBeWithdrawn;
            account.setBalance(accountBalance);
            LOGGER.info("Withdrawn amount deducted from account");
        } else {
            LOGGER.info("Exception caught cause of insufficient balance");
            throw new DeficientBalanceException("Insufficient balance");
        }
        return amountToBeWithdrawn;
    }
}
