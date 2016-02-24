package entity_testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.UEDataList;
import com.the_bean_quartet.msc_project.entities.UETypeClass;

public class TestUEDataList {

	@Test
	public void testGetUEDataCollection() {
		UEDataList dataList = new UEDataList();
		Collection<UETypeClass> ueClass = new ArrayList<UETypeClass>();
		ueClass.add(new UETypeClass());
		dataList.setUEDataCollection(ueClass);
		
		assertEquals(ueClass, dataList.getUEDataCollection());
	}

}
