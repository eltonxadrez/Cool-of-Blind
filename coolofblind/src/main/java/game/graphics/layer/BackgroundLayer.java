package game.graphics.layer;

import java.awt.*;

public class BackgroundLayer extends Layer {

    public BackgroundLayer(Integer camada, Boolean show) {
        this.camada = camada;
        this.show = show;
    }

    @Override
    public void render(Graphics2D graphics2D, int janelaWidth, int janelaHeight) {
        //background black
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, janelaHeight, janelaWidth);
    }
}
