package telas;


import telas.design.Cores;
import telas.design.Fontes;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Entrada extends JFrame {
    private JLabel tituloLbl;
    private JPanel painelNumero;
    private JLabel lblDesc;
    private JSpinner spnNumero;
    private SpinnerNumberModel spnNumeroModel;
    private JButton btnIniciar;

    public Entrada() {
        super("Entrada | Jogo da Tabuada");
        mudaLookAndFeel("Nimbus");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Cores.COR_FUNDO);
        inserirTituloLbl();
        inserirPainelNumero();
        inserirBotaoIniciar();
        setVisible(true);
    }

    private void inserirTituloLbl() {
        tituloLbl = new JLabel("Jogo da Tabuada");
        tituloLbl.setFont(Fontes.FONTE_TITULO);
        tituloLbl.setBounds(getWidth()/2, 0, getWidth(), 80);
        add(tituloLbl);
    }

    private void inserirPainelNumero() {
        painelNumero = new JPanel(null);
        painelNumero.setBackground(Cores.COR_FUNDO);
        painelNumero.setBounds(getWidth()/2 + 50, getHeight()/2 - 80, getWidth(), 100);

        lblDesc = new JLabel("Escolha um número: ");
        lblDesc.setFont(Fontes.FONTE_GERAL);
        lblDesc.setBounds(0, 0, 310, 50);
        painelNumero.add(lblDesc);

        spnNumeroModel = new SpinnerNumberModel(2, 1, 10, 1);
        spnNumero = new JSpinner(spnNumeroModel);
        spnNumero.setFont(Fontes.FONTE_GERAL);
        spnNumero.setBounds(320, 0, 70, 50);
        spnNumero.setEditor(new JSpinner.DefaultEditor(spnNumero)); // Faz com que fique nao editavel
        painelNumero.add(spnNumero);

        add(painelNumero);
    }

    private void inserirBotaoIniciar() {
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setFont(Fontes.FONTE_GERAL);
        btnIniciar.setBounds(getWidth()/2 + 150, getHeight() - 100, 150, 50);
        add(btnIniciar);
    }

    private void mudaLookAndFeel(String lkfName) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (lkfName.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e) {
            System.err.println("\nLook and Feel error: \n\t" + e.getMessage());
        }

    }

    public static void main(String[] args) {
        new Entrada();

    }
}
