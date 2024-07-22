package game.graphics;

import javax.swing.*;
import java.io.Serial;

public class Janela extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    public boolean fullScreen = false;
    public Renderizador renderizador;

    public Janela(Renderizador renderizador, int width, int height) {
        this.renderizador = renderizador;
        this.setBounds(0, 0, width, height);
//		this.setUndecorated(this.fullScreen);
        this.add(renderizador);
        this.setTitle("Cool of Blind");
//		this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(new ListenerJanela(renderizador, this));
        this.setVisible(true);
    }

    public void turnFullscreen(){
        if(fullScreen) {
            this.renderizador.renderizar = false;
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.dispose();
            this.setVisible(false);
            this.setUndecorated(false);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(true);
            this.fullScreen = false;
            this.renderizador.renderizar = true;
        }
        else {
            this.renderizador.renderizar = false;
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.dispose();
            this.setVisible(false);
            this.setUndecorated(true);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(true);
            this.fullScreen = true;
            this.renderizador.renderizar = true;
        }
    }

}
