import java.util.ArrayList;

public class Universidade implements GerenciadorDePessoas {
    private ArrayList<Pessoa> pessoas;

    public Universidade(){
        pessoas = new ArrayList<Pessoa>();
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public void removePessoa(Pessoa pessoa){
        pessoas.remove(pessoa);
    }

    public Pessoa procuraPessoa(String id){
        Aluno aluno = null;
        for(Pessoa aux : pessoas){
            if(aux.getNusp().equals(id)){
                aluno = (Aluno) aux;
            }
        }
        return aluno;
    }

    @Override
    public void ordenarDataIngresso() {
        int i = 0;
        int j = 0;
        Pessoa auxA = null;
        Pessoa auxB = null;
        while(j < pessoas.size() - 1) {
            i = j + 1;
            auxA = pessoas.get(j);
            while (i < pessoas.size()) {
                auxB = pessoas.get(i);
                if (auxA.getDataIngresso().getAno() > auxB.getDataIngresso().getAno()) {
                    auxA = auxB;
                }else if (auxA.getDataIngresso().getMes() > auxB.getDataIngresso().getMes()){
                    auxA = auxB;
                }else if (auxA.getDataIngresso().getDia() > auxB.getDataIngresso().getDia()){
                    auxA = auxB;
                }
                ++i;
            }
            Pessoa tempA = auxA;
            int indexA = pessoas.indexOf(auxA);
            Pessoa tempB = pessoas.get(j);
            pessoas.set(indexA, tempB);
            pessoas.set(j, tempA);
            ++j;
        }
    }

    @Override
    public void areasSemelhantes() {
        ArrayList<String> departamentos = new ArrayList<String>();

        for(Pessoa prof : pessoas){
            if(prof.getClass().getName().equals("Professor")) {
                if(departamentos.isEmpty() || !(departamentos.contains(prof.getDepartamento()))){
                    departamentos.add(prof.getDepartamento());
                }
            }
        }

        for(String dpto : departamentos){
            System.out.println(dpto + ":");
            System.out.print("    ");
            for(Pessoa prof : pessoas){
                if(prof.getDepartamento() != null) {
                    if (prof.getDepartamento().equals(dpto)) {
                        System.out.println(prof.getNome());
                    }
                }
            }
        }
    }

    @Override
    public int quantosEstaoEmFerias() {
        int i = 0;
        for(Pessoa aux : pessoas){
            if(aux.getClass().getName().equals("Geral")) {
                if (aux.isFerias()) {
                    ++i;
                }
            }
        }
        return i;
    }

    @Override
    public ArrayList<Pessoa> quemEstaEmFerias(){
        ArrayList<Pessoa> pessoasDeFerias = new ArrayList<Pessoa>();
        for(Pessoa aux : pessoas){
            if(aux.getClass().getName().equals("Geral")) {
                if (aux.isFerias()) {
                    pessoasDeFerias.add(aux);
                }
            }
        }
        return pessoasDeFerias;
    }


    @Override
    public ArrayList<Pessoa> jubilados(){
        ArrayList<Pessoa> pessoasJubiladas = new ArrayList<Pessoa>();
        for(Pessoa aluno : pessoas){
            if(aluno.getClass().getName().equals("Aluno")) {
                if (aluno.getPrevisaoDeFormatura().getAno() - aluno.getDataIngresso().getAno() >= 7) {
                    pessoasJubiladas.add(aluno);
                } else if (aluno.getDps().size() > 3 * (aluno.getPrevisaoDeFormatura().getAno() - aluno.getDataIngresso().getAno())) {
                    pessoasJubiladas.add(aluno);
                }
            }
        }
        return pessoasJubiladas;
    }

    @Override
    public boolean periodoIdeal(String id) {
        Aluno aluno = null;
        for(Pessoa aux : pessoas){
            if(aux.getClass().getName().equals("Aluno")) {
                if (aux.getNusp().equals(id)) {
                    aluno = (Aluno) aux;
                }
            }
        }
        if(aluno != null){
            if(aluno.getDps().size() > (aluno.getPrevisaoDeFormatura().getAno() - aluno.getDataIngresso().getAno())/2){
                return false;
            }
        }
        return true;
    }
}
