package dev.icheppy.chatcontrolmod;

import net.minecraft.client.gui.*;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;


public class ChatControlModGui extends GuiScreen {

    private GuiButton aote_button;
    private GuiButton button_playing_skyblock;
    private GuiButton button_playing_on_profile;
    private GuiButton button_warping;
    private GuiButton button_sending_to_server;
    private GuiButton button_reached_hype_limit;
    private GuiButton button_gexp;
    private GuiButton button_joined_the_lobby;
    private GuiButton button_request_to_join;
    private GuiButton button_implosion;
    private GuiButton button_combo;
    private GuiButton button_sceptre;
    private GuiButton button_midas_staff;
    private GuiButton button_heal_messages;
    private GuiButton button_not_enough_mana;
    private GuiButton button_cooldown;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui(){
        aote_button = new GuiButton(0, (width / 3) - 130, (int) (height * 0.05), "Block AOTE message:" + variableStateToString(ChatControlMod.block_aote_messages));
        button_playing_skyblock = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.05), "Block playing SB message:" + variableStateToString(ChatControlMod.block_playing_skyblock));

        button_playing_on_profile = new GuiButton(0, (width / 3) - 130, (int) (height * 0.15), "Block profile message:" + variableStateToString(ChatControlMod.block_playing_on_profile));
        button_warping = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.15), "Block warping message:" + variableStateToString(ChatControlMod.block_warping));

        button_sending_to_server= new GuiButton(0, (width / 3) - 130, (int) (height * 0.25), "Block sending to server message:" + variableStateToString(ChatControlMod.block_sending_to_server));
        button_reached_hype_limit = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.25), "Block hype limit message:" + variableStateToString(ChatControlMod.block_reached_hype_limit));

        button_gexp = new GuiButton(0, (width / 3) - 130, (int) (height * 0.35), "Block GEXP message:" + variableStateToString(ChatControlMod.block_gexp));
        button_joined_the_lobby = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.35), "Block joined message:" + variableStateToString(ChatControlMod.block_joined_the_lobby));

        button_request_to_join = new GuiButton(0, (width / 3) - 130, (int) (height * 0.45), "Block request message:" + variableStateToString(ChatControlMod.block_request_to_join));
        button_implosion = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.45), "Block implosion message:" + variableStateToString(ChatControlMod.block_implosion));

        button_combo = new GuiButton(0, (width / 3) - 130, (int) (height * 0.55), "Block combo message:" + variableStateToString(ChatControlMod.block_combo));
        button_sceptre = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.55), "Block sceptre message:" + variableStateToString(ChatControlMod.block_sceptre));

        button_midas_staff = new GuiButton(0, (width / 3) - 130, (int) (height * 0.65), "Block midas message:" + variableStateToString(ChatControlMod.block_midas_staff));
        button_heal_messages = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.65), "Block heal message:" + variableStateToString(ChatControlMod.block_heal_messages));

        button_not_enough_mana = new GuiButton(0, (width / 3) - 130, (int) (height * 0.75), "Block mana message:" + variableStateToString(ChatControlMod.block_not_enough_mana));
        button_cooldown = new GuiButton(0, (width / 3) * 2 - 70, (int) (height * 0.75), "Block cooldown message:" + variableStateToString(ChatControlMod.block_cooldown));

        this.buttonList.add(aote_button);
        this.buttonList.add(button_playing_skyblock);
        this.buttonList.add(button_playing_on_profile);
        this.buttonList.add(button_warping);
        this.buttonList.add(button_sending_to_server);
        this.buttonList.add(button_reached_hype_limit);
        this.buttonList.add(button_gexp);
        this.buttonList.add(button_joined_the_lobby);
        this.buttonList.add(button_request_to_join);
        this.buttonList.add(button_implosion);
        this.buttonList.add(button_combo);
        this.buttonList.add(button_sceptre);
        this.buttonList.add(button_midas_staff);
        this.buttonList.add(button_heal_messages);
        this.buttonList.add(button_not_enough_mana);
        this.buttonList.add(button_cooldown);

        super.initGui();

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == aote_button){
            ChatControlMod.block_aote_messages = !ChatControlMod.block_aote_messages;
            aote_button.displayString = "AOTE Messages:" + variableStateToString(ChatControlMod.block_aote_messages);

        }
        else if (button == button_playing_skyblock){
            ChatControlMod.block_playing_skyblock = !ChatControlMod.block_playing_skyblock;
            button_playing_skyblock.displayString = "Playing SB message:" + variableStateToString(ChatControlMod.block_playing_skyblock);
        }
        else if (button == button_playing_on_profile){
            ChatControlMod.block_playing_on_profile = !ChatControlMod.block_playing_on_profile;
            button_playing_on_profile.displayString = "Block profile message:" + variableStateToString(ChatControlMod.block_playing_on_profile);
        }
        else if (button == button_warping){
            ChatControlMod.block_warping = !ChatControlMod.block_warping;
            button_warping.displayString = "Block warping message:" + variableStateToString(ChatControlMod.block_warping);
        }
        else if (button == button_sending_to_server){
            ChatControlMod.block_sending_to_server = !ChatControlMod.block_sending_to_server;
            button_sending_to_server.displayString = "Block sending to server message:" + variableStateToString(ChatControlMod.block_sending_to_server);
        }
        else if (button == button_reached_hype_limit){
            ChatControlMod.block_reached_hype_limit = !ChatControlMod.block_reached_hype_limit;
            button_reached_hype_limit.displayString = "Block hype limit message:" + variableStateToString(ChatControlMod.block_reached_hype_limit);
        }
        else if (button == button_gexp){
            ChatControlMod.block_gexp = !ChatControlMod.block_gexp;
            button_gexp.displayString = "Block GEXP message:" + variableStateToString(ChatControlMod.block_gexp);
        }
        else if (button == button_joined_the_lobby){
            ChatControlMod.block_joined_the_lobby = !ChatControlMod.block_joined_the_lobby;
            button_joined_the_lobby.displayString = "Block joined message:" + variableStateToString(ChatControlMod.block_joined_the_lobby);
        }
        else if (button == button_request_to_join){
            ChatControlMod.block_request_to_join = !ChatControlMod.block_request_to_join;
            button_request_to_join.displayString = "Block request message:" + variableStateToString(ChatControlMod.block_request_to_join);
        }
        else if (button == button_implosion){
            ChatControlMod.block_implosion = !ChatControlMod.block_implosion;
            button_implosion.displayString = "Block implosion message:" + variableStateToString(ChatControlMod.block_implosion);
        }
        else if (button == button_combo){
            ChatControlMod.block_combo = !ChatControlMod.block_combo;
            button_combo.displayString = "Block combo message:" + variableStateToString(ChatControlMod.block_combo);
        }
        else if (button == button_sceptre){
            ChatControlMod.block_sceptre = !ChatControlMod.block_sceptre;
            button_sceptre.displayString = "Block sceptre message:" + variableStateToString(ChatControlMod.block_sceptre);
        }
        else if (button == button_midas_staff){
            ChatControlMod.block_midas_staff = !ChatControlMod.block_midas_staff;
            button_midas_staff.displayString = "Block midas message:" + variableStateToString(ChatControlMod.block_midas_staff);
        }
        else if (button == button_heal_messages){
            ChatControlMod.block_heal_messages = !ChatControlMod.block_heal_messages;
            button_heal_messages.displayString = "Block heal message:" + variableStateToString(ChatControlMod.block_heal_messages);
        }
        else if (button == button_not_enough_mana){
            ChatControlMod.block_not_enough_mana = !ChatControlMod.block_not_enough_mana;
            button_not_enough_mana.displayString = "Block mana message:" + variableStateToString(ChatControlMod.block_not_enough_mana);
        }
        else if (button == button_cooldown){
            ChatControlMod.block_cooldown = !ChatControlMod.block_cooldown;
            button_cooldown.displayString = "Block cooldown message:" + variableStateToString(ChatControlMod.block_cooldown);
        }

        super.actionPerformed(button);

    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        ChatControlMod.guiToOpen = null;
        ChatControlMod.configUpdate();
    }

    public static String variableStateToString(boolean state){
        if (state){
            return EnumChatFormatting.GREEN + " On";
        } else{
            return EnumChatFormatting.RED + " Off";
        }
    }
}

