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

create table permission
(
    id          int auto_increment primary key comment '主键ID',
    name        varchar(10) not null comment '权限名称',
    description varchar(100) null comment '权限描述'
) comment '权限表';

create table role
(
    id          int auto_increment primary key comment '主键ID'
    name        varchar(10) not null comment '角色名称',
    description varchar(100) null comment '角色描述'
) comment '角色表';

create table user_role
(
    user_id int not null comment '用户ID',
    role_id int not null,
    constraint user_role_pk
        primary key (user_id, role_id)
) comment '用户-角色关联表';

create table role_permission
(
    role_id       int not null comment '角色ID',
    permission_id int not null comment '权限ID',
    constraint role_permission_pk
        primary key (role_id, permission_id)
) comment '角色-权限关联表';


