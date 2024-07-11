package OrdenacaoRelatorio;

import java.util.Arrays;
import java.util.Random;

public class QuickSortMain {
    public static void main(String[] args) {
        int[] tamanhos = {100000, 1000000};
        Random rand = new Random();

        for (int tamanho : tamanhos) {
            int[] arrayOrdenado = new int[tamanho];
            int[] arrayInvertido = new int[tamanho];
            int[] arrayAleatorio = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                arrayOrdenado[i] = i;
                arrayInvertido[i] = tamanho - i - 1;
                arrayAleatorio[i] = rand.nextInt(tamanho);
            }

            testarAlgoritmoDeOrdenacao("Quick Sort", new QuickSort(), arrayOrdenado, arrayInvertido, arrayAleatorio.clone());
        }
    }

    private static void testarAlgoritmoDeOrdenacao(String nomeAlgoritmo, SorteioAlgoritmo algoritmo, int[] arrayOrdenado, int[] arrayInvertido, int[] arrayAleatorio) {
        System.out.println("Testando " + nomeAlgoritmo + " com " + arrayOrdenado.length + " elementos.");

        testarCenario(algoritmo, "Ordenado", arrayOrdenado);
        testarCenario(algoritmo, "Invertido", arrayInvertido);
        testarCenario(algoritmo, "Aleatório", arrayAleatorio);

        System.out.println();
    }

    private static void testarCenario(SorteioAlgoritmo algoritmo, String cenario, int[] arrayOriginal) {
        int[] array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        algoritmo.resetarContadores();

        long tempoInicio = System.nanoTime();
        algoritmo.ordenar(array);
        long tempoFim = System.nanoTime();

        long duracao = (tempoFim - tempoInicio) / 1_000_000; 
        System.out.printf("%s array: %d ms, %d comparacoes, %d trocas%n",
                cenario, duracao, algoritmo.getComparacoes(), algoritmo.getTrocas());
    }
}
