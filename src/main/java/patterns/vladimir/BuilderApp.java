package patterns.vladimir;

public class BuilderApp {
    public static void main(String ... args){
        //простой билдер
//        Car car = new CarBuilder()
//                .buildBrand("Mercedes")
//                .buildTransmission(Transmission.AUTO)
//                .buildMaxSpeed(220)
//                .build();
//        System.out.println(car.toString());

        //------------------------------------------------------
        //сложный билдер
        Director director = new Director();
        director.setBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}

//коробка передач (ручная/авто)
enum Transmission{
    MANUAL, AUTO
}

class Car{
    String brand;
    Transmission transmission;
    int maxSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

//class CarBuilder{
//    String br = "Default";
//    Transmission tr = Transmission.MANUAL;
//    int maxS = 120;
//
//    CarBuilder buildBrand(String br){
//        this.br=br;
//        return this;
//    }
//
//    CarBuilder buildTransmission(Transmission tr){
//        this.tr=tr;
//        return this;
//    }
//
//    CarBuilder buildMaxSpeed(int maxS){
//        this.maxS=maxS;
//        return this;
//    }
//
//    Car build(){
//        Car car = new Car();
//        car.setBrand(br);
//        car.setTransmission(tr);
//        car.setMaxSpeed(maxS);
//        return car;
//    }
//}

abstract class CarBuilder{
    Car car;
    void createCar(){
        car = new Car();
    }

    abstract void buildBrand();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar(){
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder{

    void buildBrand() {
        car.setBrand("Ford Mondeo");
    }

    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    void buildMaxSpeed() {
        car.setMaxSpeed(240);
    }
}


class SubaruBuilder extends CarBuilder{

    void buildBrand() {
        car.setBrand("Subaru");
    }

    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    void buildMaxSpeed() {
        car.setMaxSpeed(320);
    }
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder builder){this.builder=builder;}

    Car buildCar(){
        builder.createCar();
        builder.buildBrand();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}




