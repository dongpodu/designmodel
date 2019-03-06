package me.will.designmodel;

public class TestSimpleFactory {
    public interface Car{
    }

    public static class Audi implements Car{

    }
    public static class Byd implements Car{

    }

    public static class CarFactory{
        public static Car createCar(String type){
            if("audi".equalsIgnoreCase(type)){
                return new Audi();
            }else if("byd".equalsIgnoreCase(type)){
                return new Byd();
            }else{
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Car car = CarFactory.createCar("audi");
        System.out.println(car);
    }

}
