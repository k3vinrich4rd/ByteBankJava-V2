package br.com.ByteBankJavav2.application.template;

public class AddressCommercial extends Address {

    public AddressCommercial(String publicPlace, int number, String neighborhood, String city, String state, String zipCode, String complement) {
        super(publicPlace, number, neighborhood, city, state, zipCode, complement);
    }

    public AddressCommercial() {
        super();
    }

    @Override
    public String toString() {
        return "AddressCommercial{} " + super.toString();
    }
}
