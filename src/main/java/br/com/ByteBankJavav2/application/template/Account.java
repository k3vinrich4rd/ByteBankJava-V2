package br.com.ByteBankJavav2.application.template;

import br.com.ByteBankJavav2.application.enums.MessageSuccessEnum;
import br.com.ByteBankJavav2.application.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Account {
    private Holder holder;
    protected BigDecimal balance;
    private int numberAccount;
    private int agencyAccount;

    public Account(Holder holder, BigDecimal balance, int numberAccount, int agencyAccount) {
        this.holder = holder;
        this.balance = balance;
        this.numberAccount = numberAccount;
        this.agencyAccount = agencyAccount;
    }

    public Account() {
        super();
    }

    public abstract void depositInAccount(BigDecimal value);

    public void toWithdraw(BigDecimal value) throws InsufficientBalanceException {
        if (this.balance.compareTo(value) < 0) {
            System.out.println("Balance in account: " + this.balance + " value to withdraw: " + value);

            throw new InsufficientBalanceException();
        }
        this.balance = this.balance.subtract(value);
        var message = MessageSuccessEnum.SUCCESS_TOWITHDRAW.getMessage();
        System.out.println(message);
        balanceRound();
    }

    public void tranfer(BigDecimal value, Account account) throws InsufficientBalanceException {
        if (this.balance.compareTo(value) < 0) {
            throw new InsufficientBalanceException();
        }
        this.balance = this.balance.add(value);
        account.depositInAccount(value);
        var message = MessageSuccessEnum.SUCCESS_TRANSFER.getMessage();
        System.out.println(message);
        balanceRound();
    }

    protected void balanceRound() {
        this.balance = this.balance.setScale
                (2, RoundingMode.UP);
    }

    public Holder getHolder() {
        return this.holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getNumberAccount() {
        return this.numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public int getAgencyAccount() {
        return agencyAccount;
    }

    public void setAgencyAccount(int agencyAccount) {
        this.agencyAccount = agencyAccount;
    }
}
