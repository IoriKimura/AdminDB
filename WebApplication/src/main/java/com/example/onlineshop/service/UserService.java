package com.example.onlineshop.service;

import com.example.onlineshop.dataBases.PostgreSQL.Repository.WorkerRepo;
import com.example.onlineshop.dataBases.dao.WorkerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private final WorkerRepo workerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            return workerRepo.findWorkerByEmail(email).orElseThrow();
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User is not found");
        }
    }
}