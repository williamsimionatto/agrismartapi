package agrismart.com.agrismart.controller;

import agrismart.com.agrismart.domain.User;
import agrismart.com.agrismart.dto.user.AddUserDTO;
import agrismart.com.agrismart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody AddUserDTO data) {
        User user = userService.save(data);
        return ResponseEntity.ok(user);
    }
}