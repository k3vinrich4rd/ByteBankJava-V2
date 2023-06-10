package br.com.ByteBankJavav2.application.template;

public class Holder {
    private String name;
    private String cpf;
    private AddressResidential addressResidential;
    private Account account;

    public Holder(String name, String cpf, AddressResidential addressResidential, Account account) {
        this.name = name;
        this.cpf = cpf;
        this.addressResidential = addressResidential;
        this.account = account;
    }

    public Holder() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AddressResidential getAddressResidential() {
        return addressResidential;
    }

    public void setAddressResidential(AddressResidential addressResidential) {
        this.addressResidential = addressResidential;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "\nHolder" + "\n" +
                "name: " + name + "\n" +
                "cpf: " + cpf + "\n" +
                "addressResidential: " + addressResidential + "\n" +
                "account: " + account +
                "\n";
    }
}
