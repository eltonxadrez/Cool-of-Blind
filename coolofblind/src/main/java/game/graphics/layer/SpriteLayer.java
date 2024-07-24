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

    private BufferedImage imgSprWarriorLb01 = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_01);

    private BufferedImage[] spriteSheetCaminhada;

    private BufferedImage spritePlayerAtual;

    public SpriteLayer(Integer camada, Boolean show, Board board) {
        this.absPosX = 3;
        this.absPosY = 3;
        this.camada = camada;
        this.show = show;
        this.board = board;
        this.spriteSheetCaminhada = new BufferedImage[3];
        this.carregarCaminhada();
        this.spriteIdle();
    }
    private int quadroCaminhada = 0;

    public void carregarCaminhada(){
        this.spriteSheetCaminhada[0] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_02);
        this.spriteSheetCaminhada[1] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_01);
        this.spriteSheetCaminhada[2] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_03);
    }
    //teste

    public void spriteAndarYPstart(){
        if(!spriteAndandoYP){
            this.spriteAndandoYP = true;
        }
    }
    Integer cicloAnimacao = 0;
    public void spriteAndarYP(){

        //testes caminhada
        if(cicloAnimacao >= 33){
            this.valorDeMovX = 0;
            this.valorDeMovX2= 0;
            this.absPosY++;
            this.cicloAnimacao = 0;
            this.spriteAndandoYP = false;
            //60
        }
        else if(cicloAnimacao >= 32){
            this.quadroCaminhada = 1;
            this.valorDeMovX = 16;
            this.valorDeMovX2= 8;
            this.cicloAnimacao++; //60
        }
        else if(cicloAnimacao >= 24){
            this.quadroCaminhada = 0;
            this.valorDeMovX = 12;
            this.valorDeMovX2= 6;
            this.cicloAnimacao++; //48
        }
        else if(cicloAnimacao >= 16){
            this.quadroCaminhada = 1;
            this.valorDeMovX = 8;
            this.valorDeMovX2= 4;
            this.cicloAnimacao++; //36
        }
        else if(cicloAnimacao >= 8){
            this.quadroCaminhada = 2;
            this.valorDeMovX = 4;
            this.valorDeMovX2= 2;
            this.cicloAnimacao++; //24
        }
        else if(cicloAnimacao >= 0){
            this.quadroCaminhada = 1;
            this.valorDeMovX = 0;
            this.valorDeMovX2= 0;
            this.cicloAnimacao++; //12
        }

        this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
    }

    public void spriteIdle(){
        this.spritePlayerAtual = this.spriteSheetCaminhada[1];
    }

    Integer valorDeMovX = 0;
    Integer valorDeMovX2 = 0;
    Integer valorDeMovY = 0;
    Integer valorDeMovY2 = 0;
    Boolean spriteAndandoYP = false;
    @Override
    public void render(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) {

        if(spriteAndandoYP){
            this.spriteAndarYP();
        }

        //ticks
        graphics2D.drawImage(this.spritePlayerAtual,

                (janelaHeight/2) + ((this.absPosX * ((32/2) * escala) - (valorDeMovX * escala)) - (this.absPosY * ((32 / 2) * escala) + (valorDeMovY)) + (7 * escala) + (posXCam)) ,
                (janelaWidth /2) + ((this.absPosY * ((17/2) * escala) - (valorDeMovY)) + (this.absPosX * ((17 / 2) * escala) + (valorDeMovX2 * escala)) - (22 * escala) + (posYCam)) ,
//                (janelaHeight/2) + (this.absPosX * ((32/2) * escala) - (this.absPosY * ((32 / 2) * escala)) + (7 * escala) + (posXCam)) ,
//                (janelaWidth /2) + (this.absPosY * ((17/2) * escala) + (this.absPosX * ((17 / 2) * escala)) - (22 * escala) + (posYCam)) ,
                18 * escala,
                35 * escala,
                null);


//        graphics2D.drawImage(this.imgSprWarriorLb01,
//                (janelaHeight/2) + (this.absPosX * ((32/2) * escala) - (this.absPosY * ((32 / 2) * escala)) + (7 * escala) + (posXCam)) ,
//                (janelaWidth /2) + (this.absPosY * ((17/2) * escala) + (this.absPosX * ((17 / 2) * escala)) - (22 * escala) + (posYCam)) ,
//                18 * escala,
//                35 * escala,
//                null);
    }
}
