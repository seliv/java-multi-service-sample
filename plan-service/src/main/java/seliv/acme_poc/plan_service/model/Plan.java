package seliv.acme_poc.plan_service.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    private String code;

    @Column(length = 1000, nullable = false)
    private String description;

    @OneToMany(mappedBy = "plan", fetch = FetchType.EAGER)
    private List<PlanLeg> planLegs;
}
