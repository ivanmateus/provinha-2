public class Geral extends Funcionario {
    private String funcao;
    private boolean ferias;

    public Geral(String nome, String nusp, Date data, double salario, int anos, String funcao, boolean ferias){
        super(nome, nusp, data, salario, anos);
        this.funcao = funcao;
        this.ferias = ferias;
    }

    public String getFuncao() {
        return funcao;
    }

    public boolean isFerias() {
        return ferias;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setFerias(boolean ferias) {
        this.ferias = ferias;
    }
}
