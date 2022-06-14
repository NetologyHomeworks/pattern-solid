package ru.netology;

public class UserDialog {
    private static UserDialog dialog;

    private UserDialog() {
    }

    public void out(String msg) {
        System.out.println(msg);
    }

    public static UserDialog getInstance() {
        if (dialog == null) dialog = new UserDialog();
        return dialog;
    }
}
