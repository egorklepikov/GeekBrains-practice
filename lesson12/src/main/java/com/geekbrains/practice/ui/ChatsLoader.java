package com.geekbrains.practice.ui;

import javafx.fxml.FXMLLoader;

import java.util.ArrayList;

public class ChatsLoader {
  private static ChatsLoader chatsLoader;
  private final ArrayList<FXMLLoader> chats;

  private ChatsLoader() {
    chats = new ArrayList<>();
  }

  public static ChatsLoader getInstance() {
    if (chatsLoader == null) {
      chatsLoader = new ChatsLoader();
    }
    return chatsLoader;
  }

  public ArrayList<FXMLLoader> loadChatsFXMLFragments() throws IllegalArgumentException {
    for (int i = 0; i < 10; i++) {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chat_fragment.fxml"));
      chats.add(fxmlLoader);
    }
    return chats;
  }

  public ArrayList<FXMLLoader> getChats() {
    return chats;
  }
}
