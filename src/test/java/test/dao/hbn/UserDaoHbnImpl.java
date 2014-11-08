package test.dao.hbn;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import test.TestBaseDao;
import test.dao.UserDao;
import test.domain.User;

@Repository("userDaoHbn")
public class UserDaoHbnImpl  extends TestBaseDao implements UserDao{

	@Override
	public Long insertUser(User u) {
		getSession().save(u);
		return u.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser(User query) {
		return (List<User>) getSession().createQuery(" from User ").list();
//		return (List<User>) getHbnSession().find(" from User ");
//		return (List<User>) getHbnSession().findByNamedQuery("listUser");
//		return null;
	}

	@Override
	public Long updateUser(User u) {
		Assert.notNull(u, "target user is required.");

		User updateUser = (User) getSession().get(User.class, u.getId());
		
		log.info("try to update user: " + updateUser);
		
		getSession().merge(u);
		
		log.info("updated user: " + u.getId());
		
		return u.getId();
	}

	@Override
	public Long deleteUser(User u) {
		
		User updateUser =  (User) getSession().get(User.class, u.getId());
		if(null != updateUser){
			getSession().delete(updateUser);
		}else{
			log.error("user not exists for delete: " + u);
		}
		return u.getId();
	}

	@Override
	public User selectUserById(Long id) {
		User user =  (User) getSession().get(User.class, id);
		return user;
	}

}
