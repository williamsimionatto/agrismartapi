package agrismart.com.agrismart.controller;


import agrismart.com.agrismart.dto.user.Auth;
import agrismart.com.agrismart.dto.user.Token;
import agrismart.com.agrismart.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Auth data) throws Exception {
        var token = authService.singin(data);

        if (token == null) {
            return new ResponseEntity<Token>(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(token);
    }
}
