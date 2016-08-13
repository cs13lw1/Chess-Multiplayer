package network;


import javax.swing.JOptionPane;

public class NetworkManager {

	public static NetworkInstance selectRole() {

		Object[] options = { "Host", "Client", "Abbrechen" };

		int n = JOptionPane.showOptionDialog(null, "Do you want to be host or client?", "Network Role Selection",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		NetworkInstance networkInstance = null;

		switch (n) {
		case 0:
			networkInstance = createHost();
			break;
		case 1:
			networkInstance = createClient();
			break;
		default:
			System.exit(0);
		}
		return networkInstance;
	}

	private static NetworkInstance createHost() {
		Host host = new Host();
		host.openServer(9595);
		host.waitForClient();
		System.out.println("connected");
		return host;
	}

	private static NetworkInstance createClient() {
		String host = JOptionPane.showInputDialog("Please insert a Hostname", "localhost");
		
		Client client = new Client();
		client.connect(host, 9595);
		return client;
	}

}
