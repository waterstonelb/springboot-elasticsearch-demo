package com.example.es_test.service;

import com.example.es_test.util.EsUtil;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsController {
  @Autowired
  EsUtil esUtil;

  @GetMapping("/es")
  public String testController() throws IOException {
    return esUtil.searchByIndexAndId("bank","_search").toString();
  }
}
