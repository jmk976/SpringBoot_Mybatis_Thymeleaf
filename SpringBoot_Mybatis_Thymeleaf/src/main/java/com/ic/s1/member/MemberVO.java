package com.ic.s1.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
//Spring Security  에서 사용하는VO 가 존재
//UserDetails
//  따로 생성 또는 구현
public class MemberVO implements UserDetails {
	private String username;
	
	private String password1;
	
	@Length(max=10, min=2)
	private String password;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String phone;
	
	private boolean enabled;
	
	//Role
	private List<RoleVO> roles;
	
    //List<? super BoardVO>  //extends, super  가능 

	//Role저장
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {   //collection : List set의 부모 형
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    
	    for(RoleVO roleVO: this.roles) {
	    	authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
	    }
		return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {  //비밀번호 5회이상 틀리면 락 걸림 같은 기능
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override    //강사님꺼 복사
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
	

}
