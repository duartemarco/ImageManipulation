package app;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        BufferedImage imagem = ManipulaImagem.abrirImagem("lena.jpg");

        ManipulaImagem.exibirImagens(
                imagem,
                OpPontuais.bandaRed(imagem),
                OpPontuais.bandaGreen(imagem),
                OpPontuais.bandaBlue(imagem));

        ManipulaImagem.salvarImagem(imagem);
    }

}