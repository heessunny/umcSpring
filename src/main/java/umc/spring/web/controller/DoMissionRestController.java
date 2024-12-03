package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.DoMissionConverter;
import umc.spring.domain.mapping.DoMission;
import umc.spring.service.DoMissionQueryService;
import umc.spring.validation.annotation.ExistDoMission;
import umc.spring.validation.annotation.ExistProgressMission;
import umc.spring.web.dto.MissionResponseDTO;

@Validated
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

    @PatchMapping("/{mission_id}/complete-mission")
    @Operation(summary = "내가 현재 진행중인 미션 완료로 수정 API",description = "내가 진행중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "mission_id", description = "미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.CompleteMissionResultDTO> completeMission( @PathVariable("mission_id") @ExistProgressMission Long missionId) {

        Long memberId =1L;

        DoMission mission = missionService.completeMission(missionId,memberId);
        return ApiResponse.onSuccess(DoMissionConverter.CompleteMissionResultDTO(mission));
    }
}