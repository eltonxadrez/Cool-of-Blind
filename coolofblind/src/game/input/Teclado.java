package game.input;

import game.Game;
import game.graphics.Janela;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    public Game game;
    public Janela janela;
    public boolean tecladoLivre;

    public Teclado(Game game) {
        this.game = game;
        this.tecladoLivre = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyTyped");
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("esc");
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F11) {
            System.out.println("f11");
            this.janela.turnFullscreen();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
