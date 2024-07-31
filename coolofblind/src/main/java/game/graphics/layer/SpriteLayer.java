package game.graphics.layer;

import game.board.Board;
import game.graphics.ImageRepository;
import game.graphics.Renderizador;
import lombok.Getter;
import lombok.Setter;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
//import java.util.ArrayList;

@Getter
@Setter
public class SpriteLayer extends Layer{

    private Board board;
    
    private Renderizador renderizador;
    
    private List<Sprite> sprites;
    
    private Sprite mainSprite;

    private final ImageRepository imageRepository = new ImageRepository();

    public SpriteLayer(Integer camada, Boolean show, Board board, Renderizador renderizador) {
    	this.sprites = new ArrayList<>();
        this.camada = camada;
        this.show = show;
        this.board = board;
        this.renderizador = renderizador;
        this.addSprite();
    }
    
    public void addSprite() {
//    	this.sprites.add(new Sprite(3, 3, 1, true, imageRepository, this.renderizador));
    	this.mainSprite = new Sprite(1, 1, 2, true, imageRepository, this.renderizador);
    	this.sprites.add(this.mainSprite);
    }

    @Override
    public void render(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) {
    	Collections.sort(this.sprites);
    	
    	for (Sprite sprite : this.sprites) {
			sprite.renderSprt(graphics2D, janelaWidth, janelaHeight, fpsRT, fps, escala, posXCam, posYCam);
		}
    	
    }
}
