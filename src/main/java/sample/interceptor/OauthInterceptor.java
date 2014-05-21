package sample.interceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class OauthInterceptor implements HandlerInterceptor {

	final Logger logger = LoggerFactory.getLogger(OauthInterceptor.class);

	@Autowired
    private Configuration configuration;
	@Autowired
	private MessageSource message;

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {

		String responseFromOauth = null;
		String joonId = null;

		String pathInfo = request.getPathInfo();
		logger.info("pathInfo >>> " + pathInfo);
		// Check user URL path. Not login.
		if (pathInfo.equals("/checkOk.sp")) {
			return true;
		}

		/*
		 * According to change, you should make a program.
		 *
		 */

		/*
		ModelAndView inviteListMv = new ModelAndView();
		inviteListMv.setViewName("error/error");

		// Get a Access Token from the Request Header.
		String strAccessToken = getAccessToken(request, response);

		// Check registered user or not.
		if(!Utility.checkNullEmpty(strAccessToken)) {
			logger.warn("this user is not registered.");

			// Set Null to a user.
			request.setAttribute("joonId", joonId);
			return true;
		}

		if(Utility.checkSpecialSymbol(strAccessToken)) {
			logger.error("Getting Access Token Error, strAccessToken = " + strAccessToken);
			response.setStatus(400);
			inviteListMv.addObject("errorTitle", message.getMessage("crane.error.400.title", null, Locale.JAPAN));
			inviteListMv.addObject("errorMessage", message.getMessage("crane.error.400.message", null, Locale.JAPAN));
			throw new ModelAndViewDefiningException(inviteListMv);
		}

		StringBuffer sb = new StringBuffer();
		// Check accessToken
		try {
			// ServiceId is blank.
			responseFromOauth = ApiHttpClient.reqOauthGetMethod(getQueryString(configuration.getString("oAuth.api.scope")), 
					configuration.getString("oAuth.api.url"), sb.append("OAuth ").append(strAccessToken).toString() , 5000, 5000, 3, false);

		} catch (Exception e) {
			logger.error("Unauthorized, pathInfo = " + pathInfo + ", strAccessToken = " + strAccessToken, e);
			response.setStatus(401);
			inviteListMv.addObject("errorTitle", message.getMessage("crane.error.401.title", null, Locale.JAPAN));
			inviteListMv.addObject("errorMessage", message.getMessage("crane.error.401.message", null, Locale.JAPAN));
			throw new ModelAndViewDefiningException(inviteListMv);
		}

		if(responseFromOauth == null) {
			logger.error("Unauthorized, responseFromOauth = null");
			response.setStatus(500);
			inviteListMv.addObject("errorTitle", message.getMessage("crane.error.500.title", null, Locale.JAPAN));
			inviteListMv.addObject("errorMessage", message.getMessage("crane.error.500.message", null, Locale.JAPAN));
			throw new ModelAndViewDefiningException(inviteListMv);
		}

		Map<String, String> mapJoonId = (Map<String, String>)JSON.decode(responseFromOauth);
		joonId = mapJoonId.get("joonId");
		if(joonId == null) {
			logger.error("JoonId is Null, strAccessToken = " + strAccessToken);
			response.setStatus(500);
			inviteListMv.addObject("errorTitle", message.getMessage("crane.error.500.title", null, Locale.JAPAN));
			inviteListMv.addObject("errorMessage", message.getMessage("crane.error.500.message", null, Locale.JAPAN));
			throw new ModelAndViewDefiningException(inviteListMv);
		}

		request.setAttribute("joonId", joonId);
		*/


		return true;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	
	/**
	 * Get a AccessToken
	 * 
	 * @param request
	 * @param response
	 * @throws OauthClientException
	 */
	private String getAccessToken(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		String accessToken = null;
		String authHeader = request.getHeader("Authorization");

		if (StringUtils.isEmpty(authHeader)) {
			response.setHeader("WWW-Authenticate", "OAuth error=".concat("invalid_request"));
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
		Matcher macher = Pattern.compile("(OAuth )(.+)").matcher(authHeader);
		if (macher.find() && macher.groupCount() == 2) {
			accessToken = macher.group(2);
		}

		return accessToken;
	}

	private NameValuePair[] getQueryString(String scope) throws Exception {

		NameValuePair nvpScope = new NameValuePair("scope", scope);
		NameValuePair nvpServiceId = new NameValuePair("serviceId", "1");

		NameValuePair[] arrayNvls = new NameValuePair[]{nvpScope, nvpServiceId};

		return arrayNvls;
	}

}