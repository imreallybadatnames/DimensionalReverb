package de.dafuqs.reverb.sound.distortion;

import com.mojang.serialization.*;
import de.dafuqs.reverb.*;
import net.fabricmc.fabric.api.event.registry.*;
import net.minecraft.client.*;
import net.minecraft.client.sound.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

import java.util.function.*;

/**
 * A Distortion effect controls
 */
public abstract class DistortionEffect {

    @SuppressWarnings("unchecked")
    public static final Registry<Codec<? extends DistortionEffect>> DISTORTION_EFFECT_CODEC = (SimpleRegistry<Codec<? extends DistortionEffect>>) (Object) FabricRegistryBuilder.createSimple(Codec.class, new Identifier(Reverb.MOD_ID, "distortion_effect")).attribute(RegistryAttribute.SYNCED).buildAndRegister();
    public static final Codec<DistortionEffect> CODEC = DISTORTION_EFFECT_CODEC.getCodec().dispatchStable(DistortionEffect::getCodec, Function.identity());

    public abstract Codec<? extends DistortionEffect> getCodec();

    /**
     * Whether a Sound Event should be ignored
     *
     * @param identifier the Identifier of the Sound Event
     */
    public abstract boolean shouldIgnore(Identifier identifier);

    public abstract boolean isEnabled(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getEdge(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getGain(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getLowpassCutoff(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getEQCenter(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getEQBandWidth(MinecraftClient client, SoundInstance soundInstance);

}
