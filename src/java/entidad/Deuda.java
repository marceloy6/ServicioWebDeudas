/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "deuda")
@Cacheable(false)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deuda.findAll", query = "SELECT d FROM Deuda d")
    , @NamedQuery(name = "Deuda.findByIddeuda", query = "SELECT d FROM Deuda d WHERE d.iddeuda = :iddeuda")
        , @NamedQuery(name = "Deuda.findByIdcliente", query = "SELECT d FROM Deuda d WHERE d.idcliente.idcliente = :idcliente")
        , @NamedQuery(name = "Deuda.actualizarDeuda", query = "UPDATE Deuda d SET d.pagado = true WHERE d.iddeuda = :iddeuda")
    , @NamedQuery(name = "Deuda.findByMontototal", query = "SELECT d FROM Deuda d WHERE d.montototal = :montototal")
    , @NamedQuery(name = "Deuda.findByFecharegistro", query = "SELECT d FROM Deuda d WHERE d.fecharegistro = :fecharegistro")})
public class Deuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddeuda")
    private Long iddeuda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montototal")
    private Double montototal;
    @Size(max = 30)
    @Column(name = "moneda")
    private String moneda;
    
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    
    @Column(name = "pagado")
    private boolean pagado;
    
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente idcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddeuda")
    private Collection<DetalleDeuda> detalleDeudaCollection;
    @OneToMany(mappedBy = "iddeuda")
    private Collection<Pago> pagoCollection;

    public Deuda() {
    }

    public Deuda(Long iddeuda) {
        this.iddeuda = iddeuda;
    }

    public Long getIddeuda() {
        return iddeuda;
    }

    public void setIddeuda(Long iddeuda) {
        this.iddeuda = iddeuda;
    }

    public Double getMontototal() {
        return montototal;
    }

    public void setMontototal(Double montototal) {
        this.montototal = montototal;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }
    
    

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    
    

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public Collection<DetalleDeuda> getDetalleDeudaCollection() {
        return detalleDeudaCollection;
    }

    public void setDetalleDeudaCollection(Collection<DetalleDeuda> detalleDeudaCollection) {
        this.detalleDeudaCollection = detalleDeudaCollection;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddeuda != null ? iddeuda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deuda)) {
            return false;
        }
        Deuda other = (Deuda) object;
        if ((this.iddeuda == null && other.iddeuda != null) || (this.iddeuda != null && !this.iddeuda.equals(other.iddeuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Deuda[ iddeuda=" + iddeuda + " ]";
    }
    
}
