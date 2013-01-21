package net.caseydunham.pirate.stripes.interceptor;

import net.caseydunham.pirate.hibernate.HibernateUtil;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.config.ConfigurableComponent;
import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;

@Intercepts(value = {LifecycleStage.HandlerResolution, LifecycleStage.ResolutionExecution})
public class HibernateInterceptor implements Interceptor, ConfigurableComponent {

	private static final Logger LOG = LoggerFactory.getLogger(HibernateInterceptor.class);

	private SessionFactory sessionFactory;

	public void init(Configuration configuration) throws Exception {
		setSessionFactory(HibernateUtil.getSessionFactory());
		LOG.debug("initialized");
	}

	@SuppressWarnings("unchecked")
	public Resolution intercept(ExecutionContext ctx) throws Exception {
		Resolution next;
		Session session = getSessionFactory().getCurrentSession();
		try {
			if (ctx.getLifecycleStage().equals(LifecycleStage.HandlerResolution)) {
				LOG.debug("beginning hibernate transaction");
				session.beginTransaction();
			}
			next = ctx.proceed();
			if (ctx.getLifecycleStage().equals(LifecycleStage.ResolutionExecution)
					&& session.isOpen() && !session.getTransaction().wasRolledBack()) {
				LOG.debug("committing and closing transaction");
				session.getTransaction().commit();
			}
		} catch (Throwable ex) {
			doRollback(session);
			if (ex instanceof ServletException) {
				throw (ServletException) ex;
			} else if (ex instanceof HibernateException) {
				throw (HibernateException) ex;
			} else {
				throw new ServletException(ex);
			}
		}
		return next;
	}

	protected void doRollback(Session session) {
		try {
			if (session.isOpen()) {
				if (session.isDirty()) {
					LOG.warn("rolling back transaction after exception");
					session.getTransaction().rollback();
				} else {
					LOG.warn("closing open transaction after exception");
					session.close();
				}
			}
		} catch (Throwable t) {
			LOG.error("failed to roll back transaction after exception, attempting to close", t);
			session.close();
		}
	}

	public SessionFactory getSessionFactory() { return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

}