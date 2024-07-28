package game.graphics.layer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import game.graphics.ImageRepository;

public class Sprite extends Layer implements Comparable<Sprite> {
	
    private final ImageRepository imageRepository;

    private BufferedImage[] spriteSheetCaminhada;

    private BufferedImage spritePlayerAtual;

    public Sprite(Integer absPosX, Integer absPosY, Integer camada, Boolean show, ImageRepository imageRepository) {
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
        this.spriteSheetCaminhada[0] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_02);
        this.spriteSheetCaminhada[1] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_01);
        this.spriteSheetCaminhada[2] = this.imageRepository.getImageRepo(ImageRepository.IMG_SPR_WARRIOR_LB_03);
    }

    public void spriteAndarYPstart(){
    	this.isIdle = false;
    	
    	if(!spriteAndandoYP){    	
    		this.spriteAndandoYP = true;
    		spriteAndarYP();
    	}
    }
    
    public void spriteCorrerYPstart(){
    	this.isIdle = false;
    	
    	if(!spriteAndandoYP){    	
    		this.spriteAndandoYP = true;
    		spriteCorrerYP();
    	}
    }

    Integer valorDeMovX = 0;
    Integer valorDeMovX2 = 0;
    Integer valorDeMovY = 0;
    Integer valorDeMovY2 = 0;

    Boolean spriteAndandoYP = false;
    Integer cicloAnimacao = 0;
    
    Boolean alternanciaPasso = true;
    
    public void spriteCorrerYP(){
    	
    	Thread.startVirtualThread(() -> {
    		
    		Integer quadroCaminhada = 0;
    		
    		boolean sleep = true;
    		
    		while (spriteAndandoYP) {
    			
    			if(alternanciaPasso) {
    				switch (cicloAnimacao) {
					case 0:
						quadroCaminhada = 2;
	    				this.valorDeMovX = 4;
	    				this.valorDeMovX2= 2;
						break;
					case 1:
						quadroCaminhada = 1;
	    				this.valorDeMovX = 8;
	    				this.valorDeMovX2= 4;
	    				sleep = false;
						break;
					case 2:
//						quadroCaminhada = 1;
//	    				this.valorDeMovX = 12;
//	    				this.valorDeMovX2= 6;
	    				this.cicloAnimacao = 0;
        				this.absPosY++;
        				this.valorDeMovX = 0;
        				this.valorDeMovX2= 0;
        				this.spriteAndandoYP = false;
        				this.isIdle = true;
        				this.spriteIdle();
        				sleep = false;
    					break;
					}
    				
    			}
    			else {
    				switch (cicloAnimacao) {
    				case 0:
    					quadroCaminhada = 0;
        				this.valorDeMovX = 12;
        				this.valorDeMovX2= 6;
        				break;
    				case 1:
    					quadroCaminhada = 1;
        				this.valorDeMovX = 16;
        				this.valorDeMovX2= 8;
        				this.cicloAnimacao++;
        				sleep = false;
    					break;
    				case 2:
    					this.cicloAnimacao = 0;
        				this.absPosY++;
        				this.valorDeMovX = 0;
        				this.valorDeMovX2= 0;
        				this.spriteAndandoYP = false;
        				this.isIdle = true;
        				this.spriteIdle();
        				sleep = false;
    					break;
    				}
    			}
    			
//    			switch (cicloAnimacao) {
//    			case 0:
//    				quadroCaminhada = 1;
//    				this.valorDeMovX = 0;
//    				this.valorDeMovX2= 0;
//    				
//    				break;
//    			case 1:
//    				quadroCaminhada = 2;
//    				this.valorDeMovX = 4;
//    				this.valorDeMovX2= 2;
//    				break;
//    			case 2:
//    				quadroCaminhada = 1;
//    				this.valorDeMovX = 8;
//    				this.valorDeMovX2= 4;
//    				break;
//    				
//    			case 3:
//    				quadroCaminhada = 0;
//    				this.valorDeMovX = 12;
//    				this.valorDeMovX2= 6;
//    				break;
//    			case 4:
//    				quadroCaminhada = 1;
//    				this.valorDeMovX = 16;
//    				this.valorDeMovX2= 8;
//    				this.cicloAnimacao++;
//    				sleep = false;
//    				break;
//    			case 5:
//    				this.cicloAnimacao = 0;
//    				this.absPosY++;
//    				this.valorDeMovX = 0;
//    				this.valorDeMovX2= 0;
//    				this.spriteAndandoYP = false;
//    				this.isIdle = true;
//    				this.spriteIdle();
//    				sleep = false;
////					return;
//    				break;
//    			}
    			
    			this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
    			if(sleep) {
    				this.cicloAnimacao++;
    				try {
    					Thread.sleep(1000/3);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    			}
    		}
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
					this.valorDeMovX = 4;
					this.valorDeMovX2= 2;
					
					break;
				case 1:
					quadroCaminhada = 2;
					this.valorDeMovX = 8;
					this.valorDeMovX2= 4;
					break;
				case 2:
					quadroCaminhada = 1;
					this.valorDeMovX = 12;
					this.valorDeMovX2= 6;
					break;
				case 3:
					quadroCaminhada = 0;
					this.valorDeMovX = 16;
					this.valorDeMovX2= 8;
					break;
				case 4:
					quadroCaminhada = 1;
					this.valorDeMovX = 16;
					this.valorDeMovX2= 8;
					this.cicloAnimacao++;
					sleep = false;
					break;
				case 5:
					this.cicloAnimacao = 0;
					this.absPosY++;
					this.valorDeMovX = 0;
					this.valorDeMovX2= 0;
					this.spriteAndandoYP = false;
					this.isIdle = true;
					this.spriteIdle();
					sleep = false;
//					return;
					break;
				}
				
				this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
				if(sleep) {
					this.cicloAnimacao++;
					try {
						Thread.sleep(1000/10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
    }

    Boolean isIdle = true;
//    Integer cicloAnimacaoIdle = 0;

    public void spriteIdle(){
    	System.out.println("01");
    	Thread.startVirtualThread(() -> {
    		System.out.println("02");
    		Integer quadroCaminhada = 0;
    		Integer cicloAnimacaoIdle = 0;
    		System.out.println("03");
    		while (isIdle) {
//    			System.out.println("04");
				switch (cicloAnimacaoIdle ) {
				case 0:
					quadroCaminhada = 1;
					break;
				case 1:
					quadroCaminhada = 2;
					break;
				case 2:
					quadroCaminhada = 1;
					break;
				case 3:
					quadroCaminhada = 0;
					break;
				case 4:
					quadroCaminhada = 1;
					cicloAnimacaoIdle = 0;
					break;
//				case 5:
//					cicloAnimacaoIdle = 0;
//					break;
				}
				
				this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
				cicloAnimacaoIdle++;
				try {
					Thread.sleep(1000/2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				if(sleep) {
//				}
    			
    			//testes caminhada
//    			if(cicloAnimacaoIdle >= 81){
//    				this.cicloAnimacaoIdle = 0;
////                this.isIdle = false;
//    			}
//    			else if(cicloAnimacaoIdle >= 80){
//    				quadroCaminhada = 1;
//    				this.cicloAnimacaoIdle++; //60
//    			}
//    			else if(cicloAnimacaoIdle >= 60){
//    				quadroCaminhada = 0;
//    				this.cicloAnimacaoIdle++; //48
//    			}
//    			else if(cicloAnimacaoIdle >= 40){
//    				quadroCaminhada = 1;
//    				this.cicloAnimacaoIdle++; //36
//    			}
//    			else if(cicloAnimacaoIdle >= 20){
//    				quadroCaminhada = 2;
//    				this.cicloAnimacaoIdle++; //24
//    			}
//    			else if(cicloAnimacaoIdle >= 0){
//    				quadroCaminhada = 1;
//    				this.cicloAnimacaoIdle++; //12
//    			}
//    			this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
			}
    	});
//    	Integer quadroCaminhada = 0;
//        //testes caminhada
//        if(cicloAnimacaoIdle >= 81){
//            this.cicloAnimacaoIdle = 0;
////            this.isIdle = false;
//        }
//        else if(cicloAnimacaoIdle >= 80){
//            quadroCaminhada = 1;
//            this.cicloAnimacaoIdle++; //60
//        }
//        else if(cicloAnimacaoIdle >= 60){
//            quadroCaminhada = 0;
//            this.cicloAnimacaoIdle++; //48
//        }
//        else if(cicloAnimacaoIdle >= 40){
//            quadroCaminhada = 1;
//            this.cicloAnimacaoIdle++; //36
//        }
//        else if(cicloAnimacaoIdle >= 20){
//            quadroCaminhada = 2;
//            this.cicloAnimacaoIdle++; //24
//        }
//        else if(cicloAnimacaoIdle >= 0){
//            quadroCaminhada = 1;
//            this.cicloAnimacaoIdle++; //12
//        }
//        this.spritePlayerAtual = this.spriteSheetCaminhada[quadroCaminhada];
    }


    public void aniSpriteIdle(){
        this.spritePlayerAtual = this.spriteSheetCaminhada[0];
    }
	
	public void renderSprt(Graphics2D graphics2D, Integer janelaWidth, Integer janelaHeight, Integer fpsRT, Integer fps, Integer escala, Integer posXCam, Integer posYCam) {
		
//		if(isIdle){
//			this.spriteIdle();
//		}
		
		graphics2D.drawImage(this.spritePlayerAtual,
				(janelaHeight/2) + ((this.absPosX * ((32/2) * escala) - (valorDeMovX * escala)) - (this.absPosY * ((32 / 2) * escala) + (valorDeMovY)) + (7 * escala) + (posXCam)) ,
				(janelaWidth /2) + ((this.absPosY * ((17/2) * escala) - (valorDeMovY)) + (this.absPosX * ((17 / 2) * escala) + (valorDeMovX2 * escala)) - (22 * escala) + (posYCam)) ,
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
