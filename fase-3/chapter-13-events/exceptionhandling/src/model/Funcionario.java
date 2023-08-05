package model;

public class Funcionario {
    private String nome;
    private String email;
    private Double salario;

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
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        if (salario<0.0) {
            throw new IllegalArgumentException("O salário não pode ser negativo");
        }
        this.salario = salario;
    }

}