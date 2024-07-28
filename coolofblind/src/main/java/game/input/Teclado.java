package game.input;

import game.config.Game;
import game.graphics.Renderizador;
import game.graphics.janela.Janela;
import game.graphics.layer.SpriteLayer;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Getter
@Setter
public class Teclado implements KeyListener {

    private Game game;
    private Janela janela;
    private Renderizador renderizador;
    private SpriteLayer spriteLayer;

    private Boolean tecladoLivre;
    private Boolean keyPressed = false;

    private Boolean keyPressedUp = false;
    private Boolean keyPressedDown = false;
    private Boolean keyPressedLeft = false;
    private Boolean keyPressedRight = false;


    public Teclado(Game game, Janela janela, Renderizador renderizador) {
        this.game = game;
        this.janela = janela;
        this.renderizador = renderizador;
        this.spriteLayer = this.renderizador.getSpriteLayer();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("keyTyped");

        //DEBUG
        if(e.getKeyCode() == KeyEvent.VK_L) {
            System.out.println("TICK TECLADO!!!");
        }

        //PROGRAM EXIT
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("fechando programa");
            System.exit(0);
        }

        //JANELA FULLSCREEN
        if(e.getKeyCode() == KeyEvent.VK_F11) {
            this.renderizador.pausarRender();
            this.renderizador.renderizar = false;
            System.out.println("fullscreen");
            this.janela.turnFullscreen();
            this.renderizador.renderizar = true;
            this.renderizador.pausarRender();
        }

        //CAMADAS
        if(e.getKeyCode() == KeyEvent.VK_1) {
            System.out.println("camada 1");
            this.renderizador.switchShowCamada(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_2) {
            System.out.println("camada 2");
            this.renderizador.switchShowCamada(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_3) {
            System.out.println("camada 3");
            this.renderizador.switchShowCamada(3);
        }
        if(e.getKeyCode() == KeyEvent.VK_4) {
            System.out.println("camada 4");
            this.renderizador.switchShowCamada(4);
        }
        if(e.getKeyCode() == KeyEvent.VK_5) {
            System.out.println("camada 5");
            this.renderizador.switchShowCamada(5);
        }

        //ESCALA / ZOOM
        if(e.getKeyCode() == KeyEvent.VK_M) {
            System.out.println("aumentar escala");
            this.renderizador.aumentarEscala();
        }
        if(e.getKeyCode() == KeyEvent.VK_N) {
            System.out.println("diminuir escala");
            this.renderizador.diminuirEscala();
        }

        //CAMERA
        if(e.getKeyCode() == KeyEvent.VK_0) {
           this.renderizador.switchCameraMode();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(!this.keyPressedUp){
                this.keyPressedUp = true;
                this.renderizador.moveCamYM();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(!this.keyPressedDown){
                this.keyPressedDown = true;
                this.renderizador.moveCamYP();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(!this.keyPressedLeft){
                this.keyPressedLeft = true;
                this.renderizador.moveCamXM();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(!this.keyPressedRight){
                this.keyPressedRight = true;
                this.renderizador.moveCamXP();
            }
        }

        //SPRITE TESTE DEBUG
        if(e.getKeyCode() == KeyEvent.VK_W) {
            this.spriteLayer.getMainSprite().absPosY --;

        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            this.spriteLayer.getMainSprite().absPosX --;

        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
        	this.spriteLayer.getMainSprite().spriteAndarYPstart();
//        	this.spriteLayer.getMainSprite().spriteCorrerYPstart();
//            this.spriteLayer.spriteAndarYPstart();
//            this.spriteLayer.absPosY ++;


        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            this.spriteLayer.getMainSprite().absPosX ++;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(this.keyPressedUp){
                this.renderizador.moveCamYM();
                this.keyPressedUp = false;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(this.keyPressedDown){
                this.keyPressedDown = false;
                this.renderizador.moveCamYP();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(this.keyPressedLeft){
                this.keyPressedLeft = false;
                this.renderizador.moveCamXM();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(this.keyPressedRight){
                this.keyPressedRight = false;
                this.renderizador.moveCamXP();
            }
        }
    }
}
