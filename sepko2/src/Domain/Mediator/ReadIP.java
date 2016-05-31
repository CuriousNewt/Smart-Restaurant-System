package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadIP {
	private static ReadIP readIP;
	private String ip;
	private String filepath;

		/**
	    * Constructor setting up filepath and then setting up ip from the file.
	    * @param filepath String, which Contains the path to the file.
	    * * @throws FileNotFoundException If the file is not found.
	    */
	private ReadIP(String filepath) throws FileNotFoundException {
		this.filepath = filepath;
		this.ip = readIpFromTxt(filepath);
		
	}

	
		/**
	    * Method for setting up integer ip variable from file.
	    * @param filepath String containing the filepath of file with ip.
	    * @return Method is returning String, which contains the ip.
	    * @throws FileNotFoundException If the file is not found.
	    */
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
	

		/**
	    * Defining method of singleton pattern.
	    * @param filepath String the filepath of file with ip.
	    * @return ReadIP Returning itself.
	    * @throws FileNotFoundException If the file is not found. 
	    */
	public static ReadIP getReadIP(String filepath) throws FileNotFoundException {
		if (readIP == null) {
			readIP = new ReadIP(filepath);
		}
		return readIP;
	}

		/**
	    * Method returning the ip variale.
	    * @return ip Variable containing the IP.
	    */
	public String getIP() {
		return ip;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(ReadIP.getReadIP("ServerIPaID").getIP());
		
	}

}
