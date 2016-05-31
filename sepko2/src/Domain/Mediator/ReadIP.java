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
	private int id;
	private String filepath;

	private ReadIP(String filepath) throws FileNotFoundException {
		this.filepath = filepath;
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
	
	private int readIdFromTxt(String filepath) throws FileNotFoundException {
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new FileReader(filepath));
		id = 0;
		String idString = "";
		try {
			in.readLine();
			idString = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		id = Integer.parseInt(idString);
		return id;
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
	
	public int getID() throws FileNotFoundException{
		this.id = readIdFromTxt(filepath);
		return id;
	}
	public static void main(String[] args) throws Exception{
		System.out.println(ReadIP.getReadIP("ServerIPaID").getID());
		System.out.println(ReadIP.getReadIP("ServerIPaID").getIP());
		
	}

}
