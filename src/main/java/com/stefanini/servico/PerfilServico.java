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

import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Perfil;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PerfilServico implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private PerfilDao dao;
	
	
//	@Override
	public Optional<Perfil>  salvar(Perfil entity) {
		return dao.salvar(entity);
	}

	//@Override
	public Optional<Perfil> atualizar(Perfil entity) {
		return dao.atualizar(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	//@Override
	public void remover(@Valid Long id) {
		dao.remover(id);
	}

	//@Override
	public Optional<List<Perfil>> getList() {
		return dao.getList();
	}

	//@Override
	public Optional<Perfil> encontrar(Long id) {
		return dao.encontrar(id);
	}

}
