package net.caseydunham.pirate.stripes;

import net.caseydunham.pirate.BaseTest;
import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.stripes.action.HomeActionBean;
import net.sourceforge.stripes.mock.MockRoundtrip;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
		assertTrue(trip.getRedirectUrl().startsWith("/pirate/pastes/"));
	}

	@Test
	public void testRecentPastes() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext, HomeActionBean.class, mockHttpSession);
		trip.execute();
		HomeActionBean bean = trip.getActionBean(HomeActionBean.class);
		List<Paste> recent = bean.getRecentPastes();
		assertNotNull(recent);
	}

	@Test
	public void testDefaults() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext, HomeActionBean.class, mockHttpSession);
		trip.execute("submit");
		HomeActionBean bean = trip.getActionBean(HomeActionBean.class);
		assertEquals("Untitled", bean.getTitle());
		assertEquals("Unknown", bean.getUsername());
		assertTrue(trip.getRedirectUrl().startsWith("/pirate/pastes/"));
	}

}
