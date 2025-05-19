package Models.trabalhoprojeto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @Column(name = "id_produto", nullable = false)
    private Integer id;

    @Column(name = "tipo_produto", length = 100)
    private String tipoProduto;

    @ManyToMany(mappedBy = "produtos")
    private Set<Terreno> terrenos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Set<Terreno> getTerrenos() {
        return terrenos;
    }

    public void setTerrenos(Set<Terreno> terrenos) {
        this.terrenos = terrenos;
    }

}