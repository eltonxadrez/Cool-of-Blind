package game.graphics.layer;

import java.awt.*;

public class Layer {

    public Integer camada;
    public Integer absPosX;
    public Integer absPosY;
    Boolean show;


    public void render(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) { }

    public Boolean isShow(){
        return this.show;
    }

    public Integer getAbsPosX(){
        return this.absPosX;
    }

    public Integer getAbsPosY(){
        return this.absPosY;
    }
}
