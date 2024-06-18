import java.util.ArrayList;
import java.util.List;

public class DevMedicoAplicacao {
    private final List<Medico> medicos;

    public DevMedicoAplicacao() {
        this.medicos = new ArrayList<>();
    }

    public void executar() {
        MedicoCLI cli = new MedicoCLI();

        while (true) {
            cli.exibirMenu();
            int opcao = cli.obterOpcao();
            Operacao operacao = Operacao.fromCodigo(opcao);

            if (operacao == null) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (operacao) {
                case ADICIONAR:
                    Medico novoMedico = cli.solicitarDadosMedico();
                    if (!medicoJaCadastrado(novoMedico.crm())) {
                        medicos.add(novoMedico);
                        System.out.println("Médico cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: CRM já cadastrado.");
                    }
                    break;
                case LISTAR:
                    if (medicos.isEmpty()) {
                        System.out.println("Nenhum médico cadastrado.");
                    } else {
                        medicos.forEach(System.out::println);
                    }
                    break;
                case SAIR:
                    System.out.println("Sistema encerrado.");
                    return;
            }
        }
    }

    private boolean medicoJaCadastrado(String crm) {
        return medicos.stream().anyMatch(medico -> medico.crm().equals(crm));
    }
}
