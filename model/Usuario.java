package model;

public class Usuario {


    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String dataCadastro;


    public Usuario(int id, String nome, String email, String cpf, String dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public boolean validarCPF() {
        if (this.cpf == null || this.cpf.isEmpty()) {
            System.out.println("[ERRO] CPF não informado.");
            return false;
        }

        // Expressão regular para validar o formato XXX.XXX.XXX-XX
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        boolean valido = this.cpf.matches(regex);

        if (valido) {
            System.out.println("[OK] CPF " + this.cpf + " está no formato válido.");
        } else {
            System.out.println("[ERRO] CPF " + this.cpf + " está em formato inválido. Use XXX.XXX.XXX-XX.");
        }

        return valido;
    }


    public void atualizarDados(String nome, String email) {
        String nomeAntigo = this.nome;
        String emailAntigo = this.email;

        this.nome = nome;
        this.email = email;

        System.out.println("[ATUALIZAÇÃO] Dados do usuário atualizados com sucesso!");
        System.out.println("  Nome:  " + nomeAntigo + " → " + this.nome);
        System.out.println("  Email: " + emailAntigo + " → " + this.email);
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataCadastro='" + dataCadastro + '\'' +
                '}';
    }
}
