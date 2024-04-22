package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class OpLocais {

    public static BufferedImage media3x3(BufferedImage imagemEntrada) {
        int altura = imagemEntrada.getHeight();
        int largura = imagemEntrada.getWidth();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, imagemEntrada.getType());

        for (int h = 0; h < altura - 1; h++) { // significa altura-2, por conta do array ir do 0 até altura-1
            for (int w = 0; w < largura - 1; w++) {
                // se entrou no if, é pixel de borda
                if (h == 0 || w == 0 || h == altura - 1 || w == largura - 1) {
                    int rgb = imagemEntrada.getRGB(w, h);
                    imagemSaida.setRGB(w, h, rgb);
                    continue;
                }
                // pixels que não são das bordas

                // percorrendo uma matriz (w-1, h-1) (w, h-1) (w+1, h-1)
                //                        (w-1, h)   (w, h)   (w+1, h)
                //                        (w-1, h+1) (w, h+1) (w+1, h+1)

                int[] vizinhanca = new int[9];
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int rgb = imagemEntrada.getRGB(w + j, h + i);
                        Color cor = new Color(rgb);
                        vizinhanca[count++] = cor.getRed();
                    }
                }

                int media = Arrays.stream(vizinhanca).sum() / 9;
                Color novaCor = new Color(media, media, media);
                imagemSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imagemSaida;
    }

    public static BufferedImage mediana3x3(BufferedImage imagemEntrada) {
        return imagemSaida;
    }
}
