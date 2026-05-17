import model.*;

/**
 * ╔═══════════════════════════════════════════════════════════════════════════╗
 * ║            SISTEMA DE TRANSPORTE SUSTENTÁVEL COM PROGRAMA DE PONTOS       ║
 * ╠═══════════════════════════════════════════════════════════════════════════╣
 * ║                                                                           ║
 * ║  Descrição:                                                               ║
 * ║  Sistema que incentiva o uso de transportes sustentáveis através de um    ║
 * ║  programa de fidelidade baseado em pontos. Os usuários acumulam pontos    ║
 * ║  ao utilizar meios de transporte com menor emissão de carbono e podem     ║
 * ║  resgatar passagens com descontos especiais.                              ║
 * ║                                                                           ║
 * ║  Classes do sistema:                                                      ║
 * ║  • Usuario       - Gerencia dados cadastrais e validação de CPF           ║
 * ║  • CartaoPontos  - Controla saldo de pontos do programa de fidelidade     ║
 * ║  • Transporte    - Representa meios de transporte e suas emissões         ║
 * ║  • Passagem      - Gerencia passagens e cálculos de pontos/descontos      ║
 * ║  • Resgate       - Processa transações de resgate de passagens            ║
 * ║                                                                           ║
 * ║                                                                           ║
 * ╚═══════════════════════════════════════════════════════════════════════════╝
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE TRANSPORTE SUSTENTÁVEL - PROGRAMA DE PONTOS      ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");


        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  ETAPA 1: Cadastro de Usuário");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");


        Usuario usuario1 = new Usuario(1, "Bruno Pires", "",
                "123.456.789-00", "12/05/2026");
        System.out.println("Usuário criado: " + usuario1);


        System.out.println("\n--- Teste de Validação de CPF ---");
        usuario1.validarCPF();


        Usuario usuario2 = new Usuario(2, "João Santos", "joao@email.com",
                "12345678900", "12/05/2026");
        usuario2.validarCPF();


        System.out.println("\n--- Teste de Atualização de Dados ---");
        usuario1.atualizarDados("Maria Silva Oliveira", "maria.oliveira@email.com");


        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  ETAPA 2: Cartão de Pontos");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");


        CartaoPontos cartao = new CartaoPontos("CP-2026-0001", 0, "12/05/2028", usuario1);
        System.out.println("Cartão criado: " + cartao);


        System.out.println("\n--- Verificação de Saldo Inicial ---");
        cartao.verificarSaldo();


        System.out.println("\n--- Adicionando Pontos ---");
        cartao.adicionarPontos(500);
        cartao.adicionarPontos(300);
        cartao.adicionarPontos(200);


        System.out.println("\n--- Verificação de Saldo Atual ---");
        cartao.verificarSaldo();


        System.out.println("\n--- Teste com Valor Inválido ---");
        cartao.adicionarPontos(-50);


        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  ETAPA 3: Meios de Transporte");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");


        Transporte bicicletaEletrica = new Transporte(1, "Bicicleta Elétrica",
                "E-Bike Urbana", 200, 0.02);
        System.out.println("Transporte 1 criado: " + bicicletaEletrica);


        Transporte onibus = new Transporte(2, "Ônibus",
                "Ônibus Intermunicipal", 500, 0.08);
        System.out.println("Transporte 2 criado: " + onibus);


        Transporte aviao = new Transporte(3, "Avião",
                "Voo Doméstico", 1500, 0.25);
        System.out.println("Transporte 3 criado: " + aviao);


        System.out.println("\n--- Verificação de Disponibilidade ---");
        bicicletaEletrica.verificarDisponibilidade();
        onibus.verificarDisponibilidade();
        aviao.verificarDisponibilidade();


        System.out.println("\n--- Cálculo de Descontos ---");
        bicicletaEletrica.calcularDesconto(true);   
        System.out.println();
        aviao.calcularDesconto(false);               


        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  ETAPA 4: Passagens");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");


        Passagem passagem1 = new Passagem(1, "São Paulo", "Campinas", "20/06/2026",
                bicicletaEletrica, 200, "Disponível");
        System.out.println("Passagem 1 criada: " + passagem1);

        Passagem passagem2 = new Passagem(2, "São Paulo", "Rio de Janeiro", "25/06/2026",
                onibus, 500, "Disponível");
        System.out.println("Passagem 2 criada: " + passagem2);


        System.out.println("\n--- Cálculo de Pontos Necessários ---");
        passagem1.calcularPontosNecessarios();
        System.out.println();
        passagem2.calcularPontosNecessarios();


        System.out.println("\n--- Aplicação de Desconto Sustentável ---");
        System.out.println("Passagem 1 (E-Bike - taxa carbono: " + bicicletaEletrica.getTaxaCarbono() + "):");
        int pontosFinais1 = passagem1.aplicarDescontoSustentavel();

        System.out.println("\nPassagem 2 (Ônibus - taxa carbono: " + onibus.getTaxaCarbono() + "):");
        int pontosFinais2 = passagem2.aplicarDescontoSustentavel();


        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  ETAPA 5: Resgate de Passagem (Fluxo Completo)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        
        System.out.println(">>> Resgate 1: Passagem sustentável (E-Bike)");
        System.out.println("    Saldo atual do cartão: " + cartao.getSaldoPontos() + " pts");
        System.out.println("    Pontos necessários:    " + pontosFinais1 + " pts\n");

        Resgate resgate1 = new Resgate(1, cartao, passagem1, "12/05/2026", pontosFinais1);
        resgate1.processarTransacao();

        
        System.out.println("\n>>> Resgate 2: Passagem convencional (Ônibus)");
        System.out.println("    Saldo atual do cartão: " + cartao.getSaldoPontos() + " pts");
        System.out.println("    Pontos necessários:    " + pontosFinais2 + " pts\n");

        Resgate resgate2 = new Resgate(2, cartao, passagem2, "12/05/2026", pontosFinais2);
        resgate2.processarTransacao();


        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  RESUMO FINAL DO SISTEMA");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        System.out.println("Usuário:    " + usuario1.getNome());
        System.out.println("CPF:        " + usuario1.getCpf());
        System.out.println("E-mail:     " + usuario1.getEmail());
        System.out.println("Cartão:     " + cartao.getNumeroCartao());
        System.out.println("Saldo:      " + cartao.getSaldoPontos() + " pontos restantes");
        System.out.println("Passagem 1: " + passagem1.getOrigem() + " → " + passagem1.getDestino()
                + " | Status: " + passagem1.getStatus());
        System.out.println("Passagem 2: " + passagem2.getOrigem() + " → " + passagem2.getDestino()
                + " | Status: " + passagem2.getStatus());

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║          SISTEMA FINALIZADO COM SUCESSO!                        ║");
        System.out.println("║   Obrigado por escolher transportes sustentáveis! 🌿           ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
    }
}
