package pretest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pretest.Bean.Column;
import pretest.Bean.Order;
import static org.hamcrest.CoreMatchers.*;

public class SorterTest {
	Beans beans;
	final int FIRST_ROW = 0;
	
	@Before
	public void setUp(){
		beans = new Beans();
		beans.addBean("fish", "김이박", "010-1234-1234", "fish@naver.com");
		beans.addBean("photo", "최강석", "010-3456-3456", "photo@gmail.com");
		beans.addBean("eclipse", "Vincent", "", "vincent@naver.com");
	}
	
	@Test
	public void testSortByPhoneDesc_폰번호를_역순으로_확인(){
		// Given
		
		// When
		beans.sort(Column.phone, Order.desc);
		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getPhone(), is("010-3456-3456"));
	}
	
	@Test
	public void testSortByPhoneAsc(){
		// Given
		
		// When
		beans.sort(Column.phone, Order.asc);
		
		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getPhone(), is(""));
	}
	
	@Test
	public void testSortByNameAsc(){
		// Given
		
		// When
		beans.sort(Column.name, Order.asc);
		
		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getName(), is("Vincent"));
	}
	
	@Test
	public void testSortByNameDesc(){
		// Given
		
		// When
		beans.sort(Column.name, Order.desc);
		
		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getName(), is("최강석"));
	}
	
	@Test
	public void testSortByJobAsc() {
		// Given

		// When
		beans.sort(Column.job, Order.asc);

		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getJob(), is("eclipse"));
	}
	
	@Test
	public void testSortByJobDesc() {
		// Given

		// When
		beans.sort(Column.job,Order.desc);

		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getJob(), is("photo"));
	}
	
	@Test
	public void testSortByEmailASC() {
		// Given

		// When
		beans.sort(Column.mail,Order.asc);

		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getMail(), is("fish@naver.com"));
	}
	
	@Test
	public void testSortByEmailDesc() {
		// Given
		
		// When
		beans.sort(Column.mail,Order.desc);
		
		// Then
		assertThat(beans.getBeans().get(FIRST_ROW).getMail(), is("vincent@naver.com"));
	}

	
}