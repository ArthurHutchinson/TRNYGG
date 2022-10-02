package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.UserDTO;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<UserDTO> findAllUserDTO();

    UserDTO findUserDTObyId(int userId);

    User getUserById(int userId);

    UserDTO getUserDTOById(int userId);

    public UserDTO findUserDTOByUsername(String username);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);
}
