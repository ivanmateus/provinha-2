//------------------------------------------------------------
//Ivan Mateus de Lima Azevedo
//10525602
//------------------------------------------------------------
public class Contato implements Comparable<Contato>{
    private String nome;
    private String idade;
    private String numero;

    public Contato(String nome, String idade, String numero){
        this.nome = nome;
        this.idade = idade;
        this.numero = numero;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(String idade){
        this.idade = idade;
    }

    public void setNum(String numero){
        this.numero = numero;
    }

    public String getNome(){
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public String getNumero(){
        return numero;
    }

    public int compareTo(Contato o){
        return nome.compareTo(o.nome);
    }
}
