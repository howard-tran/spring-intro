package com.demo.model;

import java.util.Date;

public class ChatMessage {
  public String from;
  public String message;

  public Date dateTime;

  public ChatMessage(String _from, String _mes, Date _datetime) {
    this.from = _from;
    this.message = _mes;
    this.dateTime = _datetime;
  }
}
