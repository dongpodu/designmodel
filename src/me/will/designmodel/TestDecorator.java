package me.will.designmodel;

public class TestDecorator {
    public interface ICar{
        void move();
    }

    /**
     * 真实组件角色
     */
    public static class Car implements ICar{

        @Override
        public void move() {
            System.out.println("move");
        }
    }

    /**
     * 装饰器角色
     */
    public static class SuperCar implements ICar{
        private ICar car;
        public SuperCar(ICar car) {
            this.car = car;
        }

        @Override
        public void move() {
            car.move();
        }
    }

    /**
     * 具体装饰器角色
     */
    public static class FLyCar extends SuperCar{

        public FLyCar(ICar car) {
            super(car);
        }

        public void fly(){
            System.out.println("fly");
        }

        @Override
        public void move() {
            super.move();
            fly();
        }
    }

    /**
     * 具体装饰器角色
     */
    public static class WaterCar extends SuperCar{

        public WaterCar(ICar car) {
            super(car);
        }

        public void swim(){
            System.out.println("swim");
        }

        @Override
        public void move() {
            super.move();
            swim();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        FLyCar fLyCar = new FLyCar(car);
        fLyCar.move();

        WaterCar waterCar = new WaterCar(car);
        waterCar.move();

        WaterCar waterCar1 = new WaterCar(fLyCar);
        waterCar1.move();
    }
}
