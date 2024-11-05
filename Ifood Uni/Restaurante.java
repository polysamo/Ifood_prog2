import java.util.ArrayList;

public class Restaurante extends Estabelecimento {
    public Restaurante(String nome, ArrayList<Produto> Itens, double avalicao){
        super(nome, Itens, avalicao);
    }
    public void teste(){
        System.out.println("Teste");
    }

}
