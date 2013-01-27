package net.caseydunham.pirate;

import net.caseydunham.pirate.stripes.action.ViewPasteActionBean;
import net.sourceforge.stripes.mock.MockRoundtrip;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestViewPasteActionBean extends BaseTest {

	@Test
	public void testHomeActionBeanSetsRightPage() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext, ViewPasteActionBean.class, mockHttpSession);
		trip.execute();
		assertEquals("/WEB-INF/jsps/ViewPaste.jsp", trip.getDestination());
	}

}
