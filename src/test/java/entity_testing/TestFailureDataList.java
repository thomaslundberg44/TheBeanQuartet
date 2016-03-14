package entity_testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.EventCauseList;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.FailureDataList;



public class TestFailureDataList {
	
	@Test
	public void testEquals(){
	FailureClass fClass=new FailureClass(0,"objOne");
	FailureClass fClass2=new FailureClass(0,"objOne");
	FailureClass fClass3=new FailureClass(69,"objThree");
	FailureClass fClass4=new FailureClass(1,"objFour");
	assertFalse(fClass.equals(null));
	assertTrue(fClass.equals(fClass));
	assertFalse(fClass.equals(new String()));
	assertFalse(fClass.equals(fClass3));
	assertFalse(fClass.equals(fClass4));
	
	Collection<FailureClass> eventList = new ArrayList<FailureClass>();
	
	FailureDataList list = new FailureDataList();
	list.setFailureDataCollection(eventList);
	
	assertEquals(eventList, list.getFailureDataCollection());

}
}
