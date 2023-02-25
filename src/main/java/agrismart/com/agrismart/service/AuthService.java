package agrismart.com.agrismart.service;

import agrismart.com.agrismart.dto.user.Auth;
import agrismart.com.agrismart.dto.user.Token;
import agrismart.com.agrismart.repository.UserRepository;
import agrismart.com.agrismart.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    public ResponseEntity<Token> singin(Auth auth) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword()));

            var user = repository.findByUserName(auth.getUserName());
            var token = new Token();
            if (user.isPresent()) {
                token = tokenProvider.createAccessToken(auth.getUserName(), user.get().getRoles());
            } else {
                throw new Exception("Account not found!");
            }
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            throw new Exception("Invalid Credentials");
        }
    }
}
