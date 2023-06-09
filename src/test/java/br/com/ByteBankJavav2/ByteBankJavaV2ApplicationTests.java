package br.com.ByteBankJavav2;

import br.com.ByteBankJavav2.application.exception.InsufficientBalanceException;
import br.com.ByteBankJavav2.application.template.CurrentAccount;
import br.com.ByteBankJavav2.application.template.Holder;
import br.com.ByteBankJavav2.application.template.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ByteBankJavaV2ApplicationTests {
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    @BeforeEach
    @DisplayName("Inicializando os objetos")
    void inicializandoObjetos() {
        var holder1 = new Holder();
        var holder2 = new Holder();
        this.savingsAccount = new SavingsAccount(holder2,
                new BigDecimal("500"), 111, 111);
        this.currentAccount = new CurrentAccount(holder1,
                new BigDecimal("300"),
                4444, 5555);
    }

    @Test
    @DisplayName("Desenvolvimento guiado por testes - deposito")
    void aContaDeveEfetuarUmDeposito() {
        currentAccount.depositInAccount(new BigDecimal("30"));
        assertEquals(new BigDecimal("330.00"), currentAccount.getBalance());
    }

    @Test
    @DisplayName("Desenvolvimento guiado por testes - Saque")
    void aContaDeveEfetuarUmSaque() throws InsufficientBalanceException {
        currentAccount.toWithdraw(new BigDecimal("100"));
        assertEquals(new BigDecimal("200.00"), currentAccount.getBalance());
    }

    @Test
    @DisplayName("Desenvolvimento guiado por teste - transferência")
    void aContaDeveEfetuarUmaTransferenciaParaOutraConta() throws InsufficientBalanceException {
        savingsAccount.tranfer(new BigDecimal("100.00"), currentAccount);
        assertEquals(new BigDecimal("400.00"), currentAccount.getBalance());
    }
}
