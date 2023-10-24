package de.dafuqs.reverb;

import de.dafuqs.reverb.sound.*;
import de.dafuqs.reverb.sound.distortion.*;
import de.dafuqs.reverb.sound.reverb.*;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.event.registry.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

import java.util.*;

public class Reverb implements ModInitializer {
	
	public static final String MOD_ID = "reverb";
	
	public static final RegistryKey<Registry<SoundEffects>> SOUND_EFFECTS_KEY = RegistryKey.ofRegistry(new Identifier(MOD_ID, "sound_effects"));
	public static final Registry<SoundEffects> SOUND_EFFECTS = FabricRegistryBuilder.createSimple(SOUND_EFFECTS_KEY).buildAndRegister();
	
	@Override
	public void onInitialize() {
		Registry.register(ReverbEffect.REVERB_EFFECT_CODEC, new Identifier(MOD_ID, "static"), StaticReverbEffect.CODEC);
		Registry.register(DistortionEffect.DISTORTION_EFFECT_CODEC, new Identifier(MOD_ID, "static"), StaticDistortionEffect.CODEC);
		
		Registry.register(Reverb.SOUND_EFFECTS, new Identifier("overworld"),
				new SoundEffects(Optional.of(new StaticReverbEffect.Builder().setDecayTime(8.0F).setDensity(0.5F).build()),
						Optional.empty(),
						Optional.empty())
		);
	}
	
}
