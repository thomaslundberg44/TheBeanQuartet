package entity_testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.MccDataList;

public class TestMccDataList {

	@Test
	public void testEquals(){
		MccData mClass=new MccData(0,0,"IRL","Three");
		MccData mClass2=new MccData(0,0,"IRL","Three");
		MccData mClass3=new MccData(69,0,"GB","Orange");
		MccData mClass4=new MccData(1,1,"FR","Vodafone");
		assertFalse(mClass.equals(null));
		assertTrue(mClass.equals(mClass));
		assertFalse(mClass.equals(new String()));
		assertFalse(mClass.equals(mClass3));
		assertFalse(mClass.equals(mClass4));
		
		Collection<MccData> eventList = new ArrayList<MccData>();
		
		MccDataList list = new MccDataList();
		list.setMccDataCollection(eventList);
		
		assertEquals(eventList, list.getData());


	}
}
