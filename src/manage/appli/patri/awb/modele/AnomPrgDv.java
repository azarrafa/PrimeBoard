package manage.appli.patri.awb.modele;

// Generated 27 avr. 2012 17:38:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AnomPrgDv generated by hbm2java
 */
@Entity
@Table(name = "ANOM_PRG_DV", schema = "INTEGRATEUR")
public class AnomPrgDv implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2561890427281530051L;
	private AnomPrgDvId id;

	public AnomPrgDv() {
	}

	public AnomPrgDv(AnomPrgDvId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dataview", column = @Column(name = "DATAVIEW", length = 50)),
			@AttributeOverride(name = "programs", column = @Column(name = "PROGRAMS", length = 50)),
			@AttributeOverride(name = "version", column = @Column(name = "VERSION", length = 10)),
			@AttributeOverride(name = "system", column = @Column(name = "SYSTEM", length = 10)) })
	public AnomPrgDvId getId() {
		return this.id;
	}

	public void setId(AnomPrgDvId id) {
		this.id = id;
	}

}