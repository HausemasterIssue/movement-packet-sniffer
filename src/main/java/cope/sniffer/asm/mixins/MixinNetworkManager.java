package cope.sniffer.asm.mixins;

import cope.sniffer.PositionPacketSniffer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {
    @Inject(method = "sendPacket", at = @At("HEAD"))
    public void sendPacket(Packet<?> packet, CallbackInfo info) {
        if (packet instanceof CPacketPlayer) {
            PositionPacketSniffer.log((CPacketPlayer) packet);
        }
    }
}
