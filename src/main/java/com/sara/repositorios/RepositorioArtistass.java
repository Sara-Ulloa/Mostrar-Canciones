package com.sara.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.modelos.Artista;

@Repository
public interface RepositorioArtistass extends CrudRepository<Artista, Long>{
	List<Artista> findAll();

}
