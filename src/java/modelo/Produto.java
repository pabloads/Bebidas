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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByQtdEntrada", query = "SELECT p FROM Produto p WHERE p.qtdEntrada = :qtdEntrada"),
    @NamedQuery(name = "Produto.findByQtdEstoque", query = "SELECT p FROM Produto p WHERE p.qtdEstoque = :qtdEstoque"),
    @NamedQuery(name = "Produto.findByEstoqueMin", query = "SELECT p FROM Produto p WHERE p.estoqueMin = :estoqueMin"),
    @NamedQuery(name = "Produto.findByValor", query = "SELECT p FROM Produto p WHERE p.valor = :valor")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduto")
    private Integer idproduto;
    @Column(name = "nome")
    private String nome;
    @Column(name = "qtd_entrada")
    private Integer qtdEntrada;
    @Column(name = "qtd_estoque")
    private Integer qtdEstoque;
    @Column(name = "estoque_min")
    private Integer estoqueMin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @JoinTable(name = "distribuidora_produto", joinColumns = {
        @JoinColumn(name = "produto_idproduto", referencedColumnName = "idproduto")}, inverseJoinColumns = {
        @JoinColumn(name = "distribuidora_iddistribuidora", referencedColumnName = "iddistribuidora")})
    @ManyToMany
    private Collection<Distribuidora> distribuidoraCollection;
    @JoinColumn(name = "categoria_produto_idcategoria_produto", referencedColumnName = "idcategoria_produto")
    @ManyToOne(optional = false)
    private CategoriaProduto categoriaProdutoIdcategoriaProduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoIdproduto")
    private Collection<ItemProduto> itemProdutoCollection;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdEntrada() {
        return qtdEntrada;
    }

    public void setQtdEntrada(Integer qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Integer getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(Integer estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Distribuidora> getDistribuidoraCollection() {
        return distribuidoraCollection;
    }

    public void setDistribuidoraCollection(Collection<Distribuidora> distribuidoraCollection) {
        this.distribuidoraCollection = distribuidoraCollection;
    }

    public CategoriaProduto getCategoriaProdutoIdcategoriaProduto() {
        return categoriaProdutoIdcategoriaProduto;
    }

    public void setCategoriaProdutoIdcategoriaProduto(CategoriaProduto categoriaProdutoIdcategoriaProduto) {
        this.categoriaProdutoIdcategoriaProduto = categoriaProdutoIdcategoriaProduto;
    }

    @XmlTransient
    public Collection<ItemProduto> getItemProdutoCollection() {
        return itemProdutoCollection;
    }

    public void setItemProdutoCollection(Collection<ItemProduto> itemProdutoCollection) {
        this.itemProdutoCollection = itemProdutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Produto[ idproduto=" + idproduto + " ]";
    }
    
}
