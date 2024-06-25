package Candidatos;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroUsuario{

    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cadastro de Usuários");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Listar usuários cadastrados");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.next();

        System.out.print("Digite o email do usuário: ");
        String email = scanner.next();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.next();

        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        System.out.println("Usuários cadastrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Senha: " + usuario.getSenha());
            System.out.println();
        }
    }

    private static class Usuario {
        private String nome;
        private String email;
        private String senha;

        public Usuario(String nome, String email, String senha) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getSenha() {
            return senha;
        }
    }
}