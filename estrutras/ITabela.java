public interface ITabela<Chave, Valor> {
    void put(Chave c, Valor v);

    Valor get(Chave c);

    void remove(Chave c);
    int rank(Chave c);
}
