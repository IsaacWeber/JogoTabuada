package telas;

import main.Exe;
import telas.design.Cores;
import telas.design.EstiloLKF;
import telas.design.Fontes;
import telas.handlers.TelaHandler;
import telas.imgs.GerenciadorImagens;

import javax.swing.*;

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
    private Entrada telaEntrada;

    public Resultado(Entrada telaEntrada, long acertos, long erros) {
        super("Resultado | Jogo da Tabuada");
        EstiloLKF.mudaLookAndFeel("Nimbus");
        setIconImage(GerenciadorImagens.pegarImagem("tabuada.png"));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Cores.COR_FUNDO);
        this.telaEntrada = telaEntrada;
        inserirTitulo();
        //inserirBotaoVoltar();
        inserirPainelResultado(acertos, erros);
        inserirPainelBotoes();
        addWindowListener(new TelaHandler(this));
        setVisible(true);
    }

    private void inserirTitulo() {
        lblTitulo = new JLabel("Resultado");
        lblTitulo.setFont(Fontes.FONTE_TITULO);
        lblTitulo.setBounds(400, 10, getWidth(), 200);
        add(lblTitulo);
    }
    private void inserirBotaoVoltar() {
        btnVoltar = new JButton(GerenciadorImagens.pegarIcone("voltar.png"));
        btnVoltar.setBounds(10, 10, 70, 70);
        btnVoltar.setFocusable(false);
        add(btnVoltar);
    }

    private void inserirPainelResultado(long acertos, long erros) {
        painelResultado = new JPanel(null);
        painelResultado.setBackground(Cores.COR_FUNDO);
        painelResultado.setBounds(200, 250, getWidth(), 150);

        lblImgAcerto = new JLabel(GerenciadorImagens.pegarIcone("acerto.png"));
        lblImgAcerto.setBounds(0, 0, 128, 128);
        painelResultado.add(lblImgAcerto);

        lblAcerto = new JLabel(String.valueOf(acertos));
        lblAcerto.setFont(Fontes.FONTE_TITULO);
        lblAcerto.setBounds(140, 25, 300, 100);
        painelResultado.add(lblAcerto);

        lblImgErro = new JLabel(GerenciadorImagens.pegarIcone("erro.png"));
        lblImgErro.setBounds(450, 0, 128, 128);
        painelResultado.add(lblImgErro);

        lblErro = new JLabel(String.valueOf(erros));
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
        btnReiniciar.addActionListener(e -> {
            if(telaEntrada != null) {
                dispose();
                telaEntrada = null;
                new Exe().main(null); // Reinicia
            }
        });

        painelBotoes.add(btnReiniciar);

        btnFechar = new JButton("Fechar");
        btnFechar.setFont(Fontes.FONTE_GERAL);
        btnFechar.setBounds(230, 0, 180, 50);
        btnFechar.addActionListener(e -> {
            //System.exit(0);

            JOptionPane.showMessageDialog(null,
                    "Obrigado por jogar!",
                    "Obrigado!",
                    JOptionPane.PLAIN_MESSAGE,
                    GerenciadorImagens.pegarIcone("tabuada.png"));
            System.exit(0);
        });
        painelBotoes.add(btnFechar);

        add(painelBotoes);
    }

}
