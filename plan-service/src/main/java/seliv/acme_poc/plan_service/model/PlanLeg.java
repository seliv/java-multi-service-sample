package seliv.acme_poc.plan_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UC_plan_leg_id_code", columnNames = {"id", "code"})
})
@Getter
@ToString
public class PlanLeg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50, nullable = false)
    private String code;

    @Column(nullable = false)
    private int percent;

    @Column(length = 1000, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Plan plan;
}
