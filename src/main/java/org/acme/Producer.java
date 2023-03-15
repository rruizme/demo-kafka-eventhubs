package org.acme;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/demo-kafka-eventhubs")
public class Producer {

    @Inject
    @Channel("generated-message")
    Emitter<String> emitter;

    @GET
    @Path("/send/{message}")
    public void send(@PathParam("message") String message) {

        emitter.send(message);
    }
}