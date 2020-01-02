package ru.ifmo.java;

import ru.ifmo.java.common.protocol.Protocol.*;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Client implements Runnable{

    private final Random rand;
    private final Server server;
    private final Socket socket;

    public Client() throws IOException {
        rand = new Random();
        socket = new Socket(Constant.serverHost, Constant.serverPort);
        server = new Server(socket);
    }

    @Override
    public void run() {
        for (int i = 0; i < DefaultSetting.numberOfRequestByClient; i++){
            sendOneRequest();
        }
    }

    private void sendOneRequest() {
        List<Integer> list = generateRandomValues();
        Request request = Request.newBuilder()
                .build();

        try {
            Response response = server.send(request);
            check(response.getNumberList());
        } catch (IOException e) {
            e.printStackTrace(); // io problems with one request
        }

        try {
            Thread.sleep(DefaultSetting.sleepTimeAfterResponse);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean check(List<Integer> list) {
        System.out.println("Ok");
        return true; //MOCK
    }

    private List<Integer> generateRandomValues() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < DefaultSetting.sizeOfArrayInRequest; i++) {
            list.add(rand.nextInt());
        }
        return list;
    }
}
