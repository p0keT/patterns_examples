package patterns.vladimir;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String ... args){
//        patterns.vladimir.Watch watch = new patterns.vladimir.DigitalWatch();
//        watch.showTime();
//        watch = new patterns.vladimir.RomeWatch();
//        watch.showTime();
//-----------------------------------------------------
//        patterns.vladimir.WatchMaker maker =
//                new patterns.vladimir.DigitalWatchMaker();
//                //new patterns.vladimir.RomeWatchMaker();
//        patterns.vladimir.Watch watch = maker.createWatch();
//        watch.showTime();
// -----------------------------------------------------
        WatchMaker maker = getMakerByName("Rome");
        Watch watch = maker.createWatch();
        watch.showTime();

    }

    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital")){
            return new DigitalWatchMaker();
        }else{
            if(maker.equals("Rome")){
                return new RomeWatchMaker();
            }
        }
        throw new RuntimeException("Не поддерживаемая производственная линия часов "+ maker);
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{


    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{


    public void showTime() {
        System.out.println("XII-V");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{

    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{

    public Watch createWatch() {
        return new RomeWatch();
    }
}
