/*
 * Copyright 2011 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id: TechnicalInfo.java 1068 2012-03-16 14:29:33Z ovaraksin@gmail.com $
 */

package manage.appli.patri.awb.webapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

/**
 * TechnicalInfo.
 *
 * @author  Oleg Varaksin / last modified by $Author: ovaraksin@gmail.com $
 * @version $Revision: 1068 $
 */

@Component("technicalInfo")
@ApplicationScoped
public class TechnicalInfo {

	private static final Logger LOGGER = Logger.getLogger(TechnicalInfo.class.getName());
	private String primeFaces;
	private String primeFacesExt;
	private String jsfImpl;
	private String server;
	private String revision;
	private String buildTime;
	private boolean online = false;
	private boolean mojarra = true;

	//mfenoglio
	private List<String> newComponents = new ArrayList<String>();
	private List<String> updatedComponents = new ArrayList<String>();

	@PostConstruct
	protected void initialize() {
		
			

			primeFaces = "Developed by  : Attijariwafa";
			primeFacesExt = "version: 1.0 " ;
			jsfImpl = "" ;
			server = "mail : a.zarrafa@gmail.com " ;
			revision = " " ;

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Calendar calendar = Calendar.getInstance();
			//calendar.getTime();
			//calendar.setTimeInMillis(Long.valueOf(appProperties.get("timestamp")));
			buildTime = "Date: " + formatter.format(calendar.getTime());

			online = Boolean.valueOf(true);
		

		
	}

	public boolean isOnline() {
		return online;
	}

	public String getPrimeFaces() {
		return primeFaces;
	}

	public String getPrimeFacesExt() {
		return primeFacesExt;
	}

	public String getJsfImpl() {
		return jsfImpl;
	}

	public String getServer() {
		return server;
	}

	public String getRevision() {
		return revision;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public boolean isMojarra() {
		return mojarra;
	}

	public String getMenuitemIconStyleClass(final String page) {
		if (newComponents.contains(page)) {
			return "ui-icon-new-comp";
		}

		if (updatedComponents.contains(page)) {
			return "ui-icon-updated-comp";
		}

		return "ui-icon-none";
	}

	private void proccessNewsComponents(String newComp, String updatedComp) {
		try {
			String[] newCompArray = newComp.split(";");
			Collections.addAll(newComponents, newCompArray);

			String[] updatedCompArray = updatedComp.split(";");
			Collections.addAll(updatedComponents, updatedCompArray);
		} catch (Exception ex) {
			this.newComponents = new ArrayList<String>();
			this.updatedComponents = new ArrayList<String>();
		}
	}
}
