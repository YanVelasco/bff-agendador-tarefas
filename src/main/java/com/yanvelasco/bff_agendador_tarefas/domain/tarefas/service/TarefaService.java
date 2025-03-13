package com.yanvelasco.bff_agendador_tarefas.domain.tarefas.service;


import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.request.TarefaRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.response.TarefaResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.enums.StatusEnum;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface TarefaService {
    ResponseEntity<TarefaResponseDTO> save(TarefaRequestDTO tarefaRequestDTO, String token);
    ResponseEntity<List<TarefaResponseDTO>> findByDataEventoBetween(
            String token,
            LocalDateTime dataEventoInicial,
            LocalDateTime dataEventoFinal
    );
    ResponseEntity<List<TarefaResponseDTO>> findByEmailDoUsuario(String emailDoUsuario);
    public ResponseEntity<Void> deletaTarefaPorId(
            String token,
            String id
    );
    public ResponseEntity<TarefaResponseDTO> alterarStatus(
            String token,
            StatusEnum status,
            String id
    );
    ResponseEntity<TarefaResponseDTO> updateDeTarefa(
            String token,
            TarefaRequestDTO tarefaRequestDTO,
            String id
    );
}
