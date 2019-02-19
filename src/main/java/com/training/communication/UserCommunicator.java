package com.training.communication;

import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserCommunicator {

    private Scanner scanner;
    private ResourceBundle messageBundle;

    public UserCommunicator(InputStream text) {
        this.scanner = new Scanner(text);
        this.messageBundle = ResourceBundle.getBundle("MessageTextBundle");
    }

    private void viewMessage(String text) {
        System.out.println(text);
    }

    public void viewNoTypeMessage(String text) {
        viewMessage(text);
    }

    public void viewErrorMessage(MessageType messageType) {
        viewMessage(messageBundle.getString(messageType.name()));
    }

    public String requestTextValue(MessageType messageType) {
        viewMessage(messageBundle.getString(messageType.name()));
        return scanner.nextLine();
    }

    public Integer requestNumberValue(MessageType messageType) {
        viewMessage(messageBundle.getString(messageType.name()));
        while (!scanner.hasNextInt()) {
            viewMessage(messageBundle.getString(MessageType.WRONG_ENTER_NUMBER.name()));
            scanner.next();
        }
        return Integer.parseInt(scanner.nextLine());
    }
}
