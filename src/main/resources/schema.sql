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

create table if not exists farmproductions_category
(
    id           bigint auto_increment
        primary key,
    parent_id    int            not null,
    name         varchar(100)   null,
    edescribe    varchar(500)   null,
    ylut         decimal(10, 2) null,
    growth_cycle varchar(50)    null,
    planting_in  datetime       null,
    mature_in    datetime       null,
    picture      varchar(500)   null,
    parent_ids   varchar(2000)  null,
    create_date  timestamp      not null default CURRENT_TIMESTAMP,
    create_by    varchar(64)    not null,
    sort         decimal        not null,
    status       decimal(1)              default 1 not null,
    update_by    varchar(64)    not null,
    update_date  timestamp      not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    office_id    bigint         null,
    del_flag     int                     default 1 not null
)
    comment '种类';



create table if not exists variety
(
    id           bigint auto_increment
        primary key,
    name         varchar(100)   null,
    category     varchar(100)   null comment '种类',
    ylut         decimal(10, 2) null comment '亩产',
    plot         int            null comment '所属地块',
    growth_cycle int            null comment '生长周期',
    planting_in  date       null comment '种植月份',
    mature_in    date       null comment '成熟月份',
    picture      varchar(500)   null comment '图片',
    remarks      varchar(500)   null comment '描述',
    del_flag     int default 1  not null
)
    comment '品种';

