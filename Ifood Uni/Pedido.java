import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private Cliente cliente;
    private Estabelecimento estabelecimento;
    private ArrayList<Produto> Produtos_pedidos;
    private Pagamento pagamento;
    private String observacoes;
    private String endereco;

    public Pedido(Cliente cliente, ArrayList<Produto> produtos_pedidos, Pagamento pagamento, String observacoes, String endereco){
        this.cliente = cliente;
        this.Produtos_pedidos = produtos_pedidos;
        this.pagamento = pagamento;
        this.observacoes = observacoes;
        this.endereco = endereco;
    }

    public void AdicionarAdicionais(){
        Scanner scan = new Scanner(System.in);
        for(Produto produto : Produtos_pedidos){
            System.out.println("Produto "+produto.getNome()+":");
            String adicional = scan.nextLine();
            produto.setAdicionais(adicional);
        }
    }

    public void listarProdutosPedidos() {
        for(int i = 0; i < Produtos_pedidos.size() ; i++){
            System.out.print(Produtos_pedidos.get(i).getNome());
            if (i < Produtos_pedidos.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.print(".");
        System.out.println();
    }

    public ArrayList<Produto> getProdutos_pedidos() {
        return Produtos_pedidos;
    }

    public void setProdutos_pedidos(ArrayList<Produto> produtos_pedidos) {
        Produtos_pedidos = produtos_pedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estabelecimento getOrigem() {
        return estabelecimento;
    }

    public void setOrigem(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
