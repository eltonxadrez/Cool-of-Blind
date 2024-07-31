package game.graphics.layer;

import game.board.Board;
import game.graphics.ImageRepository;
import game.graphics.Renderizador;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@Setter
public class BoardLayer extends Layer{

    //acessar diretamente ou criar uma interface depois para o board
    private Board board;

    //CRIAR UM SINGLETON DESSA CLASSE
    private final ImageRepository imageRepository = new ImageRepository();

    private BufferedImage imgIsoGrass01 = this.imageRepository.getImageRepo(ImageRepository.IMG_ISO_GRASS_01);
    private BufferedImage imgIsoGrass02 = this.imageRepository.getImageRepo(ImageRepository.IMG_ISO_GRASS_02);
    private BufferedImage imgIsoGrass03 = this.imageRepository.getImageRepo(ImageRepository.IMG_ISO_GRASS_03);

    private BufferedImage imgRectGrass01 = this.imageRepository.getImageRepo(ImageRepository.IMG_RECT_GRASS_01);
    private BufferedImage imgRectGreen01 = this.imageRepository.getImageRepo(ImageRepository.IMG_RECT_GREEN_01);

//    private Integer escala = 4;

//    AffineTransform trans = new AffineTransform();

    public BoardLayer(Integer camada, Boolean show, Board board) {
        this.camada = camada;
        this.show = true;
        this.board = board;
    }

    @Override
    public void render(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) {


        for (int x = 0; x < this.board.getBoardTest().length; x++){
            for (int y = 0; y < this.board.getBoardTest().length; y++){
//                if(this.board.getBoardTest()[x][y] == 'c'){

                    graphics2D.drawImage(this.imgIsoGrass03,
                            (janelaHeight/2) + (x * ((32/2) * escala) - (y * ((32 / 2) * escala)) + (posXCam)) ,
                            (janelaWidth /2) + (y * ((17/2) * escala) + (x * ((17 / 2) * escala)) + (posYCam)) ,
                            32 * escala,
                            17 * escala,
                            null);


//                }
            }
        }


    }
}
