package game.graphics;

import game.config.Game;
import game.graphics.layer.*;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serial;
import java.util.Map;

@Getter
@Setter
public class Renderizador extends Canvas implements Runnable {

    private Graphics2D graphics2d;
    private BufferStrategy bs;
    private Integer janelaWidth, janelaHeight;
    private LayerImpl layers;
    private Integer fps;
    private Integer escala;
    private Game game;

    //testando se é possivel desvincular
    private Thread renderizadorThread;

    @Serial
    private static final long serialVersionUID = 1L;

    public boolean renderizar = true;

    public Renderizador(Game game, Integer janelaWidth, Integer janelaHeight, Integer fps) {
        this.game = game;
        this.requestFocusInWindow();
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(janelaWidth, janelaHeight));
        this.janelaWidth = janelaWidth;
        this.janelaHeight = janelaHeight;
        this.fps = fps;
        this.escala = 4;
        //criar Layer Manager e Layers usados na renderizacao
        this.inciarLayers();
    }

    //adicionar as camadas a serem renderizadas aqui
    private void inciarLayers() {
        this.layers = new LayerImpl();
        this.layers.addLayer(new BackgroundLayer(1, true));
        this.layers.addLayer(new TesteLayer(2, true));
        this.layers.addLayer(new BoardLayer(3, true, this.game.getBoard()));
        this.layers.addLayer(new SpriteLayer(4, true, this.game.getBoard()));
        //hud
    }

    public void switchShowCamada(Integer camada){
        this.layers.switchShowCamada(camada);
    }

    public void render() {
        if(renderizar) {
            this.bs = this.getBufferStrategy();

            if(this.bs == null) {
                this.createBufferStrategy(3);
                return;
            }

            this.graphics2d = (Graphics2D) bs.getDrawGraphics();

            for (Map.Entry<Integer, Layer> entry : this.layers.getLayerMap().entrySet()){
                if(entry.getValue().isShow()){
                    entry.getValue().render(this.graphics2d, this.janelaWidth, this.janelaHeight, this.escala);
                }
            }

            this.bs.show();
        }
    }

    @Override
    public void run() {
        Thread.currentThread().setName("TRD-RENDER");
        System.out.println("INICIANDO THREAD RENDER");
        while(true) {
            try {
                this.render();
                Thread.sleep(1000/this.fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
