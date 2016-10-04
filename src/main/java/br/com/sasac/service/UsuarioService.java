/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.service;

import br.com.sasac.DTO.UsuarioDTO;
import br.com.sasac.model.Usuario;
import java.util.List;

/**
 *
 * @author Matheus Herculano
 */
public interface UsuarioService {
    
    UsuarioDTO getUsuarioPeriodo(Long idUsuario);
}
