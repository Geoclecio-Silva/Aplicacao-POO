package com.android.estudanteapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String form(@Valid Estudante estudante, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Campos vazios! Por favor preencha todos os campos (^-^)");
			return "redirect:/cadastrarEstudante";
		}
		er.save(estudante);
		attributes.addFlashAttribute("mensagem", "Cadastrado com Sucesso!");
		
		return "redirect:/estudantes";
	}
	
	@RequestMapping("/estudantes")
	public ModelAndView listaEstudantes() {
		ModelAndView mv= new ModelAndView("index");
		Iterable<Estudante> estudantes = er.findAll();
		mv.addObject("estudantes", estudantes);
		return mv;
	}
	
	  @GetMapping("/login")
	  public String login() {
	    return "login"; // <<< Retorna a página de login
	  }
	

}
