package me.will.designmodel;

public class TestFactoryMethod {
    public interface Car{
    }

    public interface CarFactory {
        Car createCar();
    }

    public static class Audi implements Car{

    }
    public static class Byd implements Car{

    }

    public static class AudiFactory implements CarFactory{
        @Override
        public Car createCar() {
            return new Audi();
        }
    }

    public static class BydFactory implements CarFactory{
        @Override
        public Car createCar() {
            return new Byd();
        }
    }

    public static void main(String[] args) {
        Car car = new AudiFactory().createCar();
        System.out.println(car);
    }

}
