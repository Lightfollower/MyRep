package lesson_2.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Server server;
    private List<String> blackList;
    private String nick;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            server.executorService.submit(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String newNick = DBService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            boolean userAlreadyConnected = false;
                            if (newNick != null) {
                                for (ClientHandler o :
                                        server.getClients()) {
                                    if (o.nick.equals(newNick)) {
                                        sendMsg("You're already here, mr. Durden");
                                        userAlreadyConnected = true;
                                        break;
                                    }
                                }
                                if (!userAlreadyConnected) {
                                    sendMsg("/authok " + newNick);
                                    nick = newNick;
                                    server.subscribe(this);
                                    blackList = DBService.getBlackList(this.getNick());
                                    System.out.println(server.getClients());
                                    break;
                                }
                            } else {
                                sendMsg("Неверный логин/пароль!");
                            }
                        }


//                        if(str.startsWith("/reg")){
//                            String[] tokens = str.split(" ");
//                            String newNick = DBService.getNickByLoginAndPass(tokens[1], tokens[2]);
//                            if (newNick != null){
//                                sendMsg("no seats, all tickets sold");
//                            }else {
//                                DBService.addNewUser(tokens[1], tokens[2]);
//                            }
//                        }
                    }

                    while (true) {
                        String str = in.readUTF();
                        System.out.println("Client " + str);
//                        Disconnect
                        if (str.equals("/end")) {
                            out.writeUTF("/serverClosed");
                            break;
                        }
//                        Private messages
                        if (str.startsWith("/w")) {
                            String[] tokens = str.split(" ", 3);
                            if (tokens.length > 1) {
                                server.sendPrivateMsg((nick + ": " + (tokens.length == 3 ? tokens[2] : "_")), this, tokens[1]);
                            } else {
                                sendMsg("Who do you want to send it to?");
                            }
                            continue;
                        }
//                        BlackList
                        if (str.startsWith("/bs")) {
                            String[] tokens = str.split(" ");
                            if (tokens.length > 1) {
                                blackList.add(tokens[1]);
                                DBService.addUserInBlacklist(this.getNick(), tokens[1]);
                                sendMsg("Вы добавили пользователя " + tokens[1] + " в черный список");
                            } else sendMsg("Who you want to add to blacklist?");
                            continue;
                        }
//                      Nickname change
                        if (str.startsWith("/newNick")) {
                            String[] tokens = str.split(" ");
                            try {
                                DBService.changeNick(tokens[1], nick);
                                server.refreshBlackLists(nick, tokens[1]);
                                nick = tokens[1];
                                sendMsg("/changeOk " + nick);
                                continue;
                            } catch (SQLException e) {
                                sendMsg("/nickChangeDenied");
                                continue;
                            }
                        }

                        server.broadcastMsg(this, nick + ": " + str);
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
                    server.unsubscribe(this);
                    System.out.println(server.getClients());

                }

            });

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

    public boolean checkBlacklist(String nick) {
        return blackList.contains(nick);
    }

    public void updateBlacklist(String nick, String newNick) {
        for (int i = 0; i < blackList.size(); i++) {
            if(blackList.get(i).equals(nick))
                blackList.set(i, newNick);
        }
    }

    public String getNick() {
        return nick;
    }
}
