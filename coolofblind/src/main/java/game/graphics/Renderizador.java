package game.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serial;
import java.util.ArrayList;

public class Renderizador extends Canvas {

    public Graphics2D graphics2d;

    public BufferStrategy bs;
    public int width, height;
    public JFrame jFrame;

    public ArrayList<Concreto> elementosRenderizadosList;

    @Serial
    private static final long serialVersionUID = 1L;

    public boolean renderizar = true;

    public Renderizador(int width, int height) {
        this.setBackground(Color.BLACK);
        this.elementosRenderizadosList = new ArrayList<Concreto>();
        this.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
    }


    public void render() {
        if(renderizar) {
            this.bs = this.getBufferStrategy();

            if(this.bs == null) {
                this.createBufferStrategy(3);
                return;
            }

            this.graphics2d = (Graphics2D) bs.getDrawGraphics();

            this.background();

            for (Concreto concreto : this.elementosRenderizadosList) {
                concreto.render(this.graphics2d, this.jFrame.getBounds().width, this.jFrame.getBounds().height);
            }

            this.bs.show();
        }
    }

    private void background() {
        //background black
        this.graphics2d.setColor(Color.BLACK);
        this.graphics2d.fillRect(0, 0, this.height, this.width);

        //painel cinza
        this.graphics2d.setColor(new Color(25, 25, 25));
        this.graphics2d.fillRect(this.height / 7, 0,
                this.height - (this.height / 4) , this.width);

        //linhas vermelhas marcando o centro
		this.graphics2d.setColor(Color.RED);
		this.graphics2d.fillRect(0, this.width/2, this.height, 1);

		this.graphics2d.setColor(Color.RED);
		this.graphics2d.fillRect(this.height/2, 0, 1, this.width);
    }

}
