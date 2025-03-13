package com.yanvelasco.bff_agendador_tarefas.domain.user.service.impl;

import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.EnderecoRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.LoginRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.TelefoneRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.request.UsuarioRequestDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.EnderecoResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.TelefoneResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.response.UsuarioResponseDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.service.UsuarioService;
import com.yanvelasco.bff_agendador_tarefas.infra.client.UsuarioClient;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioServiceImpl(UsuarioClient usuarioClient){
        this.usuarioClient = usuarioClient;
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO usuarioRequestDTO) {
       return usuarioClient.cadastrar(usuarioRequestDTO);
    }

    @Override
    public String login(LoginRequestDTO loginRequestDTO) {
        return usuarioClient.login(loginRequestDTO);
    }


    @Override
    public UsuarioResponseDTO buscarUsuarioPorEmail(String token, String email) {
       return usuarioClient.buscaUsuarioPorEmail(token,email);
    }

    @Override
    public void deletaUsuarioPorEmail(String token, String email) {
        usuarioClient.deletaUsuarioPorEmail(token, email);
    }

    @Override
    public UsuarioResponseDTO atualizarDadosDoUsuario(String token, UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioClient.atualizarDadosDoUsuario(token, usuarioRequestDTO);
    }

    @Override
    public EnderecoResponseDTO atualizarEndereco(String token, Long id, EnderecoRequestDTO enderecoRequestDTO) {
        return usuarioClient.atualizarEndereco(token, id, enderecoRequestDTO);
    }

    @Override
    public TelefoneResponseDTO atualizarTelefone(String token, Long id, TelefoneRequestDTO telefoneRequestDTO) {
       return usuarioClient.atualizarTelefone(token, id, telefoneRequestDTO);
    }

    @Override
    public EnderecoResponseDTO cadastrarEndereco(String token, EnderecoRequestDTO enderecoRequestDTO) {
        return usuarioClient.cadastrarEndereco(token, enderecoRequestDTO);
    }

    @Override
    public TelefoneResponseDTO cadastrarTelefone(String token, TelefoneRequestDTO telefoneRequestDTO) {
        return usuarioClient.cadastrarTelefone(token, telefoneRequestDTO);
    }
}