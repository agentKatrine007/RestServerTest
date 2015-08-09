package rest.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "topic")
@XmlRootElement
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTopic")
    private Integer idTopic;
    
    @Size(max = 45)
    @Column(name = "nameTopic")
    private String nameTopic;
    
    @Size(max = 45)
    @Column(name = "adress")
    private String adress;
    
    @Size(max = 45)
    @Column(name = "model_name")
    private String modelName;

    public Topic() {}

    public Topic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTopic != null ? idTopic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        return !((this.idTopic == null && other.idTopic != null) || (this.idTopic != null && !this.idTopic.equals(other.idTopic)));
    }

    @Override
    public String toString() {
        return "models.Topic[ idTopic=" + idTopic + " ]";
    }
    
}
