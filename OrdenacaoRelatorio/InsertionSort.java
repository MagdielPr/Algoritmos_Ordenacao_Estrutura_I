package OrdenacaoRelatorio;

public class InsertionSort implements SorteioAlgoritmo {
    private long comparacoes;
    private long trocas;

    @Override
    public void ordenar(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int chave = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > chave) {
                comparacoes++;
                trocas++;
                array[j + 1] = array[j];
                j = j - 1;
            }
            if (j >= 0) {
                comparacoes++; 
            }
            array[j + 1] = chave;
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
