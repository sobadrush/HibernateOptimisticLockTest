package test.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.model.dao.EmpDAO;
import com.ctbc.model.vo.EmpVO;

import _00_Config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class TestEmpDAO {

	@Autowired
	public EmpDAO empDAO;

	@Test
//	@Ignore
	@Rollback(true)
	public void test001() throws SQLException {
		List<EmpVO> empList;
		try {
			empList = empDAO.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for (EmpVO empVO : empList) {
//			System.out.println(empVO);
//		}
	}

}











