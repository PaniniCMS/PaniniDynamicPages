package com.mrpowergamerbr.paninidynamicpages;

import com.mitchellbosecke.pebble.template.PebbleTemplate;
import com.paninicms.Panini;
import com.paninicms.plugin.PaniniPlugin;
import com.paninicms.plugin.event.Listener;
import com.paninicms.plugin.event.SubscribeEvent;
import com.paninicms.plugin.event.blog.PostRenderEvent;

public class PaniniDynamicPages extends PaniniPlugin implements Listener {
	@Override
	public void onEnable() {
		System.out.println("PaniniDynamicPages by MrPowerGamerBR");
		this.registerListener(this);
	}

	@SubscribeEvent
	public void onPostRender(PostRenderEvent ev) {
		if (ev.getTemplate() == null) { // If the template is null...
			// Try loading our own custom PebbleTemplate!
			try {
				PebbleTemplate template = Panini.getEngine().getTemplate("custom/" + ev.getRenderContext().arguments()[0] + ".html");
				ev.setTemplate(template);
			} catch (Exception e) {}
		}
	}
}