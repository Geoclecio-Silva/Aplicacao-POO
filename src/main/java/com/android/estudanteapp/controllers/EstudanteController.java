package com.android.estudanteapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.android.estudanteapp.models.Estudante;
import com.android.estudanteapp.repository.EstudanteRepository;

@Controller
public class EstudanteController {
	
	@Autowired
	private EstudanteRepository er;
	
	@RequestMapping(value="/cadastrarEstudante", method=RequestMethod.GET)
	public String form() {
		return "estudante/formEstudante";
	}
	
	@RequestMapping(value="/cadastrarEstudante", method=RequestMethod.POST)
	public String form(Estudante estudante) {
		
		er.save(estudante);
		
		return "redirect:/cadastrarEstudante";
	}
	
	@RequestMapping("/estudantes")
	public ModelAndView listaEstudantes() {
		ModelAndView mv= new ModelAndView("index");
		Iterable<Estudante> estudantes = er.findAll();
		mv.addObject("estudantes", estudantes);
		return mv;
	}

}
