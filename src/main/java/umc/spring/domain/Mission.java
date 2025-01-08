package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.DoMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer minimumAmount;

    private Integer point;

    private String type;

    private String missionSpec;

    private LocalDate deadline;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<DoMission> doMissionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", store='" + (store != null ? store.getName() : "No Store") + '\'' +
                ", region='" + (store != null && store.getRegion() != null ? store.getRegion().getName() : "No Region") + '\'' +
                ", missionSpec='" + missionSpec + '\'' +
                '}';
    }

}


