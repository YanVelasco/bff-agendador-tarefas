package com.yanvelasco.bff_agendador_tarefas.domain.user.controller;


import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.EnderecoRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.LoginRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.TelefoneRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.UsuarioRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.EnderecoResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.TelefoneResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.UsuarioResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "API para gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já existe")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.cadastrar(usuarioRequestDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuário", description = "Login do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Crendênciais invalidas")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(usuarioService.login(loginRequestDTO));
    }

    @GetMapping
    @Operation(summary = "Buscar dados de usuários por email", description = "Buscar dados do usuário por email")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<UsuarioResponseDTO> buscaUsuarioPorEmail(
            @RequestHeader("Authorization") String token,
            @RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(token, email));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar usuário por email", description = "Deletar usuário por email")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Void> deletaUsuarioPorEmail(
            @RequestHeader("Authorization") String token,
            @PathVariable String email) {
        usuarioService.deletaUsuarioPorEmail(token, email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar dados do usuário", description = "Atualizar dados do usuário")
    @ApiResponse(responseCode = "200", description = "Dados do usuário atualizados com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<UsuarioResponseDTO> atualizarDadosDoUsuario(
            @RequestHeader("Authorization") String token,
            @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.atualizarDadosDoUsuario(token, usuarioRequestDTO));
    }

    @PutMapping("/endereco/{id}")
    @Operation(summary = "Atualizar endereço do usuário", description = "Atualizar endereço do usuário")
    @ApiResponse(responseCode = "200", description = "Endereço do usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        return ResponseEntity.ok(usuarioService.atualizarEndereco(token, id, enderecoRequestDTO));
    }

    @PutMapping("/telefone/{id}")
    @Operation(summary = "Atualizar telefone do usuário", description = "Atualizar telefone do usuário")
    @ApiResponse(responseCode = "200", description = "Telefone do usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TelefoneResponseDTO> atualizarTelefone(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @RequestBody TelefoneRequestDTO telefoneRequestDTO) {
        return ResponseEntity.ok(usuarioService.atualizarTelefone(token, id, telefoneRequestDTO));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Cadastrar endereço do usuário", description = "Cadastrar endereço do usuário")
    @ApiResponse(responseCode = "200", description = "Endereço do usuário cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<EnderecoResponseDTO> cadastrarEndereco(
            @RequestHeader("Authorization") String token,
            @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        return ResponseEntity.ok(usuarioService.cadastrarEndereco(token, enderecoRequestDTO));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Cadastrar telefone do usuário", description = "Cadastrar telefone do usuário")
    @ApiResponse(responseCode = "200", description = "Telefone do usuário cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<TelefoneResponseDTO> cadastrarTelefone(
            @RequestHeader("Authorization") String token,
            @RequestBody TelefoneRequestDTO telefoneRequestDTO) {
        return ResponseEntity.ok(usuarioService.cadastrarTelefone(token, telefoneRequestDTO));
    }
}