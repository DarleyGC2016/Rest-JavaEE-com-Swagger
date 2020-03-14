package com.stefanini.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.resource.util.ObjectMapperContextResolver;
import com.stefanini.servico.PerfilServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/perfis")
@Api(value = "Api Rest Perfil",tags = "Controle de Perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {
	@Inject
	private PerfilServico ps;
	
	@ApiOperation(value="Lista o(s) Perfil ")
	@GET
	public Response obterListaEndereco() {
		return Response.ok(ps.getList().get()).build();
	}
	
	
	@ApiOperation(value="Cadastra um Perfil ")
	@POST
	public Response salvar(@Valid Perfil perfil) {
		
		return Response.ok(ps.salvar(perfil)).build();
	}
	
	@ApiOperation(value="Atualizar um Perfil ")
	@PUT
	public Response atualizar(@Valid Perfil perfil) {
	    return Response.ok(ps.atualizar(perfil)).build();
	}

	@ApiOperation(value="Excluir um Perfil pelo seu id")
	@DELETE
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		ps.remover(id);
	}
	
	@ApiOperation(value="Procurar o Perfil pelo seu id ")
	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		//return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(ps.encontrar(id).get()).build();
	}
	
	@ApiOperation(value="Procurar um Perfil pelo seu id na query") 
	@GET
	@Path("/procurar")
	public Response findQueryById(@QueryParam("id") Long id) {
		return Response.ok(ps.encontrar(id).get()).build();
	}
}
