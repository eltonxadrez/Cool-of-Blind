package game.graphics.layer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import game.graphics.ImageRepository;
import game.graphics.Renderizador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sprite extends Layer implements Comparable<Sprite> {
	
    private final ImageRepository imageRepository;
    
    private Renderizador renderizador;

    private BufferedImage[] spriteSheetCaminhada;

    private BufferedImage spritePlayerAtual;
    
    private Boolean threadIdlePausada = false;
    
    private Boolean isIdle = true;
    
    public Sprite(Integer absPosX, Integer absPosY, Integer camada, Boolean show, ImageRepository imageRepository, Renderizador renderizador) {
    	this.renderizador = renderizador;
    	this.imageRepository = imageRepository;
        this.absPosX = absPosX;
        this.absPosY = absPosY;
        this.camada = camada;
        this.show = show;
        this.spriteSheetCaminhada = new BufferedImage[3];
        this.carregarCaminhada();
        this.spriteIdle();
    }

    public void carregarCaminhada(){
    	this.spriteSheetCaminhada[0] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_01);
        this.spriteSheetCaminhada[1] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_02);
        this.spriteSheetCaminhada[2] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_03);
    }

    public void spriteAndarYPstart(){
    	
    	if(!spriteAndandoYP){    
//    		this.idleThread.interrupt();
//    		this.isIdle = false;
    		this.pausarThread();
    		this.spriteAndandoYP = true;
    		spriteAndarYP();
    	}
    }
    
    public void spriteCorrerYPstart(){
    	System.out.println("Teclado");
    	if(!spriteCorrerYP){
    		System.out.println("Teclado Ativado");
//    		this.isIdle = false;
//    		this.idleThread.interrupt();
    		this.pausarThread();
    		this.spriteCorrerYP = true;
    		spriteCorrerYP();
    	}
    }

    private Integer valorDeMovX = 0;
    private Integer valorDeMovX2 = 0;
    private Integer valorDeMovY = 0;
    private Integer valorDeMovY2 = 0;

    private Boolean spriteCorrerYP = false;
    private Boolean spriteAndandoYP = false;
    
    private Integer cicloAnimacao = 0;
    
    private Boolean esquerdaDireita = true;
    
    private void alternarPasso() {
    	if(this.esquerdaDireita) {
    		this.esquerdaDireita = false;
    	}
    	else {
    		this.esquerdaDireita = true;
    	}
    }
    
    public void spriteCorrerYP(){
    	
    	System.out.println("01");
    	Thread.startVirtualThread(() -> {
    		System.out.println("02");
    		Integer quadroCaminhada = 0;
    		
    		boolean sleep = true;
    		
    		while (spriteCorrerYP) {
    			System.out.println("03");
    			if(esquerdaDireita) {
    				System.out.println("Direita");
    				switch (cicloAnimacao) {
					case 0:
						System.out.println("SW0");
						quadroCaminhada = 1;
	    				this.valorDeMovX  += 8;
	    				this.valorDeMovX2 += 4;
//	    				this.renderizador.moverCameraXM(8);
						break;
					case 1:
						System.out.println("SW1");
						quadroCaminhada = 0;
	    				this.valorDeMovX  += 8;
	    				this.valorDeMovX2 += 4;
						break;
					case 2:
						System.out.println("SW2");
	    				this.cicloAnimacao = 0;
        				this.absPosY++;
        				this.valorDeMovX = 0;
        				this.valorDeMovX2= 0;
        				this.spriteCorrerYP = false;
//        				this.isIdle = true;
        				
//        				this.spriteIdle();
        				sleep = false;
        				this.alternarPasso();
    					break;
					}
    			}
    			
    			else {
    				System.out.println("Esquerda");
    				switch (cicloAnimacao) {
    				case 0:
    					quadroCaminhada = 2;
    					this.valorDeMovX  += 8;
	    				this.valorDeMovX2 += 4;
        				break;
    				case 1:
    					quadroCaminhada = 0;
    					this.valorDeMovX  += 8;
	    				this.valorDeMovX2 += 4;
    					break;
    				case 2:
//    					this.pausarThread();
	    				this.cicloAnimacao = 0;
        				this.valorDeMovX = 0;
        				this.valorDeMovX2= 0;
        				this.spriteCorrerYP = false;
        				this.absPosY++;
//        				this.isIdle = true;
//        				this.spriteIdle();
        				sleep = false;
        				this.alternarPasso();
    					break;
    				}
    			}
    			System.out.println("04");
    			this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
    			if(sleep) {
    				System.out.println("05");
    				this.cicloAnimacao++;
    				try {
    					Thread.sleep(1000/10);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    			}
    		}
    		this.pausarThread();
    	});
    }
    
    public void spriteAndarYP(){
    	
    	Thread.startVirtualThread(() -> {
    		
    		Integer quadroCaminhada = 0;
    		
    		boolean sleep = true;
    		
			while (spriteAndandoYP) {
				
				
				switch (cicloAnimacao) {
				case 0:
					quadroCaminhada = 1;
					this.valorDeMovX += 4;
					this.valorDeMovX2 += 2;
					break;
				case 1:
					quadroCaminhada = 0;
					this.valorDeMovX += 4;
					this.valorDeMovX2 += 2;
					break;
				case 2:
					quadroCaminhada = 2;
					this.valorDeMovX += 4;
					this.valorDeMovX2 += 2;
					break;
				case 3:
					quadroCaminhada = 0;
					this.valorDeMovX += 4;
					this.valorDeMovX2 += 2;
					break;
				case 4:
//					quadroCaminhada = 1;
					this.valorDeMovX = 0;
					this.valorDeMovX2 = 0;
					this.spriteAndandoYP = false;
					this.absPosY++;
					this.cicloAnimacao = 0;
					
					sleep = false;
//					this.spritePlayerAtual = null;
//					this.isIdle = true;
//					this.spriteIdle();
					break;
//				case 5:
//					this.cicloAnimacao = 1;
//					this.absPosY++;
//					this.valorDeMovX = 0;
//					this.valorDeMovX2 = 0;
//					this.spriteAndandoYP = false;
////					this.isIdle = true;
////					this.spriteIdle();
//					sleep = false;
//					this.spritePlayerAtual = null;
////					return;
//					break;
				}
				
				if(sleep) {
					this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
					this.cicloAnimacao++;
					try {
						Thread.sleep(1000/5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			this.pausarThread();
		});
    }

   
//    Integer cicloAnimacaoIdle = 0;
    
    
	public void pausarThread() {
		if(this.threadIdlePausada) {
			this.despausarThreadSync();
			this.threadIdlePausada = false;
		}
		else { 
			this.threadIdlePausada = true;
		}
	}
	
	public synchronized void pausarThreadSync() {
		try {
			System.out.println("PAUSAR THREAD!!!");
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void despausarThreadSync() {
		System.out.println("THREAD DESPAUSADA");
		notifyAll();
	}
    
    public void spriteIdle(){
    	
    	Thread.startVirtualThread(() -> {
    		
    		Integer quadroCaminhada = 0;
    		Integer cicloAnimacaoIdle = 0;
    		System.out.println("IDLE");
    		while (isIdle) {
    			
    			if(this.threadIdlePausada) {
    				System.out.println("SWITCH PAUSA");
    				this.pausarThreadSync();
    			}
    			
    			System.out.println("IDLE TRUE");
				switch (cicloAnimacaoIdle ) {
				case 0:
					quadroCaminhada = 1;
					break;
				case 1:
					quadroCaminhada = 0;
					break;
				case 2:
					quadroCaminhada = 2;
					break;
				case 3:
					quadroCaminhada = 0;
					cicloAnimacaoIdle = -1;
					break;
				}
				
				this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
				cicloAnimacaoIdle++;
				try {
					Thread.sleep(1000/1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
    		System.out.println("IDLE FALSE");
    	});
    }


    public void aniSpriteIdle(){
        this.spritePlayerAtual = this.spriteSheetCaminhada[0];
    }
	
	public void renderSprt(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) {
		
		
//		if(isIdle){
//			this.spriteIdle();
//		}
//		renderizador.moverCameraXM(1);
		graphics2D.drawImage(this.spritePlayerAtual,
				(janelaHeight/2) + ((this.absPosX * ((32/2) * escala) - (valorDeMovX * escala)) - (this.absPosY * ((32 / 2) * escala) + (valorDeMovY2 * escala)) + (7 * escala) + (posXCam)) ,
				(janelaWidth /2) + ((this.absPosY * ((17/2) * escala) - (valorDeMovY * escala)) + (this.absPosX * ((17 / 2) * escala) + (valorDeMovX2 * escala)) - (22 * escala) + (posYCam)) ,
				18 * escala,
				35 * escala,
				null);
		
	}
	
	private Integer camadaDinamica() {
		return (absPosX*100) + (absPosY*100) + valorDeMovX + valorDeMovX2 + valorDeMovY + valorDeMovY2;
	}
	
	@Override
	public int compareTo(Sprite sprite) {
		return((this.camadaDinamica()) - (sprite.camadaDinamica()));
	}
}
