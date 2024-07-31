package game.graphics.layer;

import java.awt.*;

import game.graphics.Renderizador;

public class BackgroundLayer extends Layer {

    public BackgroundLayer(Integer camada, Boolean show) {
        this.camada = camada;
        this.show = show;
    }

    @Override
    public void render(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) {
        //background black

        GradientPaint primary = new GradientPaint(
                0f, 0f, new Color(0, 101, 242),
                0f, 1080f, new Color(0, 174, 242));


        GradientPaint shade = new GradientPaint(
                0f, 0f, new Color(0, 0, 0, 0),
                0f, 200f, new Color(0, 0, 0, 255));

//        graphics2D.setColor(Color.BLACK);
        graphics2D.setPaint(primary);
        graphics2D.fillRect(0, 0, janelaHeight, janelaWidth);
    }
}
