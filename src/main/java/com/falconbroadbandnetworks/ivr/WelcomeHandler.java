package com.falconbroadbandnetworks.ivr;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.*;

import static com.twilio.twiml.voice.Say.Voice.*;

public class WelcomeHandler {

    public WelcomeHandler(){

    }

    public String welcome(){
        Say welcomePrompt  = new Say.Builder(
                "Welcome to Falcon Broadband Networks")
                .voice(POLLY_MATTHEW)
                .build();

        Say spanishPrompt = new Say.Builder(
                "Para continuar en espanol oprima 2")
                .voice(POLLY_LUPE)
                .build();

        Say closedPrompt = new Say.Builder(
                "We are currently closed. Please call back later")
                .voice(POLLY_MATTHEW)
                .build();

        VoiceResponse voiceResponse = new VoiceResponse.Builder()
                .say(welcomePrompt)
                .pause(new Pause.Builder().length(1).build())
                .say(spanishPrompt)
                .gather(new Gather.Builder()
                        .action("/menu/spanish")
                        .numDigits(1)
                        .build())
                .redirect(new Redirect.Builder("/menu").build())
                .build();

        return voiceResponse.toXml();
    }
}
