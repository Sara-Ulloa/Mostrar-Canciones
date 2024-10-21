package com.sara.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sara.modelos.Artista;
import com.sara.modelos.Cancion;
import com.sara.servicios.ServicioCanciones;
import com.sara.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	@Autowired
	private final ServicioCanciones servicioCanciones;
	
	@Autowired
	private final ServicioArtistas ServicioArtistas;
	
	public ControladorCanciones(ServicioCanciones servicioCanciones, ServicioArtistas ServicioArtistas) {
		this.servicioCanciones = servicioCanciones;
		this.ServicioArtistas = ServicioArtistas;
	}

	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		List<Cancion> canciones = this.servicioCanciones.obtenerTodas();
		model.addAttribute("canciones", canciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion.jsp"; 
    }
	@GetMapping("/canciones/formulario/agregar/{idCancion}")
	public String formularioAgregarCancion(Model model) {
	      model.addAttribute("cancion", new Cancion());
	      model.addAttribute("artistas", new Artista());
	     return "agregarCancion.jsp";
	    }
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult validaciones) {
		if(validaciones.hasErrors()) {
			return "agregarCancion.jsp";
	}
		Artista artista = this.ServicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
        cancion.setArtista(artista);
        
        this.servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
	    Cancion cancion = servicioCanciones.obtenerUno(idCancion);
	    modelo.addAttribute("cancion", cancion);
	    return "editarCancion.jsp";
	}
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@PathVariable Long idCancion, @ModelAttribute Cancion cancion, BindingResult validaciones) {
	    if (validaciones.hasErrors()) {
	        return "editarCancion.jsp";
}
	    cancion.setId(idCancion);
	    this.servicioCanciones.actualizarCancion(cancion);
	    
	    return "redirect:/canciones";
	}
	@DeleteMapping("eliminar/cancion/{idCancion}")
	public String eliminarCancion(@PathVariable Long idCancion) {
		this.servicioCanciones.eliminarUno(idCancion);
		return "redirect:/canciones";
	}
}