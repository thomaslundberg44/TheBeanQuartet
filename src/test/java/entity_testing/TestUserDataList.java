package entity_testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.UserData;
import com.the_bean_quartet.msc_project.entities.UserDataList;

public class TestUserDataList {

	@Test
	public void test() {
		Collection<UserData> data = new ArrayList<UserData>();
		data.add(new UserData(1234, "Cornelius", "password", "Admin"));
		
		UserDataList list = new UserDataList();
		list.setUserData(data);
		
		assertEquals(data, list.getUserData());
	}

}
