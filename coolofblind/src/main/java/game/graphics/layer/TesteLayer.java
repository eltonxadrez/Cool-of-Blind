package game.graphics.layer;

import java.awt.*;

import game.graphics.Renderizador;

public class TesteLayer extends Layer{

    public TesteLayer (Integer camada, Boolean show){
        this.camada = camada;
        this.show = show;
    }

    @Override
    public void render(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) {
        //painel cinza
//        graphics2D.setColor(new Color(75, 75, 75));
//        graphics2D.fillRect(janelaHeight / 7, 0, janelaHeight - (janelaHeight / 4) , janelaWidth);

        //linha vermelha vertical centralizada
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(0, janelaWidth/2, janelaHeight, 1);

        //linha vermelha horizontal centralizada
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(janelaHeight /2, 0, 1, janelaWidth);
    }
}
