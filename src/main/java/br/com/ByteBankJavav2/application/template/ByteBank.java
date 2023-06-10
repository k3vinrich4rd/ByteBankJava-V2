package br.com.ByteBankJavav2.application.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ByteBank {

    private String cnpj;
    private AddressCommercial addressCommercial;
    private final List<Account> accounts = new ArrayList<>();
    private final List<Holder> clients = new ArrayList<>();

    public ByteBank(String cnpj, AddressCommercial addressCommercial) {
        this.cnpj = cnpj;
        this.addressCommercial = addressCommercial;
    }

    public ByteBank() {

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public AddressCommercial getAddressCommercial() {
        return addressCommercial;
    }

    public void setAddressCommercial(AddressCommercial addressCommercial) {
        this.addressCommercial = addressCommercial;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);

    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(this.accounts);
    }

    public int sizeListAccount() {
        return this.accounts.size();
    }

    public void addHolders(Holder holder) {
        this.clients.add(holder);

    }

    public List<Holder> getHolders() {
        return Collections.unmodifiableList(this.clients);
    }

    public int sizeListHolders() {
        return this.clients.size();
    }

    @Override
    public String toString() {
        return "ByteBank{" +
                "cnpj='" + cnpj + '\'' +
                ", addressCommercial=" + addressCommercial +
                ", accounts=" + accounts +
                ", clients=" + clients +
                '}';
    }
}
