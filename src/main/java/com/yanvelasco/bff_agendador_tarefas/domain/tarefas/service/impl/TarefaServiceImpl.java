package com.yanvelasco.bff_agendador_tarefas.domain.tarefas.service.impl;


import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.request.TarefaRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.response.TarefaResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.enums.StatusEnum;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.service.TarefaService;
import com.yanvelasco.bff_agendador_tarefas.infra.client.TarefaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaClient tarefaClient;


    @Override
    public ResponseEntity<TarefaResponseDTO> save(TarefaRequestDTO tarefaRequestDTO, String token) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaClient.save(tarefaRequestDTO, token));
    }

    @Override
    public ResponseEntity<List<TarefaResponseDTO>> findByDataEventoBetween(
            String token,
            LocalDateTime dataEventoInicial,
            LocalDateTime dataEventoFinal
    ) {
       return ResponseEntity.status(HttpStatus.OK).body(tarefaClient.findByDataEventoBetween(token, dataEventoInicial, dataEventoFinal));
    }

    public ResponseEntity<List<TarefaResponseDTO>> findByEmailDoUsuario(String emailDoUsuario) {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaClient.findByEmailDoUsuario(emailDoUsuario));
    }

    @Override
    public ResponseEntity<Void> deletaTarefaPorId(
            String token,
            String id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaClient.deletaTarefaPorId(token, id));
    }

    @Override
    public ResponseEntity<TarefaResponseDTO> alterarStatus(
            String token,
            StatusEnum status,
            String id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaClient.alteraStatus(token, status.name(), id));
    }

    @Override
    public ResponseEntity<TarefaResponseDTO> updateDeTarefa(
            String token,
            TarefaRequestDTO tarefaRequestDTO,
            String id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaClient.updateDeTarefa(token, tarefaRequestDTO, id));
    }

}