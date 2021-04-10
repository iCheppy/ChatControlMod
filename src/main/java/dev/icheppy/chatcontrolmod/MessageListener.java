package dev.icheppy.chatcontrolmod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class MessageListener {

    @SubscribeEvent
    public void onMessageEvent(ClientChatReceivedEvent event){

        String message = event.message.getUnformattedText().replaceAll("(?:§.)", "");

        if (message.contains("You are playing on profile:")){
            System.out.println("Cancelling you are playing on profile");
            event.setCanceled(ChatControlMod.block_playing_on_profile);
        }

        // Prevent player messages from being affected
        if (message.contains(":")){
            return;
        }

        // Block AOTE messages
        if (message.equals("There are blocks in the way!")){
            event.setCanceled(ChatControlMod.block_aote_messages);
            return;
        }

        if (message.equals("Welcome to Hypixel SkyBlock!")){
            event.setCanceled(ChatControlMod.block_playing_skyblock);
            return;
        }


        if (message.startsWith("Sending to server")){
            event.setCanceled(ChatControlMod.block_sending_to_server);
            return;
        }

        if (message.startsWith("Request join for")){
            event.setCanceled(ChatControlMod.block_request_to_join);
            return;
        }

        if (message.startsWith("Warping")){
            event.setCanceled(ChatControlMod.block_warping);
            return;
        }

        if (message.endsWith("right-clicking with the Hype Diamond!")){
            event.setCanceled(ChatControlMod.block_reached_hype_limit);
            return;
        }

        if (message.endsWith("joined the lobby!")){
            event.setCanceled(ChatControlMod.block_joined_the_lobby);
            return;
        }

        if (message.endsWith("from playing SkyBlock!")){
            event.setCanceled(ChatControlMod.block_gexp);
            return;
        }

        if (message.equals("You do not have enough mana to do this!")){
            event.setCanceled(ChatControlMod.block_not_enough_mana);
            return;
        }

        if (message.startsWith("Your Implosion hit")){
            event.setCanceled(ChatControlMod.block_implosion);
            return;
        }

        if (message.contains("Kill Combo")){
            event.setCanceled(ChatControlMod.block_combo);
            return;
        }

        if (message.startsWith("This ability is on cooldown for")){
            event.setCanceled(ChatControlMod.block_cooldown);
            return;
        }

        if (message.contains("healed you for ") || message.startsWith("You healed")){
            event.setCanceled(ChatControlMod.block_heal_messages);
            return;
        }

        if (message.startsWith("Your Kill Combo ")){
            event.setCanceled(ChatControlMod.block_combo);
            return;
        }

        if (message.startsWith("Your Molten Wave hit")){
            event.setCanceled(ChatControlMod.block_midas_staff);
            return;
        }

        if (message.startsWith("Your Spirit Sceptre hit")){
            event.setCanceled(ChatControlMod.block_sceptre);
            return;
        }








        /*
        // Ambient mode check

        if (ExampleMod.ambient){
            event.setCanceled(true);
        }

        String unformatted_message_text = event.message.getUnformattedText();
        String formatted_message_text = event.message.getFormattedText();


        // Block AOTE messages

        if (unformatted_message_text.equalsIgnoreCase("There are blocks in the way!")){
            event.setCanceled(ExampleMod.block_aote_messages);
        }

        // Guild replacement

        if (unformatted_message_text.contains("Guild >")){
            formatted_message_text = formatted_message_text.replaceFirst("Guild >", ExampleMod.guild_alt + " >");
        }

        // Party replacement

        if (unformatted_message_text.contains("§9Party §8>")){
            formatted_message_text = formatted_message_text.replaceFirst("(?:Party)", ExampleMod.party_alt);
        }

        // Hide ranks

        if (ExampleMod.hide_ranks){
            formatted_message_text = formatted_message_text.replaceFirst("(?:\\[[M,V][I,V][P]]\\s|\\[[M,V][I,V][P]..\\+..]\\s|\\[[M,V][I,V][P]..\\+\\+..]\\s)", "");
        }


        // Send replaced message
        //.setChatStyle(event.message.getChatStyle())
        event.message = new ChatComponentText(formatted_message_text);
        */

    }

    @SubscribeEvent
    public void renderTick(TickEvent.RenderTickEvent event){
        if (ChatControlMod.guiToOpen != null){
            Minecraft.getMinecraft().displayGuiScreen(new ChatControlModGui());
        }
    }
}
