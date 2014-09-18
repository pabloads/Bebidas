/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo Rocha
 */
@Entity
@Table(name = "distribuidora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidora.findAll", query = "SELECT d FROM Distribuidora d"),
    @NamedQuery(name = "Distribuidora.findByIddistribuidora", query = "SELECT d FROM Distribuidora d WHERE d.iddistribuidora = :iddistribuidora"),
    @NamedQuery(name = "Distribuidora.findByNome", query = "SELECT d FROM Distribuidora d WHERE d.nome = :nome"),
    @NamedQuery(name = "Distribuidora.findByCnpj", query = "SELECT d FROM Distribuidora d WHERE d.cnpj = :cnpj")})
public class Distribuidora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddistribuidora")
    private Integer iddistribuidora;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @ManyToMany(mappedBy = "distribuidoraCollection")
    private Collection<Produto> produtoCollection;

    public Distribuidora() {
    }

    public Distribuidora(Integer iddistribuidora) {
        this.iddistribuidora = iddistribuidora;
    }

    public Integer getIddistribuidora() {
        return iddistribuidora;
    }

    public void setIddistribuidora(Integer iddistribuidora) {
        this.iddistribuidora = iddistribuidora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddistribuidora != null ? iddistribuidora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribuidora)) {
            return false;
        }
        Distribuidora other = (Distribuidora) object;
        if ((this.iddistribuidora == null && other.iddistribuidora != null) || (this.iddistribuidora != null && !this.iddistribuidora.equals(other.iddistribuidora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Distribuidora[ iddistribuidora=" + iddistribuidora + " ]";
    }
    
}
