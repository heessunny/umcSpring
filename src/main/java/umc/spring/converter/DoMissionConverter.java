package umc.spring.converter;

import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.DoMission;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class DoMissionConverter {

    public static MissionResponseDTO.DoMissionResultDTO toDoMissionResultDTO(DoMission doMission){
        return MissionResponseDTO.DoMissionResultDTO.builder()
                .doMisisonId(doMission.getId())
                .status(MissionStatus.PROGRESS)
                .createdAt(LocalDateTime.now())
                .build();
    }



}
