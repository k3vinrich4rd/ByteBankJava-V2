package br.com.ByteBankJavav2.application.enums;

public enum MessageSuccessEnum {
    SUCESS_DEPOSIT("Deposit action performed successfully"),
    SUCCESS_TRANSFER("Transfer performed successfully"),

    SUCCESS_TOWITHDRAW("Withdrawal action performed successfully");

    private final String message;

    MessageSuccessEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

