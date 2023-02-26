package agrismart.com.agrismart.service;

import agrismart.com.agrismart.domain.User;
import agrismart.com.agrismart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String userName) {
        Optional<User> data = userRepository.findByUserName(userName);
        if (data.isPresent()) {
            User user = data.get();
            return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new HashSet<>()
            );
        }
        return null;
    }
}
