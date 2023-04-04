package com.Imp.insuranceManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Imp.insuranceManagement.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

