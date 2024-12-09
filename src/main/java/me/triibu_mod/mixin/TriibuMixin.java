package me.triibu_mod.mixin;

import me.triibu_mod.WorldAPI;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class TriibuMixin {

    @Inject(method = "runServer", at = @At("HEAD"))
    public void onServerStart(CallbackInfo info) {
        WorldAPI.setMinecraftServer((MinecraftServer) (Object) this);
    }

    @Inject(at = @At("HEAD"), method = "loadWorld")
    private void init(CallbackInfo info) {
    }
}
