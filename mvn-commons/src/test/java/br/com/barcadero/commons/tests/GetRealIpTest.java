package br.com.barcadero.commons.tests;

import java.net.*;
import java.io.*;
public class GetRealIpTest {


public static void main(String[] args) {
	URL whatismyip = null;
	try {
		whatismyip = new URL("http://checkip.amazonaws.com");
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	BufferedReader in = null;
	try {
		in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	String ip = "";
	try {
		ip = in.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //you get the IP as a String
	System.out.println(ip);
}
	
}
