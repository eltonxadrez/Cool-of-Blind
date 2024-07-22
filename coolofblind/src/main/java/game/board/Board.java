package game.board;



import game.graphics.Concreto;
import game.graphics.ImageRepository;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Board implements Concreto {

    private final ImageRepository imageRepository = new ImageRepository();

    private BufferedImage imgIsoGrass01 = this.imageRepository.getImageRepo(ImageRepository.IMG_ISO_GRASS_01);
    private BufferedImage imgRectGrass01 = this.imageRepository.getImageRepo(ImageRepository.IMG_RECT_GRASS_01);
    private BufferedImage imgRectGreen01 = this.imageRepository.getImageRepo(ImageRepository.IMG_RECT_GREEN_01);

    //teste
    public char[][] boardTest;

    public Board() {
        this.boardTest = new char[6][6];
        this.fillBoard();
        this.desenharBoard();
    }

    //teste
    public void fillBoard(){
        for (int y = 0; y < boardTest.length; y++){
            for (int x = 0; x < boardTest.length; x++){
                this.boardTest[y][x] = 'o';
            }
        }
    }

    //teste
    public void desenharBoard(){
        this.boardTest[0][0] = 'c';
        this.boardTest[1][0] = 'c';
        this.boardTest[2][0] = 'c';
        this.boardTest[2][1] = 'c';
        this.boardTest[2][2] = 'c';
        this.boardTest[1][2] = 'c';
        this.boardTest[0][1] = 'c';
        this.boardTest[0][2] = 'c';
    }

    //teste
    @Override
    public void render(Graphics2D graphics2D, int janelaWidth, int janelaHeight) {

        AffineTransform trans = new AffineTransform();

        trans.translate(((double) janelaWidth/2) ,((double)janelaHeight/2));

        int scale = 4;
//        double scale = ((double) janelaWidth / 250);
        trans.scale(scale,scale);


//        graphics2D.setTransform(trans);
        graphics2D.drawImage(this.imgRectGrass01, trans, null);

//        graphics2D.setColor(new Color(75, 75, 75));
//        graphics2D.fillRect(janelaWidth/2,janelaHeight/2,32,32);


        for (int y = 0; y < boardTest.length; y++){
            for (int x = 0; x < boardTest.length; x++){
                if(boardTest[y][x] == 'c'){
//                    AffineTransform trans = AffineTransform.getShearInstance(2d,2d);
//                    graphics2D.setTransform(trans);

//                    graphics2D.setColor(new Color(50, 50, 50));
//                    graphics2D.fillRect(
//                            (janelaWidth/2) + (x*33),
//                            (janelaHeight/2) + (y*33),
//                            32,
//                            32);

//                    graphics2D.drawImage(this.imgIsoGrass01,
//                            (int)((janelaWidth * 50)/100)  + (x * 32),
//                            (int)((janelaHeight * 50)/100)  + (y * 32),
//                            null);
                }
            }
        }
    }
}
