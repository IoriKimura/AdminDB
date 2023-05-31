package com.example.onlineshop.service;

import com.example.onlineshop.dataBases.dao.WorkerDao;
import com.example.onlineshop.message.request.RegistrationRequest;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final WorkerDao workerDao;

    public String findAllUsers(){
        return new Gson().toJson(workerDao.findAll());
    }

    public ResponseEntity<String> delete(Long workerId) {
        if (workerDao.isUserExist(workerDao.getUserEmailById(workerId))) {
            workerDao.deleteWorker(workerId);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Такого пользователя нет");
    }

    public boolean register(RegistrationRequest request){
        if (!workerDao.isUserExist(request.getEmail())) {
            workerDao.createNewWorker(request);
            return true;
        }
        else
            return false;
    }
}
