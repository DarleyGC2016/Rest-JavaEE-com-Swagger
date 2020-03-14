package com.stefanini.resource;

import java.util.List;

import javax.inject.Inject;
import javax.sound.sampled.LineListener;
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
import javax.ws.rs.core.Response.Status;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Path("/pessoas")
@Api(value = "Api Rest Pessoa",tags = "Controle de Pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

	@Inject
	private PessoaServico pessoaServico;
	
	
	@Path("/listar")
	@ApiOperation(value="Lista a(s) Pessoa ")
	@GET
	public Response obterListaPessoa() {
		return Response.ok(pessoaServico.getList().get()).build();
	}
	@ApiOperation(value="Cadastra uma Pessoa ")
	@POST
	public Response salvar(@Valid Pessoa pessoa) {
		
		return Response.ok(pessoaServico.salvar(pessoa)).build();
	}
	
	@ApiOperation(value="Atualizar uma Pessoa ")
	@PUT
	public Response atualizar(@Valid Pessoa pessoa) {
	    return Response.ok(pessoaServico.atualizar(pessoa)).build();
	}
	@ApiOperation(value="Excluir uma Pessoa pelo seu id")
	@DELETE
	@Path("/{id}")
	public void apagar(@PathParam("id") Long id) {
		pessoaServico.remover(id);
	}
	@ApiOperation(value="Procurar uma Pessoa pelo seu id")
	@GET
	@Path("/{id}")
	public Response obterPessoa(@PathParam("id") Long id) {
		//return Response.status(Status.INTERNAL_SERVER_ERROR).entity("deu ruim").build();
		return Response.ok(pessoaServico.encontrar(id).get()).build();
	}
	
	@ApiOperation(value="Procurar uma Pessoa pelo seu id na query") 
	@GET
	@Path("/procurar")
	public Response findQueryById(@QueryParam("id") Long id) {
		return Response.ok(pessoaServico.encontrar(id).get()).build();
	}
	
}
