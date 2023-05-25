package com.cars.app.service;
import com.cars.app.exception.UserRoleNotFoundException;
import com.cars.app.repository.UserRepository;
import com.cars.app.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.cars.app.model.UserRole;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserRoleService {

    @Autowired
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    public UserRoleService(UserRoleRepository userRoleRepository,UserRepository userRepository){
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
    }
    public UserRole newUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }

    public UserRole updateUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }
    public List<UserRole> fetchAllUserRoles(){
        return userRoleRepository.findAll();
    }

    public UserRole fetchUserRoleById(Long id){
        return userRoleRepository.findUserRoleById(id)
                .orElseThrow(()-> new UserRoleNotFoundException("UserRole by id " + id + " was not found") );
    }
    public UserRole fetchUserRoleByUserId(Long user_id){
        return userRoleRepository.findUserRoleByUserId(user_id)
                .orElseThrow(()-> new UserRoleNotFoundException("UserRole by user_id " + user_id + " was not found") );
    }
    public UserRole fetchUserRoleByRole(String role){
        return userRoleRepository.findUserRoleByRole(role)
                .orElseThrow(()-> new UserRoleNotFoundException("UserRole by role " + role + " was not found") );
    }
    public void  deleteUserRole(Long id){
        userRoleRepository.deleteUserRoleById(id);
    }
}