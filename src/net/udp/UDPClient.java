package net.udp;

import test.Logs;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient extends Thread {

    DatagramSocket clientSocket;
    byte[] buff = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(buff, 1024);
    public static final int CLIENT_PORT = 4002;
    static final int TRY_SUM = 5;
    int tryTimes = 0;
    boolean canNext = true;


    @Override
    public void run() {
        super.run();
        try {
            clientSocket = new DatagramSocket(CLIENT_PORT);
            clientSocket.setSoTimeout(3000);
            String sendMessage = "hello server";
            // 客户端发送的报文
            DatagramPacket sendPacket = new DatagramPacket(sendMessage.getBytes(), 0, sendMessage.length(), InetAddress.getLocalHost(), UDPServer.SERVER_PORT);
            clientSocket.send(sendPacket);

            while (canNext && tryTimes <= TRY_SUM) {
                // 接受服务器端的报文
                try {
                    clientSocket.receive(receivePacket);
//                    String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
//                    Logs.l(receiveMessage + ",from " + receivePacket.getAddress().getHostAddress() + ":" + receivePacket.getPort());
                    canNext = false;
                } catch (Exception e) {
                    tryTimes++;
                    Logs.l("还剩余" + (TRY_SUM - tryTimes) + "次连接");
//                    e.printStackTrace();
                }
            }

            String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            Logs.l(receiveMessage + ",from " + receivePacket.getAddress() + ":" + receivePacket.getPort());
            receivePacket.setLength(1024);

            clientSocket.close();
            Logs.l("客户端断开连接");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String... args) {
        UDPClient client = new UDPClient();
        client.start();
    }


}
