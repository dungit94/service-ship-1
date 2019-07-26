package com.service.ship.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.service.ship.model.UserModel;
import com.service.ship.repository.AppRoleRepository;
import com.service.ship.repository.AppUserRepository;

@Service
public class UserDeatilsServiceImpl implements UserDetailsService{

    /**
     * name of object use to log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeatilsServiceImpl.class);

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel userModel = this.appUserRepository.findUserAccount(userName);
        
        if(userModel == null) {
            LOGGER.info("User not found!" + userName);
            throw new UsernameNotFoundException("User" + userName + "was not found in the database");
        }
        LOGGER.info("Found user:" + userModel);
        List<String> roleName = this.appRoleRepository.getRoleNames(userModel.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(roleName != null) {
            for (String role : roleName) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(userModel.getUserName(), //
                userModel.getEncrytedPassword(), grantList);
        return userDetails;
    }

}
