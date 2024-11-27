package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.DoMissionConverter;
import umc.spring.domain.mapping.DoMission;
import umc.spring.service.DoMissionQueryService;
import umc.spring.validation.annotation.ExistDoMission;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/missioins")
public class DoMissionRestController {

    private final DoMissionQueryService missionService;

    @PostMapping("/{mission_id}/domissions")
    public ApiResponse<MissionResponseDTO.DoMissionResultDTO> challengeMission(@PathVariable("mission_id") @ExistDoMission Long missionId) {

        DoMission mission = missionService.challengeMission(missionId);
        return ApiResponse.onSuccess(DoMissionConverter.toDoMissionResultDTO(mission));
    }
}