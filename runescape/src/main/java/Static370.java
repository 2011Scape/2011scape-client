import com.jagex.core.datastruct.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static370 {

    @OriginalMember(owner = "client!lm", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___152 = new ServerProt(4, 0);

    @OriginalMember(owner = "client!lm", name = "j", descriptor = "Lclient!pc;")
    public static final ZoneProt A_ZONE_PROT___11 = new ZoneProt(9, -1);

    @OriginalMember(owner = "client!lm", name = "d", descriptor = "(I)V")
    public static void method5280() {
        @Pc(12) int local12;
        if (Static384.aLocOccluderArray2 != null) {
            for (local12 = 0; local12 < Static317.anInt5046; local12++) {
                Static384.aLocOccluderArray2[local12] = null;
            }
            Static384.aLocOccluderArray2 = null;
        }
        if (Static607.aLocOccluderArray4 != null) {
            for (local12 = 0; local12 < Static444.anInt6751; local12++) {
                Static607.aLocOccluderArray4[local12] = null;
            }
            Static607.aLocOccluderArray4 = null;
        }
        if (Static285.aLocOccluderArray1 != null) {
            for (local12 = 0; local12 < Static150.anInt2634; local12++) {
                Static285.aLocOccluderArray1[local12] = null;
            }
            Static285.aLocOccluderArray1 = null;
        }
        Static560.aLocOccluderArray3 = null;
        Static446.anIntArrayArrayArray9 = null;
        Static485.anIntArray886 = null;
        Static624.anInt9461 = -1;
        Static228.anInt3709 = -1;
    }

    @OriginalMember(owner = "client!lm", name = "c", descriptor = "(I)[Lclient!kda;")
    public static Class204[] method5281() {
        return new Class204[]{Static515.aClass204_10, Static77.aClass204_1, Static565.aClass204_9, Static535.aClass204_11, Static166.aClass204_6, Static541.aClass204_12, Static647.aClass204_13, Static189.aClass204_7, Static667.aClass204_15, Static505.aClass204_16};
    }

    @OriginalMember(owner = "client!lm", name = "a", descriptor = "(BLclient!ep;Lclient!ep;)V")
    public static void method5282(@OriginalArg(1) Node arg0, @OriginalArg(2) Node arg1) {
        if (arg0.prev != null) {
            arg0.unlink();
        }
        arg0.next = arg1;
        arg0.prev = arg1.prev;
        arg0.prev.next = arg0;
        arg0.next.prev = arg0;
    }
}
