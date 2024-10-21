package com.sara.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sara.modelos.Artista;
import com.sara.repositorios.RepositorioArtistass;

@Service
public class ServicioArtistas {
	@Autowired
	private final RepositorioArtistass repositorioArtistas;

	public ServicioArtistas(RepositorioArtistass repositorioArtistas) {
		this.repositorioArtistas = repositorioArtistas;
	}
	
	public List<Artista> obtenerTodosLosArtistas(){
		return this.repositorioArtistas.findAll();
	}
	
	public Artista obtenerArtistaPorId(Long id) {
		return repositorioArtistas.findById(id).orElse(null);
    }
	
	public Artista agregarArtista(Artista nuevoArtista) {
		return this.repositorioArtistas.save(nuevoArtista);
	}
}
