package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.Male;
                break;
            case 2:
                gender = Gender.Female;
                break;
        }

        LocalDate birthDate = LocalDate.of(
                request.getBirthYear(),
                request.getBirthMonth(),
                request.getBirthDay()
        );

        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .specAddress(request.getAddress())
                .gender(gender)
                .birth(birthDate)
                .categoryChoiceList(new ArrayList<>())
                .build();

    }
}
