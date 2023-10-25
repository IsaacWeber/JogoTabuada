package telas;

import logica.GeradorNumerico;
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
    private Entrada telaEntrada;
    private int numero;
    private int acertos;
    private int erros;
    private JButton btnFinalizar;
    private Resultado telaResultado;
    private GeradorNumerico geradorNumerico;

    public Principal(Entrada telEnt, int n) {
        super("Principal | Jogo da Tabuada");
        EstiloLKF.mudaLookAndFeel("Nimbus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Cores.COR_FUNDO);
        telaEntrada = telEnt;
        numero = n;
        inserirBotaoVoltar();
        inserirPainelCalculo(String.valueOf(numero));
        inserirPainelAlternativas();
        inserirBotaoFinalizar();
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
        btnVoltar.addActionListener(e -> {
            setVisible(false);
            telaEntrada.setVisible(true);
        });
        add(btnVoltar);
    }

    private void inserirBotaoFinalizar() {
        btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setFont(Fontes.FONTE_GERAL);
        btnFinalizar.setBounds(430, 600, 200, 60);
        btnFinalizar.addActionListener(e -> { if(telaResultado == null) telaResultado = new Resultado(acertos, erros); } );
        add(btnFinalizar);
    }
    private ImageIcon pegarIcone(String nome) {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("imgs/" + nome)));
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void atualizarNumero() {
        lblNumeroEscolhido.setText(String.valueOf(numero));
    }
}
