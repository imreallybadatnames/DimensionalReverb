package de.dafuqs.reverb.sound;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import de.dafuqs.reverb.sound.distortion.*;
import de.dafuqs.reverb.sound.reverb.*;
import net.minecraft.sound.*;

import java.util.*;

public class SoundEffects {
	
	public static final Codec<SoundEffects> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
			ReverbEffect.CODEC.optionalFieldOf("reverb").stable().forGetter((soundEffects) -> soundEffects.reverb),
			DistortionEffect.CODEC.optionalFieldOf("distortion").stable().forGetter((soundEffects) -> soundEffects.distortion),
			MusicSound.CODEC.optionalFieldOf("music").stable().forGetter((soundEffects) -> soundEffects.music)
	).apply(instance, instance.stable(SoundEffects::new)));
	
	private final Optional<ReverbEffect> reverb;
	private final Optional<DistortionEffect> distortion;
	private final Optional<MusicSound> music;
	
	public SoundEffects() {
		this(Optional.empty(), Optional.empty(), Optional.empty());
	}
	
	public SoundEffects(Optional<ReverbEffect> reverb, Optional<DistortionEffect> distortion, Optional<MusicSound> music) {
		this.reverb = reverb;
		this.distortion = distortion;
		this.music = music;
	}
	
	public Optional<ReverbEffect> getReverb() {
		return reverb;
	}
	
	public Optional<DistortionEffect> getDistortion() {
		return distortion;
	}
	
	public Optional<MusicSound> getMusic() {
		return music;
	}
	
}
