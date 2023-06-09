package br.com.ByteBankJavav2.application.enums;

public enum ExceptionsEnum {

    INSUFICIENT_BALANCE("Error, insufficient balance to perform this action");
    //TodoAUTHENTICATION_FAILURE("");

    private final String message;

    ExceptionsEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
