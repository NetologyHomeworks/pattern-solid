package ru.netology;

import java.util.*;
import java.util.stream.Collectors;

public class ProductJsonDB implements ProductDBImpl {
    private List<Product> list;
    private UserDialog dialog = UserDialog.getInstance();
    private final String DB_NAME = "products_db.json";

    public ProductJsonDB() {
    }

    // Dependency inversion principle - разделив интерфейсы мы не зависим от их общей функциональности,
    // мы можем к примеру осуществлять загрузку товаров из XML либо из базы данных.
    @Override
    public void load() {
        JsonParser jsonParser = new JsonParser();
        List<Product> objList = Arrays.asList(
                new Phone().setId(1).setProductName("Galaxy S10").setManufacturer("Samsung").setCountry("Korea").setPrice(20990),
                new Phone().setId(2).setProductName("iPhone 10").setManufacturer("Apple").setCountry("USA").setPrice(24990),
                new Phone().setId(3).setProductName("Galaxy A22").setManufacturer("Samsung").setCountry("Korea").setPrice(19990),
                new Phone().setId(4).setProductName("iPhone 12").setManufacturer("Apple").setCountry("USA").setPrice(61980),
                new Phone().setId(5).setProductName("iPhone 13").setManufacturer("Apple").setCountry("USA").setPrice(94890),
                new Phone().setId(6).setProductName("iPhone 13").setManufacturer("Apple").setCountry("USA").setPrice(81990),
                new Notebook().setId(7).setProductName("Lenovo").setManufacturer("Lenovo Group Limited").setCountry("China").setPrice(49116),
                new Notebook().setId(8).setProductName("Acer").setManufacturer("Корпорация Хунци").setCountry("China").setPrice(34999)
        );

        String json = jsonParser.listObjectToJson(objList.stream().map(element -> (Object) element).collect(Collectors.toList()));
        jsonParser.writeJsonToFile(json, DB_NAME);

        json = jsonParser.readJsonFromFile(DB_NAME);
        list = jsonParser.jsonToObjectList(json, new Product()).
                stream().map(element -> (Product) element).collect(Collectors.toList());
    }

    @Override
    public void print() {
        list.forEach(System.out::println);
    }

    // Liskov substitution principle - оба класса ProductJsonDB и ProductFilter имеют метод filter,
    // поэтому они не должны быть связаны отношением наследования
    @Override
    public void filter(HashMap<ProductFilter.FilterType, String> filterList) {
        List<Product> result = new ProductFilter().filter(list, filterList);
        if (!result.isEmpty()) result.forEach(System.out::println);
        else dialog.out("Ничего не найдено!");
    }

    public void doSelectFilter() {
        Scanner scanner = new Scanner(System.in);
        HashMap<ProductFilter.FilterType, String> filterList = new HashMap<>();

        //while (true) {
        dialog.out("Выберите фильтр: ");
        dialog.out("1. Фильтровать по названию");
        dialog.out("2. Фильтровать по производителю");
        dialog.out("3. Фильтровать по цене");

        String input = scanner.nextLine();
        switch (input) {
            case "1": {
                dialog.out("Введите название:");
                filterList.put(ProductFilter.FilterType.NAME, scanner.nextLine());
                break;
            }
            case "2": {
                dialog.out("Введите производителя:");
                filterList.put(ProductFilter.FilterType.MANUFACTURER, scanner.nextLine());
                break;
            }
            case "3": {
                dialog.out("Введите цену:");
                filterList.put(ProductFilter.FilterType.PRICE, scanner.nextLine());
                break;
            }
            default: {
                dialog.out("Неправильный ввод!");
            }
        }

        dialog.out(System.lineSeparator() + "Сформированный список товаров:");
        filter(filterList);

        /*dialog.out("Выбрать ещё один фильтр? (y/n): ");
        input = scanner.nextLine();
        if (input.equals("n")) {
            dialog.out(System.lineSeparator() + "Сформированный список товаров:");
            filter(filterList);
            break;
        }*/
    }

    public Product getProductById(int id) {
        return list.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
