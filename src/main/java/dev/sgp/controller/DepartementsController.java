package dev.sgp.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Departements;
import dev.sgp.repository.DepartementRepository;

@RestController
@RequestMapping("api/departement")
public class DepartementsController extends HttpServlet {

	@Autowired
	private DepartementRepository departementRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Departements> listerDepartements() {
		return this.departementRepository.findAll();
	}

}
