package br.com.guilherme.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.guilherme.calc.modelo.Memoria;
import br.com.guilherme.calc.modelo.MemoriaObservador;

public class Display extends JPanel implements MemoriaObservador{

    private final JLabel label; //JLabel e como se fosse um rotulo, entao tudo que for algo escrito aparece como label

    public Display(){
        Memoria.getIntancia().adicionarObservador(this);

        setBackground(new Color(46, 49 ,50));
        label = new JLabel(Memoria.getIntancia().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30)); //primeiro parametro e o nome da fonte, segundo parametro é o estilo da fonte, e 3 é o tamanho da fonte
        
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));    //usa o primeiro parametro do layout para alinha o texto na direita, o segudo e o terceiro vc define o tamanho vertical e horizontal nessa ordem

        add(label);
    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);   //Sempre que esse metodo for chamado ele ira setar um novo texto
    }
}

