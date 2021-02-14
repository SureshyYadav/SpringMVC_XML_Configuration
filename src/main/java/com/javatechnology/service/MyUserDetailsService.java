package com.javatechnology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javatechnology.dao.UserRepository;
import com.javatechnology.model.MyUserPrincipal;
import com.javatechnology.model.User;
@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) {
        @SuppressWarnings("unchecked")
		List<User> user=(List<User>)hibernateTemplate.find("from User u where u.username=?", new Object[] {username});
        if(!user.isEmpty()) {
        	 return new MyUserPrincipal(user.get(0));
        }
        else {
            throw new UsernameNotFoundException(username);
        }
       
    }

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
    

}
