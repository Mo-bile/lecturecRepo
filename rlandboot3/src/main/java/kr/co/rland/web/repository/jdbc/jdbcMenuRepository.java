package kr.co.rland.web.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

//@Repository
public class jdbcMenuRepository implements MenuRepository{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Menu> findAll() {

		//가져온다 : 라이브러리가 해결할 수 있는것이 아니기 때문!
		
		String sql = "select id, name, price, regDate, categoryId from menu";
		
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//		dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver"); //사용자 계정
//		dataSourceBuilder.url("jdbc:mariadb://db.newlecture.com:3306/rlanddb");
//		dataSourceBuilder.username("rland"); //이부분 바꿔주면 됨!
//		dataSourceBuilder.password("20220823");
//		
//		DataSource dataSource = dataSourceBuilder.build();
		
		JdbcTemplate template = new JdbcTemplate(dataSource);	

		List<Menu> list = template.query(sql, new BeanPropertyRowMapper(Menu.class));
		
		
		return list;
	}

	@Override
	public Menu findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu insert(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu update(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Menu> findAll(Integer offset, Integer size, String query, Integer categoryId, Integer price,
			String orderField, String orderDir) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
		// 반복하자나!!!
//
//	@Override
//	public List<Menu> findAll() {
//		
//		
//		String sql = String.format("select id, name, price, regDate, categoryId, regMemberId from menu");
//		List<Menu> list = new ArrayList<>();
//
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://db.newlecture.com:3306/rlanddb";
//			Connection con = DriverManager.getConnection(url, "rland", "20220823");
//
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//
//			// 필터링, 집계, 정렬
//			while (rs.next()) // 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
//			{
//				long id = rs.getLong("id");
//				String name = rs.getString("name");
//				int price = rs.getInt("price");
//				Date regDate = rs.getDate("regDate");
//				int categoryId = rs.getInt("categoryId");
//				long regMemberId = rs.getLong("regMemberId");
//				
//				
//				Menu menu = new Menu(id, name, price, regDate, categoryId,1);
//				list.add(menu);
//			}
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
}
