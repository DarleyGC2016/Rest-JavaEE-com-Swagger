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

import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/enderecos")
@Api(value = "Api Rest Endereco",tags = "Controle de Endereço")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {
	
	
	@Inject
	private EnderecoServico es;
	
	@ApiOperation(value="Lista o(s) Endereço ")
	@GET
	public Response obterListaEndereco() {
		return Response.ok(es.getList().get()).build();
	}
	
	@ApiOperation(value="Cadastra um Endereço ")
	@POST
	public Response salvar(@Valid Endereco endereco) {
		
		return Response.ok(es.salvar(endereco)).build();
	}
	
	@ApiOperation(value="Atualizar um Endereço ")
	@PUT
	public Response atualizar(@Valid Endereco end) {
	    return Response.ok(es.atualizar(end)).build();
	}

	@ApiOperation(value="Excluir um Endereço pelo seu id")
	@DELETE
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		es.remover(id);
	}
	
	@ApiOperation(value="Procurar o Endereço pelo seu id ")
	@GET
	@Path("/{id}")
	public Response getEndereco(@PathParam("id") Long id) {
		//return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(es.encontrar(id).get()).build();
	}
	
	@ApiOperation(value="Procurar um Endereço pelo seu id na query") 
	@GET
	@Path("/procurar")
	public Response findQueryById(@QueryParam("id") Long id) {
		return Response.ok(es.encontrar(id).get()).build();
	}
}
