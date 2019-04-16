package com.srmasset.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.srmasset.demo.repository.entity.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
