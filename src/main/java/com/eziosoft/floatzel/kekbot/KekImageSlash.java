package com.eziosoft.floatzel.kekbot;

import com.eziosoft.floatzel.SlashCommands.FSlashCommand;
import com.eziosoft.floatzel.SlashCommands.Objects.SlashOption;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;

public class KekImageSlash extends FSlashCommand {

    public KekImageSlash(){
        name = "kekimage";
        help = "Run kekbot's image commands from slash!";
        hasoptions = true;
        optlist.add(new SlashOption(OptionType.STRING, "Image URL to download from!", "image", true));
        optlist.add(new SlashOption(OptionType.STRING, "command to run", "cmdname"));
    }

    @Override
    protected void execute(SlashCommandEvent slashCommandEvent) {
        // todo: everything
    }
}
