package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final ListPath<umc.spring.domain.mapping.CategoryChoice, umc.spring.domain.mapping.QCategoryChoice> categoryChoiceList = this.<umc.spring.domain.mapping.CategoryChoice, umc.spring.domain.mapping.QCategoryChoice>createList("categoryChoiceList", umc.spring.domain.mapping.CategoryChoice.class, umc.spring.domain.mapping.QCategoryChoice.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<umc.spring.domain.mapping.DoMission, umc.spring.domain.mapping.QDoMission> doMissionList = this.<umc.spring.domain.mapping.DoMission, umc.spring.domain.mapping.QDoMission>createList("doMissionList", umc.spring.domain.mapping.DoMission.class, umc.spring.domain.mapping.QDoMission.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final StringPath profileImg = createString("profileImg");

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.Role> role = createEnum("role", umc.spring.domain.enums.Role.class);

    public final EnumPath<umc.spring.domain.enums.SocialType> socialType = createEnum("socialType", umc.spring.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.spring.domain.enums.MemberStatus> status = createEnum("status", umc.spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

