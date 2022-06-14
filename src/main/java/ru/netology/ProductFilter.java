package ru.netology;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
    public static enum FilterType {
        NAME, MANUFACTURER, PRICE
    }

    public ProductFilter() {
    }

    public List<Product> filter(List<Product> list, HashMap<FilterType, String> filterList) {
        return list.stream()
                .filter(f -> f.getProductName().equalsIgnoreCase(filterList.get(FilterType.NAME)) ||
                        f.getManufacturer().equalsIgnoreCase(filterList.get(FilterType.MANUFACTURER)) ||
                        f.getPrice().equals(filterList.get(FilterType.PRICE)))
                .sorted(Comparator.comparing(Product::getProductName))
                .sorted(Comparator.comparing(Product::getManufacturer))
                .collect(Collectors.toList());
    }
}
