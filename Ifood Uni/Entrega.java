public class Entrega {
    private String endereco;
    private Pedido pedido;
    private Entregador entregador;

    public Entrega(Pedido pedido, Entregador entregador){
        this.endereco = pedido.getEndereco();
        this.pedido = pedido;
        this.entregador = entregador;
    }

    public void realizarEntrega(){
        System.out.print("Entrega dos produtos: ");
        pedido.listarProdutosPedidos();
        System.out.print("No endereço: " + pedido.getEndereco() + ". Realizado pelo Entregador " + entregador.getNome() + " de "+ entregador.getVeiculo().getNome());
    }
}
