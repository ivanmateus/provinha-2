import java.util.ArrayList;

public interface GerenciadorDePessoas {
    public void ordenarDataIngresso();
    public void areasSemelhantes();
    public int quantosEstaoEmFerias();
    public ArrayList<Pessoa> quemEstaEmFerias();
    public ArrayList<Pessoa> jubilados();
    public boolean periodoIdeal(String id);
}
