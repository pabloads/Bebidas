/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo Rocha
 */
@Entity
@Table(name = "categoria_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProduto.findAll", query = "SELECT c FROM CategoriaProduto c"),
    @NamedQuery(name = "CategoriaProduto.findByIdcategoriaProduto", query = "SELECT c FROM CategoriaProduto c WHERE c.idcategoriaProduto = :idcategoriaProduto"),
    @NamedQuery(name = "CategoriaProduto.findByNome", query = "SELECT c FROM CategoriaProduto c WHERE c.nome = :nome")})
public class CategoriaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoria_produto")
    private Integer idcategoriaProduto;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaProdutoIdcategoriaProduto")
    private Collection<Produto> produtoCollection;

    public CategoriaProduto() {
    }

    public CategoriaProduto(Integer idcategoriaProduto) {
        this.idcategoriaProduto = idcategoriaProduto;
    }

    public CategoriaProduto(Integer idcategoriaProduto, String nome) {
        this.idcategoriaProduto = idcategoriaProduto;
        this.nome = nome;
    }

    public Integer getIdcategoriaProduto() {
        return idcategoriaProduto;
    }

    public void setIdcategoriaProduto(Integer idcategoriaProduto) {
        this.idcategoriaProduto = idcategoriaProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (idcategoriaProduto != null ? idcategoriaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProduto)) {
            return false;
        }
        CategoriaProduto other = (CategoriaProduto) object;
        if ((this.idcategoriaProduto == null && other.idcategoriaProduto != null) || (this.idcategoriaProduto != null && !this.idcategoriaProduto.equals(other.idcategoriaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CategoriaProduto[ idcategoriaProduto=" + idcategoriaProduto + " ]";
    }
    
}
