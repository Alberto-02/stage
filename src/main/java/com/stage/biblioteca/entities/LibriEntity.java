
package com.stage.biblioteca.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "LibriEntity")
@NamedQueries({
        @NamedQuery(name = "LibriEntity.findAll", query = "SELECT l FROM LibriEntity l")})
public class LibriEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libro")
    private Integer idLibro;
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "titolo")
    private String titolo;
    @Basic(optional = false)
    @Column(name = "autore")
    private String autore;
    @Basic(optional = false)
    @Column(name = "anno")
    private String anno;
    @Basic(optional = false)
    @Column(name = "genere")
    @Temporal(TemporalType.DATE)
    private Date genere;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibro")
    private List<PrestitiEntity> PrestitiEntityList;

    public LibriEntity() {
    }

    public LibriEntity(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public LibriEntity(Integer idLibro, String isbn, String titolo, String autore, String anno, Date genere) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.genere = genere;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public Date getGenere() {
        return genere;
    }

    public void setGenere(Date genere) {
        this.genere = genere;
    }

    public List<PrestitiEntity> getPrestitiEntityList() {
        return PrestitiEntityList;
    }

    public void setPrestitiEntityList(List<PrestitiEntity> PrestitiEntityList) {
        this.PrestitiEntityList = PrestitiEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibriEntity)) {
            return false;
        }
        LibriEntity other = (LibriEntity) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.LibriEntity[ idLibro=" + idLibro + " ]";
    }

}
