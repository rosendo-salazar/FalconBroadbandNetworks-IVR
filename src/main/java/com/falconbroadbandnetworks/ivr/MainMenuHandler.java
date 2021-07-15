package com.falconbroadbandnetworks.ivr;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Gather;
import com.twilio.twiml.voice.Pause;
import com.twilio.twiml.voice.Redirect;
import com.twilio.twiml.voice.Say;

import static com.twilio.twiml.voice.Say.Voice.POLLY_LUPE;
import static com.twilio.twiml.voice.Say.Voice.POLLY_MATTHEW;

public class MainMenuHandler {

    public MainMenuHandler() {

    }


    public String mainMenu() {
        Say salesPrompt  = new Say.Builder(
                "For sales press 1")
                .voice(POLLY_MATTHEW)
                .build();

        Say customerServicePrompt = new Say.Builder(
                "For support press 2")
                .voice(POLLY_MATTHEW)
                .build();

        Say hoursOfOperationPrompt = new Say.Builder(
                "Our hours of operations are Monday through Friday 9:00AM to 8:00PM")
                .voice(POLLY_MATTHEW)
                .build();


        VoiceResponse voiceResponse = new VoiceResponse.Builder()
                .say(hoursOfOperationPrompt)
                .pause(new Pause.Builder().length(1).build())
                .say(salesPrompt)
                .pause(new Pause.Builder().length(1).build())
                .say(customerServicePrompt)
                .gather(new Gather.Builder()
                        .action("/menu/process")
                        .numDigits(1)
                        .build())
                .build();

        return voiceResponse.toXml();
    }

    public String spanishMenu() {
        Say salesPrompt  = new Say.Builder(
                "Para ventas presione 1")
                .voice(POLLY_LUPE)
                .build();

        Say customerServicePrompt = new Say.Builder(
                "Para soporte presione 2")
                .voice(POLLY_LUPE)
                .build();

        Say hoursOfOperationPrompt = new Say.Builder(
                "Nuestro horario de atención es de lunes a viernes de 9:00 a.M. A 8:00 p.M.")
                .voice(POLLY_LUPE)
                .build();


        VoiceResponse voiceResponse = new VoiceResponse.Builder()
                .say(hoursOfOperationPrompt)
                .pause(new Pause.Builder().length(1).build())
                .say(salesPrompt)
                .pause(new Pause.Builder().length(1).build())
                .say(customerServicePrompt)
                .gather(new Gather.Builder()
                        .action("/menu/process")
                        .numDigits(1)
                        .build())
                .build();

        return voiceResponse.toXml();
    }
}
