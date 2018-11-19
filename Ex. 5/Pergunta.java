//------------------------------------------------------------
//Ivan Mateus de Lima Azevedo
//10525602
//------------------------------------------------------------

import java.util.ArrayList;

public class Pergunta {
    private String pergunta;
    private String respostaCorreta;
    private String[] todasRespostas;

    public Pergunta(String pergunta, String resposta, String[] todasRespostas){
        this.pergunta = pergunta;
        this.respostaCorreta = resposta;
        this.todasRespostas = todasRespostas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public String[] getTodasRespostas() {
        return todasRespostas;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public void setTodasRespostas(String[] todasRespostas) {
        this.todasRespostas = todasRespostas;
    }
}
