package com.yanvelasco.bff_agendador_tarefas.domain.tarefas.controller;

import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.request.TarefaRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.dto.response.TarefaResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.enums.StatusEnum;
import com.yanvelasco.bff_agendador_tarefas.domain.tarefas.service.TarefaService;
import com.yanvelasco.bff_agendador_tarefas.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefas", description = "API para gerenciamento de tarefas")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    @Operation(summary = "Salvar uma nova tarefa")
    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TarefaResponseDTO> save(
            @RequestBody TarefaRequestDTO tarefaResponseDTO,
            @RequestHeader(value = "Authorization", required = false) String token
    ) {
        return tarefaService.save(tarefaResponseDTO, token);
    }

    @GetMapping("/eventos")
    @Operation(summary = "Buscar tarefas por intervalo de datas")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<List<TarefaResponseDTO>> findByDataEventoBetween(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestParam("dataEventoInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEventoInicial,
            @RequestParam("dataEventoFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEventoFinal
    ) {
        return tarefaService.findByDataEventoBetween(token, dataEventoInicial, dataEventoFinal);
    }

    @GetMapping
    @Operation(summary = "Buscar tarefas por email do usuário")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<List<TarefaResponseDTO>> findByEmailDoUsuario(
            @RequestHeader(value = "Authorization", required = false) String token
    ) {
        return tarefaService.findByEmailDoUsuario(token);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar tarefa por ID")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Void> deletaTarefaPorId(
            @RequestHeader(value = "Authorization", required = false) String token,
            @PathVariable String id
    ) {
        return tarefaService.deletaTarefaPorId(token, id);
    }

    @PatchMapping
    @Operation(summary = "Alterar status da tarefa")
    @ApiResponse(responseCode = "200", description = "Status da tarefa alterado com sucesso")
    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TarefaResponseDTO> alteraStatus(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestParam("status") String status,
            @RequestParam("id") String id
    ) {
        return tarefaService.alterarStatus(token, StatusEnum.valueOf(status), id);
    }

    @PutMapping
    @Operation(summary = "Atualizar tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TarefaResponseDTO> updateDeTarefa(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestBody TarefaRequestDTO tarefaRequestDTO,
            @RequestParam("id") String id
    ) {
        return tarefaService.updateDeTarefa(token, tarefaRequestDTO, id);
    }
}