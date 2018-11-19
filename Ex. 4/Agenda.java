//------------------------------------------------------------
//Ivan Mateus de Lima Azevedo
//10525602
//------------------------------------------------------------
import java.util.ArrayList;

public class Agenda {
    private int capacMax;
    private int numContatos;
    private ArrayList<Contato> contatos;

    public Agenda(){
        capacMax = 10;
        numContatos = 0;
        contatos = new ArrayList<Contato>();
    }

    public boolean addContato(String nome, String idade, String numero){
        if(capacMax != 0){
            int i = 0;
            boolean achou = false;
            while((i < contatos.size()) && !achou){
                if(contatos.get(i).getNumero().equals(numero)){
                    System.out.println("Numero já adicionado no contato abaixo:");
                    System.out.println("Nome: " + contatos.get(i).getNome());
                    System.out.println("Idade: " + contatos.get(i).getIdade());
                    System.out.println("Numero: " + contatos.get(i).getNumero());
                    achou = true;
                }
                ++i;
            }
            if(!achou) {
                Contato novoCont = new Contato(nome, idade, numero);
                contatos.add(novoCont);
                --capacMax;
                ++numContatos;
                System.out.println("Contato adicionado!");
                return true;
            }
        }else {
            System.out.println("Agenda cheia!");
        }
        return false;
    }

    public void removeContato(String nome){
        int i = 0;
        boolean achou = false;
        while((i < contatos.size()) && !achou){
            if(contatos.get(i).getNome().equals(nome)){
                contatos.remove(i);
                achou = true;
                ++capacMax;
                --numContatos;
                System.out.println("Contato removido!");
            }
            ++i;
        }
        if(!achou){
            System.out.println("Contato nao encontrado!");
        }
    }

    public Contato buscaContato(String nome){
        int i = 0;
        boolean achou = false;
        while((i < contatos.size()) && !achou){
            if(contatos.get(i).getNome().equals(nome)){
                return contatos.get(i);
            }
            ++i;
        }
        return null;
    }

    public void imprimeTodos(){
        int i = 0;
        while(i < contatos.size()){
            System.out.println("Nome: " + contatos.get(i).getNome());
            System.out.println("Idade: " + contatos.get(i).getIdade());
            System.out.println("Numero: " + contatos.get(i).getNumero());
            ++i;
        }
    }

    public void imprimeContato(String nome){
        int i = 0;
        boolean achou = false;
        while((i < contatos.size()) && !achou){
            if(contatos.get(i).getNome().equals(nome)){
                System.out.println("Nome: " + contatos.get(i).getNome());
                System.out.println("Idade: " + contatos.get(i).getIdade());
                System.out.println("Numero: " + contatos.get(i).getNumero());
                achou = true;
            }
            ++i;
        }
        if(!achou){
            System.out.println("Contato nao encontrado!");
        }
    }

    public int getNumContatos() {
        return numContatos;
    }

    public void setNumContatos(int numContatos) {
        this.numContatos = numContatos;
    }

    public void setCapacMax(int capacMax){
        this.capacMax = capacMax;
    }

    public int getCapacMax(){
        return capacMax;
    }

    public ArrayList<Contato> getContatos(){
        return contatos;
    }
}
