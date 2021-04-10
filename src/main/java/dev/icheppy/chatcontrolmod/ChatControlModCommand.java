package dev.icheppy.chatcontrolmod;


import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class ChatControlModCommand extends CommandBase {

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<String>() {
            {
                add("ccm");
            }
        };
    }

    @Override
    public String getCommandName() {
        return "chatcontrolmod";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chatcontrol [subcommand]";
    }

    @Override
    public void processCommand(ICommandSender ics, String[] args) {
        ics.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Opening the Chat Control Mod menu"));
        ChatControlMod.guiToOpen = "mainGui";

    }

    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}

