package com.example.onlineshop.dataBases.PostgreSQL.Repository;

import com.example.onlineshop.dataBases.PostgreSQL.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {

    Optional<Worker> findWorkerByEmail(String email);
}
