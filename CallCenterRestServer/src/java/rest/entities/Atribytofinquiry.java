package rest.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "atribytofinquiry")
public class Atribytofinquiry implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAtribyt")
    private Integer idAtribyt;
    
    @Size(max = 45)
    @Column(name = "value")
    private String value;

    public Atribytofinquiry() {}

    public Atribytofinquiry(Integer idAtribyt) {
        this.idAtribyt = idAtribyt;
    }

    public Integer getIdAtribyt() {
        return idAtribyt;
    }

    public void setIdAtribyt(Integer idAtribyt) {
        this.idAtribyt = idAtribyt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtribyt != null ? idAtribyt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atribytofinquiry)) {
            return false;
        }
        Atribytofinquiry other = (Atribytofinquiry) object;
        return !((this.idAtribyt == null && other.idAtribyt != null) || (this.idAtribyt != null && !this.idAtribyt.equals(other.idAtribyt)));
    }

    @Override
    public String toString() {
        return "models.Atribytofinquiry[ idAtribyt=" + idAtribyt + " ]";
    }
    
}
