package ru.netology;

import java.util.Scanner;

public class Buyer implements UserInputProcessor {
    private Scanner scanner = new Scanner(System.in);
    private ProductJsonDB productsDb = new ProductJsonDB();
    private ShoppingCart shoppingCart = new ShoppingCart();

    // Using dialog singleton
    private UserDialog dialog = UserDialog.getInstance();

    //Magic Numbers Principle - вместо чисел используем константы
    private final int EXIT = 5;

    public Buyer() {
        productsDb.load();
    }

    public void startBuyerInteract() {
        dialog.out("Добро пожаловать в магазин смартфонов и ноутбуков!");

        while (true) {
            dialog.out(System.lineSeparator() + "Выберите необходимое действие:");
            dialog.out("1. Вывести список товаров");
            dialog.out("2. Фильтровать список товаров");
            dialog.out("3. Добавить товар в корзину");
            dialog.out("4. Показать мою корзину");
            dialog.out("5. Покинуть магазин.");

            int input = scanner.nextInt();

            if (input == EXIT) {
                dialog.out("Пока! Приходите к нам ещё!");
                break;
            }
            userInputHandler(input);
        }
    }

    @Override
    public void userInputHandler(int inputNumber) {
        switch (inputNumber) {
            case 1: {
                //DRY - повторяющийся вывод списка товаров на экран выносим в отдельный метод
                productsDb.print();
                break;
            }
            case 2: {
                productsDb.doSelectFilter();
                break;
            }
            case 3: {
                dialog.out("Введите номер товара:");
                shoppingCart.add(productsDb.getProductById(scanner.nextInt()));
                break;
            }
            case 4: {
                shoppingCart.print();
                break;
            }
            default: {
                dialog.out("Неправильный ввод!");
            }
        }
    }
}
