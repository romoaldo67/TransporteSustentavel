package model;

public class Passagem {


    private int id;
    private String origem;
    private String destino;
    private String dataViagem;
    private Transporte transporte;
    private int valorEmPontos;
    private String status;

    
    private static final double LIMIAR_CARBONO_BAIXO = 0.05;

    public Passagem(int id, String origem, String destino, String dataViagem,
                    Transporte transporte, int valorEmPontos, String status) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataViagem = dataViagem;
        this.transporte = transporte;
        this.valorEmPontos = valorEmPontos;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public int getValorEmPontos() {
        return valorEmPontos;
    }

    public void setValorEmPontos(int valorEmPontos) {
        this.valorEmPontos = valorEmPontos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int calcularPontosNecessarios() {
        int pontosNecessarios = this.valorEmPontos;

        
        if (this.transporte != null) {
            pontosNecessarios = this.transporte.getValorPontos();
        }

        System.out.println("[CÁLCULO] Passagem " + this.origem + " → " + this.destino);
        System.out.println("  Pontos necessários: " + pontosNecessarios + " pts");

        return pontosNecessarios;
    }


    public int aplicarDescontoSustentavel() {
        int pontosBase = calcularPontosNecessarios();
        int pontosFinais = pontosBase;

        if (this.transporte != null && this.transporte.getTaxaCarbono() < LIMIAR_CARBONO_BAIXO) {
            
            double desconto = pontosBase * 0.15;
            pontosFinais = (int) (pontosBase - desconto);

            System.out.println("[SUSTENTÁVEL] Transporte com baixa emissão de carbono detectado!");
            System.out.println("  Taxa de carbono: " + this.transporte.getTaxaCarbono() + " kg CO2/km");
            System.out.println("  Desconto de 15% aplicado: -" + (int) desconto + " pts");
            System.out.println("  Valor final: " + pontosFinais + " pts");
        } else {
            System.out.println("[INFO] Transporte não elegível para desconto sustentável.");
            System.out.println("  Valor mantido: " + pontosFinais + " pts");
        }

        
        this.valorEmPontos = pontosFinais;

        return pontosFinais;
    }


    @Override
    public String toString() {
        return "Passagem{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", dataViagem='" + dataViagem + '\'' +
                ", transporte=" + (transporte != null ? transporte.getNome() : "N/A") +
                ", valorEmPontos=" + valorEmPontos +
                ", status='" + status + '\'' +
                '}';
    }
}
