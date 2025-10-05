package com.vethishan.service.impl;

import com.vethishan.exception.UserException;
import com.vethishan.modal.User;
import com.vethishan.repository.UserRepository;
import com.vethishan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new UserException("User not found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isEmpty()) {
            throw new UserException("User not found with id" + id);
        }
        userRepository.deleteById(otp.get().getId());
    }

    @Override
    public User updateUser(Long id,User user) throws UserException {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("User not fonund with id:"+id);
        }
        User existingUser=otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);

    }
}
