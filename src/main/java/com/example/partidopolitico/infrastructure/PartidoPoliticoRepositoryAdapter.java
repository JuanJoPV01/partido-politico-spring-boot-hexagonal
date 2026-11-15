package com.example.partidopolitico.infrastructure;

import com.example.partidopolitico.application.ports.out.DeletePartidoPoliticoPort;
import com.example.partidopolitico.application.ports.out.GetAllPartidosPoliticosPort;
import com.example.partidopolitico.application.ports.out.GetPartidoPoliticoByIdPort;
import com.example.partidopolitico.application.ports.out.SavePartidoPoliticoPort;
import com.example.partidopolitico.domain.Exceptions.PartidoPoliticoNotFoundException;
import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartidoPoliticoRepositoryAdapter implements
        SavePartidoPoliticoPort,
        GetPartidoPoliticoByIdPort,
        GetAllPartidosPoliticosPort,
        DeletePartidoPoliticoPort {

    private final PartidoPoliticoJpaRepository jpaRepository;

    public PartidoPoliticoRepositoryAdapter(PartidoPoliticoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PartidoPolitico save(PartidoPolitico partidoPolitico) {
        return jpaRepository.save(PartidoPoliticoEntity.fromDomain(partidoPolitico)).toDomain();
    }

    @Override
    public PartidoPolitico findById(PartidoPoliticoId id) {
        return jpaRepository.findById(id.value())
                .map(PartidoPoliticoEntity::toDomain)
                .orElseThrow(() -> new PartidoPoliticoNotFoundException(id));
    }

    @Override
    public List<PartidoPolitico> findAll() {
        return jpaRepository.findAll().stream()
                .map(PartidoPoliticoEntity::toDomain)
                .toList();
    }

    @Override
    public void deleteById(PartidoPoliticoId id) {
        if (!jpaRepository.existsById(id.value())) {
            throw new PartidoPoliticoNotFoundException(id);
        }
        jpaRepository.deleteById(id.value());
    }
}