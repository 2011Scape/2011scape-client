import com.jagex.Entity;
import com.jagex.sound.Class123;
import com.jagex.sound.MixBuss;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static576 {

    @OriginalMember(owner = "client!sba", name = "e", descriptor = "[Lclient!eo;")
    public static Entity[] opaqueStationaryEntities;

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(III)Z")
    public static boolean method7609(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static69.method6335(arg1, arg0) & (Static526.method7073(arg0, arg1) | (arg1 & 0x2000) != 0 | Static220.method3197(arg1, arg0));
    }

    @OriginalMember(owner = "client!sba", name = "b", descriptor = "(Z)Z")
    public static boolean method7611() {
        try {
            if (SongManager.anInt10171 == 2) {
                if (Static62.aClass2_Sub8_3 == null) {
                    Static62.aClass2_Sub8_3 = Static728.method1153(SongManager.midiSongs, SongManager.groupId, SongManager.midiFileId);
                    if (Static62.aClass2_Sub8_3 == null) {
                        return false;
                    }
                }
                if (Static12.aClass123_4 == null) {
                    Static12.aClass123_4 = new Class123(Static91.synthSoundsJs5, Static296.vorbisJs5);
                }
                @Pc(36) MixBuss local36 = Static581.mixBuss;
                if (SongManager.aClass2_Sub6_Sub1_2 != null) {
                    local36 = SongManager.aClass2_Sub6_Sub1_2;
                }
                if (local36.method944(Static12.aClass123_4, Static86.js5_15, Static62.aClass2_Sub8_3)) {
                    Static581.mixBuss = local36;
                    Static581.mixBuss.method933();
                    @Pc(65) int local65;
                    if (SongManager.anInt9335 <= 0) {
                        SongManager.anInt10171 = 0;
                        Static581.mixBuss.setVolume(SongManager.volume);
                        for (local65 = 0; local65 < Static286.anIntArray358.length; local65++) {
                            Static581.mixBuss.method926(Static286.anIntArray358[local65], local65);
                            Static286.anIntArray358[local65] = 255;
                        }
                    } else {
                        SongManager.anInt10171 = 3;
                        Static581.mixBuss.setVolume(SongManager.volume < SongManager.anInt9335 ? SongManager.volume : SongManager.anInt9335);
                        for (local65 = 0; local65 < Static286.anIntArray358.length; local65++) {
                            Static581.mixBuss.method926(Static286.anIntArray358[local65], local65);
                            Static286.anIntArray358[local65] = 255;
                        }
                    }
                    if (SongManager.aClass2_Sub6_Sub1_2 == null) {
                        if (SongManager.aLong95 <= 0L) {
                            Static581.mixBuss.method934(Static62.aClass2_Sub8_3, SongManager.aBoolean564);
                        } else {
                            Static581.mixBuss.method925(Static62.aClass2_Sub8_3, SongManager.aBoolean564, SongManager.aLong95);
                        }
                    }
                    if (Static426.aPcmPlayer_2 != null) {
                        Static426.aPcmPlayer_2.method3582(Static581.mixBuss);
                    }
                    SongManager.aLong95 = 0L;
                    Static12.aClass123_4 = null;
                    Static62.aClass2_Sub8_3 = null;
                    SongManager.aClass2_Sub6_Sub1_2 = null;
                    SongManager.midiSongs = null;
                    return true;
                }
            }
        } catch (@Pc(191) Exception local191) {
            local191.printStackTrace();
            Static581.mixBuss.method912();
            Static12.aClass123_4 = null;
            SongManager.aClass2_Sub6_Sub1_2 = null;
            SongManager.midiSongs = null;
            Static62.aClass2_Sub8_3 = null;
            SongManager.anInt10171 = 0;
        }
        return false;
    }

}
