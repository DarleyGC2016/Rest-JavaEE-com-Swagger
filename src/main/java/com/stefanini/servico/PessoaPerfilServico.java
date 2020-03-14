package com.stefanini.servico;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaPerfilDao;
import com.stefanini.model.PessoaPerfil;
import com.stefanini.util.IGenericService;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaPerfilServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaPerfilDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	//@Override
	public Optional<PessoaPerfil> salvar(@Valid PessoaPerfil entity) {
		// TODO Auto-generated method stub
		return dao.salvar(entity);
	}

	//@Override
	public Optional<PessoaPerfil> atualizar(@Valid PessoaPerfil entity) {
		// TODO Auto-generated method stub
		return dao.atualizar(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	//@Override
	public void remover(@Valid Long id) {
		// TODO Auto-generated method stub
        dao.remover(id);
	}

	//@Override
	public Optional<List<PessoaPerfil>> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	//@Override
	public Optional<PessoaPerfil> encontrar(Long id) {
		// TODO Auto-generated method stub
		return dao.encontrar(id);
	}

}
