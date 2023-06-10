package br.com.ByteBankJavav2.application.template;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    public SavingsAccount(Holder holder, BigDecimal balance, int numberAccount, int agencyAccount) {
        super(holder, balance, numberAccount, agencyAccount);
    }

    public SavingsAccount() {
        super();
    }

    @Override
    public void depositInAccount(BigDecimal value) {
        super.balance = super.balance.add(value);
        balanceRound();
    }

    @Override
    public String toString() {
        return "SavingsAccount{} " + super.toString();
    }
}
