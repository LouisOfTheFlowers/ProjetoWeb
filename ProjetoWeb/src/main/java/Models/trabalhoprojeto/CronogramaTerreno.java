package Models.trabalhoprojeto;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "\"Cronograma/Terreno\"")
public class CronogramaTerreno {
    @SequenceGenerator(name = "Cronograma/Terreno_id_gen", sequenceName = "Cronograma_id_cronograma_seq", allocationSize = 1)
    @EmbeddedId
    private CronogramaTerrenoId id;

    @MapsId("idCronograma")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_cronograma", nullable = false)
    private Cronograma idCronograma;

    @MapsId("idTerreno")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_terreno", nullable = false)
    private Terreno idTerreno;

    public CronogramaTerrenoId getId() {
        return id;
    }

    public void setId(CronogramaTerrenoId id) {
        this.id = id;
    }

    public Cronograma getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(Cronograma idCronograma) {
        this.idCronograma = idCronograma;
    }

    public Terreno getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(Terreno idTerreno) {
        this.idTerreno = idTerreno;
    }

}