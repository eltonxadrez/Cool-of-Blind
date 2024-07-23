package game.input;

import game.config.Game;
import game.graphics.Renderizador;
import game.graphics.janela.Janela;
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
        this.tecladoLivre = true;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("keyTyped");
        if(e.getKeyCode() == KeyEvent.VK_L) {
            System.out.println("TICK TECLADO!!!");
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("fechando programa");
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F11) {
            this.renderizador.pausarRender();
            this.renderizador.renderizar = false;
            System.out.println("fullscreen");
            this.janela.turnFullscreen();
            this.renderizador.renderizar = true;
            this.renderizador.pausarRender();
        }
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
        if(e.getKeyCode() == KeyEvent.VK_M) {
            System.out.println("aumentar escala");
            this.renderizador.aumentarEscala();
        }
        if(e.getKeyCode() == KeyEvent.VK_N) {
            System.out.println("diminuir escala");
            this.renderizador.diminuirEscala();
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
