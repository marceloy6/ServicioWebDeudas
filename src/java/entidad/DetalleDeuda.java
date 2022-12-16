/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "detalle_deuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDeuda.findAll", query = "SELECT d FROM DetalleDeuda d")
        , @NamedQuery(name = "DetalleDeuda.findByIdDeuda", query = "SELECT d FROM DetalleDeuda d WHERE d.iddeuda.iddeuda = :iddeuda")
    , @NamedQuery(name = "DetalleDeuda.findByIdDd", query = "SELECT d FROM DetalleDeuda d WHERE d.idDd = :idDd")
    , @NamedQuery(name = "DetalleDeuda.findByMonto", query = "SELECT d FROM DetalleDeuda d WHERE d.monto = :monto")})
public class DetalleDeuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dd")
    private Long idDd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @JoinColumn(name = "idconcepto", referencedColumnName = "idconcepto")
    @ManyToOne(optional = false)
    private Concepto idconcepto;
    @JoinColumn(name = "iddeuda", referencedColumnName = "iddeuda")
    @ManyToOne(optional = false)
    private Deuda iddeuda;

    public DetalleDeuda() {
    }

    public DetalleDeuda(Long idDd) {
        this.idDd = idDd;
    }

    public Long getIdDd() {
        return idDd;
    }

    public void setIdDd(Long idDd) {
        this.idDd = idDd;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Concepto getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Concepto idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Deuda getIddeuda() {
        return iddeuda;
    }

    public void setIddeuda(Deuda iddeuda) {
        this.iddeuda = iddeuda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDd != null ? idDd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDeuda)) {
            return false;
        }
        DetalleDeuda other = (DetalleDeuda) object;
        if ((this.idDd == null && other.idDd != null) || (this.idDd != null && !this.idDd.equals(other.idDd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.DetalleDeuda[ idDd=" + idDd + " ]";
    }
    
}
