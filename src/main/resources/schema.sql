-- auto-generated definition
create table if not exists scheduling
(
    id                        int auto_increment
        primary key,
    name                      varchar(100)    null comment '名称',
    plantArea                 double          null comment '种植面积',
    foreCast                  double          null comment '预估产量',
    realCast                  double          null comment '实际产量',
    officeId                  int             null comment '所属园区',
    plotId                    int             null comment '所属地块',
    greenHouseId              int             null comment '所属大棚',
    farmProductionsCategoryId varchar(20)     null comment '农产品种类',
    farmProductionsVarietyId  varchar(20)     null comment '农产品品种',
    remarks                   varchar(500)    null comment '备注',
    delFlag                   int default 1   not null comment '删除标记',
    createDate                timestamp       not null default CURRENT_TIMESTAMP comment '创建时间',
    createBy                  int default 321 not null comment '创建者',
    updateBy                  int default 123 not null comment '更新者',
    updateDate                timestamp       not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '排产';
