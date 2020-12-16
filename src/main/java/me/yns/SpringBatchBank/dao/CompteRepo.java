package me.yns.SpringBatchBank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import me.yns.SpringBatchBank.Entities.Compte;

public interface CompteRepo extends JpaRepository<Compte, Long> {

}
