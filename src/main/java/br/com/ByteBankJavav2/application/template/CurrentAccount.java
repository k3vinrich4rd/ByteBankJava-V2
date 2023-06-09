package br.com.ByteBankJavav2.application.template;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    public CurrentAccount(Holder holder, BigDecimal balance, int numberAccount, int agencyAccount) {
        super(holder, balance, numberAccount, agencyAccount);
    }

    public CurrentAccount() {
        super();
    }

    @Override
    public void depositInAccount(BigDecimal value) {
        super.balance = super.balance.add(value);
        balanceRound();
    }
}