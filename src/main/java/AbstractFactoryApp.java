public class AbstractFactoryApp {
    public static void main(String ... args){

        DeviceFactory factory = getFactoryByCountryCode("ENG");
        Mouse mouse = factory.getMouse();
        Keyboard keyboard = factory.getKeyboard();
        Touchpad touchpad = factory.getTouchpad();

        mouse.click();
        keyboard.print();
        touchpad.track(34,67);

    }
    public static DeviceFactory getFactoryByCountryCode(String code){
        if ("RU".equals(code)) {
            return new RuDeviceFactory();
        } else if ("ENG".equals(code)) {
            return new EngDeviceFactory();
        }
        throw new RuntimeException("Unsupported country code " + code);
    }

}

interface Mouse{
    void click();
    void dbclick();
    void scroll(int direction);
}

interface Keyboard{
    void print();
    void println();
}

interface Touchpad{
    void track(int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class RuDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new RuMouse();
    }

    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}

class EngDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new EngMouse();
    }

    public Keyboard getKeyboard() {
        return new EngKeyboard();
    }

    public Touchpad getTouchpad() {
        return new EngTouchpad();
    }
}

class RuMouse implements Mouse{

    public void click() {
        System.out.println("Щелчок мышкой");
    }

    public void dbclick() {
        System.out.println("Двойной щелчок мышкой");
    }

    public void scroll(int direction) {
        if(direction>0)
            System.out.println("Скролим вверх");
        else if(direction<0)
            System.out.println("Скролим вниз");
        else
            System.out.println("Не скролим");
    }
}

class RuKeyboard implements Keyboard{

    public void print() {
        System.out.println("Печатаем строку");
    }

    public void println() {
        System.out.println("Печатаем строку с переводом на новую строку");
    }
}

class RuTouchpad implements Touchpad{

    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
        System.out.println("Передвинулись на "+ s+ " пикселей");
    }
}

class EngMouse implements Mouse{

    public void click() {
        System.out.println("Mouse click");
    }

    public void dbclick() {
        System.out.println("Double mouse click");
    }

    public void scroll(int direction) {
        if(direction>0)
            System.out.println("Scroll up");
        else if(direction<0)
            System.out.println("Scroll down");
        else
            System.out.println("NO scrolling");
    }
}

class EngKeyboard implements Keyboard{

    public void print() {
        System.out.println("Print");
    }

    public void println() {
        System.out.println("Print with new line");
    }
}

class EngTouchpad implements Touchpad{

    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
        System.out.println("Move on "+ s+ " pixels");
    }
}