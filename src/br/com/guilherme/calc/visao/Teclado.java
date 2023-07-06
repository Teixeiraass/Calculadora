package br.com.guilherme.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Executable;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.guilherme.calc.modelo.Memoria;

public class Teclado extends JPanel implements ActionListener{

    private final Color COR_CINZA_ESCURO = new Color(68,68,68);
    private final Color COR_CINZA_CLARO = new Color(99, 99,99);
    private final Color LARANJA = new Color(242, 163, 60);

    public Teclado(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        setLayout(layout);

        c.weightx = 1; // faz com que ocupe totalmente a largura da tela
        c.weighty = 1; //faz com que ocupe totalmente a altura da tela
        c.fill = GridBagConstraints.BOTH; //Tira os espacamentos em braco que tinham

        //Linha 1
        c.gridwidth = 2; //faz com que a largura dos botoes seja 3, entao o ac tem largura 3
        adicionarBotao("AC", COR_CINZA_ESCURO, c, 0, 0);
        c.gridwidth = 1;    //volta a fazer as largura ser 1, entao todos os botoes voltam ao tamanho normal pra so o AC ter largura 3
        adicionarBotao("+/-", COR_CINZA_ESCURO, c, 2, 0);
        adicionarBotao("/", COR_CINZA_ESCURO, c, 3, 0);

        //Linha 2
        adicionarBotao("7", COR_CINZA_CLARO, c, 0, 1);
        adicionarBotao("8", COR_CINZA_CLARO, c, 1, 1);
        adicionarBotao("9", COR_CINZA_CLARO, c, 2, 1);
        adicionarBotao("*", LARANJA, c, 3, 1);

        //Linha3
        adicionarBotao("4", COR_CINZA_CLARO, c, 0, 2);
        adicionarBotao("5", COR_CINZA_CLARO, c, 1, 2);
        adicionarBotao("6", COR_CINZA_CLARO, c, 2, 2);
        adicionarBotao("-", LARANJA, c, 3, 2);

        //Linha4
        adicionarBotao("1", COR_CINZA_CLARO, c, 0, 3);
        adicionarBotao("2", COR_CINZA_CLARO, c, 1, 3);
        adicionarBotao("3", COR_CINZA_CLARO, c, 2, 3);
        adicionarBotao("+", LARANJA, c, 3, 3);

        //Linha5
        c.gridwidth = 2;  
        adicionarBotao("0", COR_CINZA_CLARO, c, 0, 4);
        c.gridwidth = 1;  
        adicionarBotao(",", COR_CINZA_CLARO, c, 2, 4);
        adicionarBotao("=", LARANJA, c, 3, 4);
    }

    public void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y){
        c.gridx = x;
        c.gridy = y;
        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);
        add(botao, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {    //Pega a ação de clicar no teclado
        if(e.getSource() instanceof JButton){ //e.getSource pega o valor do botao que foi clicado, mas ele retorna object, entao temos que fazer um cast para tranformar em botao
            JButton botao = (JButton) e.getSource();
            Memoria.getIntancia().processarComando(botao.getText());
        }
    }
}