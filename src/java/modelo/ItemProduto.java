/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
 * @author Pablo Rocha
 */
@Entity
@Table(name = "item_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemProduto.findAll", query = "SELECT i FROM ItemProduto i"),
    @NamedQuery(name = "ItemProduto.findByIditemProduto", query = "SELECT i FROM ItemProduto i WHERE i.iditemProduto = :iditemProduto"),
    @NamedQuery(name = "ItemProduto.findByQuantidade", query = "SELECT i FROM ItemProduto i WHERE i.quantidade = :quantidade")})
public class ItemProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditem_produto")
    private Integer iditemProduto;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "produto_idproduto", referencedColumnName = "idproduto")
    @ManyToOne(optional = false)
    private Produto produtoIdproduto;
    @JoinColumn(name = "compra_idcompra", referencedColumnName = "idcompra")
    @ManyToOne(optional = false)
    private Compra compraIdcompra;

    public ItemProduto() {
    }

    public ItemProduto(Integer iditemProduto) {
        this.iditemProduto = iditemProduto;
    }

    public Integer getIditemProduto() {
        return iditemProduto;
    }

    public void setIditemProduto(Integer iditemProduto) {
        this.iditemProduto = iditemProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProdutoIdproduto() {
        return produtoIdproduto;
    }

    public void setProdutoIdproduto(Produto produtoIdproduto) {
        this.produtoIdproduto = produtoIdproduto;
    }

    public Compra getCompraIdcompra() {
        return compraIdcompra;
    }

    public void setCompraIdcompra(Compra compraIdcompra) {
        this.compraIdcompra = compraIdcompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditemProduto != null ? iditemProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemProduto)) {
            return false;
        }
        ItemProduto other = (ItemProduto) object;
        if ((this.iditemProduto == null && other.iditemProduto != null) || (this.iditemProduto != null && !this.iditemProduto.equals(other.iditemProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemProduto[ iditemProduto=" + iditemProduto + " ]";
    }
    
}
