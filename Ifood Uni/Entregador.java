public class Entregador {
    private String nome;
    private Veiculo veiculo;

    public Entregador(String nome, Veiculo veiculo){
        this.nome = nome;
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

