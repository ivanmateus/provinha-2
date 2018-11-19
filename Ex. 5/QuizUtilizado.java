//------------------------------------------------------------
//Ivan Mateus de Lima Azevedo
//10525602
//------------------------------------------------------------

public class QuizUtilizado {
    private BancoPerguntas banco;

    public QuizUtilizado(){
        banco = new BancoPerguntas();
        String pergunta = "Qual o nome verdadeiro de Darth Vader?";
        String respCorreta = "Anakin Skywalker";
        String[] todasResp = {"Anakin Skywalker", "Obi Wan Kenobi", "Luke Skywalker", "Han Solo"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome da ilha lendária para onde o Rei Arthur supostamente foi quando morreu?";
        respCorreta = "Avalon";
        todasResp = new String[]{"Camelot","Avalon","Lancelot","Guinevere"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome da amada de Beren (O Silmarillion)?";
        respCorreta = "Lúthien";
        todasResp = new String[]{"Galadriel","Idril","Elwing","Lúthien"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome do diretor do filme 'Logan'?";
        respCorreta = "James Mangold";
        todasResp = new String[]{"James Mangold", "Peter Jackson", "James Cameron", "Christopher Nolan"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome do autor de 'The Call of Cthulhu'?";
        respCorreta = "H. P. Lovecraft";
        todasResp = new String[]{"J. R. R. Tolkien", "Stephen King", "H. P. Lovecraft", "George R. R. Martin"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o verdadeiro nome do Batman?";
        respCorreta = "Bruce Wayne";
        todasResp = new String[]{"Bruce Banner","Bruce Dickinson","Bruce Bogtrotter", "Bruce Wayne"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome da diretora do colégio do filme 'Matilda'?";
        respCorreta = "Sra. Trunchbull";
        todasResp = new String[]{"Sra. McGonagall", "Sra. Trunchbull", "Sra. Fatlady", "Sra. Blake"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome do personagem interpretado por Harrison Ford em 'Blade Runner'?";
        respCorreta = "Rick Deckard";
        todasResp = new String[]{"Roy Batty","Rick Deckard","Leon Kowalski","Hannibal Crew"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o primeiro nome do dr. Brown de 'De Volta Para o Futuro'?";
        respCorreta = "Emmett";
        todasResp = new String[]{"Harry","George","Emmett","Charles"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "No filme 'Akira', em que lugar os restos mortais do personagem homônimo foram guardados?";
        respCorreta = "Abaixo do estádio olímpico";
        todasResp = new String[]{"Abaixo do estádio olímpico", "Em um bunker secreto em Osaka", "Abaixo do monte Fuji", "Em um esconderijo submarino"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome da personagem principal do clássico cyberpunk 'Ghost In The Shell'?";
        respCorreta = "Kusanagi Motoko";
        todasResp = new String[]{"Batou","Kusanagi Motoko","Aramaki Daiasuke", "Togusa"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome do autor da trilogia 'Crônicas de Arthur'?";
        respCorreta = "Bernard Cornwell";
        todasResp = new String[]{"Timothy Zahn","George R. R. Martin","Bernard Cornwell", "J. R. R. Tolkien"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual o nome do personagem interpretado por Steve Carrell na versão americana da série 'The Office'?";
        respCorreta = "Michael Scott";
        todasResp = new String[]{"Jim Halpert","Dwight Schrute","Kevin Malone", "Michael Scott"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual a resposta para a vida, o universo e tudo mais?";
        respCorreta = "42";
        todasResp = new String[]{"Não existe","42","O amor", "8"};
        banco.addPergunta(pergunta, respCorreta, todasResp);

        pergunta = "Qual a metáfora utilizada por Roy Batty em 'Blade Runner' para os momentos que se perderiam quando ele morresse?";
        respCorreta = "Lágrimas na chuva";
        todasResp = new String[]{"Agulha no palheiro","Uma gota no oceano","Lágrimas na chuva", "Um grão de areia no deserto"};
        banco.addPergunta(pergunta, respCorreta, todasResp);
    }

    public BancoPerguntas getBanco() {
        return banco;
    }
}
