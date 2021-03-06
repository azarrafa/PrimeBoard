package manage.appli.patri.awb.modele;

// Generated 27 avr. 2012 17:38:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsePanelId generated by hbm2java
 */
@Embeddable
public class UsePanelId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3994526551148011627L;
	private String panel;
	private String version;
	private String calledPgmName;
	private String calledPgmVers;
	private String calledPgmSys;

	public UsePanelId() {
	}

	public UsePanelId(String calledPgmName, String calledPgmVers,
			String calledPgmSys) {
		this.calledPgmName = calledPgmName;
		this.calledPgmVers = calledPgmVers;
		this.calledPgmSys = calledPgmSys;
	}

	public UsePanelId(String panel, String version, String calledPgmName,
			String calledPgmVers, String calledPgmSys) {
		this.panel = panel;
		this.version = version;
		this.calledPgmName = calledPgmName;
		this.calledPgmVers = calledPgmVers;
		this.calledPgmSys = calledPgmSys;
	}

	@Column(name = "PANEL", length = 50)
	public String getPanel() {
		return this.panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	@Column(name = "VERSION", length = 50)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "CALLED_PGM_NAME", nullable = false, length = 50)
	public String getCalledPgmName() {
		return this.calledPgmName;
	}

	public void setCalledPgmName(String calledPgmName) {
		this.calledPgmName = calledPgmName;
	}

	@Column(name = "CALLED_PGM_VERS", nullable = false, length = 50)
	public String getCalledPgmVers() {
		return this.calledPgmVers;
	}

	public void setCalledPgmVers(String calledPgmVers) {
		this.calledPgmVers = calledPgmVers;
	}

	@Column(name = "CALLED_PGM_SYS", nullable = false, length = 50)
	public String getCalledPgmSys() {
		return this.calledPgmSys;
	}

	public void setCalledPgmSys(String calledPgmSys) {
		this.calledPgmSys = calledPgmSys;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsePanelId))
			return false;
		UsePanelId castOther = (UsePanelId) other;

		return ((this.getPanel() == castOther.getPanel()) || (this.getPanel() != null
				&& castOther.getPanel() != null && this.getPanel().equals(
				castOther.getPanel())))
				&& ((this.getVersion() == castOther.getVersion()) || (this
						.getVersion() != null && castOther.getVersion() != null && this
						.getVersion().equals(castOther.getVersion())))
				&& ((this.getCalledPgmName() == castOther.getCalledPgmName()) || (this
						.getCalledPgmName() != null
						&& castOther.getCalledPgmName() != null && this
						.getCalledPgmName()
						.equals(castOther.getCalledPgmName())))
				&& ((this.getCalledPgmVers() == castOther.getCalledPgmVers()) || (this
						.getCalledPgmVers() != null
						&& castOther.getCalledPgmVers() != null && this
						.getCalledPgmVers()
						.equals(castOther.getCalledPgmVers())))
				&& ((this.getCalledPgmSys() == castOther.getCalledPgmSys()) || (this
						.getCalledPgmSys() != null
						&& castOther.getCalledPgmSys() != null && this
						.getCalledPgmSys().equals(castOther.getCalledPgmSys())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPanel() == null ? 0 : this.getPanel().hashCode());
		result = 37 * result
				+ (getVersion() == null ? 0 : this.getVersion().hashCode());
		result = 37
				* result
				+ (getCalledPgmName() == null ? 0 : this.getCalledPgmName()
						.hashCode());
		result = 37
				* result
				+ (getCalledPgmVers() == null ? 0 : this.getCalledPgmVers()
						.hashCode());
		result = 37
				* result
				+ (getCalledPgmSys() == null ? 0 : this.getCalledPgmSys()
						.hashCode());
		return result;
	}

}
