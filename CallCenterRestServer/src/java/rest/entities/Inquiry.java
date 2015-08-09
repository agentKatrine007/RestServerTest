package rest.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "inquiry")
@XmlRootElement
public class Inquiry implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    public static final String FIELD_idInquiry = "idInquiry";
    public static final String FIELD_customerName = "customerName";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = FIELD_idInquiry)
    private Integer idInquiry;
    
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    
    @Size(max = 45)
    @Column(name = "customerName")
    private String customerName;

   @JoinColumn(name = "Topic_idTopic", referencedColumnName = "idTopic")
   @ManyToOne(optional = false)
    private Topic topicidTopic;

    @JoinColumn(name = "AtribytOfInquiry_idAtribyt", referencedColumnName = "idAtribyt")
    @ManyToOne(optional = false)
    private Atribytofinquiry atribytOfInquiryidAtribyt;

    public Inquiry() {}

    public Inquiry(Integer idInquiry) {
        this.idInquiry = idInquiry;
    }

    public Inquiry(Integer idInquiry, Date createDate) {
        this.idInquiry = idInquiry;
        this.createDate = createDate;
    }

    public Integer getIdInquiry() {
        return idInquiry;
    }

    public void setIdInquiry(Integer idInquiry) {
        this.idInquiry = idInquiry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

   public Topic getTopicidTopic() {
       return topicidTopic;
    }

    public void setTopicidTopic(Topic topicidTopic) {
        this.topicidTopic = topicidTopic;
    }

    public Atribytofinquiry getAtribytOfInquiryidAtribyt() {
       return atribytOfInquiryidAtribyt;
    }

    public void setAtribytOfInquiryidAtribyt(Atribytofinquiry atribytOfInquiryidAtribyt) {
        this.atribytOfInquiryidAtribyt = atribytOfInquiryidAtribyt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInquiry != null ? idInquiry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inquiry)) {
            return false;
        }
        Inquiry other = (Inquiry) object;
        return !((this.idInquiry == null && other.idInquiry != null) || (this.idInquiry != null && !this.idInquiry.equals(other.idInquiry)));
    }

    @Override
    public String toString() {
        return "models.Inquiry[ idInquiry=" + idInquiry + " ]";
    }
    
}
