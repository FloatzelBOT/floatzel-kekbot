package com.godson.kekbot.command.commands.fun;

import com.darichey.discord.api.Command;
import com.darichey.discord.api.CommandCategory;
import com.godson.kekbot.EasyMessage;

public class Shrug {
    public static Command shrug = new Command("shrug")
            .withCategory(CommandCategory.FUN)
            .withDescription("\"¯\\_(ツ)_/¯\"")
            .withUsage("{p}lenny")
            .deleteCommand(true)
            .onExecuted(context -> context.getTextChannel().sendMessage("¯\\_(ツ)_/¯"));
}
