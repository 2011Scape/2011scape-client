import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static89 {

    @OriginalMember(owner = "client!cp", name = "n", descriptor = "[I")
    public static int[] anIntArray169;

    @OriginalMember(owner = "client!cp", name = "h", descriptor = "Lclient!hc;")
    public static final CutsceneActionType A_CUTSCENE_ACTION_TYPE___9 = new CutsceneActionType(2);

    @OriginalMember(owner = "client!cp", name = "a", descriptor = "(ILclient!ca;IILclient!wj;Lclient!c;BI)V")
    public static void method1714(@OriginalArg(0) int arg0, @OriginalArg(1) PlayerEntity arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) NPCEntity arg4, @OriginalArg(5) LocType arg5, @OriginalArg(7) int arg6) {
        @Pc(7) Node_Sub51 local7 = new Node_Sub51();
        local7.anInt9350 = arg0;
        local7.anInt9357 = arg2 << 9;
        local7.anInt9352 = arg3 << 9;
        if (arg5 != null) {
            local7.aLocType_1 = arg5;
            @Pc(173) int local173 = arg5.width;
            @Pc(176) int local176 = arg5.length;
            if (arg6 == 1 || arg6 == 3) {
                local176 = arg5.width;
                local173 = arg5.length;
            }
            local7.soundVolume = arg5.ambientSoundVolume;
            local7.anInt9356 = arg5.soundDistance << 9;
            local7.sound = arg5.sound;
            local7.anInt9354 = arg5.anInt1219;
            local7.anInt9349 = arg3 + local176 << 9;
            local7.anInt9360 = arg5.anInt1249;
            local7.vorbis = arg5.aBoolean88;
            local7.aBoolean715 = arg5.aBoolean92;
            local7.anInt9355 = arg5.anInt1221 << 9;
            local7.anInt9365 = arg5.anInt1231;
            local7.anInt9359 = arg5.anInt1268;
            local7.anIntArray718 = arg5.anIntArray116;
            local7.anInt9362 = arg2 + local173 << 9;
            if (arg5.multiLocs != null) {
                local7.multi = true;
                local7.method8236();
            }
            if (local7.anIntArray718 != null) {
                local7.anInt9351 = (int) ((double) (local7.anInt9354 - local7.anInt9365) * Math.random()) + local7.anInt9365;
            }
            Static460.A_DEQUE___40.addLast(local7);
            return;
        }
        if (arg4 != null) {
            local7.npc = arg4;
            @Pc(37) NPCType local37 = arg4.type;
            if (local37.multinpcs != null) {
                local7.multi = true;
                local37 = local37.getMultiNPC(TimedVarDomain.instance);
            }
            if (local37 != null) {
                local7.anInt9362 = local37.size + arg2 << 9;
                local7.anInt9349 = arg3 + local37.size << 9;
                local7.sound = NPCEntity.currentSound(arg4);
                local7.anInt9355 = local37.soundStartDistance << 9;
                local7.soundVolume = local37.soundVolume;
                local7.anInt9359 = local37.anInt6729;
                local7.vorbis = local37.vorbisSound;
                local7.anInt9356 = local37.soundDistance << 9;
                local7.anInt9360 = local37.anInt6736;
            }
            Static717.A_DEQUE___81.addLast(local7);
            return;
        }
        if (arg1 == null) {
            return;
        }
        local7.player = arg1;
        local7.anInt9362 = arg2 + arg1.getSize() << 9;
        local7.anInt9349 = arg1.getSize() + arg3 << 9;
        local7.sound = PlayerEntity.method4870(arg1);
        local7.anInt9356 = arg1.soundRange << 9;
        local7.anInt9360 = 256;
        local7.anInt9359 = 256;
        local7.soundVolume = arg1.soundVolume;
        local7.anInt9355 = 0;
        local7.vorbis = arg1.vorbis;
        Static113.A_HASH_TABLE___12.put(arg1.id, local7);
        return;
    }

    @OriginalMember(owner = "client!cp", name = "a", descriptor = "([FFIII[FFIIIII)V")
    public static void method1715(@OriginalArg(0) float[] arg0, @OriginalArg(1) float arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) float[] arg5, @OriginalArg(6) float arg6, @OriginalArg(7) int arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9, @OriginalArg(11) int arg10) {
        @Pc(5) int local5 = arg3 - arg10;
        @Pc(9) int local9 = arg9 - arg2;
        @Pc(20) int local20 = arg8 - arg7;
        @Pc(45) float local45 = (float) local9 * arg0[2] + arg0[1] * (float) local20 + (float) local5 * arg0[0];
        @Pc(66) float local66 = (float) local9 * arg0[5] + (float) local20 * arg0[4] + arg0[3] * (float) local5;
        @Pc(87) float local87 = arg0[6] * (float) local5 + (float) local20 * arg0[7] + arg0[8] * (float) local9;
        @Pc(98) float local98 = (float) Math.atan2(local45, local87) / 6.2831855F + 0.5F;
        if (arg6 != 1.0F) {
            local98 *= arg6;
        }
        @Pc(112) float local112 = arg1 + local66 + 0.5F;
        @Pc(131) float local131;
        if (arg4 == 1) {
            local131 = local98;
            local98 = -local112;
            local112 = local131;
        } else if (arg4 == 2) {
            local112 = -local112;
            local98 = -local98;
        } else if (arg4 == 3) {
            local131 = local98;
            local98 = local112;
            local112 = -local131;
        }
        arg5[1] = local112;
        arg5[0] = local98;
    }
}
