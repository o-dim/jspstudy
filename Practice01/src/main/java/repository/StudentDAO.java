package repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.StudentDTO;

public class StudentDAO {
	private SqlSessionFactory factory;
	
	private static StudentDAO dao = new StudentDAO();
	private StudentDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static StudentDAO getInstance() {
		return dao;
	}
	private final String NS = "mybatis.mapper.student.";
	
	public List<StudentDTO> selectAllStuList() {
		SqlSession ss = factory.openSession();
		List<StudentDTO> stuList = ss.selectList(NS + "selectAllStuList");
		ss.close();
		return stuList;
	}
	public StudentDTO selectStuByNo(int StuNo) {
		SqlSession ss = factory.openSession();
		StudentDTO stu = ss.selectOne(NS + "selectStuByNo", stuNo);
		ss.close();
		return stu;
	}
}
