package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class OpLocais {

    // TO-DO: adaptar para entrada variável
    public static BufferedImage media(BufferedImage imagemEntrada, int tamVizinhanca) {
        int altura = imagemEntrada.getHeight();
        int largura = imagemEntrada.getWidth();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, imagemEntrada.getType());

        for (int h = 0; h < altura - 1; h++) { // significa altura-2, por conta do array ir do 0 até altura-1
            for (int w = 0; w < largura - 1; w++) {
                // se entrou no if, é pixel de borda

                // TO-DO: alterar para tamVizinhanca
                // quando 3x3, filtra a partir do -2,-2 ; quando 7x7, a partir do -3,-3 ; quando 9x9, a partir do -4,-4
                if (ePixelDeBorda(h, w, altura, largura)) {
                    int rgb = imagemEntrada.getRGB(w, h);
                    imagemSaida.setRGB(w, h, rgb);
                    continue;
                }
                // pixels que não são das bordas
                // percorrendo uma matriz (w-1, h-1) (w, h-1) (w+1, h-1)
                //                        (w-1, h)   (w, h)   (w+1, h)
                //                        (w-1, h+1) (w, h+1) (w+1, h+1)

                int[] vizinhanca = getVizinhanca(imagemEntrada, w, h);

                int media = Arrays.stream(vizinhanca).sum() / 9; // TO-DO: adaptar, tem que dividir por tamVizinhanca ao quadrado
                Color novaCor = new Color(media, media, media);
                imagemSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imagemSaida;
    }

    // TO-DO: alterar para tamanho variável
    public static BufferedImage mediana3x3(BufferedImage imagemEntrada) {
        int altura = imagemEntrada.getHeight();
        int largura = imagemEntrada.getWidth();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, imagemEntrada.getType());

        // editar o for conforme tamanho necessário (2 linhas deixarão de ser lidas no 5x5, 3 linhas no 7x7)
        for (int h = 0; h < altura - 1; h++) {
            for (int w = 0; w < largura - 1; w++) {
                if (ePixelDeBorda(h, w, altura, largura)) {
                    int rgb = imagemEntrada.getRGB(w, h);
                    imagemSaida.setRGB(w, h, rgb);
                    continue;
                }

                int[] vizinhanca = getVizinhanca(imagemEntrada, w, h);

                Arrays.sort(vizinhanca);
                int mediana = vizinhanca[4]; //posição da mediana do 5x5 é 12, do 7x7 é 24
                Color novaCor = new Color(mediana, mediana, mediana);
                imagemSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imagemSaida;
    }

    // quando for 5x5, verifica se h é 0 ou 1, se w é 0 ou 1, se h é altura -1 ou -2, se w é largura -1 ou -2
    // sqrt round ?
    private static boolean ePixelDeBorda(int h, int w, int altura, int largura) {
        return h == 0 || w == 0 || h == altura - 1 || w == largura - 1;
    }

    private static int[] getVizinhanca(BufferedImage imagemEntrada, int w, int h) {
        int[] vizinhanca = new int[9];
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int rgb = imagemEntrada.getRGB(w + j, h + i);
                Color cor = new Color(rgb);
                vizinhanca[count++] = cor.getRed();
            }
        }
        return vizinhanca;
    }

    public BufferedImage convolucao(BufferedImage imagemEntrada, int[] kernel) {
        int tamanhoVizinhanca = (int) Math.sqrt(kernel.length);
        int qtdElementosVizinhanca = tamanhoVizinhanca * tamanhoVizinhanca;
        int altura = imagemEntrada.getHeight();
        int largura = imagemEntrada.getWidth();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, imagemEntrada.getType());

        for (int h = 0; h < altura - 1; h++) {
            for (int w = 0; w < largura - 1; w++) {
                if (ePixelDeBorda(h, w, altura, largura)) {
                    int rgb = imagemEntrada.getRGB(w, h);
                    imagemSaida.setRGB(w, h, rgb);
                    continue;
                }

                int[] vizinhanca = getVizinhanca(imagemEntrada, w, h);

                int soma = 0;
                for (int i = 0; i < qtdElementosVizinhanca; i++) {
                    soma += vizinhanca[i] * kernel[i];
                }
                if (soma > 255) soma = 255;
                else if (soma < 0) soma = 0;
                Color novaCor = new Color(soma, soma, soma);
                imagemSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imagemSaida;
    }

    public BufferedImage convolucao(BufferedImage imagemEntrada, double[] kernel) {
        int tamanhoVizinhanca = (int) Math.sqrt(kernel.length);
        int qtdElementosVizinhanca = tamanhoVizinhanca * tamanhoVizinhanca;
        int altura = imagemEntrada.getHeight();
        int largura = imagemEntrada.getWidth();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, imagemEntrada.getType());

        for (int h = 0; h < altura - 1; h++) {
            for (int w = 0; w < largura - 1; w++) {
                if (ePixelDeBorda(h, w, altura, largura)) {
                    int rgb = imagemEntrada.getRGB(w, h);
                    imagemSaida.setRGB(w, h, rgb);
                    continue;
                }

                int[] vizinhanca = getVizinhanca(imagemEntrada, w, h);

                double soma = 0;
                for (int i = 0; i < qtdElementosVizinhanca; i++) {
                    soma += vizinhanca[i] * kernel[i];
                }
                if (soma > 255) soma = 255;
                else if (soma < 0) soma = 0;
                Color novaCor = new Color((int) soma, (int) soma, (int) soma);
                imagemSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imagemSaida;
    }

}
