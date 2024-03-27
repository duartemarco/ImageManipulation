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
                if (banda.equalsIgnoreCase("red")) {
                    red = tratarLimitesRGB(red, aumento);
                } else if (banda.equalsIgnoreCase("green")){
                    green = tratarLimitesRGB(green, aumento);
                } else if (banda.equalsIgnoreCase("blue")) {
                    blue = tratarLimitesRGB(blue, aumento);
                }
                Color novaCor = new Color(red/3, green/3, blue/3);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage brilhoAditivoRGB(BufferedImage img, float aumento) {
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
                red = tratarLimitesRGB(red, aumento);
                green = tratarLimitesRGB(green, aumento);
                blue = tratarLimitesRGB(blue, aumento);
                Color novaCor = new Color(red, green, blue);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage brilhoAditivoBandaY(BufferedImage img, float aumento) {
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

                //criando banda YIQ
                //cria y
                float y = (float) ((0.299 * red) + (0.587 * green) + (0.114 * blue));
                //cria i
                float i = (float) ((0.596 * red) - (0.274 * green) - (0.322 * blue));
                //cria q
                float q = (float) ((0.211 * red) - (0.523 * green) + (0.312 * blue));

                y += aumento;

                //cria novas cores a partir de YIQ
                int novoRed = (int) ((1*y) + (0.956 * i) + (0.621 * q));
                int novoGreen = (int) ((1*y) - (0.272 * i) - (0.647 * q));
                int novoBlue = (int) ((1*y) - (1.106 * i) + (1.703 * q));

                novoRed = somenteTrataLimite(novoRed);
                novoGreen = somenteTrataLimite(novoGreen);
                novoBlue = somenteTrataLimite(novoBlue);

                Color novaCor = new Color(novoRed, novoGreen, novoBlue);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage brilhoMultiplicativoBandaY(BufferedImage img, float aumento) {
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

                float y = (float) ((0.299 * red) + (0.587 * green) + (0.114 * blue));
                float i = (float) ((0.596 * red) - (0.274 * green) - (0.322 * blue));
                float q = (float) ((0.211 * red) - (0.523 * green) + (0.312 * blue));

                y *= aumento;

                int novoRed = (int) ((1*y) + (0.956 * i) + (0.621 * q));
                int novoGreen = (int) ((1*y) - (0.272 * i) - (0.647 * q));
                int novoBlue = (int) ((1*y) - (1.106 * i) + (1.703 * q));

                novoRed = somenteTrataLimite(novoRed);
                novoGreen = somenteTrataLimite(novoGreen);
                novoBlue = somenteTrataLimite(novoBlue);

                Color novaCor = new Color(novoRed, novoGreen, novoBlue);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    private static int somenteTrataLimite(int valor) {
        if (valor > 255) valor = 255;
        else if (valor < 0) valor = 0;
        return valor;
    }

    private static int tratarLimitesRGB(int valor, int acrescimo) {
        valor += acrescimo;
        if (valor > 255) valor = 255;
        else if (valor < 0) valor = 0;
        return valor;
    }

    private static int tratarLimitesRGB(int valor, float acrescimo) {
        valor += acrescimo;
        if (valor > 255) valor = 255;
        else if (valor < 0) valor = 0;
        return valor;
    }
}
