package ru.progect.Sinner;


public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Пользователь с ником" + playerName + "не зарегистрирован");
    }
}
