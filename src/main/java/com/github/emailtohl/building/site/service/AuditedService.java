package com.github.emailtohl.building.site.service;

import static com.github.emailtohl.building.site.entities.Authority.AUDIT;

import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import com.github.emailtohl.building.common.jpa.Pager;
import com.github.emailtohl.building.site.dto.RoleDto;
import com.github.emailtohl.building.site.dto.UserDto;

/**
 * 查询被审计的实体的历史记录
 * @author HeLei
 */
@PreAuthorize("hasAuthority('" + AUDIT + "')")
public interface AuditedService {
	/**
	 * 根据User的email查询某实体所有历史记录
	 * @param email 
	 * @param pageable
	 * @return
	 */
	Pager<UserDto> getUserRevision(String email, Pageable pageable);
	
	/**
	 * 查询User某个修订版下所有的历史记录
	 * @param revision
	 * @param email
	 * @param pageable
	 * @return
	 */
	Pager<UserDto> getUsersAtRevision(int revision, String email, Pageable pageable);
	
	/**
	 * 查询User在某个修订版时的历史记录
	 * @param userId
	 * @param revision
	 * @return
	 */
	UserDto getUserAtRevision(long userId, int revision);
	
	/**
	 * 根据Role的名字查询某实体所有历史记录
	 * @param name 实体属性名和属性值
	 * @param pageable
	 * @return
	 */
	Pager<RoleDto> getRoleRevision(String name, Pageable pageable);
	
	/**
	 * 查询Role修订版下所有的历史记录
	 * @param revision
	 * @param name
	 * @param pageable
	 * @return
	 */
	Pager<RoleDto> getRolesAtRevision(int revision, String name, Pageable pageable);
	
	/**
	 * 查询Role在某个修订版时的历史记录
	 * @param id
	 * @param revision
	 * @return
	 */
	RoleDto getRoleAtRevision(long roleId, int revision);
	
}
