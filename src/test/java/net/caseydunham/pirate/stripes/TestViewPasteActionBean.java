package net.caseydunham.pirate.stripes;

import net.caseydunham.pirate.BaseTest;
import net.caseydunham.pirate.stripes.action.ViewPasteActionBean;
import net.sourceforge.stripes.mock.MockRoundtrip;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestViewPasteActionBean extends BaseTest {

	@Test
	public void testViewActionBeanSetsRightPage() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext, ViewPasteActionBean.class, mockHttpSession);
		trip.execute();
		assertEquals("/WEB-INF/jsps/ViewPaste.jsp", trip.getDestination());
	}

	@Test
	public void testViewSetsCorrectPaste() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext, ViewPasteActionBean.class, mockHttpSession);
		trip.setParameter("id", "1");
		trip.execute();

		ViewPasteActionBean bean = trip.getActionBean(ViewPasteActionBean.class);
		assertEquals(new Long(1), bean.getId());
	}

}
