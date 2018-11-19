import java.util.ArrayList;

public class Aluno extends Pessoa {
    private String curso;
    private int periodo;
    private ArrayList<String> dps;
    private Date previsaoDeFormatura;

    public Aluno(String nome, String nusp, Date data, String curso, int periodo, ArrayList<String> dps, Date previsaoDeFormatura){
        super(nome, nusp, data);
        this.curso = curso;
        this.periodo = periodo;
        this.dps = dps;
        this.previsaoDeFormatura = previsaoDeFormatura;
    }

    public String getCurso() {
        return curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public ArrayList<String> getDps() {
        return dps;
    }

    public Date getPrevisaoDeFormatura() {
        return previsaoDeFormatura;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public void setDps(ArrayList<String> dps) {
        this.dps = dps;
    }

    public void setPrevisaoDeFormatura(Date previsaoDeFormatura) {
        this.previsaoDeFormatura = previsaoDeFormatura;
    }
}
