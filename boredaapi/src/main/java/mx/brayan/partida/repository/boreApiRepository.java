package mx.brayan.partida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.brayan.partida.entities.boredapi;

@Repository
public interface boreApiRepository extends JpaRepository<boredapi, Integer> {

}
