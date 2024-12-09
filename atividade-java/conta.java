
import java.util.*; // serve tanto para classe Random, quanto para a Scanner


public class Conta {

    int numero_conta;
    String titular_conta;
    double saldo;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome_titular, double saldo_inicial){
        titular_conta = nome_titular;
        this.saldo = saldo_inicial;

        Random gerador_numero = new Random();
        numero_conta = gerador_numero.nextInt(1000); // gerador randomico de números (class Random)
    }

    public void Emprestimo(double valor_emprestimo){
        if(saldo >= valor_emprestimo) {
            this.saldo -= valor_emprestimo;
            System.out.println("Emprestado com sucesso!");
            System.out.println("Seu saldo agora é de: " + saldo);
        }else{
            System.out.println("Saldo insuficiente para emprestar!");
        }
    }

    public void VerSaldo(){
        System.out.println("O número da conta é: " + numero_conta);
        System.out.println("O nome do titular é : " + titular_conta);
        System.out.println("O saldo da conta é : " + saldo);
    }

    public void Saque(double valor_saque){
        if(saldo >= valor_saque){
            this.saldo = saldo - valor_saque;
            System.out.println("Seu saldo atual é de: " + saldo);
        }else{
            System.out.println("Saldo insuficiente");
        }

    }

    public void Deposito(double valor_deposito){
        if(valor_deposito <= 0){
            System.out.println("Depósito invalido");
        }else{
            saldo = saldo + valor_deposito;
            System.out.println("Depósito realizado com sucesso");
            System.out.println("Seu saldo agora é de: " + saldo);
        }
    }

    public void Iniciar(){
        int opcao;
        do {
            Exibir_menu();
            opcao = entrada.nextInt();
            Escolher_funcao(opcao);
        }while (opcao !=5);

    }


    public void Exibir_menu(){
        System.out.println("Bem-vindo ao Banco Vouvi");
        System.out.println("Escolha sua opção");
        System.out.println("1 - Ver Saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Emprestar");
        System.out.println("5 - Fizalizar");

 }

 public void Escolher_funcao(int opcao){
        double saque;
        double deposito;
        double emprestimo;

        switch(opcao){
            case 1:
                VerSaldo();
                break;

            case 2:
                System.out.println("Digite o valor a ser sacado: ");
                saque = entrada.nextDouble();
                Saque(saque);
                break;

            case 3:
                System.out.println("Digite o valor a ser depositado: ");
                deposito = entrada.nextDouble();
                Deposito(deposito);
                break;
                
            case 4:
                System.out.println("Digite o valor a ser emprestado: ");
                emprestimo = entrada.nextDouble();
                Emprestimo(emprestimo);
                break;

            case 5:
                System.out.println("Operação Finalizada!");
                break;

            default:
                System.out.println("opção invalida");
        }
 }

}

