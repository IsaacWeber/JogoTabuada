package telas.imgs;

import javax.swing.*;
import java.awt.*;

public class GerenciadorImagens {

    public static ImageIcon pegarIcone(String nome) {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(GerenciadorImagens.class.getResource(nome)));
    }

    public static Image pegarImagem(String nome) {
        return pegarIcone(nome).getImage();
    }
}
