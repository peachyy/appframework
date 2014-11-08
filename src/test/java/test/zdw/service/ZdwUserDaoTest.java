package test.zdw.service;

import javax.transaction.Transactional;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import test.dao.UserDao;
import test.domain.User;
import test.zdw.ZdwBaseService;

@Service("zdwUserDaoTest")
public class ZdwUserDaoTest extends ZdwBaseService {

	@Transactional
	public void myUserTest(String userDaoBeanId) {
		
		UserDao userDao = getBean(userDaoBeanId,UserDao.class);
		
		try {

			for (int i = 0; i < 4; i++) {

				String className = userDao.getClass().getName();
				User u = new User();
				u.setUsername(className + " 用户 " + (i+1)+ " Test-" + getTime());
				u.setPassword(getTime());
				
//				userDao.insertUser(u);
				
				if (i < 2) {
					userDao.insertUser(u);
				} else {
					throw new RuntimeException("more than 2 is not supported.");
				}
				
				log.info("user inserted: " + u);
			}

		} catch (Throwable e) {
			log.error("insertUser error:", e);
			org.junit.Assert.fail("insertUser error:"
					+ ExceptionUtils.getRootCauseMessage(e));
		}

	}


	
	public static void main(String[] args) {
		ZdwUserDaoTest service = getBean("zdwUserDaoTest",ZdwUserDaoTest.class);
		
//		service.myUserTest("userDaoHbn");
//		service.myUserTest("userDaoMbt");
		service.myUserTest("userDaoJdbc");
		
	}

}
