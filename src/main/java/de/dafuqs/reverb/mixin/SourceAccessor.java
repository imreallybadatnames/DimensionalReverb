package de.dafuqs.reverb.mixin;

import net.minecraft.client.sound.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin(Source.class)
public interface SourceAccessor {

    @Accessor
    int getPointer();

}
