public class Bicicleta implements Veiculo{
    private String nome;
    private String modelo;

    public Bicicleta(String nome, String modelo){
        this.nome = nome;
        this.modelo = modelo;
    }


    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}
