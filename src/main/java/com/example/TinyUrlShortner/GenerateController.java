package com.example.TinyUrlShortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GenerateController {
  @Autowired
  private TinyURLService tinyURLService;

  @GetMapping("/generate")
  public String showGenerateForm(Model model) {
    model.addAttribute("longURL", new LongURL());
    return "generate";
  }

  @PostMapping("/generate")
  public String generateShortURL(LongURL longURL, Model model) {
    String shortURL = tinyURLService.addTinyURLToDB(longURL.getLongURL()).getShortURL();
    model.addAttribute("shortURL", shortURL);
    return "result";
  }
}
