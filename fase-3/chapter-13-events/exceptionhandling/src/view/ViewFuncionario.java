package view;

import model.Funcionario;

public class ViewFuncionario {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        try {
            funcionario.setNome("Alfredo");
            funcionario.setEmail("alfredo@empresa.com");
            funcionario.setSalario(-100.00);
        }catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

}