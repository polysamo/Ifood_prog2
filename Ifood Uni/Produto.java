public class Produto {
    private String nome;
    private double preco;
    private String adicionais;
    private double avaliacao;

    public Produto(String nome, double preco, double avaliacao){
        this.nome = nome;
        this.preco = preco;
        this.avaliacao = avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getAdicionais(){return adicionais;}

    public void setAdicionais(String adicionais){
        this.adicionais = adicionais;
    }
}
