import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static412 {

    @OriginalMember(owner = "client!naa", name = "f", descriptor = "I")
    public static int anInt6357;

    @OriginalMember(owner = "client!naa", name = "d", descriptor = "I")
    public static final int anInt6358 = 5000;

    @OriginalMember(owner = "client!naa", name = "a", descriptor = "(IIIBIII)V")
    public static void method5692(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        if (arg4 - arg1 >= Static180.anInt2995 && arg1 + arg4 <= Static111.anInt2219 && Static724.anInt10930 <= arg3 - arg1 && arg1 + arg3 <= Static273.anInt4395) {
            Static123.method2210(arg2, arg5, arg3, arg1, arg4, arg0);
        } else {
            Static51.method1146(arg0, arg5, arg2, arg4, arg1, arg3);
        }
    }

}
