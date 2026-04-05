package com.practicos.ejercicio1.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.practicos.ejercicio1.modelo.Plato;

@RestController
@RequestMapping("/platos")
public class PlatoControlador {
    
    private List<Plato> platos = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plato crearPlato(@RequestBody Plato plato) {

        validarPlato(plato);

        if (buscarPorNumeroInterno(plato.getNumPlato()) != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Ya existe un plato con el numero " + plato.getNumPlato()
            );
        }

        platos.add(plato);
        return plato;
    }

    @GetMapping
    public List<Plato> obtenerPlatos() {
        return platos;
    }

    private Plato buscarPorNumeroInterno(Integer numeroPlato) {
        for (Plato plato : platos) {
            if (plato.getNumPlato().equals(numeroPlato)) {
                return plato;
            }
        }
        return null;
    }

    @GetMapping("/{numeroPlato}")
    public Plato obtenerPlatoPorNumero(@PathVariable Integer numeroPlato) {
        Plato plato = buscarPorNumeroInterno(numeroPlato);

        if (plato == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se encontro un plato con el numero " + numeroPlato
            );
        }

        return plato;
    }

    private void validarPlato(Plato plato) {
        if (plato == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe enviar los datos del plato");
        }
        if (plato.getNumPlato() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El numero de plato es obligatorio");
        }
        if (plato.getNombre() == null || plato.getNombre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es obligatorio");
        }
        if (plato.getPrecio() == null || plato.getPrecio() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El precio debe ser mayor o igual a 0");
        }
        if (plato.getDescripcion() == null || plato.getDescripcion().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La descripcion es obligatoria");
        }
    }

}
