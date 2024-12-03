package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.DoMissionConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.DoMission;
import umc.spring.service.DoMissionQueryService;
import umc.spring.service.MissionQueryService;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistDoMission;
import umc.spring.validation.annotation.ExistPage;
import umc.spring.validation.annotation.ExistProgressMission;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {
    private final MissionQueryService missionQueryService;

    private final MissionCommandService missionCommandService;
    private final DoMissionQueryService doMissionQueryService;

    @PostMapping("/{store_id}/missions")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> reviewCommandService(@PathVariable("store_id") @ExistStore Long storeId, @RequestBody @Valid MissionRequestDTO.CreateMissionDto request){

        Mission mission = missionCommandService.registerMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }


}
