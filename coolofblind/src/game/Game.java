package game;

import game.board.Board;
import game.graphics.Janela;
import game.graphics.Renderizador;
import game.input.Teclado;

import java.awt.*;

public class Game implements Runnable{

    public Janela janela;
    public Renderizador renderizador;
    public Teclado teclado;
    public Thread gameThread;
    public Board board;

    //tamanho janela
    public int width, height;

    public int y = 24;
    public int x = 10;

    //public int speedGame = 75;
    public boolean renderizar = true;
    public boolean isMenu = true;
    private int fps = 60;

    public Game() {
        init();
    }

    private void init() {
        //this.importFont();

        this.setWindowSize();

        this.initMainComponents();

        this.initMainConections();

        this.board = new Board();
        this.renderizador.elementosRenderizadosList.add(this.board);

        //this.iniciarMenu();
    }

    private void setWindowSize() {
        Toolkit toolkit =  Toolkit.getDefaultToolkit ();
        Dimension dim = toolkit.getScreenSize();
        //1920 - 1080
        this.width = (int) dim.getWidth()/2;
        this.height = (int) dim.getHeight()/2;
        //teste
        this.width = 1024;
        this.height = 768;
    }

    private void initMainComponents() {
        //this.entidades = new ArrayList<Entity>();
        //this.menu = new Menu(this);
        this.teclado = new Teclado(this);
        this.renderizador = new Renderizador(this.width, this.height);
        this.janela = new Janela(this.renderizador, this.width, this.height);
    }

    public void initMainConections() {
        this.teclado.janela = this.janela;
        //this.teclado.menu = this.menu;
        this.renderizador.jFrame = this.janela;
        this.renderizador.addKeyListener(teclado);
        this.renderizador.requestFocusInWindow();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("TRD-GAME");
        while(true) {
            try {
                if(renderizar) {
                    this.renderizador.render();
                }
                Thread.sleep(1000/this.fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
