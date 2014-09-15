package manage.appli.patri.awb.modele;

// Generated 27 avr. 2012 17:38:38 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UseReport generated by hbm2java
 */
@Entity
@Table(name = "USE_REPORT", schema = "INTEGRATEUR")
public class UseReport implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1952753256979989782L;
	private UseReportId id;
	private Programs programs;

	public UseReport() {
	}

	public UseReport(UseReportId id, Programs programs) {
		this.id = id;
		this.programs = programs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "report", column = @Column(name = "REPORT", length = 50)),
			@AttributeOverride(name = "version", column = @Column(name = "VERSION", length = 50)),
			@AttributeOverride(name = "calledPgmName", column = @Column(name = "CALLED_PGM_NAME", nullable = false, length = 50)),
			@AttributeOverride(name = "calledPgmVers", column = @Column(name = "CALLED_PGM_VERS", nullable = false, length = 50)),
			@AttributeOverride(name = "calledPgmSys", column = @Column(name = "CALLED_PGM_SYS", nullable = false, length = 50)) })
	public UseReportId getId() {
		return this.id;
	}

	public void setId(UseReportId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CALLED_PGM_NAME", referencedColumnName = "NAME", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CALLED_PGM_VERS", referencedColumnName = "VERSION", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CALLED_PGM_SYS", referencedColumnName = "SYSTEM", nullable = false, insertable = false, updatable = false) })
	public Programs getPrograms() {
		return this.programs;
	}

	public void setPrograms(Programs programs) {
		this.programs = programs;
	}

}