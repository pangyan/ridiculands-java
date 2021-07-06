package com.ridiculands;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class ZAuthenticator extends Authenticator {

	private String proxyUserName;
	private String proxyPassword;

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		System.err.println("TESTING, " + this.getRequestingHost());
		System.err.println("TESTING, " + this.getRequestingPrompt());
		System.err.println("TESTING, " + this.getRequestingProtocol());
		System.err.println("TESTING, " + this.getRequestingScheme());
		System.err.println("TESTING, " + String.valueOf(this.getRequestingPort()));
		System.err.println("TESTING, " + this.getRequestingSite().getHostAddress());
//		Log.error("TESTING", this.getRequestingURL().toExternalForm());
		System.err.println("TESTING, " + this.getRequestorType().toString());

		return new PasswordAuthentication(this.proxyUserName, this.proxyPassword.toCharArray());
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

}
