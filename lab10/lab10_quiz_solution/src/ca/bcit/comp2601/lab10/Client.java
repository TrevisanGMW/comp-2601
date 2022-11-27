package ca.bcit.comp2601.lab10;

/**
 * Java program to implement simplified version of the "command" design pattern.
 */
public class Client {

    public static void main(String args[]) {

        ControlDevice voiceControl = new VoiceControl("Alexa");
        voiceControl.setCommand("Light On", new LightOnCommand());
        voiceControl.setCommand("Light Off", new LightOffCommand());
        voiceControl.setCommand("Music On", new MusicOnCommand());
        voiceControl.setCommand("Music Off", new MusicOffCommand());

        voiceControl.runCommand("Light On");
        voiceControl.runCommand("Light Off");
        voiceControl.runCommand("Music On");
        voiceControl.runCommand("Music Off");


        ControlDevice remoteControl = new RemoteControl();
        remoteControl.setCommand("Light On", new LightOnCommand());
        remoteControl.setCommand("Light Off", new LightOffCommand());

        remoteControl.runCommand("Light On");
        remoteControl.runCommand("Light Off");
    }
}
