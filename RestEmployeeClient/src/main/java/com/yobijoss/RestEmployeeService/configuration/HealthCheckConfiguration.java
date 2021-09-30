package com.yobijoss.RestEmployeeService.configuration;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HealthCheckController {

  @GetMapping(path = "/")
  public ResponseEntity<?> rootHealthcheck()  {

    return ResponseEntity.ok().build();
  }

}
