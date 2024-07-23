package game.graphics.layer;

import game.board.Board;
import game.graphics.ImageRepository;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@Setter
public class SpriteLayer extends Layer{

    //acessar diretamente ou criar uma interface depois para o board
    private Board board;

    private final ImageRepository imageRepository = new ImageRepository();

    private BufferedImage imgSprWarriorLb = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB);

    private Integer escala = 4;

    public SpriteLayer(Integer camada, Boolean show, Board board) {
       this.camada = camada;
       this.show = show;
       this.board = board;
    }

    @Override
    public void render(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer escala, Integer posXCam, Integer posYCam) {
        int x = 3;
        int y = 3;
        graphics2D.drawImage(this.imgSprWarriorLb,
                (janelaHeight/2) + (x * ((32/2) * escala) - (y * ((32 / 2) * escala)) + (7 * escala) + (posXCam)) ,
                (janelaWidth /2) + (y * ((17/2) * escala) + (x * ((17 / 2) * escala)) - (22 * escala) + (posYCam)) ,
                18 * escala,
                35 * escala,
                null);
    }
}
