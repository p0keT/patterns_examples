package patterns.vladimir;

public class BridgeApp {
    public static void main(String[] args) {
        CarAbstr carAbstr = new Sedan(new Kia());
        carAbstr.showDetails();
    }
}

abstract class CarAbstr{
    Make make;
    public CarAbstr(Make m){
        make = m;
    }

    abstract void showDetails();
}

class Sedan extends CarAbstr{

    public Sedan(Make m) {
        super(m);
    }

    @Override
    void showDetails() {
        System.out.println("Sedan");
        make.setMake();
    }
}

class Hatchback extends CarAbstr{

    public Hatchback(Make m) {
        super(m);
    }

    @Override
    void showDetails() {
        System.out.println("Hatchback");
        make.setMake();
    }
}

interface Make{
    void setMake();
}

class Kia implements Make{

    @Override
    public void setMake() {
        System.out.println("make Kia");
    }
}

class Skoda implements Make{

    @Override
    public void setMake() {
        System.out.println("make Skoda");
    }
}
