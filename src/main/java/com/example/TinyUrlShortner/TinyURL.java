package com.example.TinyUrlShortner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TinyURL {

  public String getKey() {
    return hashKey;
  }

  public void setKey(String key) {
    this.hashKey = key;
  }

  public String getLongURL() {
    return longURL;
  }

  public void setLongURL(String longURL) {
    this.longURL = longURL;
  }

  public String getShortURL() {
    return shortURL;
  }

  public void setShortURL(String shortURL) {
    this.shortURL = shortURL;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String hashKey;

  private String longURL;
  private String shortURL;
}
