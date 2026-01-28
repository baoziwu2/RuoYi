-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('科研阶段', '3', '1', '/system/phase', 'C', '0', 'system:phase:view', '#', 'admin', sysdate(), '', null, '科研阶段菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('科研阶段查询', @parentId, '1',  '#',  'F', '0', 'system:phase:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('科研阶段新增', @parentId, '2',  '#',  'F', '0', 'system:phase:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('科研阶段修改', @parentId, '3',  '#',  'F', '0', 'system:phase:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('科研阶段删除', @parentId, '4',  '#',  'F', '0', 'system:phase:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('科研阶段导出', @parentId, '5',  '#',  'F', '0', 'system:phase:export',       '#', 'admin', sysdate(), '', null, '');
