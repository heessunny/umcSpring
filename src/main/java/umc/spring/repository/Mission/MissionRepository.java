package umc.spring.repository.Mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);


}

