package com.geekbrains.practice.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ChatFragment {
  @FXML
  private Label lastMessage;
  @FXML
  private Label chatName;
  @FXML
  private ImageView chatIcon;
  @FXML
  private AnchorPane chatPane;

  private ChatController chatController;

  public void setChatController(ChatController chatController) {
    this.chatController = chatController;
  }

  public AnchorPane getChatPane() {
    return chatPane;
  }

  public void onChatSelected() {
    switchPanesVisibility();
    resetChatsStyle();
    chatPane.setStyle("-fx-background-color: #009587");
  }

  private void switchPanesVisibility() {
    chatController.getBottomPane().setVisible(true);
    chatController.getNotificationLabelPane().setVisible(false);
  }

  private void resetChatsStyle() {
    for (FXMLLoader fxmlLoader : ChatsLoader.getInstance().getChats()) {
      if (fxmlLoader.getController() instanceof ChatFragment) {
        ChatFragment chatFragment = fxmlLoader.getController();
        chatFragment.getChatPane().setStyle("chat_fragment.css");
      }
    }
  }
}
