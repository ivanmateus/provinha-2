//------------------------------------------------------------
//Ivan Mateus de Lima Azevedo
//10525602
//------------------------------------------------------------

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.awt.List.*;

public class AgendaGUI extends JFrame implements ActionListener {
    private Agenda agenda;
    private JButton add;
    private JButton del;
    private JButton edit;
    private JButton pesq;
    private JTextField campoPesq;
    private JPanel telaCentro;
    private JMenuItem capac;

    public AgendaGUI(){
        super("Agenda Telefônica");
        agenda = new Agenda();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu opcoes = new JMenu("Opções");
        menuBar.add(opcoes);
        capac = new JMenuItem("Alterar capacidade...");
        capac.addActionListener(this);
        opcoes.add(capac);

        BevelBorder cima = new BevelBorder(BevelBorder.RAISED);
        JPanel telaCima = new JPanel(new FlowLayout());
        telaCima.setBorder(cima);
        add = new JButton("Adicionar");
        del = new JButton("Deletar");
        edit = new JButton("Editar");
        pesq = new JButton("Pesquisar");
        campoPesq = new JTextField(20);
        telaCima.add(add);
        add.addActionListener(this);
        telaCima.add(del);
        del.addActionListener(this);
        telaCima.add(edit);
        edit.addActionListener(this);
        telaCima.add(new JLabel(" | "));
        telaCima.add(campoPesq);
        telaCima.add(pesq);
        pesq.addActionListener(this);

        TitledBorder centro = new TitledBorder("Contatos");
        telaCentro = new JPanel();
        telaCentro.setLayout(new BoxLayout(telaCentro, BoxLayout.Y_AXIS));
        JScrollPane rolagem = new JScrollPane(telaCentro, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        rolagem.setBorder(centro);

        setLayout(new BorderLayout());
        telaCima.setPreferredSize(new Dimension(400,80));
        add(BorderLayout.NORTH, telaCima);
        rolagem.setPreferredSize(new Dimension(400,200));
        add(BorderLayout.CENTER, rolagem);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            String nome = JOptionPane.showInputDialog(
                    this,
                    "Escreva o nome do contato a ser adicionado:",
                    "Nome do contato",
                    JOptionPane.WARNING_MESSAGE
            );
            String idade = JOptionPane.showInputDialog(this,
                    "Escreva a idade do contato a ser adicionado:",
                    "Idade do contato",
                    JOptionPane.WARNING_MESSAGE
            );
            String numero = JOptionPane.showInputDialog(this,
                    "Escreva o número do contato a ser adicionado:",
                    "Número do contato",
                    JOptionPane.WARNING_MESSAGE
            );
            boolean cheia = agenda.addContato(nome, idade, numero);
            if(!cheia){
                JOptionPane.showMessageDialog(this,
                        "Caso queira inserir mais contatos, " +
                                "altere a capacidade máxima na barra de menu.",
                        "Agenda cheia!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(e.getSource() == del){
            String nome = JOptionPane.showInputDialog(
                    this,
                    "Escreva o nome do contato a ser removido:",
                    "Nome do contato",
                    JOptionPane.WARNING_MESSAGE
            );
            agenda.removeContato(nome);
        }else if(e.getSource() == edit){
            String nome = JOptionPane.showInputDialog(
                    this,
                    "Escreva o nome do contato a ser editado:",
                    "Nome do contato",
                    JOptionPane.WARNING_MESSAGE
            );

            String novoNome = JOptionPane.showInputDialog(
                    this,
                    "Escreva o novo nome do contato:",
                    "Nome do contato",
                    JOptionPane.WARNING_MESSAGE
            );
            String novaIdade = JOptionPane.showInputDialog(
                    this,
                    "Escreva a nova idade do contato:",
                    "Idade do contato",
                    JOptionPane.WARNING_MESSAGE
            );
            String novoNumero = JOptionPane.showInputDialog(
                    this,
                    "Escreva o novo número do contato:",
                    "Número do contato",
                    JOptionPane.WARNING_MESSAGE
            );

            agenda.removeContato(nome);
            agenda.addContato(novoNome, novaIdade, novoNumero);
        }else if(e.getSource() == pesq){
            Contato achou = agenda.buscaContato(campoPesq.getText());
            if(achou != null){
                JOptionPane.showMessageDialog(this,
                        "Nome: " + achou.getNome() + "\n" +
                                "Idade: " + achou.getIdade() + "\n" +
                                "Número: " + achou.getNumero(),
                        "Contato encontrado!",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,
                        "O contato não está na " +
                                "agenda ou não foi digitado corretamente.",
                        "Contato não encontrado!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            campoPesq.setText("");
        }else if(e.getSource() == capac) {
            String novaCap = JOptionPane.showInputDialog(
                    this,
                    "Escreva a capacidade desejada:",
                    "Capacidade máxima de contatos",
                    JOptionPane.WARNING_MESSAGE
            );
            if (Integer.parseInt(novaCap) <= agenda.getNumContatos()){
                agenda.setCapacMax(Math.abs(Integer.parseInt(novaCap) - agenda.getNumContatos()));

                JOptionPane.showMessageDialog(this,
                        "O novo valor de capacidade é " + novaCap + ".",
                        "Capacidade alterada com sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,
                        "A capacidade é menor que o número de contatos atual." + novaCap,
                        "Erro!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        int i = 0;
        telaCentro.removeAll();
        while(i < agenda.getContatos().size()) {
            JPanel novoContato = new JPanel();
            novoContato.setLayout(new BoxLayout(novoContato, BoxLayout.Y_AXIS));
            novoContato.setBorder(new EmptyBorder(10,5,0,0));
            JLabel nomeLabel = new JLabel("Nome: " + agenda.getContatos().get(i).getNome());
            JLabel idadeLabel = new JLabel("Idade: " + agenda.getContatos().get(i).getIdade());
            JLabel numeroLabel = new JLabel("Número: " + agenda.getContatos().get(i).getNumero());

            novoContato.add(nomeLabel);
            novoContato.add(idadeLabel);
            novoContato.add(numeroLabel);
            telaCentro.add(novoContato);
            ++i;
        }
        telaCentro.repaint();
        pack();
    }
}
