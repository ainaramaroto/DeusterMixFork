package com.example.restapi.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.example.restapi.model.Receta;
import com.example.restapi.model.Ingrediente;
import com.example.restapi.model.Usuario;
import com.example.restapi.repository.RecetaRepository;

public class ServiceReceta {
    
    private final RecetaRepository repositorioReceta;
    
    public ServiceReceta (RecetaRepository repositorioReceta) {
		this.repositorioReceta = repositorioReceta;
		
	}
    
    //Obtener TODAS las recetas de la plataforma
    public List<Receta> obtenerRecetas(){
        return repositorioReceta.findAll();
    }

    //Obtener la LISTA de recetas del usuario LOGIN
    public List<Receta> obtenerMisRecetas(String email){
		List<Receta> recetas = new ArrayList<>();
		recetas.addAll(repositorioReceta.findByUsuario_Email(email));
        return recetas;
    }

    //Obtener la LISTA de recetas de un usuario buscado
    public List<Receta> obtenerRecetasDeUsuario(Usuario usuario){
        return repositorioReceta.findByUsuario(usuario);
    }

    //Obtener UNA receta en específico
    public Receta obtenerReceta(Long id){
        return repositorioReceta.findById(id).get();
    }

    //Añadir una receta
    public void aniadirReceta(Usuario usuario, String nombre, String descripcion, List<Ingrediente> ingredientes) {
        SecureRandom aleatorio = new SecureRandom();
        Receta nuevaReceta = new Receta(aleatorio.nextLong(), nombre, descripcion, ingredientes);
        usuario.getRecetas().add(nuevaReceta);
        repositorioReceta.save(nuevaReceta);
    }

    //Eliminar una receta
    public void eliminarReceta(Usuario usuario, Long id){
        Receta receta = repositorioReceta.findById(id).get();
        usuario.getRecetas().remove(receta);
        repositorioReceta.deleteById(id);
    }   
}

