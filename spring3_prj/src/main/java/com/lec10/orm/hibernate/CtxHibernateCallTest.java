package com.lec10.orm.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;



public class CtxHibernateCallTest {

	/**
	   기능 : xml을 읽어 해당 설정에 있는 (클래스들의 인스턴스 초기화) == (new)
	    <interface>				<class>
	    BeanFactory    			XmlBeanFactory
		ApplicationContext   	ClassPathXmlApplicationContext  : src/main/resources
								FileSystemXmlApplicationContext : full path
		WebApplicationContext	XmlWebApplicationContext        : + session request..
	 */


	public static void main(String[] args) {
		
/**
 * Hibernate는 SQL문을 자동 생성 시 내부적으로 테이블명/컬럼명을 고유하게 식별하고 충돌을 방지하기 위해 내부적으로 생성한 고유한 식별자alias를 생성해 사용

  Hibernate: select uservo0_.user_seq as user_seq1_0_0_, 
					uservo0_.regdate as regdate2_0_0_, 
					uservo0_.user_gubun as user_gubun3_0_0_, 
					uservo0_.user_id as user_id4_0_0_, 
					uservo0_.user_name as user_name5_0_0_, 
					uservo0_.user_pw as user_pw6_0_0_ 
			from users3 uservo0_ 
			where uservo0_.user_seq=?
 */
	

// /**
//######################################################################################################
// String path = "hibernate-context-lec10.xml";
        SessionFactory sessionFactory = new Configuration().configure("hibernate-context-lec10.xml").buildSessionFactory();
        System.out.println("Hibernate session build ok");

        Session session = sessionFactory.openSession();

        try {
            // Begin a transaction
            Transaction transaction = session.beginTransaction();

//            System.out.println("입력------------------------------------------");
//            UserVO uvo = new UserVO();
//            uvo.setUserId("hiber");
//            uvo.setUserPw("000");
//            session.save(uvo);
//            transaction.commit(); 
//            

//            System.out.println("목록조회------------------------------------------");
//            List<UserVO> users = session.createCriteria(UserVO.class).list();
//            for (UserVO user : users) {
//                System.out.println(user);
//            }

            
            System.out.println("로그인------------------------------------------");
            UserVO uvo = (UserVO) session.createCriteria(UserVO.class)
                    .add(Restrictions.eq("userId", "admin"))
                    .add(Restrictions.eq("userPw", "0000"))
                    .uniqueResult();
            if (uvo != null) {
                System.out.println("로그인 성공: " + uvo);
            } else {
                System.out.println("로그인 실패");
            }

//            //UserVO uvo = (UserVO) session.get(UserVO.class, uvo.getId());
//            UserVO uvo = (UserVO) session.createCriteria(UserVO.class)
//                  .add(Restrictions.eq("userId", "hiber"))
//                  .uniqueResult();
//            if (uvo != null) {
//                System.out.println(uvo.getId() + " 수정------------------------------------------");
//                uvo.setUserName("하이버");
//                uvo.setUserPw("222");
//                session.update(uvo);
//                transaction.commit(); // Commit transaction after update
//            }
                    
          //UserVO uvo = (UserVO) session.get(UserVO.class, uvo.getId());
//          UserVO uvo = (UserVO) session.createCriteria(UserVO.class)
//                .add(Restrictions.eq("userId", "hiber"))
//                .uniqueResult();
//            if (uvo != null) {
//                System.out.println(uvo.getId() + " 삭제------------------------------------------");
//                session.delete(uvo);
//                transaction.commit(); // Commit transaction after delete
//            }
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }       
//*/
		
		


//######################################################################################################
//lec10-servlet-context.xml
/**		
		String xmlFile10 = "C:\\IT\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec10-servlet-context.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile10);

		//----------------------------------------------------------------------------
		// Hibernate DBCP 설정을 통한 DB 연결 및 CRUD 예
		//----------------------------------------------------------------------------
		DataSource ds = (DataSource)ctx.getBean("MY_tomcat_ds");
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("Properties DataSource myDS conn ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}


		//[MyBatis  ] SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//[Hibernate] SessionFactory       sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");	
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		if(sessionFactory == null)
			System.out.println("err");
		else
			System.out.println("Hibernate session build ok");


		//[MyBatis  ] SqlSession session = sqlSessionFactory.openSession();
		//[Hibernate]    Session session =    sessionFactory.openSession();
		Session session = sessionFactory.openSession();

		
		Long id = 1L;
		UserVO uvo2 = (UserVO) session.get(UserVO.class, id);
		System.out.println(uvo2.getUserName());

		session.close(); 		
		
		//######################################################################################################
*/
		
		
		
	}

}
