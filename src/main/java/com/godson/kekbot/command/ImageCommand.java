package com.godson.kekbot.command;

import com.eziosoft.floatzel.kekbot.KekGlue.CommandEvent;

import com.eziosoft.floatzel.kekbot.KekGlueUtil.KekCommand;

import net.dv8tion.jda.api.entities.Message;

import javax.imageio.ImageIO;
import javax.net.ssl.SSLHandshakeException;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutionException;

import static com.eziosoft.floatzel.kekbot.KekGlueTwo.throwException;

public abstract class ImageCommand extends KekCommand {

    protected String filename;

    @Override
    public void onExecuted(CommandEvent event) {
        if (event.getMessage().getAttachments().size() > 0) {
            if (event.getMessage().getAttachments().get(0).isImage()) {
                try {
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendFile(generate(ImageIO.read(event.getMessage().getAttachments().get(0).retrieveInputStream().get())),  filename + ".png").queue();
                } catch (IOException | InterruptedException | ExecutionException e) {
                    throwException(e, event, "Image Generation Problem");
                }
            } else event.getChannel().sendMessage(event.getString("command.textimage.imagenotvalid")).queue();
        } else {
            if (event.getArgs().length > 0) {
                event.getChannel().sendTyping().queue();
                try {
                    URL image = new URL(event.getArgs()[0]);
                    URLConnection connection = image.openConnection();
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    connection.connect();
                    BufferedImage check = ImageIO.read(connection.getInputStream());
                    if (check == null) {
                        event.getChannel().sendMessage(event.getString("command.textimage.noimage")).queue();
                        return;
                    }

                    event.getChannel().sendFile(generate(check), filename + ".png").queue();
                } catch (MalformedURLException | UnknownHostException | IllegalArgumentException | FileNotFoundException e) {
                    event.getChannel().sendMessage(event.getString("command.textimage.invalidurl", "`" + event.getArgs()[0] + "`")).queue();
                } catch (SSLHandshakeException | SocketException e) {
                    event.getChannel().sendMessage(event.getString("command.textimage.unabletoconnect")).queue();
                } catch (IOException e) {
                    throwException(e, event, "Image Generation Problem");
                }
            } else {
                event.getChannel().getHistory().retrievePast(50).queue(messages -> {
                    for (Message message : messages) {
                        if (message.getAttachments().size() < 1) {
                            continue;
                        }

                        if (message.getAttachments().get(0).isImage()) {
                            try {
                                event.getChannel().sendTyping().queue();
                                event.getChannel().sendFile(generate(ImageIO.read(message.getAttachments().get(0).retrieveInputStream().get())), filename + ".png").queue();
                                return;
                            } catch (IOException | InterruptedException | ExecutionException e) {
                                throwException(e, event, "Image Generation Problem");
                            }
                        }
                    }
                    event.getChannel().sendMessage(event.getString("command.textimage.noimage")).queue();
                });
            }
        }
    }

    protected abstract byte[] generate(BufferedImage base) throws IOException;
}
