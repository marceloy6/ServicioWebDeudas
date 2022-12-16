/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "pago")
@Cacheable(false)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
        , @NamedQuery(name = "Pago.findByIdCliente", query = "SELECT p FROM Pago p WHERE p.iddeuda.idcliente.idcliente = :idcliente")       
    , @NamedQuery(name = "Pago.findByIdpago", query = "SELECT p FROM Pago p WHERE p.idpago = :idpago")
    , @NamedQuery(name = "Pago.findByMonto", query = "SELECT p FROM Pago p WHERE p.monto = :monto")
    , @NamedQuery(name = "Pago.findByFechapago", query = "SELECT p FROM Pago p WHERE p.fechapago = :fechapago")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Long idpago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    
    @Size(max = 30)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 60)
    @Column(name = "tipopago")
    private String tipopago;
    @Size(max = 200)
    @Column(name = "lugarpago")
    private String lugarpago;
    
    @Column(name = "fechapago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @JoinColumn(name = "iddeuda", referencedColumnName = "iddeuda")
    @ManyToOne
    private Deuda iddeuda;

    public Pago() {
    }

    public Pago(Long idpago) {
        this.idpago = idpago;
    }

    public Long getIdpago() {
        return idpago;
    }

    public void setIdpago(Long idpago) {
        this.idpago = idpago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }
    
    

    public String getLugarpago() {
        return lugarpago;
    }

    public void setLugarpago(String lugarpago) {
        this.lugarpago = lugarpago;
    }
    
    

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
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
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Pago[ idpago=" + idpago + " ]";
    }
    
}
