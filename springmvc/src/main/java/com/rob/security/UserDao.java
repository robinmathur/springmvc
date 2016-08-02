package com.rob.security;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Repository;
 
 
@Repository
public class UserDao {
 
    public User loadUserByUsername(final String username) {
        User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setUsername("robin");
        user.setPassword("1");
        Role r = new Role();
        r.setName("ROLE_USER");
//        Role r1 = new Role();
//        r.setName("ROLE_ADMIN");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
//        roles.add(r1);
        user.setAuthorities(roles);
        return user;
    }
}