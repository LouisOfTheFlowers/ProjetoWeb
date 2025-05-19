package Models.trabalhoprojeto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoTerrenoId implements Serializable {
    private static final long serialVersionUID = 717113349547958046L;
    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    @Column(name = "id_terreno", nullable = false)
    private Integer idTerreno;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(Integer idTerreno) {
        this.idTerreno = idTerreno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProdutoTerrenoId entity = (ProdutoTerrenoId) o;
        return Objects.equals(this.idProduto, entity.idProduto) &&
                Objects.equals(this.idTerreno, entity.idTerreno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idTerreno);
    }

}