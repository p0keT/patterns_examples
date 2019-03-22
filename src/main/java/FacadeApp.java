public class FacadeApp {

    public static void main(String ... args){

//        Power power = new Power();
//        power.on();
//
//        DVDRom dvdRom = new DVDRom();
//        dvdRom.load();
//        dvdRom.unload();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdRom);

        //является нашим фасадом
        //раньше мы подобный функционал пихали в контроллере или же называли фасад контроллером, что не совсем верно
        Computer computer = new Computer();
        computer.copy();
    }
}

//является нашим фасадом
class Computer{
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power{
    void on(){
        System.out.println("Включение питания");
    }
    void off(){
        System.out.println("Выключение питания");
    }
}

class DVDRom{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }

    void load(){
        data = true;
    }

    void unload(){
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvdRom){
        if(dvdRom.hasData()){
            System.out.println("Происходит копирование данных с диска");
        }else {
            System.out.println("Вставте диск с данными");
        }
    }
}