package com.sara.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sara.modelos.Cancion;
import com.sara.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

	@Autowired
	private final RepositorioCanciones repositorioCanciones;
	public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
		this.repositorioCanciones = repositorioCanciones;
	}
	public List<Cancion> obtenerTodas(){
		return this.repositorioCanciones.findAll();
	}
	public Cancion obtenerCancionPorId(Long id) {
		return repositorioCanciones.findById(id).orElse(null);
    }
}
