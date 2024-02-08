package com.example.TinyUrlShortner;


import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinyUrlController {

  @Autowired
  private TinyURLService tinyURLService;

  @PostMapping(path = "", consumes = "application/json")
  public ResponseEntity<TinyURL> addTinyURL(@RequestBody LongURL request)  {
    String longURL = request.getLongURL();
    TinyURL createdTinyURL = tinyURLService.addTinyURLToDB(longURL);
    return ResponseEntity.ok(createdTinyURL);

  }

  @GetMapping(path = "/{hashKey}")
  public ResponseEntity<Void> redirectToLongURL(@PathVariable String hashKey)
      throws URISyntaxException {
    String longURL = "http://" + tinyURLService.getLongURL(hashKey);
//    if(longURL != null){
//      RedirectView redirectView = new RedirectView();
//      redirectView.setUrl(longURL);
//      return redirectView;
//    String longURL = tinyURLService.getLongURL(hashKey);
    if (longURL != null) {
//      System.out.println(longURL);
//      return ResponseEntity.status(HttpStatus.FOUND)
//          .header("Location", longURL)
//          .build();

      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(new URI(longURL));
      return new ResponseEntity<>(headers, HttpStatus.FOUND);
    } else {
      return ResponseEntity.notFound().build();
    }
//    }else{
//      throw new ResourceNotFoundException("Long URL not found for the given hashKey" + hashKey);
//    }

  }
  @DeleteMapping("/{hashKey}")
  public ResponseEntity<Object> deleteTinyURL(@PathVariable String hashKey){
    boolean deleted = tinyURLService.deleteTinyURL(hashKey);
    if(deleted){
      return ResponseEntity.noContent().build();
    } else
      return ResponseEntity.notFound().build();
  }
}
