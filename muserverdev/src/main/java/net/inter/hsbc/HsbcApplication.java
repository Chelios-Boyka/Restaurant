package net.inter.hsbc;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.JSONObject;
import org.json.*;

import io.muserver.rest.RestHandlerBuilder;

import javax.ws.rs.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class HsbcApplication {

	public static void main(String[] args) {
		String tableSize = "Table size";
		String firstName = "First Name";
		String lastName = "Last Name";
		String email = "email";
		String bookedAt = "Reservation made at";
		LocalDateTime localDa = LocalDateTime.now();


		JSONObject a = new JSONObject();
		a.put(firstName, "Mon");
		a.put(lastName, "Sarmiento");
		a.put(tableSize, "4 chairs");
		a.put(bookedAt, localDa);

		JSONObject b = new JSONObject();
		b.put(firstName, "Alain");
		b.put(lastName, "Iturria");
		b.put(tableSize, "2 chairs");
		b.put(bookedAt, localDa);



		Map<Integer, JSONObject> users = new HashMap<>();
		users.put(1, a);
		users.put(2, b);
		UserResource userResource = new UserResource(users);

		MuServer server = MuServerBuilder.httpServer()
				.addHandler(RestHandlerBuilder.restHandler(userResource))
				.start();

		System.out.println("API example: " + server.uri().resolve("/restaurant/reservations/1"));

	}

	@Path("/restaurant/reservations")
	public static class UserResource {

		private final Map<Integer, JSONObject> users;

		public UserResource(Map<Integer, JSONObject> users) {
			this.users = users;
		}


		@GET
		@Path("/{id}")
		@Produces("application/json")
		public String get(@PathParam("id") int id) {
			boolean us = users.containsKey(id);
			if (us == false) {
				throw new NotFoundException("No user with id " + id);
			}
			return users.get(id).toString();
		}

		@GET
		@Path("/{users}")
		@Produces("application/json")
		public List<JSONObject> getusers() {
			return (List<JSONObject>) users;
		}


	}
}