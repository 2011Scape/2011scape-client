import com.jagex.IndexedImage;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.ClippingMask;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ib")
public final class JavaFont extends Font {

    @OriginalMember(owner = "client!ib", name = "x", descriptor = "Lclient!iaa;")
    public JavaToolkit aClass19_Sub2_4;

    @OriginalMember(owner = "client!ib", name = "D", descriptor = "[I")
    public final int[] anIntArray323;

    @OriginalMember(owner = "client!ib", name = "A", descriptor = "[I")
    public final int[] anIntArray320;

    @OriginalMember(owner = "client!ib", name = "C", descriptor = "[[B")
    public final byte[][] aByteArrayArray11;

    @OriginalMember(owner = "client!ib", name = "z", descriptor = "[I")
    public final int[] anIntArray324;

    @OriginalMember(owner = "client!ib", name = "y", descriptor = "[I")
    public final int[] anIntArray322;

    @OriginalMember(owner = "client!ib", name = "B", descriptor = "[I")
    public final int[] anIntArray321;

    @OriginalMember(owner = "client!ib", name = "<init>", descriptor = "(Lclient!iaa;Lclient!ve;[Lclient!wp;[I[I)V")
    public JavaFont(@OriginalArg(0) JavaToolkit arg0, @OriginalArg(1) FontMetrics arg1, @OriginalArg(2) IndexedImage[] arg2, @OriginalArg(3) int[] arg3, @OriginalArg(4) int[] arg4) {
        super(arg0, arg1);
        this.aClass19_Sub2_4 = arg0;
        this.aClass19_Sub2_4 = arg0;
        this.anIntArray323 = arg3;
        this.anIntArray320 = arg4;
        this.aByteArrayArray11 = new byte[arg2.length][];
        this.anIntArray324 = new int[arg2.length];
        this.anIntArray322 = new int[arg2.length];
        for (@Pc(32) int local32 = 0; local32 < arg2.length; local32++) {
            this.aByteArrayArray11[local32] = arg2[local32].raster;
            this.anIntArray324[local32] = arg2[local32].offY1;
            this.anIntArray322[local32] = arg2[local32].offX1;
        }
        this.anIntArray321 = arg2[0].palette;
    }

    @OriginalMember(owner = "client!ib", name = "a", descriptor = "(CIIIZLclient!aa;II)V")
    @Override
    protected void renderSymbol(@OriginalArg(0) char c, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int colour, @OriginalArg(4) boolean shadow, @OriginalArg(5) ClippingMask mask, @OriginalArg(6) int offsetX, @OriginalArg(7) int offsetY) {
        if (mask == null) {
            this.fa(c, x, y, colour, shadow);
            return;
        }
        x += this.anIntArray322[c];
        y += this.anIntArray324[c];
        @Pc(28) int local28 = this.anIntArray323[c];
        @Pc(33) int local33 = this.anIntArray320[c];
        @Pc(37) int local37 = this.aClass19_Sub2_4.surfaceWidth;
        @Pc(43) int local43 = x + y * local37;
        @Pc(47) int local47 = local37 - local28;
        @Pc(49) int local49 = 0;
        @Pc(51) int local51 = 0;
        @Pc(62) int local62;
        if (y < this.aClass19_Sub2_4.clipY1) {
            local62 = this.aClass19_Sub2_4.clipY1 - y;
            local33 -= local62;
            y = this.aClass19_Sub2_4.clipY1;
            local51 = local62 * local28;
            local43 += local62 * local37;
        }
        if (y + local33 > this.aClass19_Sub2_4.clipY2) {
            local33 -= y + local33 - this.aClass19_Sub2_4.clipY2;
        }
        if (x < this.aClass19_Sub2_4.clipX1) {
            local62 = this.aClass19_Sub2_4.clipX1 - x;
            local28 -= local62;
            x = this.aClass19_Sub2_4.clipX1;
            local51 += local62;
            local43 += local62;
            local49 = local62;
            local47 += local62;
        }
        if (x + local28 > this.aClass19_Sub2_4.clipX2) {
            local62 = x + local28 - this.aClass19_Sub2_4.clipX2;
            local28 -= local62;
            local49 += local62;
            local47 += local62;
        }
        if (local28 <= 0 || local33 <= 0) {
            return;
        }
        if (shadow) {
            this.method3824(this.aByteArrayArray11[c], this.aClass19_Sub2_4.surfaceRaster, colour, local51, local43, local28, local33, local47, local49, x, y, this.anIntArray323[c], mask, offsetX, offsetY);
        } else {
            this.method3823(this.aByteArrayArray11[c], this.aClass19_Sub2_4.surfaceRaster, this.anIntArray321, colour, local51, local43, local28, local33, local47, local49, x, y, this.anIntArray323[c], mask, offsetX, offsetY);
        }
    }

    @OriginalMember(owner = "client!ib", name = "a", descriptor = "([B[IIIIIIII)V")
    public void method3821(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
        @Pc(4) int local4 = -(arg5 >> 2);
        @Pc(9) int local9 = -(arg5 & 0x3);
        for (@Pc(12) int local12 = -arg6; local12 < 0; local12++) {
            for (@Pc(15) int local15 = local4; local15 < 0; local15++) {
                if (arg0[arg3++] == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2;
                }
                if (arg0[arg3++] == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2;
                }
                if (arg0[arg3++] == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2;
                }
                if (arg0[arg3++] == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2;
                }
            }
            for (@Pc(69) int local69 = local9; local69 < 0; local69++) {
                if (arg0[arg3++] == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2;
                }
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    @OriginalMember(owner = "client!ib", name = "a", descriptor = "([B[I[IIIIIII)V")
    public void method3822(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
        @Pc(4) int local4 = -(arg5 >> 2);
        @Pc(9) int local9 = -(arg5 & 0x3);
        for (@Pc(14) int local14 = -arg6; local14 < 0; local14++) {
            for (@Pc(17) int local17 = local4; local17 < 0; local17++) {
                @Pc(24) byte local24;
                if ((local24 = arg0[arg3++]) == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2[local24 & 0xFF];
                }
                @Pc(42) byte local42;
                if ((local42 = arg0[arg3++]) == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2[local42 & 0xFF];
                }
                @Pc(60) byte local60;
                if ((local60 = arg0[arg3++]) == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2[local60 & 0xFF];
                }
                @Pc(78) byte local78;
                if ((local78 = arg0[arg3++]) == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2[local78 & 0xFF];
                }
            }
            for (@Pc(95) int local95 = local9; local95 < 0; local95++) {
                @Pc(102) byte local102;
                if ((local102 = arg0[arg3++]) == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2[local102 & 0xFF];
                }
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    @OriginalMember(owner = "client!ib", name = "a", descriptor = "([B[I[IIIIIIIIIIILclient!aa;II)V")
    public void method3823(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) ClippingMask arg13, @OriginalArg(14) int arg14, @OriginalArg(15) int arg15) {
        @Pc(2) JavaClippingMask local2 = (JavaClippingMask) arg13;
        @Pc(5) int[] local5 = local2.lineOffsets;
        @Pc(8) int[] local8 = local2.lineWidths;
        @Pc(14) int local14 = arg10 - this.aClass19_Sub2_4.clipX1;
        @Pc(16) int local16 = arg11;
        if (arg15 > arg11) {
            local16 = arg15;
            arg5 += (arg15 - arg11) * this.aClass19_Sub2_4.surfaceWidth;
            arg4 += (arg15 - arg11) * arg12;
        }
        @Pc(56) int local56 = arg15 + local5.length < arg11 + arg7 ? arg15 + local5.length : arg11 + arg7;
        for (@Pc(60) int local60 = local16; local60 < local56; local60++) {
            @Pc(69) int local69 = local5[local60 - arg15] + arg14;
            @Pc(75) int local75 = local8[local60 - arg15];
            @Pc(77) int local77 = arg6;
            @Pc(84) int local84;
            if (local14 > local69) {
                local84 = local14 - local69;
                if (local84 >= local75) {
                    arg4 += arg6 + arg9;
                    arg5 += arg6 + arg8;
                    continue;
                }
                local75 -= local84;
            } else {
                local84 = local69 - local14;
                if (local84 >= arg6) {
                    arg4 += arg6 + arg9;
                    arg5 += arg6 + arg8;
                    continue;
                }
                arg4 += local84;
                local77 = arg6 - local84;
                arg5 += local84;
            }
            local84 = 0;
            if (local77 < local75) {
                local75 = local77;
            } else {
                local84 = local77 - local75;
            }
            for (@Pc(152) int local152 = -local75; local152 < 0; local152++) {
                @Pc(159) byte local159;
                if ((local159 = arg0[arg4++]) == 0) {
                    arg5++;
                } else {
                    arg1[arg5++] = arg2[local159 & 0xFF];
                }
            }
            arg4 += local84 + arg9;
            arg5 += local84 + arg8;
        }
    }

    @OriginalMember(owner = "client!ib", name = "a", descriptor = "([B[IIIIIIIIIIILclient!aa;II)V")
    public void method3824(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) ClippingMask arg12, @OriginalArg(13) int arg13, @OriginalArg(14) int arg14) {
        @Pc(2) JavaClippingMask local2 = (JavaClippingMask) arg12;
        @Pc(5) int[] local5 = local2.lineOffsets;
        @Pc(8) int[] local8 = local2.lineWidths;
        @Pc(14) int local14 = arg9 - this.aClass19_Sub2_4.clipX1;
        @Pc(16) int local16 = arg10;
        if (arg14 > arg10) {
            local16 = arg14;
            arg4 += (arg14 - arg10) * this.aClass19_Sub2_4.surfaceWidth;
            arg3 += (arg14 - arg10) * arg11;
        }
        @Pc(56) int local56 = arg14 + local5.length < arg10 + arg6 ? arg14 + local5.length : arg10 + arg6;
        for (@Pc(58) int local58 = local16; local58 < local56; local58++) {
            @Pc(67) int local67 = local5[local58 - arg14] + arg13;
            @Pc(73) int local73 = local8[local58 - arg14];
            @Pc(75) int local75 = arg5;
            @Pc(82) int local82;
            if (local14 > local67) {
                local82 = local14 - local67;
                if (local82 >= local73) {
                    arg3 += arg5 + arg8;
                    arg4 += arg5 + arg7;
                    continue;
                }
                local73 -= local82;
            } else {
                local82 = local67 - local14;
                if (local82 >= arg5) {
                    arg3 += arg5 + arg8;
                    arg4 += arg5 + arg7;
                    continue;
                }
                arg3 += local82;
                local75 = arg5 - local82;
                arg4 += local82;
            }
            local82 = 0;
            if (local75 < local73) {
                local73 = local75;
            } else {
                local82 = local75 - local73;
            }
            for (@Pc(150) int local150 = -local73; local150 < 0; local150++) {
                if (arg0[arg3++] == 0) {
                    arg4++;
                } else {
                    arg1[arg4++] = arg2;
                }
            }
            arg3 += local82 + arg3;
            arg4 += local82 + arg7;
        }
    }

    @OriginalMember(owner = "client!ib", name = "fa", descriptor = "(CIIIZ)V")
    @Override
    protected void fa(@OriginalArg(0) char c, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int colour, @OriginalArg(4) boolean shadow) {
        x += this.anIntArray322[c];
        y += this.anIntArray324[c];
        @Pc(18) int local18 = this.anIntArray323[c];
        @Pc(23) int local23 = this.anIntArray320[c];
        @Pc(27) int local27 = this.aClass19_Sub2_4.surfaceWidth;
        @Pc(33) int local33 = x + y * local27;
        @Pc(37) int local37 = local27 - local18;
        @Pc(39) int local39 = 0;
        @Pc(41) int local41 = 0;
        @Pc(52) int local52;
        if (y < this.aClass19_Sub2_4.clipY1) {
            local52 = this.aClass19_Sub2_4.clipY1 - y;
            local23 -= local52;
            y = this.aClass19_Sub2_4.clipY1;
            local41 += local52 * local18;
            local33 += local52 * local27;
        }
        if (y + local23 > this.aClass19_Sub2_4.clipY2) {
            local23 -= y + local23 - this.aClass19_Sub2_4.clipY2;
        }
        if (x < this.aClass19_Sub2_4.clipX1) {
            local52 = this.aClass19_Sub2_4.clipX1 - x;
            local18 -= local52;
            x = this.aClass19_Sub2_4.clipX1;
            local41 += local52;
            local33 += local52;
            local39 += local52;
            local37 += local52;
        }
        if (x + local18 > this.aClass19_Sub2_4.clipX2) {
            local52 = x + local18 - this.aClass19_Sub2_4.clipX2;
            local18 -= local52;
            local39 += local52;
            local37 += local52;
        }
        if (local18 <= 0 || local23 <= 0) {
            return;
        }
        if (shadow) {
            this.method3821(this.aByteArrayArray11[c], this.aClass19_Sub2_4.surfaceRaster, colour, local41, local33, local18, local23, local37, local39);
        } else {
            this.method3822(this.aByteArrayArray11[c], this.aClass19_Sub2_4.surfaceRaster, this.anIntArray321, local41, local33, local18, local23, local37, local39);
        }
    }
}
