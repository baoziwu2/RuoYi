-- ----------------------------
-- 1. 课题主表 (不做修改，如果已创建成功可忽略，报错也没事)
-- ----------------------------
drop table if exists ry_research_project;
create table ry_research_project (
  project_id           bigint(20)      not null auto_increment    comment '课题ID',
  project_name         varchar(128)    not null                   comment '课题名称',
  description          varchar(500)    default ''                 comment '课题描述',
  applicant_id         bigint(20)      not null                   comment '申请人ID',
  end_time             datetime                                   comment '截止时间',
  status               char(1)         default '0'                comment '状态（0待审批 1已立项 2已驳回）',
  remark               varchar(500)    default ''                 comment '审批备注',
  create_by            varchar(64)     default ''                 comment '创建者',
  create_time          datetime                                   comment '创建时间',
  update_by            varchar(64)     default ''                 comment '更新者',
  update_time          datetime                                   comment '更新时间',
  primary key (project_id)
) engine=innodb auto_increment=1 comment = '科研课题表';

-- ----------------------------
-- 2. 项目阶段表
-- ----------------------------
drop table if exists ry_research_phase;
create table ry_research_phase (
  phase_id             bigint(20)      not null auto_increment    comment '阶段ID',
  project_id           bigint(20)      not null                   comment '关联课题ID',
  phase_name           varchar(128)    not null                   comment '阶段名称',
  sort_order           int(4)          default 0                  comment '显示排序',
  end_time             datetime                                   comment '截止时间',
  create_by            varchar(64)     default ''                 comment '创建者',
  create_time          datetime                                   comment '创建时间',
  update_by            varchar(64)     default ''                 comment '更新者',
  update_time          datetime                                   comment '更新时间',
  primary key (phase_id)
) engine=innodb auto_increment=1 comment = '科研阶段表';

-- ----------------------------
-- 3. 任务表
-- ----------------------------
drop table if exists ry_research_task;
create table ry_research_task (
  task_id              bigint(20)      not null auto_increment    comment '任务ID',
  phase_id             bigint(20)      not null                   comment '关联阶段ID',
  task_name            varchar(255)    not null                   comment '任务内容',
  assigned_user_id     bigint(20)      not null                   comment '指派执行人ID',
  status               char(1)         default '0'                comment '状态（0进行中 1已完成）',
  end_time             datetime                                   comment '截止时间',
  finish_time          datetime                                   comment '实际完成时间',
  create_by            varchar(64)     default ''                 comment '创建者',
  create_time          datetime                                   comment '创建时间',
  update_by            varchar(64)     default ''                 comment '更新者',
  update_time          datetime                                   comment '更新时间',
  primary key (task_id)
) engine=innodb auto_increment=1 comment = '科研任务表';

-- ----------------------------
-- 4. 菜单结构初始化 (修正字段名 path -> url，移除 component)
-- ----------------------------

-- 一级菜单：科研管理 (M目录) -> url=#
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time)
values('2100', '科研管理', '0', '1', '#', 'M', '0', '', 'fa fa-flask', 'admin', sysdate());

-- 二级菜单：我的审批 (M目录 - 下面有子菜单) 
-- 注意：这里设置为M目录，url=#
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time)
values('2101', '我的审批', '2100', '1', '#', 'M', '0', '', 'fa fa-check-square-o', 'admin', sysdate());

-- 三级菜单：课题审批 (C菜单 - 具体的审批页面)
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time)
values('2102', '课题审批', '2101', '1', '/research/audit/apply', 'C', '0', 'research:audit:apply', 'fa fa-edit', 'admin', sysdate());

-- 三级菜单：课题立项 (C菜单 - 管理阶段和任务)
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time)
values('2103', '课题立项', '2101', '2', '/research/audit/setup', 'C', '0', 'research:audit:setup', 'fa fa-television', 'admin', sysdate());

-- 二级菜单：课题管理 (C菜单 - 普通用户入口)
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time)
values('2104', '课题管理', '2100', '3', '/research/project', 'C', '0', 'research:project:list', 'fa fa-puzzle-piece', 'admin', sysdate());

-- 二级菜单：我的任务 (C菜单)
insert into sys_menu (menu_id, menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time)
values('2105', '我的任务', '2100', '4', '/research/task', 'C', '0', 'research:task:list', 'fa fa-list-alt', 'admin', sysdate());