import java.util.Scanner;

public class MedicoCLI {
    private final Scanner scanner;

    public MedicoCLI() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Adicionar Médico");
        System.out.println("2. Listar Médicos");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int obterOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida. Digite um número.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public Medico solicitarDadosMedico() {
        scanner.nextLine();  // Consome o newline sobrante
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  // Consome o newline sobrante
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        return new Medico(nome, crm, idade, telefone, especialidade);
    }
}