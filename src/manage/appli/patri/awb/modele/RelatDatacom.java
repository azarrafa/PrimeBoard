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
 * RelatDatacom generated by hbm2java
 */
@Entity
@Table(name = "RELAT_DATACOM", schema = "INTEGRATEUR")
public class RelatDatacom implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -317437264175300192L;
	private RelatDatacomId id;
	private DataviewDatacom dataviewDatacom;
	private Programs programs;

	public RelatDatacom() {
	}

	public RelatDatacom(RelatDatacomId id, DataviewDatacom dataviewDatacom,
			Programs programs) {
		this.id = id;
		this.dataviewDatacom = dataviewDatacom;
		this.programs = programs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dataview", column = @Column(name = "DATAVIEW", nullable = false, length = 50)),
			@AttributeOverride(name = "programs", column = @Column(name = "PROGRAMS", nullable = false, length = 50)),
			@AttributeOverride(name = "versionPg", column = @Column(name = "VERSION_PG", nullable = false, length = 50)),
			@AttributeOverride(name = "system", column = @Column(name = "SYSTEM", nullable = false, length = 50)) })
	public RelatDatacomId getId() {
		return this.id;
	}

	public void setId(RelatDatacomId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DATAVIEW", nullable = false, insertable = false, updatable = false)
	public DataviewDatacom getDataviewDatacom() {
		return this.dataviewDatacom;
	}

	public void setDataviewDatacom(DataviewDatacom dataviewDatacom) {
		this.dataviewDatacom = dataviewDatacom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "PROGRAMS", referencedColumnName = "NAME", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "VERSION_PG", referencedColumnName = "VERSION", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "SYSTEM", referencedColumnName = "SYSTEM", nullable = false, insertable = false, updatable = false) })
	public Programs getPrograms() {
		return this.programs;
	}

	public void setPrograms(Programs programs) {
		this.programs = programs;
	}

}