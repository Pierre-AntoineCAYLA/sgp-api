package dev.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	public List<Collaborateur> findByDepartementsId(Integer id);

	public Banque findBanqueBymatricule(String matricule);

	public Collaborateur findBymatricule(String matricule);
}
