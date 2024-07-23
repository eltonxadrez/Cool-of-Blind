package game.graphics.layer;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class LayerImpl {

    private Map<Integer, Layer> layerMap;

    public LayerImpl() {
        this.layerMap = new HashMap<>();
    }

    //evitar usar durante runtime
    public void addLayer(Layer layer){
        this.layerMap.put(layer.camada, layer);
    }

    //evitar usar
    public void removeByCamada(Integer camada){
        this.layerMap.remove(camada);
    }

    //recomendado usar em runtime
    public void switchShowCamada(Integer camada){
        if(this.layerMap.get(camada).show){
            this.layerMap.get(camada).show = false;
        }
        else{
            this.layerMap.get(camada).show = true;
        }
    }

    //recomendado usar em runtime
    public Boolean isShow(Integer camada){
        return this.layerMap.get(camada).show;
    }

}
