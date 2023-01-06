package de.dafuqs.reverb.access;

import net.minecraft.sound.*;
import net.minecraft.util.*;
import org.jetbrains.annotations.*;

public interface SoundSystemAccess {

    public void stopSoundsAtPosition(double x, double y, double z, @Nullable Identifier id, @Nullable SoundCategory category);

    public static SoundSystemAccess get(Object obj) {
        return (SoundSystemAccess) obj;
    }

}
