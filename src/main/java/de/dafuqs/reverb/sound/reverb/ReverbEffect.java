package de.dafuqs.reverb.sound.reverb;

import com.mojang.serialization.*;
import de.dafuqs.reverb.*;
import net.fabricmc.fabric.api.event.registry.*;
import net.minecraft.client.*;
import net.minecraft.client.sound.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;

import java.util.function.*;

/**
 * A Reverb effect controls
 */
public abstract class ReverbEffect {

    @SuppressWarnings("unchecked")
    public static final SimpleRegistry<Codec<? extends ReverbEffect>> REVERB_EFFECT_CODEC = (SimpleRegistry<Codec<? extends ReverbEffect>>) (Object) FabricRegistryBuilder.createSimple(Codec.class, new Identifier(Reverb.MOD_ID, "reverb_effect")).attribute(RegistryAttribute.SYNCED).buildAndRegister();
    public static final Codec<ReverbEffect> CODEC = REVERB_EFFECT_CODEC.getCodec().dispatchStable(ReverbEffect::getCodec, Function.identity());

    public abstract Codec<? extends ReverbEffect> getCodec();

    /**
     * Whether a Sound Event should be ignored
     *
     * @param identifier the Identifier of the Sound Event
     */
    public abstract boolean shouldIgnore(Identifier identifier);

    public abstract boolean isEnabled(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getAirAbsorptionGainHF(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getDecayHFRatio(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getDensity(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getDiffusion(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getGain(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getGainHF(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getLateReverbGainBase(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getDecayTime(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getReflectionsGainBase(MinecraftClient client, SoundInstance soundInstance);

    public abstract int getDecayHFLimit(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getLateReverbDelay(MinecraftClient client, SoundInstance soundInstance);

    public abstract float getReflectionsDelay(MinecraftClient client, SoundInstance soundInstance);

}
