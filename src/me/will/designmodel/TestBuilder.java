package me.will.designmodel;

/**
 * Created by duyisong on 09/06/2018.
 */
public class TestBuilder {

    class Pizza{
        private String dough = "";
        private String sauce = "";
        private String topping = "";

        public void setDough (String dough)     { this.dough = dough; }
        public void setSauce (String sauce)     { this.sauce = sauce; }
        public void setTopping (String topping) { this.topping = topping; }
    }


    abstract class PizzaBuilder {
        protected Pizza pizza;

        public Pizza getPizza() { return pizza; }
        public void createNewPizzaProduct() { pizza = new Pizza(); }

        public abstract void buildDough();
        public abstract void buildSauce();
        public abstract void buildTopping();
    }

    class HawaiianPizzaBuilder extends PizzaBuilder {
        public void buildDough()   { pizza.setDough("cross"); }
        public void buildSauce()   { pizza.setSauce("mild"); }
        public void buildTopping() { pizza.setTopping("ham+pineapple"); }
    }

    class Waiter {
        private PizzaBuilder pizzaBuilder;

        public void setPizzaBuilder (PizzaBuilder pb) { pizzaBuilder = pb; }
        public Pizza getPizza() { return pizzaBuilder.getPizza(); }

        public void constructPizza() {
            pizzaBuilder.createNewPizzaProduct();
            pizzaBuilder.buildDough();
            pizzaBuilder.buildSauce();
            pizzaBuilder.buildTopping();
        }
    }

    public void test(){
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();

        waiter.setPizzaBuilder ( hawaiian_pizzabuilder );
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
    }


}
