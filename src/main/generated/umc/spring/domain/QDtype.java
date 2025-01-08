package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDtype is a Querydsl query type for Dtype
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDtype extends EntityPathBase<Dtype> {

    private static final long serialVersionUID = 1144621170L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDtype dtype = new QDtype("dtype");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final QAlarm alarm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final EnumPath<umc.spring.domain.enums.AlarmStatus> status = createEnum("status", umc.spring.domain.enums.AlarmStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QDtype(String variable) {
        this(Dtype.class, forVariable(variable), INITS);
    }

    public QDtype(Path<? extends Dtype> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDtype(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDtype(PathMetadata metadata, PathInits inits) {
        this(Dtype.class, metadata, inits);
    }

    public QDtype(Class<? extends Dtype> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alarm = inits.isInitialized("alarm") ? new QAlarm(forProperty("alarm"), inits.get("alarm")) : null;
    }

}

