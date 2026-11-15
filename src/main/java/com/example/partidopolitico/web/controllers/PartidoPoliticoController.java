package com.example.partidopolitico.web.controllers;

import com.example.partidopolitico.application.commands.PartidoPoliticoCommand;
import com.example.partidopolitico.application.responses.PartidoPoliticoResponse;
import com.example.partidopolitico.application.services.PartidoPoliticoService;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
                .collect(Collectors.toList());
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
    @ResponseStatus(HttpStatus.CREATED)
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
                new PartidoPoliticoId(id), command.toUpdatedDomain(new PartidoPolitico())
        );
        PartidoPoliticoResponse respuesta = PartidoPoliticoMapper.toResponse(actualizado);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        partidoPoliticoService.execute(new PartidoPoliticoId(id));
        return ResponseEntity.noContent().build();
    }
}