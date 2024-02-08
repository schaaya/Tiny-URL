package com.example.TinyUrlShortner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TinyURLService {


  @Autowired
  private TinyURLRepo tinyURLRepo;

  public  boolean deleteTinyURL(String hashKey) {
    Optional<TinyURL> optionalTinyURL = tinyURLRepo.findByHashKey(hashKey);
    if(optionalTinyURL.isPresent()){
      TinyURL existingTinyURL = optionalTinyURL.get();
      tinyURLRepo.delete(existingTinyURL);
      return true;
    }else{
      return false;
    }

  }

  public TinyURL addTinyURLToDB(String longURL) {
    int hash=0;
    String baseUrl = "http://localhost/";
    hash = getHash(longURL, hash);
    String shortURL = baseUrl + hash;

    TinyURL tinyURL = new TinyURL();
    tinyURL.setKey(String.valueOf(hash));
    tinyURL.setLongURL(longURL);
    tinyURL.setShortURL(shortURL);
    return tinyURLRepo.save(tinyURL);
  }

  private int getHash(String longURL, int hash) {
    for(int i=0;i< longURL.length();i++){
      hash = hash *31 + longURL.charAt(i);
    }
    return Math.abs(hash);
  }

  public String getLongURL(String hashKey) throws URISyntaxException {
//    String hashKey = getHashKeyFromTinyURL(tinyURL);

    Optional<TinyURL> optionalTinyURL = tinyURLRepo.findByHashKey(hashKey);
    return optionalTinyURL.map(TinyURL::getLongURL).orElse(null);
  }

//  private String getHashKeyFromTinyURL(String tinyURL) throws URISyntaxException {
//
//    URI uri = new URI(tinyURL);
//    String segments[] = uri.getPath().split("/");
//    return segments[segments.length-1];
//  }
}
