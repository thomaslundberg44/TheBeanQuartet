package entity_testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.SysUser;
import com.the_bean_quartet.msc_project.entities.SysUserList;

public class TestSysUserList {

	@Test
	public void testGetSysUsSysUserction() {
		Collection<SysUser> users = new ArrayList<SysUser>();
		SysUser user = new SysUser();
		user.setId(0);
		user.setUserName("User1");
		user.setUserPassword("password");
		user.setUserType("Admin");
		users.add(user);
		
		users.add(new SysUser("User2","god","Engineer"));
		
		
		SysUserList list = new SysUserList();
		list.setSysUserCollection(users);
		
		assertEquals(users, list.getSysUserCollection());
	}

}
