package org.wiseSaying.entity;

public class WiseSaying {
  private int id;
  private String content;
  private String person;

  public WiseSaying(int id, String content, String person) {
    this.id = id;
    this.content = content;
    this.person = person;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPerson() {
    return person;
  }

  public void setPerson(String person) {
    this.person = person;
  }
}