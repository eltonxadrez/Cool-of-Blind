package game.config;

import game.board.Board;
import game.graphics.janela.Janela;
import game.graphics.Renderizador;
import game.input.Teclado;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Game implements Runnable{

    private Janela janela;
    private Renderizador renderizador;
    private Teclado teclado;
    private Thread gameThread;
    private Board board;

//    public int speedGame = 75;

//tamanho janela / fps
    private Integer janelaWidth, janelaHeight;
    private Integer fps = 120;
    private Integer gameSpeed = 75;

    public Game() {
        init();
    }

    private void init() {
        //this.importFont();

        this.setWindowSize();

        this.initMainComponents();

//        this.initMainConections();

//        this.board = new Board();
//        this.renderizador.elementosRenderizadosList.add(this.board);

        //this.iniciarMenu();
    }



    private void setWindowSize() {
        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        Dimension dim = toolkit.getScreenSize();

        //resolucao do monitor
        this.janelaWidth = (int) dim.getWidth()/2;
        this.janelaHeight = (int) dim.getHeight()/2;

        //resolucao setada 1024 x 768 para teste
        this.janelaWidth = 1024;
        this.janelaHeight = 768;
    }

    private void initMainComponents() {
        //this.entidades = new ArrayList<Entity>();
        this.board = new Board();
        this.renderizador = new Renderizador(this, this.janelaWidth, this.janelaHeight, this.fps);
        this.janela = new Janela(this.renderizador, this.janelaWidth, this.janelaHeight);
        this.teclado = new Teclado(this, this.janela, this.renderizador);
        this.renderizador.addKeyListener(this.teclado);
        this.renderizador.setRenderizadorThread(new Thread(this.renderizador));
        this.renderizador.getRenderizadorThread().start();
    }

    //testar teclado....
    @Override
    public void run() {
        Thread.currentThread().setName("TRD-GAME");
        System.out.println("INICIANDO THREAD GAME");
        while(true) {
            try {
//                if(renderizar) {
//                    this.renderizador.render();
//                }
                Thread.sleep(1000/this.gameSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
