package com.lec11.orm.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec11.orm.jpa.entity.UserEntity;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	//---------------------------------------------------
	@Autowired
    private UserRepository userRepository;

    public UserEntity svcUserLogin(String userId, String userPw) {
        return userRepository.findByUserIdAndUserPw(userId, userPw);
    }
		
	    
	//---------------------------------------------------
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@Override
//	@Transactional
//	public List<UserEntity> svcUserList() {
//		@SuppressWarnings("unchecked") //ignore generic type compile warning
//		List<UserEntity> list = (List<UserEntity>)sessionFactory.getCurrentSession()
//														.createCriteria(UserEntity.class)
//														.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//		return list;
//	}
	
	

}
