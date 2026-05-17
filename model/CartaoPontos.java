package model;

public class CartaoPontos {

    private String numeroCartao;
    private int saldoPontos;
    private String dataValidade;
    private Usuario usuario;

    public CartaoPontos(String numeroCartao, int saldoPontos, String dataValidade, Usuario usuario) {
        this.numeroCartao = numeroCartao;
        this.saldoPontos = saldoPontos;
        this.dataValidade = dataValidade;
        this.usuario = usuario;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getSaldoPontos() {
        return saldoPontos;
    }

    public void setSaldoPontos(int saldoPontos) {
        this.saldoPontos = saldoPontos;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void adicionarPontos(int pontos) {
        if (pontos <= 0) {
            System.out.println("[ERRO] A quantidade de pontos deve ser positiva.");
            return;
        }

        int saldoAnterior = this.saldoPontos;
        this.saldoPontos += pontos;

        System.out.println("[PONTOS] +" + pontos + " pontos adicionados ao cartão " + this.numeroCartao);
        System.out.println("  Saldo anterior: " + saldoAnterior + " pts");
        System.out.println("  Novo saldo:     " + this.saldoPontos + " pts");
    }


    public boolean verificarSaldo() {
        if (this.saldoPontos > 0) {
            System.out.println("[SALDO] Cartão " + this.numeroCartao + " possui " + this.saldoPontos + " pontos disponíveis.");
            return true;
        } else {
            System.out.println("[SALDO] Cartão " + this.numeroCartao + " não possui pontos disponíveis.");
            return false;
        }
    }


    @Override
    public String toString() {
        return "CartaoPontos{" +
                "numeroCartao='" + numeroCartao + '\'' +
                ", saldoPontos=" + saldoPontos +
                ", dataValidade='" + dataValidade + '\'' +
                ", usuario=" + (usuario != null ? usuario.getNome() : "N/A") +
                '}';
    }
}
