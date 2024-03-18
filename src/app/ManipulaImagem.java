package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ManipulaImagem {

    public static void salvarImagem(BufferedImage imagem, String formato, String path) {
        try {
            ImageIO.write(imagem, formato, new File(path));
        } catch (IOException e) {
            System.out.println("Erro ao salvar a imagem");
            throw new RuntimeException(e);
        }
    }

    public static void exibirImagens(BufferedImage... imagens) {
        JFrame janela = new JFrame(); //cria a janela
        janela.setTitle("Processamento de Imagens");
        janela.getContentPane().setLayout(new FlowLayout()); //layout lado a lado
        for (BufferedImage img : imagens) { //for-each
            JLabel label = new JLabel(new ImageIcon(img));
            janela.getContentPane().add(label);
        }
        janela.pack(); //empacota
        janela.setVisible(true); //torna visivel
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static BufferedImage abrirImagem(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Erro ao ler a imagem");
            throw new RuntimeException(e);
        }
    }
}