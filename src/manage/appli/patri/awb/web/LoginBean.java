package manage.appli.patri.awb.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.faces.application.FacesMessage;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import manage.appli.patri.awb.service.AuthenticationService;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient AuthenticationService authenticationService;

	FileWriter out;
	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws IOException {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = false;

		boolean success = authenticationService.login(username, password);
		out = new FileWriter(new File(
				"E:\\JbossAS7.1.0\\standalone\\log\\count.txt"), true);

		HttpServletRequest resqu = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String ip = resqu.getRemoteAddr();
		Date datedep = new Date();
		Locale locale = Locale.getDefault();
		DateFormat formath = DateFormat.getTimeInstance(DateFormat.MEDIUM,
				locale);
		DateFormat formad = new SimpleDateFormat("yyyy-MM-dd");
		if (username != null && success && password != null) {
			loggedIn = true;

			out.write("\n" + ip + " " + username + " log in "
					+ formad.format(datedep) + " "
					+ formath.format(datedep.getTime()));

			out.close();
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome",
					username);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", loggedIn);
			return "/views/home.jsf?faces-redirect=true";

		} else {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
					"Invalid credentials");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", loggedIn);
			out.write("\n" + ip + " " + username +" "+ password+" Invalid credentials "
					+ formad.format(datedep) + " "
					+ formath.format(datedep.getTime()));
			out.close();
			return "/login.jsf";
		}

	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "/logout.jsf?faces-redirect=true";
	}

	public void addInfo(ActionEvent actionEvent) {
		// FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
		// "System Error", "Please try again later.");

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Sample info message", "PrimeFaces rocks!"));
	}

}
