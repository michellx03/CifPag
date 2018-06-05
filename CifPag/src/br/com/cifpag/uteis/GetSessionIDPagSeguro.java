package br.com.cifpag.uteis;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetSessionIDPagSeguro {

	private static final String USER_AGENT = "Mozilla/5.0";

	

	// HTTP GET request post
	public String sendPost() throws Exception {

		String url = "https://ws.sandbox.pagseguro.uol.com.br/v2/sessions?email=robsonsantiagocortes@gmail.com&token=E27483AA8EA44076B9AAF6764649A693";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// String urlParameters =
		// "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		// wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
	   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.toString())));

		String sessionID;

		NodeList errNodes = doc.getElementsByTagName("session");
		if (errNodes.getLength() > 0) {
			Element err = (Element) errNodes.item(0);
			sessionID = err.getElementsByTagName("id").item(0).getTextContent();

		} else {
			sessionID = null;
		}

		return sessionID;

}

}
