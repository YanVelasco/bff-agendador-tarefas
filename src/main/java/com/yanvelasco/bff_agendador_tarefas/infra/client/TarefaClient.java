package com.yanvelasco.bff_agendador_tarefas.infra.client;

import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.request.TarefaRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.response.TarefaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefa", url = "${agendador-tarefa.url}")
public interface TarefaClient {

    @PostMapping
    TarefaResponseDTO save(
            @RequestBody TarefaRequestDTO tarefaRequestDTO,
            @RequestHeader("Authorization") String token
    );

    @GetMapping("/eventos")
    List<TarefaResponseDTO> findByDataEventoBetween(
            @RequestHeader("Authorization") String token,
            @RequestParam("dataEventoInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEventoInicial,
            @RequestParam("dataEventoFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEventoFinal
    );

    @GetMapping
    List<TarefaResponseDTO> findByEmailDoUsuario(@RequestHeader("Authorization") String token);

    @DeleteMapping("/{id}")
    Void deletaTarefaPorId(
            @RequestHeader("Authorization") String token,
            @PathVariable String id
    );

    @PatchMapping
    TarefaResponseDTO alteraStatus(
            @RequestHeader("Authorization") String token,
            @RequestParam("status") String status,
            @RequestParam("id") String id
    );

    @PutMapping()
    TarefaResponseDTO updateDeTarefa(
            @RequestHeader("Authorization") String token,
            @RequestBody TarefaRequestDTO tarefaRequestDTO,
            @RequestParam("id") String id
    );

}