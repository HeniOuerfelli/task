package com.heni.task.Repos;

import com.heni.task.DTOs.UserDTO;
import com.heni.task.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User getUserByEmail(String email);
    UserDTO getUserById(Integer id);
    List<UserDTO> getUserByFirstname(String firstname);
    void deleteUserByEmail(String email);


}
