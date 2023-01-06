package de.dafuqs.reverb;

import de.dafuqs.reverb.sound.*;
import de.dafuqs.reverb.sound.distortion.*;
import de.dafuqs.reverb.sound.reverb.*;
import net.fabricmc.api.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;

public class Reverb implements ModInitializer {

    public static final String MOD_ID = "reverb";

    public static final RegistryKey<Registry<SoundEffects>> SOUND_EFFECTS_KEY = RegistryKey.ofRegistry(new Identifier(MOD_ID, "sound_effects"));
    public static final Registry<SoundEffects> SOUND_EFFECTS = Registry.create(SOUND_EFFECTS_KEY, registry -> new SoundEffects());

    @Override
    public void onInitialize() {
        Registry.register(ReverbEffect.REVERB_EFFECT_CODEC, new Identifier(MOD_ID, "static"), StaticReverbEffect.CODEC);
        Registry.register(DistortionEffect.DISTORTION_EFFECT_CODEC, new Identifier(MOD_ID, "static"), StaticDistortionEffect.CODEC);
    }

}
