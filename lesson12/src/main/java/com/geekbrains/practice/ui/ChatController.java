package com.geekbrains.practice.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
  @FXML
  private AnchorPane notificationLabelPane;
  @FXML
  private VBox chats;
  @FXML
  private AnchorPane bottomPane;
  @FXML
  private GridPane mainPane;
  @FXML
  private ImageView closeButton;
  @FXML
  private ImageView sendButton;
  @FXML
  private TextArea messagesArea;
  @FXML
  private TextField inputMessageField;

  private double xOffset;
  private double yOffset;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    sendButton.setImage(new Image("/assets/send_message.jpg"));
    closeButton.setImage(new Image("/assets/close_button.jpg"));
    bottomPane.setVisible(false);
    Platform.runLater(() -> messagesArea.requestFocus());
    Platform.runLater(new ChatsListener());
  }

  @FXML
  public void sendMessageWithField(KeyEvent keyEvent) {
    if (keyEvent.getCode() == KeyCode.ENTER) {
      messagesArea.appendText(inputMessageField.getText() + "\n");
      inputMessageField.clear();
      inputMessageField.requestFocus();
    } else if (keyEvent.getCode() == KeyCode.ESCAPE) {
      inputMessageField.clear();
      inputMessageField.requestFocus();
    }
  }

  @FXML
  public void enterMouseListener() {
    sendButton.setScaleX(1.1);
    sendButton.setScaleY(1.1);
  }

  @FXML
  public void exitMouseListener() {
    sendButton.setScaleX(1.0);
    sendButton.setScaleY(1.0);
  }

  @FXML
  public void clickedMouseListener() {
    messagesArea.appendText(inputMessageField.getText() + "\n");
    inputMessageField.clear();
    inputMessageField.requestFocus();
  }

  @FXML
  public void onMouseEnteredExit() {
    closeButton.setScaleX(1.1);
    closeButton.setScaleY(1.1);
  }

  @FXML
  public void onMouseExitedExit() {
    closeButton.setScaleX(1.0);
    closeButton.setScaleY(1.0);
  }

  @FXML
  public void onMouseClickedExit() {
    System.exit(0);
  }

  @FXML
  public void onMousePressedTopPanel(MouseEvent mouseEvent) {
    xOffset = mainPane.getScene().getWindow().getX() - mouseEvent.getScreenX();
    yOffset = mainPane.getScene().getWindow().getY() - mouseEvent.getScreenY();
  }

  @FXML
  public void onMouseDraggedTopPanel(MouseEvent mouseEvent) {
    mainPane.getScene().getWindow().setX(mouseEvent.getScreenX() + xOffset);
    mainPane.getScene().getWindow().setY(mouseEvent.getScreenY() + yOffset);
  }

  public AnchorPane getBottomPane() {
    return bottomPane;
  }

  public AnchorPane getNotificationLabelPane() {
    return notificationLabelPane;
  }

  private class ChatsListener implements Runnable {
    @Override
    public void run() {
      for (FXMLLoader fxmlLoader : ChatsLoader.getInstance().loadChatsFXMLFragments()) {
        try {
          Node node = fxmlLoader.load();
          if (fxmlLoader.getController() instanceof ChatFragment) {
            ChatFragment chatFragment = fxmlLoader.getController();
            chatFragment.setChatController(ChatController.this);
          }
          chats.getChildren().add(node);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
