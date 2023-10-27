package telas;

import logica.GeradorNumerico;
import telas.design.Cores;
import telas.design.EstiloLKF;
import telas.design.Fontes;
import telas.handlers.TelaHandler;
import telas.imgs.GerenciadorImagens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private int numeroEscolhido;
    private int numeroAleatorio;
    private long acertos;
    private long erros;
    private JButton btnFinalizar;
    private Resultado telaResultado;
    private GeradorNumerico geradorNumerico;
    private List<Integer> opcoesAleatorias;
    private boolean avaliandoOpcao;
    public Principal(Entrada telEnt, int n) {
        super("Principal | Jogo da Tabuada");
        EstiloLKF.mudaLookAndFeel("Nimbus");
        setIconImage(GerenciadorImagens.pegarImagem("tabuada.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Cores.COR_FUNDO);
        telaEntrada = telEnt;
        numeroEscolhido = n;
        geradorNumerico = new GeradorNumerico();
        numeroAleatorio = geradorNumerico.gerarNumeroSemRepeticao();
        opcoesAleatorias = geradorNumerico.gerarResultados(numeroEscolhido, numeroAleatorio, NUMERO_ALTERNATIVAS);
        inserirBotaoVoltar();
        inserirPainelCalculo(numeroEscolhido);
        inserirPainelAlternativas();
        inserirBotaoFinalizar();
        addWindowListener(new TelaHandler(this));
        setVisible(true);
    }

    private void inserirPainelCalculo(int numero) {
        painelCalculo = new JPanel(null);
        painelCalculo.setBackground(Cores.COR_FUNDO);
        painelCalculo.setBounds(300, 200, getWidth() , 200);

        lblNumeroEscolhido = new JLabel(numero < 10 ? " " + String.valueOf(numero) : String.valueOf(numero));
        lblNumeroEscolhido.setFont(Fontes.FONTE_GIGANTE);
        lblNumeroEscolhido.setBounds(0, 0, 200, 200);
        painelCalculo.add(lblNumeroEscolhido);

        lblX = new JLabel("x");
        lblX.setFont(Fontes.FONTE_GIGANTE);
        lblX.setBounds(220, 0, 100, 200);
        painelCalculo.add(lblX);

        lblNumeroAleatorio = new JLabel(String.valueOf(numeroAleatorio));
        lblNumeroAleatorio.setFont(Fontes.FONTE_GIGANTE);
        lblNumeroAleatorio.setBounds(340, 0, 200, 200);
        painelCalculo.add(lblNumeroAleatorio);
        lblImgAcertoErro = new JLabel();
        lblImgAcertoErro.setBounds(560, -30 , 256, 256);

        painelCalculo.add(lblImgAcertoErro);
        add(painelCalculo);
    }

    private void inserirPainelAlternativas() {
        painelAlternativas = new JPanel(null);
        painelAlternativas.setBackground(Cores.COR_FUNDO);
        painelAlternativas.setBounds(300, 410, getWidth(), 100);

        btnAlternativas = new JButton[NUMERO_ALTERNATIVAS];
        for(int i = 0; i < btnAlternativas.length; ++i) {
            btnAlternativas[i] = new JButton(Integer.toString(opcoesAleatorias.get(i)));
            btnAlternativas[i].setFont(Fontes.FONTE_GERAL);
            btnAlternativas[i].setBounds(5 + 100 * i, 0, 80, 50);
            btnAlternativas[i].addActionListener(new OpcoesListeneer());
            btnAlternativas[i].setFocusable(false);
            painelAlternativas.add(btnAlternativas[i]);
        }

        add(painelAlternativas);
    }

    private void inserirBotaoVoltar() {
        btnVoltar = new JButton(GerenciadorImagens.pegarIcone("voltar.png"));
        btnVoltar.setBounds(10, 10, 70, 70);
        btnVoltar.setFocusable(false);
        btnVoltar.addActionListener(e -> {
            setVisible(false);
            telaEntrada.setVisible(true);
        });
        add(btnVoltar);
    }

    public void atualizarNumerosAleatorios() {
        numeroAleatorio = geradorNumerico.gerarNumeroSemRepeticao();
        lblNumeroAleatorio.setText(String.valueOf(numeroAleatorio));
        opcoesAleatorias = geradorNumerico.gerarResultados(numeroEscolhido, numeroAleatorio, NUMERO_ALTERNATIVAS);
        for(int i = 0; i < btnAlternativas.length; ++i) btnAlternativas[i].setText(String.valueOf(opcoesAleatorias.get(i)));
    }

    private void inserirBotaoFinalizar() {
        btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setFont(Fontes.FONTE_GERAL);
        btnFinalizar.setBounds(430, 600, 200, 60);
        btnFinalizar.addActionListener(e -> {
            int opcao = JOptionPane.showOptionDialog(this,
                    "Tem certeza que deseja finalizar?",
                    "Finalizar?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Sim", "Não"},
                    "Não");

            if(opcao == JOptionPane.YES_OPTION && telaResultado == null) {
                telaResultado = new Resultado(telaEntrada, acertos, erros);
                dispose();
            }
        } );
        btnFinalizar.setFocusable(false);
        add(btnFinalizar);
    }

    public void setNumeroEscolhido(int numeroEscolhido) {
        this.numeroEscolhido = numeroEscolhido;
    }

    public void reiniciar(int numero) {
        numeroEscolhido = numero;
        lblNumeroEscolhido.setText(numeroEscolhido < 10 ? " " + String.valueOf(numeroEscolhido) : String.valueOf(numeroEscolhido));
        atualizarNumerosAleatorios();
        acertos = erros = 0;
    }

    private void pintaOpcoes() {
        for(int i = 0; i < btnAlternativas.length; ++i) btnAlternativas[i].setBackground(opcoesAleatorias.get(i) == numeroEscolhido * numeroAleatorio ? Color.GREEN: Color.RED);
    }

    private void limpaOpcoes() {
        for(int i = 0; i < btnAlternativas.length; ++i) btnAlternativas[i].setBackground(Cores.COR_FUNDO_BOTAO_OPCAO);
    }

    // Classes
    class OpcoesListeneer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!avaliandoOpcao) {
                avaliandoOpcao = true;
                if(numeroEscolhido * numeroAleatorio == Integer.parseInt(e.getActionCommand())) {
                    ++acertos;
                    lblImgAcertoErro.setIcon(GerenciadorImagens.pegarIcone("acerto.png"));
                } else {
                    ++erros;
                    lblImgAcertoErro.setIcon(GerenciadorImagens.pegarIcone("erro.png"));
                }

                pintaOpcoes();
                new Thread(new RemoveImgAcertoErroThread()).start(); // Remove imagem
                avaliandoOpcao = false;
            }
        }
    }

    class RemoveImgAcertoErroThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2 * 1000);
                lblImgAcertoErro.setIcon(null);
                limpaOpcoes();
                atualizarNumerosAleatorios();
            }catch (Exception e) {
                System.err.printf("\nERRO: %s\n\n", e.getMessage());
            }
        }
    }

}



