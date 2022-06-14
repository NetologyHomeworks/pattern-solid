package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private List<Product> products;
    private final char RUB = (char) 0x20BD;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        if (product != null) {
            products.add(product);
            System.out.println("Товар: \"" + product.getProductName() + "\" добавлен в корзину");
        } else System.out.println("Товара с таким номером не существует!");
    }

    public void print() {
        if (!products.isEmpty()) {
            Map<Product, Integer> map = new HashMap<>();
            for (Product product : products) {
                Integer count = map.get(product);
                map.put(product, (count == null) ? 1 : count + 1);
            }
            printGrouped(map);
        } else System.out.println("Ваша корзина пуста!");
    }

    public void printGrouped(Map<Product, Integer> map) {
        int countNum = 0;
        int total = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            countNum++;
            total += entry.getValue() * Double.valueOf(entry.getKey().getPrice());
            System.out.println(countNum + ". " + entry.getKey().print() + " Кол-во: " + entry.getValue() + " шт.");
        }
        System.out.println(System.lineSeparator() + "Итого товаров на сумму: " + total + " " + RUB);
    }
}
