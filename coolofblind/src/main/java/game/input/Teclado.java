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
    private boolean tecladoLivre;

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
        System.out.println("keyTyped");
        if(e.getKeyCode() == KeyEvent.VK_L) {
            System.out.println("TICK TECLADO!!!");
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("fechando programa");
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F11) {
            System.out.println("fullscreen");
            this.janela.turnFullscreen();
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
            this.renderizador.setEscala(this.renderizador.getEscala() + 1);
        }
        if(e.getKeyCode() == KeyEvent.VK_N) {
            System.out.println("diminuir escala");
            this.renderizador.setEscala(this.renderizador.getEscala() - 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
