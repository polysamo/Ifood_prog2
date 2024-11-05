import java.util.ArrayList;

public abstract class Estabelecimento {
    private String nome;
    private ArrayList<Produto> Produtos;
    private double avaliacao;

    public Estabelecimento(String nome, ArrayList<Produto> produtos, double avaliacao) {
        this.nome = nome;
        this.Produtos = produtos;
        this.avaliacao = avaliacao;
    }

    public void listarItens() {
        System.out.println("Produtos do estabelecimento "+ getNome()+":");
        for(int i = 0; i < getProdutos().size() ; i++){
            System.out.print(Produtos.get(i).getNome());
            if (i < getProdutos().size() - 1){
                System.out.print(", ");
            }
        }
        System.out.print(".");
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    public void setItens(ArrayList<Produto> produtos) {
        Produtos = produtos;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
