package net.schrage.resourceserver.controller;

import net.schrage.resourceserver.response.UserRest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

  @GetMapping("/status/check")
  public String status() {
    return "Working...";
  }

  //@Secured("ROLE_Developer")
  @PreAuthorize("hasRole('Developer') or #id == #jwt.subject")
  @DeleteMapping(path = "/{id}")
  public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
    return "Delete user with id " + id;
  }
  @PostAuthorize("returnObject.id == #jwt.subject")
  @GetMapping(path = "/{id}")
  public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
    return new UserRest("Michael", "Schrage", "6009c20d-ad2c-493a-a32a-7838c1ad1634");
  }
}
