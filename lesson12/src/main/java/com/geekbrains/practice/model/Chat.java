package com.geekbrains.practice.model;

import javafx.fxml.FXMLLoader;

import java.awt.*;
import java.util.ArrayList;

public class Chat {
  private final String chatName;
  private final Image chatIcon;
  private final ArrayList<String> messages;
  private final FXMLLoader fxmlLoader;

  public Chat(String chatName, Image chatIcon, ArrayList<String> messages, FXMLLoader fxmlLoader) {
    this.chatName = chatName;
    this.chatIcon = chatIcon;
    this.messages = messages;
    this.fxmlLoader = fxmlLoader;
  }

  public String getChatName() {
    return chatName;
  }

  public Image getChatIcon() {
    return chatIcon;
  }

  public ArrayList<String> getMessages() {
    return messages;
  }

  public String getLastMessage() {
    return messages.get(messages.size() - 1);
  }

  public FXMLLoader getFxmlLoader() {
    return fxmlLoader;
  }
}
