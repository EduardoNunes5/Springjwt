package com.loginexample.springjwt.user.service;

import com.loginexample.springjwt.user.dto.UserDTO;
import com.loginexample.springjwt.user.dto.UserMessageDTO;
import com.loginexample.springjwt.user.entity.User;
import com.loginexample.springjwt.user.mapper.UserMapper;
import com.loginexample.springjwt.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper = UserMapper.INSTANCE;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserMessageDTO create(UserDTO userDTO){
        User userToBeSaved = userMapper.toModel(userDTO);
        encodePassword(userToBeSaved);
        userRepository.save(userToBeSaved);
        return new UserMessageDTO("User created");
    }

    public List<UserDTO> findAll(){
        return this.userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    private void encodePassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
