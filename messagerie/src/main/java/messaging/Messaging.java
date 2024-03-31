package messaging;

import grpc.MessagingServiceGrpc.MessagingServiceImplBase;
import grpc.Msg.EmptyResponse;
import grpc.Msg.Message;
import grpc.Msg.MessagesResponse;
import grpc.Msg.User;
import io.grpc.stub.StreamObserver;
 
public class Messaging extends MessagingServiceImplBase{

	@Override
	public void sendMessage(Message request, StreamObserver<EmptyResponse> responseObserver) {
		
	 // Logique pour envoyer le message au destinataire spécifié
        System.out.println("Message sent to: " + request.getReceiverId() + ", Text: " + request.getText());
        responseObserver.onNext(EmptyResponse.getDefaultInstance());
        responseObserver.onCompleted();
	}

	@Override
	public void getMessagesForUser(User request, StreamObserver<MessagesResponse> responseObserver) {
		// Logique pour récupérer les messages reçus pour l'utilisateur donné
        System.out.println("Messages retrieved for user: " + request.getId());
        // Supposons que nous avons une liste de messages déjà disponible
        MessagesResponse response = MessagesResponse.newBuilder()
                .addAllMessages(getMessagesFromDatabase(request.getId()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
	}

	 private List<Message> getMessagesFromDatabase(String userId) {
         // Logique pour récupérer les messages de la base de données
         // Cela peut varier selon votre configuration
         // Retourne une liste de messages pour l'utilisateur donné
     }
	
	
}
