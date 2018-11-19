//------------------------------------------------------------
//Ivan Mateus de Lima Azevedo
//10525602
//------------------------------------------------------------

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class QuizGUI extends JFrame implements ActionListener {
    private QuizUtilizado quizGUI;
    private ControleQuestoes unidControle;
    private ArrayList<Pergunta> perguntas;
    private JButton botaoInicia;
    private JPanel tela;
    private Pergunta qualPerg;
    private ButtonGroup bGroup;
    private JLabel labelPerg;
    private JRadioButton resp1;
    private JRadioButton resp2;
    private JRadioButton resp3;
    private JRadioButton resp4;
    private JButton next;
    private int qualQuest;
    private int questoesCorretas;

    public QuizGUI(){
        super("Quiz");
        quizGUI = new QuizUtilizado();
        unidControle = new ControleQuestoes();
        unidControle.selecionaQuestoes(quizGUI);
        perguntas = unidControle.getPerguntas();

        tela = new JPanel(new GridBagLayout());
        JLabel nome = new JLabel("Quiz de cultura popular");
        nome.setFont(new Font("", Font.BOLD, 25));
        botaoInicia = new JButton("Iniciar quiz");
        botaoInicia.setPreferredSize(new Dimension(200,100));
        botaoInicia.addActionListener(this);
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints bagConst = new GridBagConstraints();
        tela.setLayout(gridBag);
        bagConst.fill = GridBagConstraints.CENTER;
        bagConst.weightx = 1.0;

        bagConst.ipady = 40;
        bagConst.gridx = 0;
        bagConst.gridy = 0;
        tela.add(nome, bagConst);
        bagConst.gridx = 0;
        bagConst.gridy = 1;
        tela.add(botaoInicia, bagConst);

        tela.setPreferredSize(new Dimension(500, 400));
        add(tela);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botaoInicia){
            qualQuest = 0;
            questoesCorretas = 0;
            proxQuestao();
        }else if(e.getSource() == next){
            if (perguntaSelec().equals(qualPerg.getRespostaCorreta())) {
                ++questoesCorretas;
            }
            if(qualQuest < 4) {
                ++qualQuest;
                proxQuestao();
            }else {
                finalizaQuiz();
            }
        }
    }

    public void finalizaQuiz(){
        tela.removeAll();
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints bagConst = new GridBagConstraints();
        tela.setLayout(gridBag);
        bagConst.fill = GridBagConstraints.HORIZONTAL;
        bagConst.weightx = 1.0;

        JPanel panelResul = new JPanel(new FlowLayout());
        JLabel voceAcertou = new JLabel("Você acertou ");
        JLabel exclam = new JLabel("!");
        JLabel numCorretas = new JLabel(questoesCorretas + " questões");
        JLabel comentario = new JLabel();
        voceAcertou.setFont(new Font("", Font.PLAIN, 25));
        exclam.setFont(new Font("", Font.PLAIN, 25));
        numCorretas.setFont(new Font("", Font.BOLD, 25));
        comentario.setFont(new Font("", Font.PLAIN, 25));
        comentario.setHorizontalAlignment(SwingConstants.CENTER);

        panelResul.add(voceAcertou);
        panelResul.add(numCorretas);
        panelResul.add(exclam);

        if(questoesCorretas <= 2){
            numCorretas.setForeground(Color.red);
            comentario.setText("Mais sorte da próxima vez...");
        }else if(questoesCorretas == 3){
            numCorretas.setForeground(Color.yellow);
            comentario.setText("Quase lá!");
        }else if(questoesCorretas >= 4){
            numCorretas.setForeground(Color.green);
            comentario.setText("Parabéns!");
        }

        bagConst.gridx = 0;
        bagConst.gridy = 0;
        gridBag.setConstraints(panelResul, bagConst);
        tela.add(panelResul);

        bagConst.gridx = 0;
        bagConst.gridy = 1;
        gridBag.setConstraints(comentario, bagConst);
        tela.add(comentario);

        tela.repaint();
        pack();
    }

    public String perguntaSelec(){
        String selecionada = null;
        Enumeration<AbstractButton> botoes = bGroup.getElements();
        while(botoes.hasMoreElements()){
            JRadioButton temp = (JRadioButton) botoes.nextElement();
            if(temp.isSelected()){
                selecionada = temp.getText();
                return selecionada;
            }
        }
        return null;
    }

    public void proxQuestao(){
        tela.removeAll();
        tela.setPreferredSize(new Dimension(1100, 400));
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints bagConst = new GridBagConstraints();
        tela.setLayout(gridBag);
        bagConst.fill = GridBagConstraints.HORIZONTAL;
        bagConst.weightx = 1.0;

        qualPerg = unidControle.getPerguntas().get(qualQuest);
        labelPerg = new JLabel((qualQuest + 1) + ") " + qualPerg.getPergunta());

        resp1 = new JRadioButton(qualPerg.getTodasRespostas()[0], true);
        resp2 = new JRadioButton(qualPerg.getTodasRespostas()[1], false);
        resp3 = new JRadioButton(qualPerg.getTodasRespostas()[2], false);
        resp4 = new JRadioButton(qualPerg.getTodasRespostas()[3], false);
        bGroup = new ButtonGroup();
        bGroup.add(resp1);
        bGroup.add(resp2);
        bGroup.add(resp3);
        bGroup.add(resp4);
        if(qualQuest < 4){
            next = new JButton("Próxima questão");
        }
        if(qualQuest == 4){
            next = new JButton("Finalizar quiz");
        }
        next.addActionListener(this);

        bagConst.gridx = 0;
        bagConst.gridy = 0;
        gridBag.setConstraints(labelPerg,bagConst);
        tela.add(labelPerg);

        bagConst.gridx = 0;
        bagConst.gridy = 1;
        gridBag.setConstraints(resp1,bagConst);
        tela.add(resp1);

        bagConst.gridx = 0;
        bagConst.gridy = 2;
        gridBag.setConstraints(resp2,bagConst);
        tela.add(resp2);

        bagConst.gridx = 0;
        bagConst.gridy = 3;
        gridBag.setConstraints(resp3,bagConst);
        tela.add(resp3);

        bagConst.gridx = 0;
        bagConst.gridy = 4;
        gridBag.setConstraints(resp4,bagConst);
        tela.add(resp4);

        bagConst.gridx = 1;
        bagConst.gridy = 5;
        gridBag.setConstraints(next,bagConst);
        tela.add(next);

        tela.repaint();
        pack();
    }
}
