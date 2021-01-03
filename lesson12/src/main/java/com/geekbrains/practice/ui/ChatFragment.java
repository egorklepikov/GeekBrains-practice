package com.geekbrains.practice.ui;

import com.geekbrains.practice.model.Chat;
import javafx.fxml.FXML;
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
  private int fragmentIndex;

  public void setChatController(ChatController chatController) {
    this.chatController = chatController;
  }

  public void setFragmentIndex(int fragmentIndex) {
    this.fragmentIndex = fragmentIndex;
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
    for (Chat chat : ChatsLoader.getInstance().getChats()) {
      if (chat.getFxmlLoader().getController() instanceof ChatFragment) {
        ChatFragment chatFragment = chat.getFxmlLoader().getController();
        chatFragment.getChatPane().setStyle("chat_fragment.css");
      }
    }
  }

  public void initialize() {
    Chat chat = ChatsLoader.getInstance().getChats().get(fragmentIndex);
    lastMessage.setText(chat.getLastMessage());
    chatName.setText(chat.getChatName());
  }
}
