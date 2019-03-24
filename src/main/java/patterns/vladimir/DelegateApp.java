package patterns.vladimir;

public class DelegateApp {
    public static void main(String ... args){
//        A a = new A();
//        a.f();

        //patterns.vladimir.Painter делегирует свои полномочина по рисованию на соответствующие фигуры
        //мы такое в ньювижене делали с рисованием линий и остальной графики
        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Circle());
        painter.draw();
    }
}

//class A{
//    void f(){
//        System.out.println("f()");
//        /*
//
//        a lot of code
//
//
//         */
//    }
//}
//
//class B{
//    A a = new A();
//    void f(){
//        a.f();
//    }
//}

interface Graphics{
    void draw();
}

class Triangle implements Graphics{

    public void draw() {
        System.out.println("Рисуем триугольник");
    }
}

class Square implements Graphics{

    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}

class Circle implements Graphics{

    public void draw() {
        System.out.println("Рисуем круг");
    }
}

class Painter{
    Graphics graphics;
    void setGraphics(Graphics graphics){
        this.graphics = graphics;
    }

    void draw(){
        graphics.draw();
    }
}