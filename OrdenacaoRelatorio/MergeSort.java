package OrdenacaoRelatorio;

public class MergeSort implements SorteioAlgoritmo {
    private long comparacoes;
    private long trocas;

    @Override
    public void ordenar(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);
            merge(array, esquerda, meio, direita);
        }
    }

    private void merge(int[] array, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array[esquerda + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[meio + 1 + j];
        }

        int i = 0, j = 0, k = esquerda;
        while (i < n1 && j < n2) {
            comparacoes++;
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                trocas++;
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
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
