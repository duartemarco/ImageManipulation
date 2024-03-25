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

    public static BufferedImage binarização(BufferedImage img, int limiar) {
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);
                int valor = ( (cor.getRed() + cor.getBlue() + cor.getGreen()) / 3);
                if (valor > limiar) {
                    valor = 255;
                } else {
                    valor = 0;
                }
                Color novaCor = new Color(valor, valor, valor);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage aumentoTonalidade(BufferedImage img, String banda, int aumento) {
        //calistenia ==> early return
        if (!banda.equalsIgnoreCase("red")
            && !banda.equalsIgnoreCase("blue")
            && !banda.equalsIgnoreCase("green")) {
            throw new IllegalArgumentException("Banda inválida");
        }

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

                // banda red
                if (banda.equalsIgnoreCase("red") && (red + aumento < 255) && (red + aumento > 0)) {
                    red += aumento;
                } else if (red + aumento > 255 && red + aumento > 0){
                    red = 255;
                } else if (red + aumento < 0) {
                    red = 0;
                }

                //banda green
                if (banda.equalsIgnoreCase("green") && (green + aumento < 255) && (green + aumento > 0)) {
                    green += aumento;
                } else if (green + aumento > 255 && green + aumento > 0){
                    green = 255;
                } else if (green + aumento < 0) {
                    green = 0;
                }

                //banda blue
                if (banda.equalsIgnoreCase ("blue") && (blue + aumento < 255) && (blue + aumento > 0)) {
                    blue += aumento;
                } else if (blue + aumento > 255 && blue + aumento > 0){
                    blue = 255;
                } else if (blue + aumento < 0) {
                    blue = 0;
                }

                Color novaCor = new Color(red/3, green/3, blue/3);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }
}