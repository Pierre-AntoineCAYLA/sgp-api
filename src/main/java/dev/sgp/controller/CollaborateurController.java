package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.repository.CollaborateurRepository;
import dev.sgp.repository.DepartementRepository;

@CrossOrigin
@RestController
@RequestMapping("api/collaborateur")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private DepartementRepository departementRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> listerCollaborateur() {
		return this.collaborateurRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "departements" })
	public List<Collaborateur> afficherCollaborateur(@RequestParam("departements") int id) {
		return this.collaborateurRepository.findByDepartementsId(id);
	}

	@GetMapping(path = "/{matricule}")
	public Collaborateur afficherCollaborateurByMatricule(@PathVariable("matricule") String matricule) {
		return this.collaborateurRepository.findBymatricule(matricule);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{matricule}")
	public void modifierCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
		int id = collaborateurRepository.findBymatricule(matricule).getId();
		collaborateur.setId(id);
		this.collaborateurRepository.save(collaborateur);
	}

	@GetMapping(path = "/{matricule}/banque")
	public Banque afficherBanqueByMatricule(@PathVariable("matricule") String matricule) {
		return this.collaborateurRepository.findBymatricule(matricule).getBanque();
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{matricule}/banque")
	public void modifierBanque(@PathVariable String matricule, @RequestBody Banque banque) {
		Collaborateur collaborateur = this.collaborateurRepository.findBymatricule(matricule);
		int id = collaborateurRepository.findBymatricule(matricule).getId();
		collaborateur.setId(id);
		collaborateur.setBanque(banque);
		this.collaborateurRepository.save(collaborateur);
	}
}