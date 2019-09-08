package lesson_2.Server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    protected static final Logger LOGGER = LogManager.getLogger(Server.class);

    ExecutorService executorService;
    private Vector<ClientHandler> clients;

    public Server() throws SQLException {
        executorService = Executors.newCachedThreadPool();
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            DBService.connect();
            server = new ServerSocket(8189);
            LOGGER.info("Server started!");
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                new ClientHandler(this, socket);
                LOGGER.info("new user connected.");
            }

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            for (StackTraceElement s :
                    e.getStackTrace()) {
                System.out.println(s);
            }
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }

            try {
                server.close();
                LOGGER.info("Server closed.");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
            DBService.disconnect();
            LOGGER.info("Server stopped.");
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg) {
        for (ClientHandler o : clients) {
            if (!o.checkBlacklist(sender.getNick())) {
                o.sendMsg(msg);
                LOGGER.trace("User: " + sender.getNick() + " send message to: " + o.getNick());
            }
        }
    }

    public void sendPrivateMsg(String msg, ClientHandler sender, String destination) {
        for (ClientHandler o :
                clients) {
            if (o.getNick().equals(destination)) {
                if (!o.checkBlacklist(sender.getNick()))
                    o.sendMsg("Private message from " + msg);
                sender.sendMsg(sender.getNick() + ": Private message for " + destination + ": " + msg);
                LOGGER.trace("User: " + sender.getNick() + " sent private message to: " + o.getNick());

                return;
            }
        }
        sender.sendMsg("There is no user with this dickname");
        LOGGER.trace("User sent message with wrong destination");

    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        LOGGER.info("User " + client.getNick() + " subscribed.");
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        LOGGER.info("User " + client.getNick() + " unsubscribed.");
    }

    public void refreshBlackLists(String nick, String newNick) {
        for (ClientHandler o : clients) {
            if (o.checkBlacklist(nick))
                o.updateBlacklist(nick, newNick);
        }
    }

    public Vector<ClientHandler> getClients() {
        return clients;
    }
}
