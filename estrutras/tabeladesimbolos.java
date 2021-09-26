
class tabeladesimbolos<Chave extends Comparable<Chave>, Valor> implements ITabela<Chave, Valor> {

    private Chave[] chaves;
    private Valor[] valores;

    private int M = 0; // qtd de chaves alocadas;

    public tabeladesimbolos(int n) {
        chaves = (Chave[]) new Comparable[n];
        valores = (Valor[]) new Object[n];
    }

    public void put(Chave c, Valor v) {

        int pos = rank(c);
        if (pos > 0 && chaves[pos].compareTo(c) == 0) {
            valores[pos] = v;
            return;
        }

        int i = M;
        while (i > 0 && c.compareTo(chaves[i]) < 0) {
            chaves[i + 1] = chaves[i];
            valores[i + 1] = valores[i];
            i--;
        }
        valores[i] = v;
        chaves[i] = c;
        M++;
    }

    @Override
    public Valor get(Chave c) {
        int pos = getPos(c);
        if (pos < 0)
            return null;
        else
            return valores[pos];
    }

    private int rank(Chave c) {

       int superior, inferior, mid;

       superior = chaves.length;
       inferior = 0;
       int pos = -1;
       while(inferior < superior) {
           mid = inferior + (inferior + superior) / 2;

           if (c.compareTo(chaves[mid]) > 0) {
               inferior = mid + 1;
           } else if (c.compareTo(chaves[mid]) < 0) {
               superior = mid - 1;
           } else {
                pos = mid;
                break;
           }
       }
       return pos;
    }

    @Override
    public void remove(Chave c) {
        int pos = getPos(c);
        if (pos < 0)
            return;

        int i = pos;
        while (i < M) {
            valores[i] = valores[i + 1];
            chaves[i] = chaves[i + 1];
        }
        M--;
    }
}
