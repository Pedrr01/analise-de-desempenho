package Monitoria;

public class Engenheiro extends Pessoa{
    private String profissao;

    public Engenheiro(String nome, int idade, String profissao) {
        super(nome, idade);
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Cadastro: " + getNome() + " - " + getIdade() + "(" + getProfissao() + ")";
    }
}
