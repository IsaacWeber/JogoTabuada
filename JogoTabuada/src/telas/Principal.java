package telas;

import telas.design.Cores;
import telas.design.EstiloLKF;
import telas.design.Fontes;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Principal extends JFrame {
    private JPanel painelCalculo;
    private JPanel painelAlternativas;
    private JButton[] btnAlternativas;
    private static final int NUMERO_ALTERNATIVAS = 5;
    private JLabel lblNumeroEscolhido;
    private JLabel lblX;
    private JLabel lblNumeroAleatorio;
    private JLabel lblImgAcertoErro;
    private JButton btnVoltar;

    public Principal() {
        super("Principal | Jogo da Tabuada");
        EstiloLKF.mudaLookAndFeel("Nimbus");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Cores.COR_FUNDO);
        inserirBotaoVoltar();
        inserirPainelCalculo("2");
        inserirPainelAlternativas();
        setVisible(true);
    }

    private void inserirPainelCalculo(String numero) {
        painelCalculo = new JPanel(null);
        painelCalculo.setBackground(Cores.COR_FUNDO);
        painelCalculo.setBounds(300, 200, getWidth(), 200);

        lblNumeroEscolhido = new JLabel(numero);
        lblNumeroEscolhido.setFont(Fontes.FONTE_GIGANTE);
        lblNumeroEscolhido.setBounds(0, 0, 200, 200);
        painelCalculo.add(lblNumeroEscolhido);

        lblX = new JLabel("x");
        lblX.setFont(Fontes.FONTE_GIGANTE);
        lblX.setBounds(215, 0, 200, 200);
        painelCalculo.add(lblX);

        lblNumeroAleatorio = new JLabel("?");
        lblNumeroAleatorio.setFont(Fontes.FONTE_GIGANTE);
        lblNumeroAleatorio.setBounds(415, 0, 200, 200);
        painelCalculo.add(lblNumeroAleatorio);
        lblImgAcertoErro = new JLabel();
        lblImgAcertoErro.setIcon(pegarIcone("acerto.png"));
        lblImgAcertoErro.setBounds(615, -30 , 256, 256);

        painelCalculo.add(lblImgAcertoErro);
        add(painelCalculo);
    }

    private void inserirPainelAlternativas() {
        painelAlternativas = new JPanel(null);
        painelAlternativas.setBackground(Cores.COR_FUNDO);
        painelAlternativas.setBounds(300, 410, getWidth(), 100);

        btnAlternativas = new JButton[NUMERO_ALTERNATIVAS];
        for(int i = 0; i < btnAlternativas.length; ++i) {
            btnAlternativas[i] = new JButton(Integer.toString(i));
            btnAlternativas[i].setFont(Fontes.FONTE_GERAL);
            btnAlternativas[i].setBounds(5 + 100 * i, 0, 80, 50);
            painelAlternativas.add(btnAlternativas[i]);
        }

        add(painelAlternativas);
    }

    private void inserirBotaoVoltar() {
        btnVoltar = new JButton(pegarIcone("voltar.png"));
        btnVoltar.setBounds(10, 10, 70, 70);
        btnVoltar.setFocusable(false);
        add(btnVoltar);
    }

    private ImageIcon pegarIcone(String nome) {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("imgs/" + nome)));
    }
    public static void main(String[] args) {
        new Principal();
    }
}
