package grpc;
import grpc.Msg.EmptyResponse;
import grpc.Msg.Message;
import grpc.Msg.MessagesResponse;
import grpc.Msg.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MessagingClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        MessagingServiceGrpc.MessagingServiceBlockingStub stub = MessagingServiceGrpc.newBlockingStub(channel);

        // Exemple d'envoi de message
        Message message = Message.newBuilder()
                .setSenderId("sender_id")
                .setReceiverId("receiver_id")
                .setText("Hello, world!")
                .build();
        EmptyResponse response = stub.sendMessage(message);
        System.out.println("Message sent successfully!");

        // Exemple de récupération de messages pour un utilisateur
        User user = User.newBuilder()
                .setId("receiver_id")
                .build();
        MessagesResponse messagesResponse = stub.getMessagesForUser(user);
        for (Message msg : messagesResponse.getMessagesList()) {
            System.out.println("Message: " + msg.getText());
        }

        channel.shutdown();
    }
}
