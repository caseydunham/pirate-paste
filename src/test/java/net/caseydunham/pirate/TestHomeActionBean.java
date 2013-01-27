package net.caseydunham.pirate;

import net.caseydunham.pirate.hibernate.HibernateUtil;
import net.caseydunham.pirate.model.Paste;
import net.caseydunham.pirate.services.PasteService;
import net.caseydunham.pirate.stripes.action.HomeActionBean;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockHttpSession;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

public class TestHomeActionBean extends BaseTest {

	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	private static Session hibernateSession;

	private static MockServletContext mockServletContext;
	private static MockHttpSession mockHttpSession;

	@Mock
	private PasteService mockPasteService;

	@Before
	public void setUp() {
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();

		HibernateUtil.setSessionFactory(sessionFactory);

		mockServletContext = new MockServletContext("pirate");
		Map<String, String> params = new HashMap<String, String>();
		params.put("ActionResolver.Packages", "net.caseydunham.pirate.stripes.action");
		params.put("Extension.Packages", "net.caseydunham.pirate.stripes.ext");
		params.put("Interceptor.Class", "net.caseydunham.pirate.stripes.interceptor.HibernateInterceptor");
		mockServletContext.addFilter(StripesFilter.class, "StripesFilter", params);
		mockServletContext.setServlet(DispatcherServlet.class, "DispatcherServlet", null);
		mockHttpSession = new MockHttpSession(mockServletContext);

		doNothing().when(mockPasteService).create(any(Paste.class));
		HibernateUtil.beginTransaction();
	}

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
