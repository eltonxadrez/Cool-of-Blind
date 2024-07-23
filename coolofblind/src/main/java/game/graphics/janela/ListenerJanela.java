package game.graphics.janela;

import game.graphics.Renderizador;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@Getter
@Setter
public class ListenerJanela extends ComponentAdapter {

    private Renderizador renderizador;
    private Janela janela;

    public ListenerJanela(Renderizador canvas, Janela janela) {
        this.renderizador = canvas;
        this.janela = janela;
    }

    @Override
    public void componentResized(ComponentEvent evt) {
        this.renderizador.renderizar = false;
//        this.renderizador.changeResolution = true;
        this.renderizador.setJanelaWidth((int) this.janela.getBounds().getHeight());
        this.renderizador.setJanelaHeight((int) this.janela.getBounds().getWidth());
        this.renderizador.renderizar = true;
        this.renderizador.requestFocusInWindow();
    }
}
