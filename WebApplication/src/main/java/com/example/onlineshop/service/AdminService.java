package com.example.onlineshop.service;

import com.example.onlineshop.dataBases.dao.WorkerDao;
import com.example.onlineshop.message.request.RegistrationRequest;
import com.example.onlineshop.message.request.UpdateRequest;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdminService {
    @Autowired
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

    public String updateInfo(UpdateRequest request){
        return new Gson().toJson(workerDao.updateWorkerInfo(request));
    }
}
