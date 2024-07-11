package OrdenacaoRelatorio;

interface SorteioAlgoritmo {
    void ordenar(int[] array);
    void resetarContadores();
    long getComparacoes();
    long getTrocas();
}
