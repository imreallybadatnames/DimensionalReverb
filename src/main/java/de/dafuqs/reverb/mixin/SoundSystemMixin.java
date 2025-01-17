package de.dafuqs.reverb.mixin;

import de.dafuqs.reverb.sound.distortion.*;
import de.dafuqs.reverb.sound.reverb.*;
import net.minecraft.client.sound.*;
import net.minecraft.sound.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.At.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import java.util.*;
import java.util.concurrent.*;

@Mixin(SoundSystem.class)
public abstract class SoundSystemMixin {
	
	@Inject(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/GameOptions;getSoundVolume(Lnet/minecraft/sound/SoundCategory;)F", shift = Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD)
	public void reverb$tick(CallbackInfo ci, Iterator<?> iterator, Map.Entry<?, ?> entry, Channel.SourceManager sourceManager, SoundInstance soundInstance) {
		sourceManager.run(source -> ReverbFilter.update(soundInstance, ((SourceAccessor) source).getPointer()));
		sourceManager.run(source -> DistortionFilter.update(soundInstance, ((SourceAccessor) source).getPointer()));
	}
	
	@Inject(method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/Channel$SourceManager;run(Ljava/util/function/Consumer;)V", ordinal = 0, shift = Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD)
	public void reverb$play(SoundInstance soundInstance, CallbackInfo ci, WeightedSoundSet weightedSoundSet, Identifier identifier, Sound sound, float f, float g, SoundCategory soundCategory, float h, float i, SoundInstance.AttenuationType attenuationType, boolean bl, Vec3d vec3d, boolean bl3, boolean bl4, CompletableFuture<?> completableFuture, Channel.SourceManager sourceManager) {
		sourceManager.run(source -> ReverbFilter.update(soundInstance, ((SourceAccessor) source).getPointer()));
		sourceManager.run(source -> DistortionFilter.update(soundInstance, ((SourceAccessor) source).getPointer()));
	}
	
	@Inject(method = "reloadSounds()V", at = @At("TAIL"))
	public void reverb$reloadSounds(CallbackInfo ci) {
		ReverbFilter.update();
		DistortionFilter.update();
	}
	
}
