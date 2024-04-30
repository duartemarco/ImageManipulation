package app;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        BufferedImage imagem = ManipulaImagem.abrirImagem("menino.png");
        double[] kernelGaussiano = {0.0625, 0.125, 0.0625, 0.125, 0.25, 0.125, 0.0625, 0.125, 0.0625};
        int[] linhasHorizontais = {-1, -2, -1, 0, 0, 0, 1, 2, 1};
        int[] linhasVerticais = {-1, 0, 1, -2, 0, 0, 0, 1, 2, 1};
        int[] linhasOeste = {1, 1, -1, 1, -2, -1, 1, 1, -1};
        int[] laplaciano = {0, -1, 0, -1, 4, };


        ManipulaImagem.exibirImagens(imagem,
                //OpLocais.media3x3(imagem),
                OpLocais.mediana3x3(imagem));

        ManipulaImagem.salvarImagem(imagem, "jpg", "menino.png");
    }

}
