public class Funcionario extends Pessoa {
    private double salario;
    private int anos;

    public Funcionario(String nome, String nusp, Date data, double salario, int anos){
        super(nome, nusp, data);
        this.salario = salario;
        this.anos = anos;
    }

    public double getSalario() {
        return salario;
    }

    public int getAnos() {
        return anos;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public void ajusteSalarial(double ajuste){
        salario = salario*(1 + ajuste);
    }
}
