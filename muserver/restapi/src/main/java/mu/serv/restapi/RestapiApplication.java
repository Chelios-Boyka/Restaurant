package mu.serv.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.muserver.*;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

		MuServer server = MuServerBuilder.httpServer()
				.addHandler(Method.GET, "/", (request, response, pathParams) -> {
					response.write("Hello, world");
				})
				.start();
		System.out.println("Started server at " + server.uri());
	}
}