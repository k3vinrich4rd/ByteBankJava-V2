package br.com.ByteBankJavav2;

import br.com.ByteBankJavav2.application.exception.InsufficientBalanceException;
import br.com.ByteBankJavav2.application.template.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ByteBankJavaV2ApplicationTests {
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;
    private final ByteBank byteBank = new ByteBank();

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

    //Testando listas
    @Test
    @DisplayName("Testando o preenchimento de uma lista de clientes")
    void aListaDeClientesDeveSerPreenchidaConformeEsperado() {
        var holder1 = new Holder();
        var holder2 = new Holder();
        byteBank.addHolders(holder1);
        byteBank.addHolders(holder2);
        var sizeListHolders = byteBank.sizeListHolders();
        assertEquals(2, sizeListHolders);
    }

    //Testando listas
    @Test
    @DisplayName("Testando o preenchimento de uma lista de contas")
    void aListaDeContasDeveSerPreenchidaConformeEsperado() {
        var currentAccount = new CurrentAccount();
        var savingsAccount = new SavingsAccount();
        byteBank.addAccount(currentAccount);
        byteBank.addAccount(savingsAccount);
        var sizeListAccounts = byteBank.sizeListAccount();
        assertEquals(2, sizeListAccounts);
    }

    //Testando exceptions
    @Test
    @DisplayName("Testando exception - Saldo insuficiente")
    void deveEstourarUmaExceptionCasoOSaldoForInsuficienteQuandoUmaContaForEfetuarUmSaque() {
        assertThrows(InsufficientBalanceException.class, () ->
                currentAccount.toWithdraw(new BigDecimal("600")));
    }

    @Test
    @DisplayName("Testando exception - Saldo insuficiente")
    void deveEstourarUmaExceptionCasoOSaldoForInsuficienteQuandoUmaContaForEfetuarUmaTransferencia() {
        assertThrows(InsufficientBalanceException.class, () ->
                savingsAccount.tranfer(new BigDecimal("600"), currentAccount));
    }

    @Test
    @DisplayName("Testando se a mensagem de uma exception está sendo lançada")
    void aMensagemDaExceptionDeveSerLancadaComoEsperado() {

        try {
            currentAccount.toWithdraw(new BigDecimal("1000"));
        } catch (InsufficientBalanceException insufficientBalanceException) {
            assertEquals("Error, insufficient balance to perform this action",
                    insufficientBalanceException.getMessage());
        }
    }
}
