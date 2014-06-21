package nl.wur.alterra.quickanddirtyows.wms;

public class Layer {

    private String layerName;

    private String layerTitle;

    private String abstractText;

    private String metadataOnlineResource;

    private LayerList layerList;

    public Layer(String name, String title, String abstracttext,
            String metadataonlineresource) {
        super();

        this.layerList = new LayerList();

        this.layerName = name;
        this.layerTitle = title;
        this.abstractText = abstracttext;
        this.metadataOnlineResource = metadataonlineresource;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public String getLayerTitle() {
        return layerTitle;
    }

    public void setLayerTitle(String title) {
        this.layerTitle = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getMetadataOnlineResource() {
        return metadataOnlineResource;
    }

    public void setMetadataOnlineResource(String metadataOnlineResource) {
        this.metadataOnlineResource = metadataOnlineResource;
    }

    public LayerList getLayerList() {
        return layerList;
    }

    public void setLayerList(LayerList layerList) {
        this.layerList = layerList;
    }
}
