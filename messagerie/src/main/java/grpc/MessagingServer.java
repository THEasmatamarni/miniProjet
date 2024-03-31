package grpc;
import messaging.Messaging;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MessagingServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090)
                .addService(new Messaging())
                .build();

        server.start();
        System.out.println("Server started...");
        server.awaitTermination();
    }

 
    }

