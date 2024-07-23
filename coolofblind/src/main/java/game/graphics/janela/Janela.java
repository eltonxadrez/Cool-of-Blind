package game.graphics.janela;

import game.graphics.Renderizador;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.io.Serial;

@Getter
@Setter
public class Janela extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    private boolean fullScreen = false;
    private Renderizador renderizador;

    public Janela(Renderizador renderizador, int width, int height) {
        this.renderizador = renderizador;
        this.setBounds(0, 0, width, height);
        this.add(renderizador);
        this.setTitle("Cool of Blind");
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
