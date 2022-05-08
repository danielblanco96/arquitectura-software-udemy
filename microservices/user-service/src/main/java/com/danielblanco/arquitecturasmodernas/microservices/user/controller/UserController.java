package com.danielblanco.arquitecturasmodernas.microservices.user.controller;

import com.danielblanco.arquitecturasmodernas.microservices.user.model.User;
import com.danielblanco.arquitecturasmodernas.microservices.user.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    return userService.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/")
  public List<User> findAll() {
    return userService.findAll();
  }
}
