package telas;


import telas.design.Cores;
import telas.design.EstiloLKF;
import telas.design.Fontes;

import javax.swing.*;

public class Entrada extends JFrame {
    private JLabel tituloLbl;
    private JPanel painelNumero;
    private JLabel lblDesc;
    private JSpinner spnNumero;
    private SpinnerNumberModel spnNumeroModel;
    private JButton btnIniciar;
    private Principal telaPrincipal;

    public Entrada() {
        super("Entrada | Jogo da Tabuada");
        EstiloLKF.mudaLookAndFeel("Nimbus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        spnNumeroModel = new SpinnerNumberModel(5, 1, 10, 1);
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
        btnIniciar.addActionListener(e -> {
            setVisible(false);
            if(telaPrincipal == null) {
                telaPrincipal = new Principal(this, (int)spnNumeroModel.getNumber());
            } else {
                telaPrincipal.reiniciar((int)spnNumeroModel.getNumber());
                telaPrincipal.setVisible(true);
            }
        });
        add(btnIniciar);
    }

    public static void main(String[] args) {
        new Entrada();

    }
}
