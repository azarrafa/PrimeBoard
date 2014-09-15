/*
 * Copyright (C) 2012 Scalaris AG, Germany. All rights reserved.
 *
 * $Id: ThemeConverter.java 984 2012-02-29 10:50:54Z ovaraksin@gmail.com $
 */

package manage.appli.patri.awb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import manage.appli.patri.awb.model.system.AvailableThemes;
import manage.appli.patri.awb.model.system.Theme;

/**
 * ThemeConverter
 *
 * @author  Oleg Varaksin / last modified by $Author: ovaraksin@gmail.com $
 * @version $Revision: 984 $
 */
@FacesConverter("manage.appli.patri.awb.converter.ThemeConverter")
public class ThemeConverter implements Converter {

	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		return AvailableThemes.getInstance().getThemeForName(value);
	}

	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		return ((Theme) value).getName();
	}
}
