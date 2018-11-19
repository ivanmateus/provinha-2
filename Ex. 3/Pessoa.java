import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String nusp;
    private Date dataIngresso;

    public Pessoa(String nome, String nusp, Date data){
        this.nome = nome;
        this.nusp = nusp;
        this.dataIngresso = data;
    }

    public ArrayList<String> getDps() {
        return null;
    }

    public Date getPrevisaoDeFormatura() {
        return null;
    }

    public String getDepartamento() {
        return null;
    }

    public String getEspecialidade() {
        return null;
    }

    public boolean isFerias() {
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getNusp() {
        return nusp;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNusp(String nusp) {
        this.nusp = nusp;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
}
