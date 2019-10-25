package com.cotemig.ProjetoMecanOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cotemig.ProjetoMecanOn.model.Perfil;

@Repository("perfilRepository")
public interface PerfilRepostory extends JpaRepository<Perfil, Integer>{

}