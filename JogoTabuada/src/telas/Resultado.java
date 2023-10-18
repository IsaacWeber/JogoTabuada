package telas;

import telas.design.Cores;
import telas.design.EstiloLKF;
import telas.design.Fontes;

import javax.swing.*;
import java.awt.*;

public class Resultado extends JFrame {
    private JButton btnVoltar;
    private JPanel painelResultado;
    private JLabel lblImgAcerto;
    private JLabel lblAcerto;
    private JLabel lblImgErro;
    private JLabel lblErro;
    private JLabel lblTitulo;
    private JPanel painelBotoes;
    private JButton btnFechar;
    private JButton btnReiniciar;

    public Resultado() {
        super("Resultado | Jogo da Tabuada");
        EstiloLKF.mudaLookAndFeel("Nimbus");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Cores.COR_FUNDO);
        inserirTitulo();
        inserirBotaoVoltar();
        inserirPainelResultado();
        inserirPainelBotoes();
        setVisible(true);
    }

    private void inserirTitulo() {
        lblTitulo = new JLabel("Resultado");
        lblTitulo.setFont(Fontes.FONTE_TITULO);
        lblTitulo.setBounds(400, 10, getWidth(), 200);
        add(lblTitulo);
    }
    private void inserirBotaoVoltar() {
        btnVoltar = new JButton(pegarIcone("voltar.png"));
        btnVoltar.setBounds(10, 10, 70, 70);
        btnVoltar.setFocusable(false);
        add(btnVoltar);
    }

    private void inserirPainelResultado() {
        painelResultado = new JPanel(null);
        painelResultado.setBackground(Cores.COR_FUNDO);
        painelResultado.setBounds(200, 250, getWidth(), 150);

        lblImgAcerto = new JLabel(pegarIcone("acerto.png"));
        lblImgAcerto.setBounds(0, 0, 128, 128);
        painelResultado.add(lblImgAcerto);

        lblAcerto = new JLabel("00");
        lblAcerto.setFont(Fontes.FONTE_TITULO);
        lblAcerto.setBounds(140, 25, 300, 100);
        painelResultado.add(lblAcerto);

        lblImgErro = new JLabel(pegarIcone("erro.png"));
        lblImgErro.setBounds(450, 0, 128, 128);
        painelResultado.add(lblImgErro);

        lblErro = new JLabel("0");
        lblErro.setFont(Fontes.FONTE_TITULO);
        lblErro.setBounds(590, 25, 300, 100);
        painelResultado.add(lblErro);
        painelResultado.add(lblErro);

        add(painelResultado);
    }

    private void inserirPainelBotoes() {
        painelBotoes = new JPanel(null);
        painelBotoes.setBackground(Cores.COR_FUNDO);
        painelBotoes.setBounds(350, 430, getWidth(), 200);

        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setFont(Fontes.FONTE_GERAL);
        btnReiniciar.setBounds(0, 0, 180, 50);
        painelBotoes.add(btnReiniciar);

        btnFechar = new JButton("Fechar");
        btnFechar.setFont(Fontes.FONTE_GERAL);
        btnFechar.setBounds(230, 0, 180, 50);
        painelBotoes.add(btnFechar);

        add(painelBotoes);
    }

    private ImageIcon pegarIcone(String nome) {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("imgs/" + nome)));
    }

    public static void main(String[] args) {
        new Resultado();
    }
}
