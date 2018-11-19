//------------------------------------------------------------
//Ivan Mateus de Lima Azevedo
//10525602
//------------------------------------------------------------

import java.util.ArrayList;

public class BancoPerguntas {
    private ArrayList<Pergunta> quiz;

    public BancoPerguntas(){
        quiz = new ArrayList<Pergunta>();
    }

    public void addPergunta(String pergunta, String respostaCorreta, String[] todasRespostas){
        Pergunta perg = new Pergunta(pergunta, respostaCorreta, todasRespostas);
        quiz.add(perg);
    }

    public ArrayList<Pergunta> getQuiz() {
        return quiz;
    }
}
