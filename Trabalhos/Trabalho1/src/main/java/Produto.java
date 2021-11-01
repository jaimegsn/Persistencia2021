public class Produto {
    private String nome;
    private int preco;
    private int qtd;
    private float peso;

    public Produto(String nome, int preco, int qtd, float peso){
        this.nome =  nome;
        this.preco = preco;
        this.qtd = qtd;
        this.peso = peso;
    }


    @Override
    public String toString() {
        return nome + ";" + preco + ";" + qtd + ";" + peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }
    public float getPeso() {
        return peso;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
