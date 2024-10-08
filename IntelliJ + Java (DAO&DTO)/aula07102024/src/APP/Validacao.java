package src.APP;

import java.util.regex.Pattern;

public class Validacao {

    public static boolean validarCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }
        return true;
    }

    public static boolean validarIdade(int idade) {
        return idade >= 0 && idade <= 120;
    }

    public static boolean validarTexto(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static void main(String[] args) {
        String cpf = "12345678901";
        int idade = 25;
        String nome = "João";

        if (validarCpf(cpf)) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }

        if (validarIdade(idade)) {
            System.out.println("Idade válida.");
        } else {
            System.out.println("Idade inválida.");
        }

        if (validarTexto(nome)) {
            System.out.println("Nome válido.");
        } else {
            System.out.println("Nome inválido.");
        }
    }
}
