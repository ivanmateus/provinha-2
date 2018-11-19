import java.util.ArrayList;
import java.util.Random;

public class ControleQuestoes {
    private ArrayList<Pergunta> perguntas;

    public ControleQuestoes(){
        perguntas = new ArrayList<Pergunta>();
    }

    public void selecionaQuestoes(QuizUtilizado quiz){
        Random gerador = new Random();
        ArrayList<Integer> adicionados = new ArrayList<Integer>();
        int randomNum;

        for(int i = 0; i < 5; ++i){
            randomNum = gerador.nextInt(quiz.getBanco().getQuiz().size());
            while (adicionados.contains(randomNum)){
                randomNum = gerador.nextInt(quiz.getBanco().getQuiz().size());
            }
            adicionados.add(randomNum);
            perguntas.add(quiz.getBanco().getQuiz().get(randomNum));
        }
    }

    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }
}
