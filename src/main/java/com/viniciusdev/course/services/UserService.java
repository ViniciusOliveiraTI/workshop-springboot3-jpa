package com.viniciusdev.course.services;

import com.viniciusdev.course.entities.User;
import com.viniciusdev.course.repositories.UserRepository;
import com.viniciusdev.course.services.exceptions.DatabaseException;
import com.viniciusdev.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> object = userRepository.findById(id);
        return object.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
           throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User object) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, object);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User object) {
        entity.setName(object.getName());
        entity.setEmail(object.getEmail());
        entity.setPhone(object.getPhone());
    }

}
