package com.redhat.latam.brms;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;

import com.redhat.latam.brms.home.HomePage;
import com.redhat.latam.brms.trivia.TriviaPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.redhat.latam.brms.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{

		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{

		super.init();

		getResourceSettings().setThrowExceptionOnMissingResource(false);

		getRequestCycleSettings().addResponseFilter(new AjaxServerAndClientTimeFilter());

		getDebugSettings().setAjaxDebugModeEnabled(true);

		mountPage("trivia", TriviaPage.class);

	}

	@Override
	public Session newSession(Request request, Response response) {

		return new BeneficiosSession(request);
	}
}
