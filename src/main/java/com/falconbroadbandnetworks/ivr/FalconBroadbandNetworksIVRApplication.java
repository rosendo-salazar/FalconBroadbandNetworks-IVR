package com.falconbroadbandnetworks.ivr;

import com.sun.tools.javac.Main;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Gather;
import com.twilio.twiml.voice.Say;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static spark.Spark.*;

public class FalconBroadbandNetworksIVRApplication {

	public static int getPort(){
		int port = 8080;

		String value = System.getenv("PORT");

		if(value != null){
			port = Integer.parseInt(value);
		}
		return port;
	}

	public static void main(String[] args) {

		port(getPort());

		WelcomeHandler welcomeHandler = new WelcomeHandler();
		MainMenuHandler mainMenuHandler = new MainMenuHandler();

		get("/", (request, response) -> {
			return welcomeHandler.welcome();
		});

		post("/", (request, response) -> {
			return welcomeHandler.welcome();
		});

		get("/menu", (request, response) -> {
			return mainMenuHandler.mainMenu();
		});

		post("/menu", (request, response) -> {
			return mainMenuHandler.mainMenu();
		});

		get("/menu/spanish", (request, response) -> {
			return mainMenuHandler.spanishMenu();
		});

		post("/menu/spanish", (request, response) -> {
			return mainMenuHandler.spanishMenu();
		});


	}

}
