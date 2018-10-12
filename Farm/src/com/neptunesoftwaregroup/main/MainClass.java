package com.neptunesoftwaregroup.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.ws.Endpoint;

import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.protocol.http.WicketServlet;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.skife.jdbi.v2.DBI;

import utilities.XAPISettings;
import utilities.XAPIUtils;

public class MainClass {

	// public static Predictor predictor;
	public static final Properties props = new Properties();

	public static DBI jdbi;
	public static Endpoint endpoint;

	public static void main(String[] args) throws Exception {
		configure();
		ServletHolder servletHolder = new ServletHolder(new WicketServlet());
		servletHolder.setInitParameter("applicationClassName", "com.neptunesoftwaregroup.application.WebApp");
		servletHolder.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
		servletHolder.setInitOrder(1);
		WebAppContext context = new WebAppContext();
		context.addServlet(servletHolder, "/*");
		context.setResourceBase("html");
		Server server = new Server();
		HttpConfiguration http_config = new HttpConfiguration();
		http_config.setSecureScheme("https");
		http_config.setSecurePort(8443);
		http_config.setOutputBufferSize(32768);
		ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(http_config));
		http.setPort(ENDPOINT_PORT);
		http.setIdleTimeout(30000);
		server.setHandler(context);
		server.setConnectors(new Connector[] { http });
		server.setHandler(context);
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void configure() {
		readConfigToProps();
	}

	private static void readConfigToProps() {
		try {
			props.loadFromXML(new FileInputStream("config/settings.xml"));

			ENDPOINT_PORT = Integer.parseInt(props.getProperty("endpoint_port", "8009"));
			XAPISettings.dsn = props.getProperty("app_schema");
			XAPISettings.user = props.getProperty("schema_user");
			XAPISettings.pswd = XAPIUtils.decrypt(props.getProperty("schema_paswd"));
			jdbi = new DBI(XAPISettings.dsn, XAPISettings.user, XAPISettings.pswd);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int ENDPOINT_PORT;
	public static String allowed_roles;
}
