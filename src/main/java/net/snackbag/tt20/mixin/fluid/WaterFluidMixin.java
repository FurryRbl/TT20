package net.snackbag.tt20.mixin.fluid;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.fluid.WaterFluid;
import net.snackbag.tt20.TT20;
import net.snackbag.tt20.util.TPSUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WaterFluid.class)
public abstract class WaterFluidMixin {
    @ModifyReturnValue(method = "getTickRate", at = @At("RETURN"))
    private int tickRateTT20(int original) {
        if (!TT20.config.enabled() || !TT20.config.fluidAcceleration()) return original;
        return TPSUtil.tt20(original, true);
    }
}
