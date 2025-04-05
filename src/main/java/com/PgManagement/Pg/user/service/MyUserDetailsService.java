package com.PgManagement.Pg.user.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.PgManagement.Pg.security.UserPrincipal;
import com.PgManagement.Pg.user.entity.MstUser;
import com.PgManagement.Pg.user.repo.MstUserRepo;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private MstUserRepo userRepository;

    public MstUser createUser(MstUser user){
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<MstUser> user = userRepository.findByUsername(username);
       // Optional<MstUser> user = userRepository.getLogInData(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("User not found!");
        return new UserPrincipal(user.get());
    }
}