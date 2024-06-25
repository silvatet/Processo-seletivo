package Candidatos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class candidatos {

    public static void main(String[] args) {
        selecaoCandidatos();
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando =!atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println(" CONTATO REALIZADO COM SUCESSO ");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.printf(" CONSEGUIMOS CONTATO COM %s NA %dª TENTATIVA%n", candidato, tentativasRealizadas);
        } else {
            System.out.printf(" NÃO CONSEGUIMOS CONTATO COM %s NUMERO MAXIMO DE TENTATIVAS %d%n", candidato, tentativasRealizadas);
        }
    }

    // METODO AUXILIAR
    static boolean atender() {
        return new Random().nextInt(2) == 0;
    }

    static void imprimirSelecionados(String[] selecionados, String[] candidatos) {
        System.out.println("Imprimindo a lista de candidatos selecionados:");
        for (int i = 0; i < selecionados.length; i++) {
            if (selecionados[i]!= null) {
                int indice = getIndiceCandidato(candidatos, selecionados[i]);
                System.out.printf("O candidato de número %d é o %s%n", indice + 1, selecionados[i]);
            }
        }
    }

    static int getIndiceCandidato(String[] candidatos, String candidato) {
        for (int i = 0; i < candidatos.length; i++) {
            if (candidatos[i].equals(candidato)) {
                return i;
            }
        }
        return -1;
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "ISABEL", "LETICIA", "JUAN", "ANDREA"};
        String[] selecionados = new String[5];
        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;

        System.out.println("Iniciando processo de seleção de candidatos:");
        for (String candidato : candidatos) {
            double salarioPretendido = ValorPretendido();
            System.out.printf("O candidato %s solicitou este valor de salário: %.2f%n", candidato, salarioPretendido);
            if (salarioBase > salarioPretendido && candidatosSelecionados < 5) {
                selecionados[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
                entrandoEmContato(candidato);
            }
            analisaCandidato(candidato, salarioPretendido, salarioBase);
        }

        System.out.println();
        imprimirSelecionados(selecionados, candidatos);
    }

    static double ValorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisaCandidato(String candidato, double salarioPretendido, double salarioBase) {
        if (salarioBase > salarioPretendido) {
            System.out.printf("O candidato %s foi selecionado para a vaga.%n", candidato);
        } else if (salarioBase == salarioPretendido) {
            System.out.printf("Ligar para o candidato %s com outra proposta!%n", candidato);
        } else {
            System.out.printf("O candidato %s não foi selecionado.%n", candidato);
        }
    }
}