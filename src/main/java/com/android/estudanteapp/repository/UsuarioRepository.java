package com.android.estudanteapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.android.estudanteapp.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByLogin(String login);

}
