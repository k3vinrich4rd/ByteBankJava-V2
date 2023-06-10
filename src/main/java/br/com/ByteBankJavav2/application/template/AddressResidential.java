package br.com.ByteBankJavav2.application.template;

public class AddressResidential extends Address {

    public AddressResidential(String publicPlace, int number, String neighborhood, String city, String state, String zipCode, String complement) {
        super(publicPlace, number, neighborhood, city, state, zipCode, complement);
    }

    public AddressResidential() {

    }

    @Override
    public String toString() {
        return "AddressResidential{} " + super.toString();
    }
}

