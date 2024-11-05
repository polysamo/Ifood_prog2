public class Moto implements Veiculo {
    String nome;
    String modelo;

    public Moto(String nome, String modelo){
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