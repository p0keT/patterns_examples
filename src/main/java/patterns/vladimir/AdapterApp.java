package patterns.vladimir;

public class AdapterApp {
    public static void main(String[] args) {
        // 1 способ через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster1();
        g1.drawLine();
        g1.drawSquare();
        // 2 способ через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RastreGraphics());
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RastreGraphics{
    void drawRasterLine(){
        System.out.println("Draw line");
    }

    void drawRasterSquare(){
        System.out.println("Draw square");
    }
}

class VectorAdapterFromRaster1 extends RastreGraphics implements VectorGraphicsInterface{

    public void drawLine() {
        drawRasterLine();
    }

    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RastreGraphics rastreGraphics = null; //new RastreGraphics();

    public VectorAdapterFromRaster2(RastreGraphics rastreGraphics) {
        this.rastreGraphics = rastreGraphics;
    }

    public void drawLine() {
        rastreGraphics.drawRasterLine();
    }

    public void drawSquare() {
        rastreGraphics.drawRasterSquare();
    }
}