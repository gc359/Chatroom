package Project.Milestone2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Room implements AutoCloseable{
	protected static Server server;// used to refer to accessible server functions
	private String name;
	private List<ServerThread> clients = new ArrayList<ServerThread>();
	private boolean isRunning = false;
	// Commands
	private final static String COMMAND_TRIGGER = "/";
	private final static String CREATE_ROOM = "createroom";
	private final static String JOIN_ROOM = "joinroom";
	private final static String DISCONNECT = "disconnect";
	private final static String LOGOUT = "logout";
	private final static String LOGOFF = "logoff";

	public Room(String name) {
		this.name = name;
		isRunning = true;
	}

	private void info(String message) {
		System.out.println(String.format("Room[%s]: %s", name, message));
	}

	public String getName() {
		return name;
	}

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			new Thread() {
				@Override
				public void run() {
					// slight delay to let potentially new client to finish
					// binding input/output streams
					// comment out the Thread.sleep to see what happens
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//sendMessage(client, "joined the room " + getName());
					sendConnectionStatus(client, true);
				}
			}.start();

		}
	}

	protected synchronized void removeClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		clients.remove(client);
		// we don't need to broadcast it to the server
		// only to our own Room
		if (clients.size() > 0) {
			//sendMessage(client, "left the room");
			sendConnectionStatus(client, false);
		}
		checkClients();
	}

	/***
	 * Checks the number of clients.
	 * If zero, begins the cleanup process to dispose of the room
	 */
	private void checkClients() {
		// Cleanup if room is empty and not lobby
		if (!name.equalsIgnoreCase("lobby") && clients.size() == 0) {
			close();
		}
	}

	/***
	 * Helper function to process messages to trigger different functionality.
	 * 
	 * @param message The original message being sent
	 * @param client  The sender of the message (since they'll be the ones
	 *                triggering the actions)
	 */
	private boolean processCommands(String message, ServerThread client) {
		boolean wasCommand = false;
		try {
			if (message.startsWith(COMMAND_TRIGGER)) {
				String[] comm = message.split(COMMAND_TRIGGER);
				String part1 = comm[1];
				String[] comm2 = part1.split(" ");
				String command = comm2[0];
				String roomName;
				wasCommand = true;
				switch (command) {
					case CREATE_ROOM:
						roomName = comm2[1];
						Room.createRoom(roomName, client);
						break;
					case JOIN_ROOM:
						roomName = comm2[1];
						Room.joinRoom(roomName, client);
						break;
					case DISCONNECT:
					case LOGOUT:
					case LOGOFF:
						Room.disconnectClient(client, this);
						break;
					default:
						wasCommand = false;
						break;
				}

			}

			if(message.startsWith("/flip")){
            
				int coin = (int) ( Math.random() * 2 + 1); // will return either 1 or 2
				
					if (coin == 1){ server.broadcast(client.getClientName()+" has flipped a coin and it landed on heads"); }
					else {server.broadcast(client.getClientName()+" has flipped a coin and it landed on tails");}}

			if(message.startsWith("/roll")){
            
				int dice = (int) ( Math.random() * 6 + 1); // will return either 1 - 6
				
				server.broadcast(client.getClientName()+" has rolled the dice and it landed on " + dice); }
					
				if (message.contains("!") || 
				message.contains("@") ||
				message.contains("#") ||
				message.contains("$") ||
				message.contains("%") ||
				message.contains("^") ){
			
			//! = bold
			//@ = italic
			//# = underline
			//$ = red
			//% = blue
			//^ = green
			
			String bold = "!";
			String italic = "_";
			String underline = "#";
			String red = "$";
			String blue = "%";
			String green = "^";
			
			int underlineCounter = 0;
			int italicCounter = 0;
			int boldCounter = 0;
			int redCounter = 0;
			int blueCounter = 0;
			int greenCounter = 0;
			
			String[] newMessage = message.split("");
			
			for (int i = 0; i < newMessage.length; i++) {
			  
			  if (newMessage[i].equals(bold) && boldCounter == 0){
				  newMessage[i] = "<b>";
				boldCounter++;}
			  
			  else if (newMessage[i].equals(bold) && boldCounter == 1){
				  newMessage[i] = "</b>";
				boldCounter--;}
				
			  if (newMessage[i].equals(italic) && italicCounter == 0){
				  newMessage[i] = "<i>";
				italicCounter++;}
			  
			  else if (newMessage[i].equals(italic) && italicCounter == 1){
				  newMessage[i] = "</i>";
				italicCounter--;}
				
			  if (newMessage[i].equals(underline) && underlineCounter == 0){
				  newMessage[i] = "<u>";
				underlineCounter++;}
			  
			  else if (newMessage[i].equals(underline) && underlineCounter == 1){
				  newMessage[i] = "</u>";
				underlineCounter--;}
				
			   if (newMessage[i].equals(red) && redCounter == 0){
				  newMessage[i] = "<font color='red'>";
				redCounter++;}
			  
			  else if (newMessage[i].equals(red) && redCounter == 1){
				  newMessage[i] = "</font>";
				redCounter--;}
				
			   if (newMessage[i].equals(blue) && blueCounter == 0){
				  newMessage[i] = "<font color='blue'>";
				blueCounter++;}
			  
			  else if (newMessage[i].equals(blue) && blueCounter == 1){
				  newMessage[i] = "</font>";
				blueCounter--;}
				
			   if (newMessage[i].equals(green) && greenCounter == 0){
				  newMessage[i] = "<font color='green'>";
				greenCounter++;}
			  
			  else if (newMessage[i].equals(green) && greenCounter == 1){
				  newMessage[i] = "</font>";
				greenCounter--;}
			  
		 
			
			}
			
			message = String.join("",newMessage);
			server.broadcast(message);}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasCommand;
	}

	// Command helper methods
	protected static void createRoom(String roomName, ServerThread client) {
		if (server.createNewRoom(roomName)) {
			server.joinRoom(roomName, client);
		} else {
			client.sendMessage("Server", String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!server.joinRoom(roomName, client)) {
			client.sendMessage("Server", String.format("Room %s doesn't exist", roomName));
		}
	}

	protected static void disconnectClient(ServerThread client, Room room) {
		client.setCurrentRoom(null);
		client.disconnect();
		room.removeClient(client);
	}
	// end command helper methods

	/***
	 * Takes a sender and a message and broadcasts the message to all clients in
	 * this room. Client is mostly passed for command purposes but we can also use
	 * it to extract other client info.
	 * 
	 * @param sender  The client sending the message
	 * @param message The message to broadcast inside the room
	 */
	protected synchronized void sendMessage(ServerThread sender, String message) {
		if (!isRunning) {
			return;
		}
		info("Sending message to " + clients.size() + " clients");
		if (sender != null && processCommands(message, sender)) {
			// it was a command, don't broadcast
			return;
		}
		
		String from = (sender == null ? "Room" : sender.getClientName());
		Iterator<ServerThread> iter = clients.iterator();
		while (iter.hasNext()) {
			ServerThread client = iter.next();
			boolean messageSent = client.sendMessage(from, message);
			if (!messageSent) {
				handleDisconnect(iter, client);
			}
		}
	}
	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected){
		Iterator<ServerThread> iter = clients.iterator();
		while (iter.hasNext()) {
			ServerThread client = iter.next();
			boolean messageSent = client.sendConnectionStatus(sender.getClientName(), isConnected);
			if (!messageSent) {
				handleDisconnect(iter, client);
			}
		}
	}
	private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client){
		iter.remove();
		info("Removed client " + client.getId());
		checkClients();
		sendMessage(null, client.getId() + " disconnected");
	}
	public void close() {
		server.removeRoom(this);
		//NOTE: This will break all rooms
		//be sure to remove/comment out server = null;
		server = null;
		isRunning = false;
		clients = null;
	}
}