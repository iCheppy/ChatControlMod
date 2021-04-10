package dev.icheppy.chatcontrolmod;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Mod(modid = ChatControlMod.MODID, version = ChatControlMod.VERSION)
public class ChatControlMod
{
    public static final String MODID = "Chat Control Mod";
    public static final String VERSION = "1.3";
    
    public static boolean block_aote_messages = true;
    public static boolean block_playing_skyblock = true;
    public static boolean block_playing_on_profile = true;
    public static boolean block_warping = true;
    public static boolean block_sending_to_server = true;
    public static boolean block_reached_hype_limit = true;
    public static boolean block_gexp = true;
    public static boolean block_joined_the_lobby = true;
    public static boolean block_request_to_join = true;
    public static boolean block_implosion = true;
    public static boolean block_combo = true;
    public static boolean block_sceptre = true;
    public static boolean block_midas_staff = true;
    public static boolean block_heal_messages = true;
    public static boolean block_not_enough_mana = true;
    public static boolean block_cooldown = true;
    

    public static String guiToOpen = null;


    public static void configSetup(){

        // Create config file if doesn't exist

        try {
            File config = new File("config/ChatControlMod.cfg");
            if (config.createNewFile()) {
                configUpdate();
                System.out.println("Chat Control Mod config file created: " + config.getName());
            }

            Scanner config_reader = new Scanner(config);

            while (config_reader.hasNextLine()) {
                String[] data_split = config_reader.nextLine().split("=");
                if (data_split.length == 2){
                    if ("block_aote_messages".equalsIgnoreCase(data_split[0])) { block_aote_messages = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_playing_skyblock".equalsIgnoreCase(data_split[0])) { block_playing_skyblock = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_playing_on_profile".equalsIgnoreCase(data_split[0])) { block_playing_on_profile = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_warping".equalsIgnoreCase(data_split[0])) { block_warping = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_sending_to_server".equalsIgnoreCase(data_split[0])) { block_sending_to_server = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_reached_hype_limit".equalsIgnoreCase(data_split[0])) { block_reached_hype_limit = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_gexp".equalsIgnoreCase(data_split[0])) { block_gexp = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_joined_the_lobby".equalsIgnoreCase(data_split[0])) { block_joined_the_lobby = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_request_to_join".equalsIgnoreCase(data_split[0])) { block_request_to_join = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_implosion".equalsIgnoreCase(data_split[0])) { block_implosion = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_combo".equalsIgnoreCase(data_split[0])) { block_combo = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_sceptre".equalsIgnoreCase(data_split[0])) { block_sceptre = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_midas_staff".equalsIgnoreCase(data_split[0])) { block_midas_staff = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_heal_messages".equalsIgnoreCase(data_split[0])) { block_heal_messages = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_not_enough_mana".equalsIgnoreCase(data_split[0])) { block_not_enough_mana = "on".equalsIgnoreCase(data_split[1]);
                    } else if ("block_cooldown".equalsIgnoreCase(data_split[0])) { block_cooldown = "on".equalsIgnoreCase(data_split[1]);}

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void configUpdate(){
        try {
            FileWriter config_writer = new FileWriter("config/ChatControlMod.cfg");

            config_writer.write("block_aote_messages=" + stateConverter(block_aote_messages) + "\n");
            config_writer.write("block_playing_skyblock=" + stateConverter(block_playing_skyblock) + "\n");
            config_writer.write("block_playing_on_profile=" + stateConverter(block_playing_on_profile) + "\n");
            config_writer.write("block_warping=" + stateConverter(block_warping) + "\n");
            config_writer.write("block_sending_to_server=" + stateConverter(block_warping) + "\n");
            config_writer.write("block_reached_hype_limit=" + stateConverter(block_reached_hype_limit) + "\n");
            config_writer.write("block_gexp=" + stateConverter(block_gexp) + "\n");
            config_writer.write("block_joined_the_lobby=" + stateConverter(block_joined_the_lobby) + "\n");
            config_writer.write("block_request_to_join=" + stateConverter(block_request_to_join) + "\n");
            config_writer.write("block_implosion=" + stateConverter(block_implosion) + "\n");
            config_writer.write("block_combo=" + stateConverter(block_combo) + "\n");
            config_writer.write("block_sceptre=" + stateConverter(block_sceptre) + "\n");
            config_writer.write("block_midas_staff=" + stateConverter(block_midas_staff) + "\n");
            config_writer.write("block_heal_messages=" + stateConverter(block_heal_messages) + "\n");
            config_writer.write("block_not_enough_mana=" + stateConverter(block_not_enough_mana) + "\n");
            config_writer.write("block_cooldown=" + stateConverter(block_cooldown) + "\n");
            
            
            config_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String stateConverter(boolean state){
        if (state){
            return "on";
        } else {
            return "off";
        }
    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        configSetup(); // Creating a config file and populating it with data

        MinecraftForge.EVENT_BUS.register(new MessageListener());
        ClientCommandHandler.instance.registerCommand(new ChatControlModCommand());
    }
}
