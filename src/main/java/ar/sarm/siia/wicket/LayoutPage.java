package ar.sarm.siia.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public abstract class LayoutPage extends WebPage {
	public LayoutPage() {
		this.agregarLink("homePage", HomePage.class);
		this.agregarLink("informacionPage", InformacionPage.class);
	}
	
	private void agregarLink(String nombre, Class<? extends Page> pageClass) {
		this.add(new Link<String>(nombre) {
			@Override
			public void onClick() {
				this.setResponsePage(pageClass);
			}
		});
	}
}
