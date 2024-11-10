import java.util.ArrayList;
import java.util.List;

class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public String getTitular() {
        return titular;
    }
}

class Banco {
    private List<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta de " + conta.getTitular() + " adicionada com sucesso.");
    }

    public ContaBancaria buscarConta(String titular) {
        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equals(titular)) {
                return conta;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaBancaria conta1 = new ContaBancaria("João");
        ContaBancaria conta2 = new ContaBancaria("Maria");

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        conta1.depositar(1000);
        conta1.sacar(200);
        conta1.consultarSaldo();

        conta2.depositar(500);
        conta2.consultarSaldo();
    }
}
