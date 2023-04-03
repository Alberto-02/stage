
package com.stage.biblioteca.entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "prestiti")
@NamedQueries({
        @NamedQuery(name = "PrestitiEntity.findAll", query = "SELECT p FROM PrestitiEntity p")})
public class PrestitiEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestito")
    private Integer idPrestito;
    @Basic(optional = false)
    @Column(name = "data_inizio")
    private int dataInizio;
    @Basic(optional = false)
    @Column(name = "data_fine")
    private int dataFine;
    @Basic(optional = false)
    @Column(name = "data_consegna")
    private int dataConsegna;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private ClientiEntity idCliente;
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    @ManyToOne(optional = false)
    private LibriEntity idLibro;

    public PrestitiEntity() {
    }

    public PrestitiEntity(Integer idPrestito) {
        this.idPrestito = idPrestito;
    }

    public PrestitiEntity(Integer idPrestito, int dataInizio, int dataFine, int dataConsegna) {
        this.idPrestito = idPrestito;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.dataConsegna = dataConsegna;
    }

    public Integer getIdPrestito() {
        return idPrestito;
    }

    public void setIdPrestito(Integer idPrestito) {
        this.idPrestito = idPrestito;
    }

    public int getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(int dataInizio) {
        this.dataInizio = dataInizio;
    }

    public int getDataFine() {
        return dataFine;
    }

    public void setDataFine(int dataFine) {
        this.dataFine = dataFine;
    }

    public int getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(int dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public ClientiEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClientiEntity idCliente) {
        this.idCliente = idCliente;
    }

    public LibriEntity getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(LibriEntity idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestito != null ? idPrestito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestitiEntity)) {
            return false;
        }
        PrestitiEntity other = (PrestitiEntity) object;
        if ((this.idPrestito == null && other.idPrestito != null) || (this.idPrestito != null && !this.idPrestito.equals(other.idPrestito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.PrestitiEntity[ idPrestito=" + idPrestito + " ]";
    }

}
