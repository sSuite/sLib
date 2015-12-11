package com.github.sSuite.sLib.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPUtility {

	/**
	 * Performs a GET request with the specified URL.
	 *
	 * @param url
	 *            - the URL
	 * @return the response from the GET request
	 * @throws MalformedURLException
	 *             if no protocol is specified, or an unknown protocol is found,
	 *             or spec is null
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static String get(String url) throws MalformedURLException, IOException {
		return get(new URL(url));
	}

	/**
	 * Performs a GET request with the specified URL.
	 *
	 * @param url
	 *            - the URL
	 * @return the response from the GET request
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static String get(URL url) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

		String response = reader.readLine();

		while (true) {
			String line = reader.readLine();

			if (line == null) {
				reader.close();
				break;
			}

			response += System.lineSeparator() + line;
		}

		if (response == null) {
			response = "";
		}

		return response;
	}

}
