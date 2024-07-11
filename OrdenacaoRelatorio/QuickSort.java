package OrdenacaoRelatorio;

import java.util.Random;

public class QuickSort implements SorteioAlgoritmo {
    private long comparacoes;
    private long trocas;
    private static final Random random = new Random();

    @Override
    public void ordenar(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int baixo, int alto) {
        while (baixo < alto) {
            int pi = particao(array, baixo, alto);

            if (pi - baixo < alto - pi) {
                quickSort(array, baixo, pi - 1);
                baixo = pi + 1;
            } else {
                quickSort(array, pi + 1, alto);
                alto = pi - 1;
            }
        }
    }

    private int particao(int[] array, int baixo, int alto) {
        int pivotIndex = baixo + random.nextInt(alto - baixo + 1);
        int pivot = array[pivotIndex];
        trocar(array, pivotIndex, alto);
        int i = baixo - 1;
        for (int j = baixo; j < alto; j++) {
            comparacoes++;
            if (array[j] < pivot) {
                i++;
                trocas++;
                trocar(array, i, j);
            }
        }
        trocas++;
        trocar(array, i + 1, alto);
        return i + 1;
    }

    private void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void resetarContadores() {
        comparacoes = 0;
        trocas = 0;
    }

    @Override
    public long getComparacoes() {
        return comparacoes;
    }

    @Override
    public long getTrocas() {
        return trocas;
    }
}
