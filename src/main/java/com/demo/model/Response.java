package com.demo.model;

public class Response<T> {
  private int status;
  private String error;
  private String message;
  private T data;

  public static enum ErrorType {
    OK, NOT_FOUND
  }

  public Response(T data, int status, String error, String message) {
    this.setData(data);
    this.setStatus(status);
    this.setError(error);
    this.setMessage(message);
  }

  public Response(T data, ErrorType t) {
    switch (t) {
      case OK:
        this.setCustomResponse(data, 200, "ok", "successful");
        break;
      case NOT_FOUND:
        this.setCustomResponse(data, 400, "not found", "cannot found data in database");
        break;
    }
  }

  public void setCustomResponse(T data, int status, String error, String message) {
    this.setData(data);
    this.setStatus(status);
    this.setError(error);
    this.setMessage(message);
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getError() {
    return this.error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
