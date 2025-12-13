create
database IF NOT EXISTS admin_template;
DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

use
admin_template;

create table user
(
    id          int auto_increment primary key comment '主键',
    username    varchar(10) not null comment '用户名',
    password    varchar(100) null comment '密码',
    email       varchar(100) null comment '邮箱',
    create_time timestamp default current_timestamp null comment '创建时间',
    update_time timestamp default current_timestamp null on update current_timestamp comment '更新时间'
) comment '用户信息表';

