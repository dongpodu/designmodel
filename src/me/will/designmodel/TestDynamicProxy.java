package me.will.designmodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public interface Star{
        void sing();
    }

    public static class RealStar implements Star{

        @Override
        public void sing() {
            System.out.println("sing");
        }
    }

    public static class Handler implements InvocationHandler{
        private Star star;

        public Handler(Star star) {
            this.star = star;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(method);
            System.out.println(args);
            return null;
        }
    }

    public static void main(String[] args) {
        Star realStar = new RealStar();
        Handler handler = new Handler(realStar);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class},handler);
        proxy.sing();
    }

}
