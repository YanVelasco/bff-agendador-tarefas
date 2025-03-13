package com.yanvelasco.bff_agendador_tarefas.domain.user.service.impl;

import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.EnderecoDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.TelefoneDTO;
import com.yanvelasco.bff_agendador_tarefas.domain.user.dto.UsuarioDTO;
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
    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {
       return usuarioClient.cadastrar(usuarioDTO);
    }

    @Override
    public String login(UsuarioDTO usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }


    @Override
    public UsuarioDTO buscarUsuarioPorEmail(String token,String email) {
       return usuarioClient.buscaUsuarioPorEmail(token,email);
    }

    @Override
    public void deletaUsuarioPorEmail(String token, String email) {
        usuarioClient.deletaUsuarioPorEmail(token, email);
    }

    @Override
    public UsuarioDTO atualizarDadosDoUsuario(String token, UsuarioDTO usuarioDTO) {
        return usuarioClient.atualizarDadosDoUsuario(token, usuarioDTO);
    }

    @Override
    public EnderecoDTO atualizarEndereco(String token,Long id, EnderecoDTO enderecoDTO) {
        return usuarioClient.atualizarEndereco(token, id, enderecoDTO);
    }

    @Override
    public TelefoneDTO atualizarTelefone(String token, Long id, TelefoneDTO telefoneDTO) {
       return usuarioClient.atualizarTelefone(token, id, telefoneDTO);
    }

    @Override
    public EnderecoDTO cadastrarEndereco(String token, EnderecoDTO enderecoDTO) {
        return usuarioClient.cadastrarEndereco(token, enderecoDTO);
    }

    @Override
    public TelefoneDTO cadastrarTelefone(String token, TelefoneDTO telefoneDTO) {
        return usuarioClient.cadastrarTelefone(token, telefoneDTO);
    }
}