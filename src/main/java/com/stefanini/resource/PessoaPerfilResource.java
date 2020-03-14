package com.stefanini.resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.model.PessoaPerfil;
import com.stefanini.servico.PessoaPerfilServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/pessoasperfis")
@Api(value = "Api Rest Pessoa",tags = "Controle de Pessoa e Perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaPerfilResource {
     
	@Inject
	private PessoaPerfilServico pps;
	
	@ApiOperation(value="Cadastra uma Pessoa ")
	@POST
	public Response salvar(@Valid PessoaPerfil pessoaPerfil) {
		
		return Response.ok(pps.salvar(pessoaPerfil)).build();
	}
	
	@ApiOperation(value="Atualizar uma Pessoa e seu Perfil ")
	@PUT
	public Response atualizar(@Valid PessoaPerfil pessoaPerfil) {
	    return Response.ok(pps.atualizar(pessoaPerfil)).build();
	}
	
	@ApiOperation(value="Excluir uma Pessoa e seu Perfil pelo seu id")
	@DELETE
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		pps.remover(id);
	}
	
	
}
