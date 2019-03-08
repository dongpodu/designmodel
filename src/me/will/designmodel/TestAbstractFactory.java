package me.will.designmodel;

public class TestAbstractFactory {
    public interface Engine{
        void run();
        void start();
    }

    public interface Seat{
        void massage();
    }

    public interface CarFactory {
        Engine createEngine();
        Seat createSeat();
    }

    public static class LuxuryEngine implements Engine{
        @Override
        public void run() {
            System.out.println("LuxurySeat run");
        }

        @Override
        public void start() {
            System.out.println("LuxurySeat start");
        }
    }

    public static class LowerEngine implements Engine{
        @Override
        public void run() {
            System.out.println("LowerEngine run");
        }

        @Override
        public void start() {
            System.out.println("LowerEngine start");
        }
    }

    public static class LuxurySeat implements Seat{
        @Override
        public void massage() {
            System.out.println("LuxurySeat massage");
        }
    }

    public static class LowerSeat implements Seat{
        @Override
        public void massage() {
            System.out.println("LowerSeat massage");
        }
    }

    public static class LuxuryFactory implements CarFactory{
        @Override
        public Engine createEngine() {
            return new LuxuryEngine();
        }

        @Override
        public Seat createSeat() {
            return new LuxurySeat();
        }
    }

    public static class LowerFactory implements CarFactory{
        @Override
        public Engine createEngine() {
            return new LowerEngine();
        }

        @Override
        public Seat createSeat() {
            return new LowerSeat();
        }
    }


    public static void main(String[] args) {

    }

}
