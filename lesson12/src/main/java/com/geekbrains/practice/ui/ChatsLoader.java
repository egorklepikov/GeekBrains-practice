package com.geekbrains.practice.ui;

import com.geekbrains.practice.model.Chat;
import javafx.fxml.FXMLLoader;

import java.util.concurrent.CopyOnWriteArrayList;

public class ChatsLoader {
  private static ChatsLoader chatsLoader;
  private final CopyOnWriteArrayList<Chat> chats;

  private ChatsLoader() {
    chats = new CopyOnWriteArrayList<>();
  }

  public static ChatsLoader getInstance() {
    if (chatsLoader == null) {
      chatsLoader = new ChatsLoader();
    }
    return chatsLoader;
  }

  public CopyOnWriteArrayList<Chat> getChats() {
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
