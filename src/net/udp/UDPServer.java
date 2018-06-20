package net.udp;

import test.Logs;

import java.io.IOException;
import java.net.*;

public class UDPServer extends Thread {

    public static final int SERVER_PORT = 4001;
    byte[] buff = new byte[1024];
    DatagramSocket serverSocket = null;
    DatagramPacket receivePacket = new DatagramPacket(buff, 1024);
    DatagramPacket sendPacket = null;


    public UDPServer() {
        try {
            serverSocket = new DatagramSocket(SERVER_PORT, InetAddress.getLocalHost());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    boolean isStart = true;

    @Override
    public void run() {
        super.run();

        Logs.l("server is running");

        while (isStart) {
            try {
                serverSocket.receive(receivePacket);
                String info = new String(receivePacket.getData(), 0, receivePacket.getLength());
                Logs.l(info + " from " + receivePacket.getAddress() + ":" + receivePacket.getPort());
                String sendText = "hello client";

                Thread.sleep(5000);

                sendPacket = new DatagramPacket(sendText.getBytes(), 0, sendText.length(),receivePacket.getAddress(),UDPClient.CLIENT_PORT);
                serverSocket.send(sendPacket);
                receivePacket.setLength(1024);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        serverSocket.close();
    }

    public static void main(String... args) {
        UDPServer server = new UDPServer();
        server.start();
    }


}
