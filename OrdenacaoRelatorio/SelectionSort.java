package OrdenacaoRelatorio;

public class SelectionSort implements SorteioAlgoritmo {
    private long comparacoes;
    private long trocas;

    @Override
    public void ordenar(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                trocas++;
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
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
