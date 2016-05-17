package Domain.Mediator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadIP {
	private static ReadIP readIP;
	private String ip;

	private ReadIP(String filepath) throws FileNotFoundException {
		this.ip = readIpFromTxt(filepath);
	}

	private String readIpFromTxt(String filepath) throws FileNotFoundException {
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new FileReader(filepath));
		ip = null;
		try {
			ip = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ip;
	}

	public static ReadIP getReadIP(String filepath)
			throws FileNotFoundException {
		if (readIP == null) {
			readIP = new ReadIP(filepath);
		}
		return readIP;
	}

	public String getIP() {
		return ip;
	}

}
