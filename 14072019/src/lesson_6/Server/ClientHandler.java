package lesson_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Server server;
    private String nick;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {

                        String str = in.readUTF();
                        if (str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            boolean userAlreadyConnected = false;
                            if (newNick != null) {
                                for (ClientHandler o :
                                        server.getClients()) {
                                    if(o.nick.equals(newNick)) {
                                        sendMsg("You're already here, mr. Durden");
                                        userAlreadyConnected = true;
                                        break;
                                    }
                                }
                                if(!userAlreadyConnected){
                                sendMsg("/authok");
                                nick = newNick;
                                server.subscribe(ClientHandler.this);
                                    System.out.println(server.getClients());
                                break;}
                            } else {
                                sendMsg("Неверный логин/пароль!");
                            }
                        }
                    }

                    while (true) {
                            String str = in.readUTF();
                            System.out.println("Client " + str);
                            if (str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            if (str.startsWith("/w")) {
                                String[] tokens = str.split(" ", 3);
                                if (tokens.length > 1) {
                                    server.sendPrivateMsg("Private message from " +
                                            nick + ": " + (tokens.length == 3 ? tokens[2] : "_"), this, tokens[1]);
                                    out.writeUTF("Message for " + tokens[1] + ": " + (tokens.length == 3 ? tokens[2] : "_"));
                                }
                                continue;
                            }
                            server.broadcastMsg(nick + ": " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(ClientHandler.this);
                    System.out.println(server.getClients());

                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }
}
