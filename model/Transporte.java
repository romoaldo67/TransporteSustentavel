package model;

public class Transporte {

    private int id;
    private String tipo;
    private String nome;
    private int valorPontos;
    private double taxaCarbono;

    public Transporte(int id, String tipo, String nome, int valorPontos, double taxaCarbono) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.valorPontos = valorPontos;
        this.taxaCarbono = taxaCarbono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValorPontos() {
        return valorPontos;
    }

    public void setValorPontos(int valorPontos) {
        this.valorPontos = valorPontos;
    }

    public double getTaxaCarbono() {
        return taxaCarbono;
    }

    public void setTaxaCarbono(double taxaCarbono) {
        this.taxaCarbono = taxaCarbono;
    }

    public double calcularDesconto(boolean usaTransporteSustentavel) {
        double desconto = 0.0;

        if (usaTransporteSustentavel) {
            desconto = 0.10; // 10% de desconto
            int pontosComDesconto = (int) (this.valorPontos * (1 - desconto));
            System.out.println("[DESCONTO] Transporte sustentável! 10% de desconto aplicado.");
            System.out.println("  Valor original: " + this.valorPontos + " pts");
            System.out.println("  Valor com desconto: " + pontosComDesconto + " pts");
        } else {
            System.out.println("[INFO] Sem desconto aplicável. Valor: " + this.valorPontos + " pts");
        }

        return desconto;
    }

    public boolean verificarDisponibilidade() {
        boolean disponivel = this.valorPontos > 0 && this.taxaCarbono >= 0;

        if (disponivel) {
            System.out.println("[DISPONÍVEL] " + this.nome + " (" + this.tipo + ") está disponível.");
        } else {
            System.out.println("[INDISPONÍVEL] " + this.nome + " (" + this.tipo + ") não está disponível no momento.");
        }

        return disponivel;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", valorPontos=" + valorPontos +
                ", taxaCarbono=" + taxaCarbono + " kg CO2/km" +
                '}';
    }
}
