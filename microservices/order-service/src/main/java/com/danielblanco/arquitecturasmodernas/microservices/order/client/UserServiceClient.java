package com.danielblanco.arquitecturasmodernas.microservices.order.client;

import com.danielblanco.arquitecturasmodernas.microservices.order.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserServiceClient {

  @GetMapping("/user-service/{userId}")
  UserDTO findUserById(@PathVariable("userId") Long userId);
}
