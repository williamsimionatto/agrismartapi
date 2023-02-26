package agrismart.com.agrismart.service;

import agrismart.com.agrismart.domain.User;
import agrismart.com.agrismart.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import agrismart.com.agrismart.dto.user.AddUserDTO;
import agrismart.com.agrismart.dto.user.UserDTO;
import agrismart.com.agrismart.service.exceptions.ObjectnotFoundException;

@Service
public class UserService {
  @Autowired
  private FarmService farmService;
  @Autowired
  private BCryptPasswordEncoder encoder;

  @Autowired
  private UserRepository userRepository;

  public User save(AddUserDTO data) {
    if (!farmService.exists(data.getFarmId())) {
      throw new ObjectnotFoundException("Farm not found");
    }

    String encodedPassword = encoder.encode(data.getPassword());

    User user = new User(data);
    user.setPassword(encodedPassword);
    return userRepository.save(user);
  }

  public List<UserDTO> findAll() {
    List<User> users = userRepository.findAll();
    List<UserDTO> usersDTO = users.stream().map(UserDTO::new).collect(Collectors.toList());

    usersDTO.forEach(user -> {
      user.setFarm(farmService.getFarm(user.getFarmId()));
    });

    return usersDTO;
  }

  public UserDTO findById(Long id) {
    User user = userRepository.findById(id).orElseThrow(() -> new ObjectnotFoundException("User not found"));
    UserDTO userDTO = new UserDTO(user);
    userDTO.setFarm(farmService.getFarm(userDTO.getFarmId()));
    return userDTO;
  }
}
