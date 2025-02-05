package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "marcas")
public class Marca {
	@Id
	@Column(nullable = false)
	private String codigo;
	private String nombreComercial;
	@ManyToOne
	@JoinColumn(name = "cod_pais", nullable = false)
	private Pais pais;
	@ManyToMany
	@JoinTable(name = "centro_comercial_marcas",
			joinColumns = {@JoinColumn(name = "cod_marca", nullable = false)},
			inverseJoinColumns = {@JoinColumn(name = "uuid_centro", nullable = false)})
	private List<CentroComercial> centrosComerciales;
	
	
	public Marca() {
		super();
	}
	public Marca(String codigo, String nombreComercial, Pais pais) {
		super();
		this.codigo = codigo;
		this.nombreComercial = nombreComercial;
		this.pais = pais;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public List<CentroComercial> getCentrosComerciales() {
		return centrosComerciales;
	}
	public void setCentrosComerciales(List<CentroComercial> centrosComerciales) {
		this.centrosComerciales = centrosComerciales;
	}
	@Override
	public String toString() {
		return "Marca [codigo=" + codigo + ", nombreComercial=" + nombreComercial + ", pais=" + pais + "]";
	}
	
	
	

}
