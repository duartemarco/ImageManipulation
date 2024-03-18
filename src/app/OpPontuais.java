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

        for (int h = 0; h < altura; h++) { // percorrendo a matriz
            for (int w = 0; w < largura; w++) { // h e w são pixeis da imagem
                int rgb = img.getRGB(w, h); // para cada pixel, pegue o rgb
                Color cor = new Color(rgb); // e jogue para a classe color
                int blue = cor.getBlue();
                Color novaCor = new Color(0, 0, blue);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage negativo(BufferedImage img) {
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                int red = cor.getRed();
                int green = cor.getGreen();
                Color novaCor = new Color(255 - red, 255 - green, 255 - blue);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage cinzaRed(BufferedImage img) { //pega o valor do Red e joga para todos os campos
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                Color novaCor = new Color(red, red, red);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage cinzaGreen(BufferedImage img) { //pega o valor do Green e joga para todos os campos
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int green = cor.getGreen();
                Color novaCor = new Color(green, green, green);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage cinzaBlue(BufferedImage img) { //pega o valor do Blue e joga para todos os campos
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                Color novaCor = new Color(blue, blue, blue);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage cinzaMedia(BufferedImage img) {
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                int red = cor.getRed();
                int green = cor.getGreen();
                Color novaCor = new Color(red/3, green/3, blue/3);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }
}