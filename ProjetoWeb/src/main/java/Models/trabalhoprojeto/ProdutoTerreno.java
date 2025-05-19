package Models.trabalhoprojeto;

import jakarta.persistence.*;

@Entity
@Table(name = "\"produto/terreno\"")
public class ProdutoTerreno {
    @EmbeddedId
    private ProdutoTerrenoId id;

    @MapsId("idProduto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @MapsId("idTerreno")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_terreno", nullable = false)
    private Terreno idTerreno;

    public ProdutoTerrenoId getId() {
        return id;
    }

    public void setId(ProdutoTerrenoId id) {
        this.id = id;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Terreno getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(Terreno idTerreno) {
        this.idTerreno = idTerreno;
    }

}