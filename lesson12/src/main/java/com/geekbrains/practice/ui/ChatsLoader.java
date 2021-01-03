package com.geekbrains.practice.ui;

import com.geekbrains.practice.model.Chat;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;

public class ChatsLoader {
  private static ChatsLoader chatsLoader;
  private final ArrayList<Chat> chats;

  private ChatsLoader() {
    chats = new ArrayList<>();
  }

  public static ChatsLoader getInstance() {
    if (chatsLoader == null) {
      chatsLoader = new ChatsLoader();
    }
    return chatsLoader;
  }

  public ArrayList<Chat> getChats() {
    for (int i = 0; i < 10; i++) {
      Chat chat = new Chat(
        "Test" + i,
        null,
        null,
        new FXMLLoader(getClass().getResource("chat_fragment.fxml"))
      );
      chats.add(chat);
    }
    return chats;
  }
}
