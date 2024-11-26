package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPlayload.code.status.ErrorStatus;
import umc.spring.apiPlayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.CategoryChoiceConverter;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.CategoryChoice;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {


    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override

    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<CategoryChoice> memberPreferList = CategoryChoiceConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
