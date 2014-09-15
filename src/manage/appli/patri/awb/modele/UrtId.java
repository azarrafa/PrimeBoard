package manage.appli.patri.awb.modele;

// Generated 27 avr. 2012 17:38:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UrtId generated by hbm2java
 */
@Embeddable
public class UrtId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3654367444320608871L;
	private String jobAppel;
	private String urt;

	public UrtId() {
	}

	public UrtId(String jobAppel) {
		this.jobAppel = jobAppel;
	}

	public UrtId(String jobAppel, String urt) {
		this.jobAppel = jobAppel;
		this.urt = urt;
	}

	@Column(name = "JOB_APPEL", nullable = false, length = 50)
	public String getJobAppel() {
		return this.jobAppel;
	}

	public void setJobAppel(String jobAppel) {
		this.jobAppel = jobAppel;
	}

	@Column(name = "URT", length = 50)
	public String getUrt() {
		return this.urt;
	}

	public void setUrt(String urt) {
		this.urt = urt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UrtId))
			return false;
		UrtId castOther = (UrtId) other;

		return ((this.getJobAppel() == castOther.getJobAppel()) || (this
				.getJobAppel() != null && castOther.getJobAppel() != null && this
				.getJobAppel().equals(castOther.getJobAppel())))
				&& ((this.getUrt() == castOther.getUrt()) || (this.getUrt() != null
						&& castOther.getUrt() != null && this.getUrt().equals(
						castOther.getUrt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getJobAppel() == null ? 0 : this.getJobAppel().hashCode());
		result = 37 * result
				+ (getUrt() == null ? 0 : this.getUrt().hashCode());
		return result;
	}

}