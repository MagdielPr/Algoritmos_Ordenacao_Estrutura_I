package OrdenacaoRelatorio;

public class CountingSort implements SorteioAlgoritmo {
    private long comparacoes;
    private long trocas;

    @Override
    public void ordenar(int[] array) {
        int max = encontrarMax(array);
        int[] contagem = new int[max + 1];

        for (int i = 0; i < array.length; i++) {
            comparacoes++; 
            contagem[array[i]]++;
        }

        int indice = 0;
        for (int i = 0; i <= max; i++) {
            while (contagem[i] > 0) {
                trocas++; 
                array[indice++] = i;
                contagem[i]--;
            }
        }
    }

    private int encontrarMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            comparacoes++;
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
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
