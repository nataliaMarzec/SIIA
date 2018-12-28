package ar.sarm.siia.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.sarm.siia.dao.ClienteHome;
import ar.sarm.siia.modelo.Cliente;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class InformacionController {
	@Autowired
	ClienteHome home;
	
	public List<Cliente> getClientes() {
		return home.all();
	}
}
