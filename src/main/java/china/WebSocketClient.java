package china;


import javax.swing.*;
import javax.websocket.*;
import java.net.URI;
import java.util.Arrays;
import java.util.Iterator;

@ClientEndpoint()
public class WebSocketClient {
    @OnOpen
    public void onOpen(Session session) {}
    @OnMessage
    public void onMessage(String message) {
        String[] msg = message.split(",");
        if (msg[0].equals("<Connection>")){
            JOptionPane.showMessageDialog(null,
                        msg[1],
                        "已经连接到的计算机为：",
                        JOptionPane.
                                INFORMATION_MESSAGE);
        } else if (msg[0].equals("err")) {
            JOptionPane.showMessageDialog(null,
                    msg[1],
                    "错误：",
                    JOptionPane.
                            INFORMATION_MESSAGE);
        } else {
            Iterator<String> i = Arrays.asList(msg).iterator();

            System.out.println("Client onMessage: " + message);
            Competitor.getInstance().run(i);
        }

    }
    @OnClose
    public void onClose() {}


    private static String uri = "ws://localhost:8080/chess";
    public static Session session;
    public void start() {
        WebSocketContainer container = null;
        try {
            container = ContainerProvider.getWebSocketContainer();
            URI r = URI.create(uri);
            session = container.connectToServer(this, r);
        } catch (Exception ex) {
            System.out.println("error" + ex);
        }
    }
}
