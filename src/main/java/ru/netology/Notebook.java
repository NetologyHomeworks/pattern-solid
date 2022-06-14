package ru.netology;

public class Notebook extends Product implements Video, Sound {
    //Single Responsibility Principle - класс Notebook описывает только ноутбук, а не все товары.
    public Notebook() {
        setName("Notebook");
    }

    @Override
    public void playVideo(String videoName) {
        System.out.println("Play video: " + videoName);
    }

    @Override
    public void playSound(String soundName) {
        System.out.println("Play sound: " + soundName);
    }
}
