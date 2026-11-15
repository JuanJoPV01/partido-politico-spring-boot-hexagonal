package com.example.partidopolitico.web.controllers;

import com.example.partidopolitico.application.commands.PartidoPoliticoCommand;
import com.example.partidopolitico.application.mappers.PartidoPoliticoMapper;
import com.example.partidopolitico.application.responses.PartidoPoliticoResponse;
import com.example.partidopolitico.application.services.PartidoPoliticoService;
import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/partidos-politicos")
public class PartidoPoliticoController {

    private final PartidoPoliticoService partidoPoliticoService;

    public PartidoPoliticoController(PartidoPoliticoService partidoPoliticoService) {
        this.partidoPoliticoService = partidoPoliticoService;
    }

    @GetMapping
    public ResponseEntity<List<PartidoPoliticoResponse>> listarTodos() {
        List<PartidoPoliticoResponse> lista = partidoPoliticoService.execute().stream()
                .map(PartidoPoliticoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoPoliticoResponse> obtenerPorId(@PathVariable String id) {
        PartidoPoliticoResponse respuesta = PartidoPoliticoMapper.toResponse(
                partidoPoliticoService.execute(new PartidoPoliticoId(id))
        );
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<PartidoPoliticoResponse> crear(@RequestBody PartidoPoliticoCommand command) {
        PartidoPolitico creado = partidoPoliticoService.execute(command.toDomain());
        PartidoPoliticoResponse respuesta = PartidoPoliticoMapper.toResponse(creado);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidoPoliticoResponse> actualizar(
            @PathVariable String id,
            @RequestBody PartidoPoliticoCommand command) {
        PartidoPolitico actualizado = partidoPoliticoService.execute(
                new PartidoPoliticoId(id), command.toDomain()
        );
        PartidoPoliticoResponse respuesta = PartidoPoliticoMapper.toResponse(actualizado);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        partidoPoliticoService.delete(new PartidoPoliticoId(id));
        return ResponseEntity.noContent().build();
    }
}