package model;

public class Resgate {

    private int id;
    private CartaoPontos cartaoPontos;
    private Passagem passagem;
    private String dataResgate;
    private int pontosUtilizados;


    public Resgate(int id, CartaoPontos cartaoPontos, Passagem passagem,
                   String dataResgate, int pontosUtilizados) {
        this.id = id;
        this.cartaoPontos = cartaoPontos;
        this.passagem = passagem;
        this.dataResgate = dataResgate;
        this.pontosUtilizados = pontosUtilizados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CartaoPontos getCartaoPontos() {
        return cartaoPontos;
    }

    public void setCartaoPontos(CartaoPontos cartaoPontos) {
        this.cartaoPontos = cartaoPontos;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    public String getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(String dataResgate) {
        this.dataResgate = dataResgate;
    }

    public int getPontosUtilizados() {
        return pontosUtilizados;
    }

    public void setPontosUtilizados(int pontosUtilizados) {
        this.pontosUtilizados = pontosUtilizados;
    }

    public boolean validarResgate() {
        System.out.println("[VALIDAÇÃO] Verificando resgate #" + this.id + "...");

        if (this.cartaoPontos == null) {
            System.out.println("  [ERRO] Cartão de pontos não associado ao resgate.");
            return false;
        }

        if (this.passagem == null) {
            System.out.println("  [ERRO] Passagem não associada ao resgate.");
            return false;
        }

        int saldoDisponivel = this.cartaoPontos.getSaldoPontos();
        int pontosNecessarios = this.pontosUtilizados;

        System.out.println("  Saldo disponível:    " + saldoDisponivel + " pts");
        System.out.println("  Pontos necessários:  " + pontosNecessarios + " pts");

        if (saldoDisponivel >= pontosNecessarios) {
            System.out.println("  [OK] Resgate APROVADO! Saldo suficiente.");
            return true;
        } else {
            int faltam = pontosNecessarios - saldoDisponivel;
            System.out.println("  [NEGADO] Saldo insuficiente. Faltam " + faltam + " pontos.");
            return false;
        }
    }

    public void processarTransacao() {
        System.out.println("\n[TRANSAÇÃO] Processando resgate #" + this.id + "...");

        
        if (!validarResgate()) {
            System.out.println("[TRANSAÇÃO] Resgate CANCELADO por saldo insuficiente.");
            return;
        }

        
        int saldoAnterior = this.cartaoPontos.getSaldoPontos();
        int novoSaldo = saldoAnterior - this.pontosUtilizados;
        this.cartaoPontos.setSaldoPontos(novoSaldo);

        
        if (this.passagem != null) {
            this.passagem.setStatus("Resgatada");
        }

        
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("  ║       RESGATE CONFIRMADO COM SUCESSO!    ║");
        System.out.println("  ╠══════════════════════════════════════════╣");
        System.out.println("  ║  Resgate #" + String.format("%-31d", this.id) + "║");
        System.out.println("  ║  Pontos debitados: " + String.format("%-21d", this.pontosUtilizados) + "║");
        System.out.println("  ║  Saldo anterior:   " + String.format("%-21d", saldoAnterior) + "║");
        System.out.println("  ║  Novo saldo:       " + String.format("%-21d", novoSaldo) + "║");
        if (this.passagem != null) {
            String rota = this.passagem.getOrigem() + " → " + this.passagem.getDestino();
            System.out.println("  ║  Rota: " + String.format("%-33s", rota) + "║");
        }
        System.out.println("  ║  Data: " + String.format("%-33s", this.dataResgate) + "║");
        System.out.println("  ╚══════════════════════════════════════════╝");
    }


    @Override
    public String toString() {
        return "Resgate{" +
                "id=" + id +
                ", cartao=" + (cartaoPontos != null ? cartaoPontos.getNumeroCartao() : "N/A") +
                ", passagem=" + (passagem != null ? passagem.getOrigem() + "→" + passagem.getDestino() : "N/A") +
                ", dataResgate='" + dataResgate + '\'' +
                ", pontosUtilizados=" + pontosUtilizados +
                '}';
    }
}
