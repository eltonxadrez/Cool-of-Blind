package game.graphics;

import game.config.Game;
import game.graphics.layer.*;
import lombok.Getter;
import lombok.Setter;

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
    private Integer posXCam;
    private Integer posYCam;
    private Game game;

    //testando se é possivel desvincular
    private Thread renderizadorThread;
    private Boolean pausado;

    @Serial
    private static final long serialVersionUID = 1L;

    public boolean renderizar = true;

    public Renderizador(Game game, Integer janelaWidth, Integer janelaHeight, Integer fps) {
        this.pausado = false;
        this.game = game;
        this.requestFocusInWindow();
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(janelaWidth, janelaHeight));
        this.janelaWidth = janelaWidth;
        this.janelaHeight = janelaHeight;
        this.fps = fps;
        this.escala = 4;
        this.posXCam = 0;
        this.posYCam = 0;
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

    public void diminuirEscala(){
        if(this.escala > 2){
            this.escala--;
        }
    }

    public void aumentarEscala(){
        if(this.escala < 10){
            this.escala++;
        }
    }

    private Boolean posXP = false;
    public void moveCamXP(){
        if(this.posXP){
            this.posXP = false;
        }
        else{
            this.posXP = true;
        }
//        this.posXCam ++;
    }

    private Boolean posXM = false;
    public void moveCamXM(){
        if(this.posXM){
            this.posXM = false;
        }
        else{
            this.posXM = true;
        }
//        this.posXCam --;
    }

    private Boolean posYP = false;
    public void moveCamYP(){
        if(this.posYP){
            this.posYP = false;
        }
        else{
            this.posYP = true;
        }
//        this.posYCam ++;
    }

    private Boolean posYM = false;
    public void moveCamYM(){
        if(this.posYM){
            this.posYM = false;
        }
        else{
            this.posYM = true;
        }
//        this.posYCam --;
    }

    public void render() {
        if(renderizar && !pausado) {
            this.bs = this.getBufferStrategy();

            if(this.bs == null) {
                this.createBufferStrategy(3);
                return;
            }

            this.graphics2d = (Graphics2D) bs.getDrawGraphics();

            this.moverCamera();

            for (Map.Entry<Integer, Layer> entry : this.layers.getLayerMap().entrySet()){
                if(entry.getValue().isShow()){
                    entry.getValue().render(this.graphics2d, this.janelaWidth, this.janelaHeight, this.escala, this.posXCam, this.posYCam);
                }
            }
            if(renderizar && !pausado){
                this.bs.show();
            }
            //puxar resolucao
        }
    }

    public void moverCamera(){
        if(this.posYM){
            this.posYCam += 3;
        }
        if(this.posYP){
            this.posYCam -= 3;
        }
        if(this.posXM){
            this.posXCam += 3;
        }
        if(this.posXP){
            this.posXCam -= 3;
        }
    }

    public void pausarRender() {
        if(pausado) {
            this.despausarThreadRender();
            this.pausado = false;
//			this.teclado.tecladoLivre = true;
        }
        else {
            this.pausado = true;
//			System.out.println("PAUSADO!");
//			this.teclado.tecladoLivre = false;
        }
    }

    public synchronized void pausarThreadRender() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void despausarThreadRender() {
        notifyAll();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("TRD-RENDER");
        System.out.println("INICIANDO THREAD RENDER");
        while(true) {
            try {
                if(pausado){
                    this.pausarThreadRender();
                }
                else{
                    this.render();
                }
                Thread.sleep(1000/this.fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
