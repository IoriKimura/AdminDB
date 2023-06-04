package com.example.onlineshop.service;

import com.example.onlineshop.dataBases.dao.WorkerDao;
import com.example.onlineshop.jwt.JwtService;
import com.example.onlineshop.message.request.LoginRequest;
import com.example.onlineshop.message.request.RegistrationRequest;
import com.example.onlineshop.message.response.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerService {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final WorkerDao workerDao;


    public JwtResponse login (LoginRequest request){
        if(!workerDao.isUserExist(request.getEmail())){
            throw new UsernameNotFoundException("User is not found");
        }

        if(!passwordEncoder.matches(request.getPassword(),
                workerDao.getUserByEmail(request.getEmail()).getPassword())){
            throw new UsernameNotFoundException("Password is not match");
        }
        return new JwtResponse(jwtService.generateToken(workerDao.getUserByEmail(request.getEmail())));
    };
}
