package ar.sarm.siia.wicket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.siia.controllers.InformacionController;
import ar.sarm.siia.modelo.Cliente;

public class InformacionPage extends LayoutPage {
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	InformacionController controller;
	
	public InformacionPage() {
		this.listadoClientes();
	}
	
	public void listadoClientes() {
		this.add(new ListView<Cliente>("clientes", new PropertyModel<>(this.controller, "clientes")) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Cliente> item) {
				Cliente clienteNombre = item.getModelObject();
				CompoundPropertyModel<Cliente> cliente = new CompoundPropertyModel<>(clienteNombre);
				item.add(new Label("nombre", cliente.bind("fullname")));
				//item.add(new ExternalLink("numero", clienteNombre.getLink(), clienteNombre.getFullName()));
			}
		});
	}
}
