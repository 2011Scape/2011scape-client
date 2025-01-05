import com.jagex.ClientConfig;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

import java.math.BigInteger;

public final class Static670 {

    @OriginalMember(owner = "client!vda", name = "N", descriptor = "Ljava/math/BigInteger;")
    public static BigInteger JS5_RSA_MODULUS = ClientConfig.JS5_MODULUS;

    @OriginalMember(owner = "client!vda", name = "b", descriptor = "(IIII)I")
    public static int method8732(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2) {
        if (arg2 >= arg0) {
            return arg1 < arg2 ? arg1 : arg2;
        } else {
            return arg0;
        }
    }

}
