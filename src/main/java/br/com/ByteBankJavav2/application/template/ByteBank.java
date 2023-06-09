package br.com.ByteBankJavav2.application.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ByteBank {

    private String cnpj;
    private AddressCommercial addressCommercial;
    private final List<Account> accounts = List.of();
    private final List<Holder> clients = new ArrayList<>();

    public ByteBank(String cnpj, AddressCommercial addressCommercial) {
        this.cnpj = cnpj;
        this.addressCommercial = addressCommercial;
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

    public void addHolders(Holder holder) {
        this.clients.add(holder);

    }

    public List<Holder> getHolders() {
        return Collections.unmodifiableList(this.clients);
    }
}
