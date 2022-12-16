/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "concepto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concepto.findAll", query = "SELECT c FROM Concepto c")
    , @NamedQuery(name = "Concepto.findByIdconcepto", query = "SELECT c FROM Concepto c WHERE c.idconcepto = :idconcepto")
    , @NamedQuery(name = "Concepto.findByNombre", query = "SELECT c FROM Concepto c WHERE c.nombre = :nombre")})
public class Concepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconcepto")
    private Long idconcepto;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconcepto")
    private Collection<DetalleDeuda> detalleDeudaCollection;

    public Concepto() {
    }

    public Concepto(Long idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Long getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Long idconcepto) {
        this.idconcepto = idconcepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<DetalleDeuda> getDetalleDeudaCollection() {
        return detalleDeudaCollection;
    }

    public void setDetalleDeudaCollection(Collection<DetalleDeuda> detalleDeudaCollection) {
        this.detalleDeudaCollection = detalleDeudaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconcepto != null ? idconcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concepto)) {
            return false;
        }
        Concepto other = (Concepto) object;
        if ((this.idconcepto == null && other.idconcepto != null) || (this.idconcepto != null && !this.idconcepto.equals(other.idconcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Concepto[ idconcepto=" + idconcepto + " ]";
    }
    
}
