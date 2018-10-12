package com.neptunesoftwaregroup.application;

import org.apache.wicket.Component;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authorization.IUnauthorizedComponentInstantiationListener;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.https.HttpsConfig;
import org.apache.wicket.protocol.https.HttpsMapper;
import org.apache.wicket.request.resource.caching.FilenameWithVersionResourceCachingStrategy;
import org.apache.wicket.request.resource.caching.IResourceCachingStrategy;
import org.apache.wicket.request.resource.caching.version.LastModifiedResourceVersion;
import org.apache.wicket.response.filter.ServerAndClientTimeFilter;
import org.skife.jdbi.v2.DBI;

import pages.LoginPage;
import pages.MasterPage;

public class WebApp extends AuthenticatedWebApplication {
	public static DBI jdbi;
	public static String SCHEMA;

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return MasterPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		// add your configuration here
		setRootRequestMapper(new HttpsMapper(getRootRequestMapper(), new HttpsConfig(8080, 443)));
		getSecuritySettings().setAuthorizationStrategy(IAuthorizationStrategy.ALLOW_ALL);
		MetaDataRoleAuthorizationStrategy.authorize(MasterPage.class, Roles.ADMIN);
		getApplicationSettings().setAccessDeniedPage(LoginPage.class);
		getSecuritySettings()
				.setUnauthorizedComponentInstantiationListener(new IUnauthorizedComponentInstantiationListener() {
					@Override
					public void onUnauthorizedInstantiation(Component component) {
						component.setResponsePage(LoginPage.class);
					}
				});
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);
		getDebugSettings().setAjaxDebugModeEnabled(false);
		getRequestCycleSettings().addResponseFilter(new ServerAndClientTimeFilter());
		IResourceCachingStrategy strategy = new FilenameWithVersionResourceCachingStrategy(
				new LastModifiedResourceVersion());
		getResourceSettings().setCachingStrategy(strategy);
		mountPages();
	}

	private void mountPages() {
		mountPage("/Login", LoginPage.class);
		mountPage("/home", MasterPage.class);
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		// TODO Auto-generated method stub
		return LoginPage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		// TODO Auto-generated method stub
		return WebSession.class;
	}

}
