public class Professor extends Funcionario {
    private String titulo;
    private String departamento;
    private String sala;
    private String especialidade;

    public Professor(String nome, String nusp, Date data, double salario, int anos, String titulo, String departamento, String sala, String especialidade){
        super(nome, nusp, data, salario, anos);
        this.titulo = titulo;
        this.departamento = departamento;
        this.sala = sala;
        this.especialidade = especialidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getSala() {
        return sala;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
