package br.com.guilherme.calc.visao;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Calculadora extends JFrame{
    public Calculadora(){

        organizarLayout();

        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Igual o dispose_on_close
        setVisible(true);
        setSize(300, 350);
        setLocationRelativeTo(null);    //Centraliza na tela
    }

    private void organizarLayout() {
        setLayout(new BorderLayout());  //Seta o layout em norte sul lest oeste e centro

        Display display = new Display();
        display.setPreferredSize(new Dimension(233, 60)); //seta o tamanho de preferencia, quando usa esse metodo e obrigatorio usar o dimension para dar tamanho para o display
        add(display,BorderLayout.NORTH);    //Aqui estou setando o display que vai mostrar o resultado para ficar no norte
        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER); //O teclado ficara no centro
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}