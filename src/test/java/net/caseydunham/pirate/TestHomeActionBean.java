package net.caseydunham.pirate;

import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.stripes.action.HomeActionBean;
import net.sourceforge.stripes.mock.MockRoundtrip;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestHomeActionBean extends BaseTest {

	@Test
	public void testHomeActionBeanSetsRightPage() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext, HomeActionBean.class, mockHttpSession);
		trip.execute();
		assertEquals("/WEB-INF/jsps/Home.jsp", trip.getDestination());
	}

	@Test
	public void testHomeActionCreatesPasteOnSubmit() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext, HomeActionBean.class, mockHttpSession);
		trip.setParameter("title", "test title");
		trip.setParameter("username", "test user");
		trip.setParameter("content", "test content");
		trip.execute("submit");
		HomeActionBean bean = trip.getActionBean(HomeActionBean.class);
		assertEquals("test title", bean.getTitle());
		assertEquals("test user", bean.getUsername());
		assertEquals("test content", bean.getContent());
		Paste p = bean.getPaste();
		assertNotNull(p);
		assertNotNull(p.getId());
		assertEquals("/pirate/home", trip.getRedirectUrl());
	}

}
