package com.example.onlineshop.dataBases.dao;

import com.example.onlineshop.dataBases.PostgreSQL.Entity.Role;
import com.example.onlineshop.dataBases.PostgreSQL.Entity.Worker;
import com.example.onlineshop.dataBases.PostgreSQL.Repository.WorkerRepo;
import com.example.onlineshop.message.request.RegistrationRequest;
import com.example.onlineshop.message.request.UpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkerDao {

    private final WorkerRepo workerRepo;
    private final PasswordEncoder passwordEncoder;

    public Worker createNewWorker(RegistrationRequest request){
        return workerRepo.save(Worker.builder().workerName(request.getName())
                .workerSurName(request.getSurName())
                .workerLastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build());
    }

    public boolean isUserExist(String email){
        return workerRepo.findWorkerByEmail(email).isPresent();
    }

    public Worker getUserByEmail(String email){
        return workerRepo.findWorkerByEmail(email).orElseThrow();
    }

    public String getUserEmailById(Long workerId){
        return workerRepo.findById(workerId).orElseThrow().getEmail();
    }
    public List<Worker> findAll() {
        ArrayList<Worker> workerList = new ArrayList<>();
        for(Worker worker : workerRepo.findAll()){
            workerList.add(
                    Worker.builder()
                            .id(worker.getId())
                            .workerName(worker.getWorkerName())
                            .workerSurName(worker.getWorkerSurName())
                            .workerLastName(worker.getWorkerLastName())
                            .role(worker.getRole())
                            .build()
            );
        }
        return workerList;
    }

    public void deleteWorker(Long workerId) {
        workerRepo.deleteById(workerId);
    }

    public Worker updateWorkerInfo(UpdateRequest request){
        Worker chosenWorker = workerRepo.findById(request.getUserId()).orElseThrow();
        if (!request.getEmail().isEmpty())
            chosenWorker.setEmail(request.getEmail());
        if (!request.getPassword().isEmpty())
            chosenWorker.setPassword((passwordEncoder.encode(request.getPassword())));
        if (!request.getRole().isEmpty())
            chosenWorker.setRole(Role.valueOf(request.getRole()));
        return workerRepo.save(chosenWorker);
    }
}
