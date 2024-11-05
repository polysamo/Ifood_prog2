public class Cartao implements Pagamento{

    private String tipo;

    public void realizarPagamento(){
        System.out.println("Pagamento via cartão realizado");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
