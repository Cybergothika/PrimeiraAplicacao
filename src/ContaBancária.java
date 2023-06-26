import java.util.Scanner;
public class ContaBancária {
    public static void main(String[] args) {
        // 1º Passo; Inserir os dados do cliente a serem usados
        String clientName = "Raziel Souza";
        String accountType = "Corrente";
        double balance = 2500.0;

        // Passo 2; Acionar Scanner e criar as variáveis
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Cortei 4 "System.out.println" usando bloco alternativo
        String[] opçõesDeMenu = {
                "Consultar saldos",
                "Inserir valor",
                "Sacar valor",
                "Sair",
        };

        do {
            System.out.println("************************");
            System.out.println("\nMenu de opções");

            for (int i = 0; i < opçõesDeMenu.length; i++) {
                System.out.println((i + 1) + "- " + opçõesDeMenu[i]);
            }
            System.out.print("\nDigite a opção desejada: ");
            choice = scanner.nextInt();

            // Apliquei contenção de escolha e loop
        if (choice < 1 || choice > opçõesDeMenu.length) {
                System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                continue; // Recomeçará se escolher além das opções oferecidas
            }

            // Passo 3, colocar o feature de balanço
            if (choice == 1) {
                System.out.println("Saldo atual: R$" + balance);
            }

            // Passo 4, implementar o feature de recebimento + adicionei limite na conta
            else if (choice == 2) {
                System.out.print("Informe o valor a adicionar: ");
                double amount = scanner.nextDouble();
                if (balance + amount <= 3000.0) {
                    balance += amount;
                    System.out.println("Saldo atualizado: R$" + balance);
                } else {
                    System.out.println("Limite de conta de 3000.");
                }
            }

            // Passo 5, transferência de valor + adicionei aviso de possível exceção
            else if (choice == 3) {
                System.out.print("Informe o valor que deseja sacar: ");
                double amount = scanner.nextDouble();
                if (amount <= balance && balance - amount >= -3000.0) {
                    balance -= amount;
                    System.out.println("Saldo atualizado: R$" + balance);
                } else {
                    if (amount > balance) {
                        System.out.println("Não há saldo suficiente para fazer essa transferência.");
                    }// Extra, decidi informar que não tem como sacar mais que 3000
                    System.out.println("Limite da conta de 3000.");
                    System.out.println("Saque total disponível: R$" + balance);
                }
            }
        }

        // Passo final, fechar e concluir
        while (choice != 4);

        scanner.close();
    }
    }


