import com.jagex.IndexedImage;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.ClippingMask;
import jaggl.OpenGL;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gs")
public final class Font_Sub2 extends Font {

    @OriginalMember(owner = "client!gs", name = "z", descriptor = "Lclient!qha;")
    public final GlToolkit aClass19_Sub3_16;

    @OriginalMember(owner = "client!gs", name = "A", descriptor = "Lclient!gb;")
    public final Class93_Sub2_Sub1 aClass93_Sub2_Sub1_1;

    @OriginalMember(owner = "client!gs", name = "x", descriptor = "Z")
    public final boolean aBoolean275;

    @OriginalMember(owner = "client!gs", name = "y", descriptor = "Lclient!bea;")
    public final Class36 aClass36_4;

    @OriginalMember(owner = "client!gs", name = "<init>", descriptor = "(Lclient!qha;Lclient!ve;[Lclient!wp;Z)V")
    public Font_Sub2(@OriginalArg(0) GlToolkit arg0, @OriginalArg(1) FontMetrics arg1, @OriginalArg(2) IndexedImage[] arg2, @OriginalArg(3) boolean arg3) {
        super(arg0, arg1);
        this.aClass19_Sub3_16 = arg0;
        @Pc(8) int local8 = 0;
        for (@Pc(10) int local10 = 0; local10 < 256; local10++) {
            @Pc(15) IndexedImage local15 = arg2[local10];
            if (local15.height > local8) {
                local8 = local15.height;
            }
            if (local15.width > local8) {
                local8 = local15.width;
            }
        }
        @Pc(37) int local37 = local8 * 16;
        @Pc(46) int local46;
        @Pc(51) IndexedImage local51;
        @Pc(57) int local57;
        @Pc(63) int local63;
        @Pc(69) int local69;
        @Pc(75) int local75;
        @Pc(77) int local77;
        @Pc(85) int local85;
        @Pc(88) int local88;
        if (arg3) {
            @Pc(44) byte[] local44 = new byte[local37 * local37];
            for (local46 = 0; local46 < 256; local46++) {
                local51 = arg2[local46];
                @Pc(54) int local54 = local51.height;
                local57 = local51.width;
                local63 = local46 % 16 * local8;
                local69 = local46 / 16 * local8;
                local75 = local69 * local37 + local63;
                local77 = 0;
                @Pc(83) byte[] local83;
                if (local51.alpha == null) {
                    local83 = local51.raster;
                    for (local85 = 0; local85 < local54; local85++) {
                        for (local88 = 0; local88 < local57; local88++) {
                            local44[local75++] = (byte) (local83[local77++] == 0 ? 0 : -1);
                        }
                        local75 += local37 - local57;
                    }
                } else {
                    local83 = local51.alpha;
                    for (local85 = 0; local85 < local54; local85++) {
                        for (local88 = 0; local88 < local57; local88++) {
                            local44[local75++] = local83[local77++];
                        }
                        local75 += local37 - local57;
                    }
                }
            }
            this.aClass93_Sub2_Sub1_1 = Static469.method6359(local37, local44, arg0, local37);
            this.aBoolean275 = true;
        } else {
            @Pc(172) int[] local172 = new int[local37 * local37];
            for (local46 = 0; local46 < 256; local46++) {
                local51 = arg2[local46];
                @Pc(182) int[] local182 = local51.palette;
                @Pc(185) byte[] local185 = local51.alpha;
                @Pc(188) byte[] local188 = local51.raster;
                local69 = local51.height;
                local75 = local51.width;
                local77 = local46 % 16 * local8;
                @Pc(206) int local206 = local46 / 16 * local8;
                local85 = local206 * local37 + local77;
                local88 = 0;
                @Pc(218) int local218;
                @Pc(221) int local221;
                if (local185 == null) {
                    for (local218 = 0; local218 < local69; local218++) {
                        for (local221 = 0; local221 < local75; local221++) {
                            @Pc(267) byte local267;
                            if ((local267 = local188[local88++]) == 0) {
                                local85++;
                            } else {
                                local172[local85++] = local182[local267 & 0xFF] | 0xFF000000;
                            }
                        }
                        local85 += local37 - local75;
                    }
                } else {
                    for (local218 = 0; local218 < local69; local218++) {
                        for (local221 = 0; local221 < local75; local221++) {
                            local172[local85++] = local185[local88] << 24 | local182[local188[local88] & 0xFF];
                            local88++;
                        }
                        local85 += local37 - local75;
                    }
                }
            }
            this.aClass93_Sub2_Sub1_1 = Static88.method1706(arg0, local37, 0, local172, local37, 0);
            this.aBoolean275 = false;
        }
        this.aClass93_Sub2_Sub1_1.method9438(false);
        this.aClass36_4 = new Class36(arg0, 256);
        @Pc(334) float local334 = this.aClass93_Sub2_Sub1_1.aFloat67 / (float) this.aClass93_Sub2_Sub1_1.anInt3259;
        @Pc(343) float local343 = this.aClass93_Sub2_Sub1_1.aFloat68 / (float) this.aClass93_Sub2_Sub1_1.anInt3257;
        for (@Pc(345) int local345 = 0; local345 < 256; local345++) {
            @Pc(350) IndexedImage local350 = arg2[local345];
            local57 = local350.height;
            local63 = local350.width;
            local69 = local350.offY1;
            local75 = local350.offX1;
            @Pc(369) float local369 = (float) (local345 % 16 * local8);
            @Pc(376) float local376 = (float) (local345 / 16 * local8);
            @Pc(380) float local380 = local369 * local334;
            @Pc(384) float local384 = local376 * local343;
            @Pc(391) float local391 = (local369 + (float) local63) * local334;
            @Pc(398) float local398 = (local376 + (float) local57) * local343;
            this.aClass36_4.method1002(local345);
            OpenGL.glBegin(OpenGL.GL_QUADS);
            OpenGL.glTexCoord2f(local380, this.aClass93_Sub2_Sub1_1.aFloat68 - local384);
            OpenGL.glVertex2i(local75, local69);
            OpenGL.glTexCoord2f(local380, this.aClass93_Sub2_Sub1_1.aFloat68 - local398);
            OpenGL.glVertex2i(local75, local69 + local57);
            OpenGL.glTexCoord2f(local391, this.aClass93_Sub2_Sub1_1.aFloat68 - local398);
            OpenGL.glVertex2i(local75 + local63, local69 + local57);
            OpenGL.glTexCoord2f(local391, this.aClass93_Sub2_Sub1_1.aFloat68 - local384);
            OpenGL.glVertex2i(local75 + local63, local69);
            OpenGL.glEnd();
            this.aClass36_4.method1004();
        }
    }

    @OriginalMember(owner = "client!gs", name = "fa", descriptor = "(CIIIZ)V")
    @Override
    protected void fa(@OriginalArg(0) char c, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int colour, @OriginalArg(4) boolean shadow) {
        this.aClass19_Sub3_16.method6974();
        this.aClass19_Sub3_16.method7001(this.aClass93_Sub2_Sub1_1);
        if (this.aBoolean275 || shadow) {
            this.aClass19_Sub3_16.method7031(8448, 7681);
            this.aClass19_Sub3_16.method7021(34168, 768, 0);
        } else {
            this.aClass19_Sub3_16.method7031(7681, 7681);
        }
        OpenGL.glColor4ub((byte) (colour >> 16), (byte) (colour >> 8), (byte) colour, (byte) (colour >> 24));
        OpenGL.glTranslatef((float) x, (float) y, 0.0F);
        this.aClass36_4.method1005(c);
        OpenGL.glLoadIdentity();
        if (this.aBoolean275 || shadow) {
            this.aClass19_Sub3_16.method7021(5890, 768, 0);
        }
    }

    @OriginalMember(owner = "client!gs", name = "a", descriptor = "(CIIIZLclient!aa;II)V")
    @Override
    protected void renderSymbol(@OriginalArg(0) char c, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int colour, @OriginalArg(4) boolean shadow, @OriginalArg(5) ClippingMask mask, @OriginalArg(6) int offsetX, @OriginalArg(7) int offsetY) {
        @Pc(2) ClippingMask_Sub3 local2 = (ClippingMask_Sub3) mask;
        @Pc(5) Class93_Sub2_Sub1 local5 = local2.aClass93_Sub2_Sub1_5;
        this.aClass19_Sub3_16.method6974();
        this.aClass19_Sub3_16.method7001(this.aClass93_Sub2_Sub1_1);
        if (this.aBoolean275 || shadow) {
            this.aClass19_Sub3_16.method7031(8448, 7681);
            this.aClass19_Sub3_16.method7021(34168, 768, 0);
        } else {
            this.aClass19_Sub3_16.method7031(7681, 7681);
        }
        this.aClass19_Sub3_16.method7014(1);
        this.aClass19_Sub3_16.method7001(local5);
        this.aClass19_Sub3_16.method7031(8448, 7681);
        this.aClass19_Sub3_16.method7021(34168, 768, 0);
        OpenGL.glTexGeni(OpenGL.GL_S, OpenGL.GL_TEXTURE_GEN_MODE, OpenGL.GL_EYE_LINEAR);
        OpenGL.glTexGeni(OpenGL.GL_T, OpenGL.GL_TEXTURE_GEN_MODE, OpenGL.GL_EYE_LINEAR);
        @Pc(78) float local78 = local5.aFloat67 / (float) local5.anInt3259;
        @Pc(85) float local85 = local5.aFloat68 / (float) local5.anInt3257;
        OpenGL.glTexGenfv(OpenGL.GL_S, OpenGL.GL_EYE_PLANE, new float[]{local78, 0.0F, 0.0F, (float) -offsetX * local78}, 0);
        OpenGL.glTexGenfv(OpenGL.GL_T, OpenGL.GL_EYE_PLANE, new float[]{0.0F, local85, 0.0F, (float) -offsetY * local85}, 0);
        OpenGL.glEnable(OpenGL.GL_TEXTURE_GEN_S);
        OpenGL.glEnable(OpenGL.GL_TEXTURE_GEN_T);
        OpenGL.glColor4ub((byte) (colour >> 16), (byte) (colour >> 8), (byte) colour, (byte) (colour >> 24));
        OpenGL.glTranslatef((float) x, (float) y, 0.0F);
        this.aClass36_4.method1005(c);
        OpenGL.glLoadIdentity();
        OpenGL.glDisable(OpenGL.GL_TEXTURE_GEN_S);
        OpenGL.glDisable(OpenGL.GL_TEXTURE_GEN_T);
        this.aClass19_Sub3_16.method7021(5890, 768, 0);
        this.aClass19_Sub3_16.method7031(8448, 8448);
        this.aClass19_Sub3_16.method7001(null);
        this.aClass19_Sub3_16.method7014(0);
        if (this.aBoolean275 || shadow) {
            this.aClass19_Sub3_16.method7021(5890, 768, 0);
        }
    }
}
