package com.geekbrains.practice.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
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
    inputMessageField.requestFocus();
    sendButton.setImage(new Image("/assets/send_message.jpg"));
    closeButton.setImage(new Image("/assets/close_button.jpg"));
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

  public void onMousePressedTopPanel(MouseEvent mouseEvent) {
    xOffset = mainPane.getScene().getWindow().getX() - mouseEvent.getScreenX();
    yOffset = mainPane.getScene().getWindow().getY() - mouseEvent.getScreenY();
  }

  public void onMouseDraggedTopPanel(MouseEvent mouseEvent) {
    mainPane.getScene().getWindow().setX(mouseEvent.getScreenX() + xOffset);
    mainPane.getScene().getWindow().setY(mouseEvent.getScreenY() + yOffset);
  }
}
