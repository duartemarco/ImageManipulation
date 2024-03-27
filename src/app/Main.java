package app;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        BufferedImage imagem = ManipulaImagem.abrirImagem("lena.jpg");

        ManipulaImagem.exibirImagens(
                imagem,
                //OpPontuais.bandaRed(imagem),
                //.bandaGreen(imagem),
                //OpPontuais.bandaBlue(imagem),
                //OpPontuais.negativo(imagem),
                //OpPontuais.cinzaRed(imagem),
                //OpPontuais.cinzaBlue(imagem),
                //OpPontuais.cinzaGreen(imagem),
                //OpPontuais.cinzaMedia(imagem),
                //OpPontuais.binarização(imagem, 80),
                //OpPontuais.aumentoTonalidade(imagem, "red", 50),
                //OpPontuais.aumentoTonalidade(imagem, "blue", 50),
                OpPontuais.aumentoTonalidade(imagem, "green", 50),
                OpPontuais.brilhoAdd(imagem,90),
                OpPontuais.brilhoAddYIQ(imagem, 50)
        );

        ManipulaImagem.salvarImagem(imagem, "jpg", "lena_resultado.jpg");
    }

    //Considerando os seguintes pixels:
    /*

    Negativo = 255 - bandaPixel

    0,0,0 (preto) -> 255,255,255 (branco)
    255,255,255 (branco) -> 0,0,0 (preto)
    100,100,100 -> 155,155,155
    50,100,150 -> 205,155,105

    Ou seja, para pegar o negativo de um valor X, pega-se 255 e subtrai dele X
    Se o valor de X é 100, seu inverso é 155
     */

}