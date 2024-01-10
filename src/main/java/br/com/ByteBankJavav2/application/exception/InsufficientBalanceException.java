package br.com.ByteBankJavav2.application.exception;

import br.com.ByteBankJavav2.application.enums.ExceptionsEnum;

public class InsufficientBalanceException extends Exception {

    @Override
    public String getMessage() {
        return ExceptionsEnum.INSUFFICIENT_BALANCE.getMessage();
    }
}
