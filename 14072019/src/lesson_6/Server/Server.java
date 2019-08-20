package lesson_6.Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;


    public Server() throws SQLException {

        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {

            DBService.connect();

            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();

                new ClientHandler(this, socket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            DBService.disconnect();
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg) {
        for (ClientHandler o : clients) {
            if (!o.checkBlacklist(sender.getNick()))
                o.sendMsg(msg);
        }
    }

    public void sendPrivateMsg(String msg, ClientHandler sender, String destination) {
        for (ClientHandler o :
                clients) {
            if (o.getNick().equals(destination)) {
                if (!o.checkBlacklist(sender.getNick()))
                    o.sendMsg("Private message from " + msg);
                sender.sendMsg(sender.getNick() + ": Private message for " + destination + ": " + msg);
                return;
            }
        }
        sender.sendMsg("There is no user with this dick");
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public Vector<ClientHandler> getClients() {
        return clients;

    }
}
