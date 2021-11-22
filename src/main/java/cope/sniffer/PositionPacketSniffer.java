package cope.sniffer;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(name = "PosPacketSniffer", modid = "fuck_you", version = "1.0", clientSideOnly = true)
public class PositionPacketSniffer {
    public static final Logger LOGGER = LogManager.getLogger(PositionPacketSniffer.class);
    private static boolean enabled = false;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        LOGGER.info("allahu akbar");
        LOGGER.info("let's position sniff these clients shall we");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        int code = Keyboard.getEventKey();
        if (!Keyboard.getEventKeyState() && code != Keyboard.KEY_NONE && Minecraft.getMinecraft().currentScreen == null) {
            if (code == Keyboard.KEY_GRAVE) {
                enabled = !enabled;
                Minecraft.getMinecraft().player.sendMessage(new TextComponentString("State: " + enabled));
            }
        }
    }

    public static void log(CPacketPlayer packet) {
        if (enabled) {
            String builder = "Packet:" + "\n" +
                    "X: " + packet.getX(0.0) +
                    "\nY: " + packet.getY(0.0) +
                    "\nZ: " + packet.getZ(0.0) +
                    "\nOnGround: " + packet.isOnGround();

            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(builder));
        }
    }
}
