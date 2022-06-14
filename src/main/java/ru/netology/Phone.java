package ru.netology;

// Interface Segregation Principle - Используем разные интерфейсы вместо одного большого.
// Dependency Inversion Principle - разделив интерфейсы мы не зависим от их общей функциональности,
// мы можем поменять один интерфейс на другой.
public class Phone extends Product implements SMS, Caller {
    public Phone() {
        setName("Phone");
    }

    @Override
    public void sendSMS(String msg, String number) {
        System.out.println(number + ": " + msg);
    }

    @Override
    public void doCall(String number) {
        System.out.println("Call to: " + number);
    }
}
