package telas.handlers;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaHandler extends WindowAdapter {
    private JFrame tela;
    public TelaHandler(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int opcao = JOptionPane.showOptionDialog(tela,
                "Deseja realmente sair do jogo?",
                "Sair?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Sim", "Não"},
                "Não");

        if(opcao == JOptionPane.YES_OPTION) System.exit(0);

    }
}
