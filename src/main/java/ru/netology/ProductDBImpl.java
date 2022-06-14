package ru.netology;

import java.util.HashMap;

public interface ProductDBImpl {
    void load();
    void print();
    void filter(HashMap<ProductFilter.FilterType, String> filterList);
}
