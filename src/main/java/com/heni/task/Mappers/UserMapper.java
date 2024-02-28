package com.heni.task.Mappers;

import com.heni.task.DTOs.UserDTO;
import com.heni.task.Entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(UserDTO dto){
        if(dto == null){
            throw new NullPointerException("u entered null user");
        }
        User user = new User();
        user.setFirstname(dto.firstname());
        user.setLastname(dto.lastname());
        user.setEmail(dto.email());
        return user;
    }

    public UserDTO toUserDTO(User user){
        return new UserDTO(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }
}
