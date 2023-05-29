package ru.liga.prerevolutionarytinder.models.jpa.auth;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.liga.prerevolutionarytinder.models.jpa.help.BaseEntity;

import java.util.UUID;

@Entity
@Table(name = "global_uuid_table")
//@Table(name = "global_uuid_table", schema = "my_schema")
@Data
@EqualsAndHashCode(callSuper = true)
//@IdClass(GlobalUserId.class)
public class GlobalUUIDEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "global_id")
    private Long globalUserId;

    @Column(name = "uuid", unique = true)
    private String uuid;

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString();
    }

    public GlobalUUIDEntity() {
        this.uuid = UUID.randomUUID().toString();
    }
}
