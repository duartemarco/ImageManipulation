package app;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OpPontuais {

    public static BufferedImage bandaRed(BufferedImage img) {
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                Color cor = new Color(img.getRGB(w, h));
                Color novaCor = new Color(cor.getRed(), 0, 0);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage bandaGreen(BufferedImage img) {
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int green = cor.getGreen();
                Color novaCor = new Color(0, green, 0);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage bandaBlue(BufferedImage img) {
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                Color novaCor = new Color(0, 0, blue);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }
}