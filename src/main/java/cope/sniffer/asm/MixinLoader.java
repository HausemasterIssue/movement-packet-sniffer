package cope.sniffer.asm;

import cope.sniffer.PositionPacketSniffer;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.Name("MixinLoader")
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE)
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class MixinLoader implements IFMLLoadingPlugin {
    public MixinLoader() {
        MixinBootstrap.init();
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
        Mixins.addConfiguration("mixins.sniffer.json");
        PositionPacketSniffer.LOGGER.info("lol loaded mixins xd cringe");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
