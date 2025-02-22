import com.jagex.graphics.ClippingMask;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!te")
public final class JavaIndexedSprite extends JavaSprite {

    @OriginalMember(owner = "client!te", name = "D", descriptor = "[B")
    public final byte[] aByteArray100;

    @OriginalMember(owner = "client!te", name = "I", descriptor = "[I")
    public final int[] anIntArray714;

    @OriginalMember(owner = "client!te", name = "<init>", descriptor = "(Lclient!iaa;[B[III)V")
    public JavaIndexedSprite(@OriginalArg(0) JavaToolkit arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        super(arg0, arg3, arg4);
        this.aByteArray100 = arg1;
        this.anIntArray714 = arg2;
    }

    @OriginalMember(owner = "client!te", name = "a", descriptor = "(IIIII)V")
    @Override
    public void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int op, @OriginalArg(3) int color, @OriginalArg(4) int mode) {
        if (super.toolkit.stopped()) {
            throw new IllegalStateException();
        }
        @Pc(12) int local12 = super.toolkit.surfaceWidth;
        x += super.anInt9298;
        y += super.anInt9308;
        @Pc(28) int local28 = y * local12 + x;
        @Pc(30) int local30 = 0;
        @Pc(33) int local33 = super.anInt9306;
        @Pc(36) int local36 = super.anInt9302;
        @Pc(40) int local40 = local12 - local36;
        @Pc(42) int local42 = 0;
        @Pc(53) int local53;
        if (y < super.toolkit.clipY1) {
            local53 = super.toolkit.clipY1 - y;
            local33 -= local53;
            y = super.toolkit.clipY1;
            local30 = local53 * local36;
            local28 += local53 * local12;
        }
        if (y + local33 > super.toolkit.clipY2) {
            local33 -= y + local33 - super.toolkit.clipY2;
        }
        if (x < super.toolkit.clipX1) {
            local53 = super.toolkit.clipX1 - x;
            local36 -= local53;
            x = super.toolkit.clipX1;
            local30 += local53;
            local28 += local53;
            local42 = local53;
            local40 += local53;
        }
        if (x + local36 > super.toolkit.clipX2) {
            local53 = x + local36 - super.toolkit.clipX2;
            local36 -= local53;
            local42 += local53;
            local40 += local53;
        }
        if (local36 <= 0 || local33 <= 0) {
            return;
        }
        @Pc(164) int[] local164 = super.toolkit.surfaceRaster;
        @Pc(174) int local174;
        @Pc(181) int local181;
        @Pc(292) int local292;
        @Pc(295) int local295;
        @Pc(299) int local299;
        @Pc(311) int local311;
        @Pc(327) int local327;
        @Pc(335) int local335;
        @Pc(468) int local468;
        @Pc(319) int local319;
        if (mode != 0) {
            @Pc(1076) byte local1076;
            @Pc(783) int local783;
            @Pc(791) int local791;
            @Pc(799) int local799;
            @Pc(811) int local811;
            @Pc(556) byte local556;
            if (mode == 1) {
                if (op == 1) {
                    for (local174 = -local33; local174 < 0; local174++) {
                        for (local181 = -local36; local181 < 0; local181++) {
                            local556 = this.aByteArray100[local30++];
                            if (local556 == 0) {
                                local28++;
                            } else {
                                local295 = this.anIntArray714[local556 & 0xFF] | 0xFF000000;
                                local319 = local164[local28];
                                local164[local28++] = ((local295 & 0xFF00FF) * 255 + (local319 & 0xFF00FF) * 0 >> 8 & 0xFFFF00FF) + (((local295 & 0xFF00FF00) >>> 8) * 255 + ((local319 & 0xFF00FF00) >>> 8) * 0 & 0xFF00FF00);
                            }
                        }
                        local28 += local40;
                        local30 += local42;
                    }
                } else {
                    @Pc(661) byte local661;
                    if (op == 0) {
                        if ((color & 0xFFFFFF) == 16777215) {
                            local174 = color >>> 24;
                            local181 = 256 - local174;
                            for (local292 = -local33; local292 < 0; local292++) {
                                for (local295 = -local36; local295 < 0; local295++) {
                                    local661 = this.aByteArray100[local30++];
                                    if (local661 == 0) {
                                        local28++;
                                    } else {
                                        local311 = this.anIntArray714[local661 & 0xFF];
                                        local319 = local164[local28];
                                        local164[local28++] = ((local311 & 0xFF00FF) * local174 + (local319 & 0xFF00FF) * local181 & 0xFF00FF00) + ((local311 & 0xFF00) * local174 + (local319 & 0xFF00) * local181 & 0xFF0000) >> 8;
                                    }
                                }
                                local28 += local40;
                                local30 += local42;
                            }
                        } else {
                            local174 = color >> 16 & 0xFF;
                            local181 = color >> 8 & 0xFF;
                            local292 = color & 0xFF;
                            local295 = color >>> 24;
                            local299 = 256 - local295;
                            for (local311 = -local33; local311 < 0; local311++) {
                                for (local319 = -local36; local319 < 0; local319++) {
                                    @Pc(763) byte local763 = this.aByteArray100[local30++];
                                    if (local763 == 0) {
                                        local28++;
                                    } else {
                                        local335 = this.anIntArray714[local763 & 0xFF];
                                        if (local295 == 255) {
                                            local783 = (local335 & 0xFF0000) * local174 & 0xFF000000;
                                            local791 = (local335 & 0xFF00) * local181 & 0xFF0000;
                                            local799 = (local335 & 0xFF) * local292 & 0xFF00;
                                            local164[local28++] = (local783 | local791 | local799) >>> 8;
                                        } else {
                                            local783 = (local335 & 0xFF0000) * local174 & 0xFF000000;
                                            local791 = (local335 & 0xFF00) * local181 & 0xFF0000;
                                            local799 = (local335 & 0xFF) * local292 & 0xFF00;
                                            local335 = (local783 | local791 | local799) >>> 8;
                                            local811 = local164[local28];
                                            local164[local28++] = ((local335 & 0xFF00FF) * local295 + (local811 & 0xFF00FF) * local299 & 0xFF00FF00) + ((local335 & 0xFF00) * local295 + (local811 & 0xFF00) * local299 & 0xFF0000) >> 8;
                                        }
                                    }
                                }
                                local28 += local40;
                                local30 += local42;
                            }
                        }
                    } else if (op == 3) {
                        local174 = color >>> 24;
                        local181 = 256 - local174;
                        for (local292 = -local33; local292 < 0; local292++) {
                            for (local295 = -local36; local295 < 0; local295++) {
                                local661 = this.aByteArray100[local30++];
                                local311 = local661 > 0 ? this.anIntArray714[local661] : 0;
                                local319 = local311 + color;
                                local327 = (local311 & 0xFF00FF) + (color & 0xFF00FF);
                                local335 = (local327 & 0x1000100) + (local319 - local327 & 0x10000);
                                local335 = local319 - local335 | local335 - (local335 >>> 8);
                                if (local311 == 0 && local174 != 255) {
                                    local311 = local335;
                                    local335 = local164[local28];
                                    local335 = ((local311 & 0xFF00FF) * local174 + (local335 & 0xFF00FF) * local181 & 0xFF00FF00) + ((local311 & 0xFF00) * local174 + (local335 & 0xFF00) * local181 & 0xFF0000) >> 8;
                                }
                                local164[local28++] = local335;
                            }
                            local28 += local40;
                            local30 += local42;
                        }
                    } else if (op == 2) {
                        local174 = color >>> 24;
                        local181 = 256 - local174;
                        local292 = (color & 0xFF00FF) * local181 & 0xFF00FF00;
                        local295 = (color & 0xFF00) * local181 & 0xFF0000;
                        local468 = (local292 | local295) >>> 8;
                        for (local299 = -local33; local299 < 0; local299++) {
                            for (local311 = -local36; local311 < 0; local311++) {
                                local1076 = this.aByteArray100[local30++];
                                if (local1076 == 0) {
                                    local28++;
                                } else {
                                    local327 = this.anIntArray714[local1076 & 0xFF];
                                    local292 = (local327 & 0xFF00FF) * local174 & 0xFF00FF00;
                                    local295 = (local327 & 0xFF00) * local174 & 0xFF0000;
                                    local164[local28++] = ((local292 | local295) >>> 8) + local468;
                                }
                            }
                            local28 += local40;
                            local30 += local42;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            } else if (mode != 2) {
                throw new IllegalArgumentException();
            } else if (op == 1) {
                for (local174 = -local33; local174 < 0; local174++) {
                    for (local181 = -local36; local181 < 0; local181++) {
                        local556 = this.aByteArray100[local30++];
                        if (local556 == 0) {
                            local28++;
                        } else {
                            local295 = this.anIntArray714[local556 & 0xFF];
                            local299 = local164[local28];
                            local311 = local295 + local299;
                            local319 = (local295 & 0xFF00FF) + (local299 & 0xFF00FF);
                            local299 = (local319 & 0x1000100) + (local311 - local319 & 0x10000);
                            local164[local28++] = local311 - local299 | local299 - (local299 >>> 8);
                        }
                    }
                    local28 += local40;
                    local30 += local42;
                }
            } else if (op == 0) {
                local174 = color >> 16 & 0xFF;
                local181 = color >> 8 & 0xFF;
                local292 = color & 0xFF;
                for (local295 = -local33; local295 < 0; local295++) {
                    for (local299 = -local36; local299 < 0; local299++) {
                        @Pc(1254) byte local1254 = this.aByteArray100[local30++];
                        if (local1254 == 0) {
                            local28++;
                        } else {
                            local319 = this.anIntArray714[local1254 & 0xFF];
                            local327 = (local319 & 0xFF0000) * local174 & 0xFF000000;
                            local335 = (local319 & 0xFF00) * local181 & 0xFF0000;
                            local783 = (local319 & 0xFF) * local292 & 0xFF00;
                            local319 = (local327 | local335 | local783) >>> 8;
                            local791 = local164[local28];
                            local799 = local319 + local791;
                            local811 = (local319 & 0xFF00FF) + (local791 & 0xFF00FF);
                            local791 = (local811 & 0x1000100) + (local799 - local811 & 0x10000);
                            local164[local28++] = local799 - local791 | local791 - (local791 >>> 8);
                        }
                    }
                    local28 += local40;
                    local30 += local42;
                }
            } else if (op == 3) {
                for (local174 = -local33; local174 < 0; local174++) {
                    for (local181 = -local36; local181 < 0; local181++) {
                        local556 = this.aByteArray100[local30++];
                        local295 = local556 > 0 ? this.anIntArray714[local556] : 0;
                        local299 = local295 + color;
                        local311 = (local295 & 0xFF00FF) + (color & 0xFF00FF);
                        local319 = (local311 & 0x1000100) + (local299 - local311 & 0x10000);
                        local295 = local299 - local319 | local319 - (local319 >>> 8);
                        @Pc(1415) int local1415 = local164[local28];
                        local299 = local295 + local1415;
                        local311 = (local295 & 0xFF00FF) + (local1415 & 0xFF00FF);
                        @Pc(1437) int local1437 = (local311 & 0x1000100) + (local299 - local311 & 0x10000);
                        local164[local28++] = local299 - local1437 | local1437 - (local1437 >>> 8);
                    }
                    local28 += local40;
                    local30 += local42;
                }
            } else if (op == 2) {
                local174 = color >>> 24;
                local181 = 256 - local174;
                local292 = (color & 0xFF00FF) * local181 & 0xFF00FF00;
                local295 = (color & 0xFF00) * local181 & 0xFF0000;
                local468 = (local292 | local295) >>> 8;
                for (local299 = -local33; local299 < 0; local299++) {
                    for (local311 = -local36; local311 < 0; local311++) {
                        local1076 = this.aByteArray100[local30++];
                        if (local1076 == 0) {
                            local28++;
                        } else {
                            local327 = this.anIntArray714[local1076 & 0xFF];
                            local292 = (local327 & 0xFF00FF) * local174 & 0xFF00FF00;
                            local295 = (local327 & 0xFF00) * local174 & 0xFF0000;
                            @Pc(1546) int local1546 = ((local292 | local295) >>> 8) + local468;
                            local335 = local164[local28];
                            local783 = local1546 + local335;
                            local791 = (local1546 & 0xFF00FF) + (local335 & 0xFF00FF);
                            @Pc(1572) int local1572 = (local791 & 0x1000100) + (local783 - local791 & 0x10000);
                            local164[local28++] = local783 - local1572 | local1572 - (local1572 >>> 8);
                        }
                    }
                    local28 += local40;
                    local30 += local42;
                }
            } else {
                throw new IllegalArgumentException();
            }
        } else if (op == 1) {
            for (local174 = -local33; local174 < 0; local174++) {
                local181 = local28 + local36 - 3;
                while (local28 < local181) {
                    local164[local28++] = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                    local164[local28++] = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                    local164[local28++] = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                    local164[local28++] = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                }
                local181 += 3;
                while (local28 < local181) {
                    local164[local28++] = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                }
                local28 += local40;
                local30 += local42;
            }
        } else if (op == 0) {
            local174 = color >> 16 & 0xFF;
            local181 = color >> 8 & 0xFF;
            local292 = color & 0xFF;
            for (local295 = -local33; local295 < 0; local295++) {
                for (local299 = -local36; local299 < 0; local299++) {
                    local311 = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                    local319 = (local311 & 0xFF0000) * local174 & 0xFF000000;
                    local327 = (local311 & 0xFF00) * local181 & 0xFF0000;
                    local335 = (local311 & 0xFF) * local292 & 0xFF00;
                    local164[local28++] = (local319 | local327 | local335) >>> 8;
                }
                local28 += local40;
                local30 += local42;
            }
        } else if (op == 3) {
            for (local174 = -local33; local174 < 0; local174++) {
                for (local181 = -local36; local181 < 0; local181++) {
                    local292 = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                    local295 = local292 + color;
                    local299 = (local292 & 0xFF00FF) + (color & 0xFF00FF);
                    local311 = (local299 & 0x1000100) + (local295 - local299 & 0x10000);
                    local164[local28++] = local295 - local311 | local311 - (local311 >>> 8);
                }
                local28 += local40;
                local30 += local42;
            }
        } else if (op == 2) {
            local174 = color >>> 24;
            local181 = 256 - local174;
            local292 = (color & 0xFF00FF) * local181 & 0xFF00FF00;
            local295 = (color & 0xFF00) * local181 & 0xFF0000;
            local468 = (local292 | local295) >>> 8;
            for (local299 = -local33; local299 < 0; local299++) {
                for (local311 = -local36; local311 < 0; local311++) {
                    local319 = this.anIntArray714[this.aByteArray100[local30++] & 0xFF];
                    local292 = (local319 & 0xFF00FF) * local174 & 0xFF00FF00;
                    local295 = (local319 & 0xFF00) * local174 & 0xFF0000;
                    local164[local28++] = ((local292 | local295) >>> 8) + local468;
                }
                local28 += local40;
                local30 += local42;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!te", name = "a", descriptor = "([I[III)V")
    @Override
    protected void method8210(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        @Pc(3) int[] local3 = super.toolkit.surfaceRaster;
        @Pc(206) int local206;
        @Pc(11) int local11;
        @Pc(16) int local16;
        @Pc(28) int local28;
        @Pc(30) int local30;
        @Pc(32) int local32;
        @Pc(34) int local34;
        @Pc(64) int local64;
        @Pc(69) int local69;
        @Pc(75) int local75;
        @Pc(122) byte local122;
        if (Static513.anInt9321 == 0) {
            if (Static513.anInt9309 == 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local16 = local11 + arg3;
                    if (local16 >= 0) {
                        if (local16 >= arg0.length) {
                            return;
                        }
                        local28 = Static513.anInt9292;
                        local30 = Static513.anInt9310;
                        local32 = Static513.anInt9317;
                        local34 = Static513.anInt9303;
                        if (local30 >= 0 && local32 >= 0 && local30 - (super.anInt9302 << 12) < 0 && local32 - (super.anInt9306 << 12) < 0) {
                            local64 = arg0[local16] - arg2;
                            local69 = -arg1[local16];
                            local75 = local64 + Static513.anInt9292 - local28;
                            if (local75 > 0) {
                                local28 += local75;
                                local34 += local75;
                                local30 += Static513.anInt9321 * local75;
                                local32 += Static513.anInt9309 * local75;
                            } else {
                                local69 -= local75;
                            }
                            if (local34 < local69) {
                                local34 = local69;
                            }
                            while (local34 < 0) {
                                local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                                if (local122 == 0) {
                                    local28++;
                                } else {
                                    local3[local28++] = this.anIntArray714[local122 & 0xFF];
                                }
                                local34++;
                            }
                        }
                    }
                    local11++;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else if (Static513.anInt9309 < 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local16 = local11 + arg3;
                    if (local16 >= 0) {
                        if (local16 >= arg0.length) {
                            return;
                        }
                        local28 = Static513.anInt9292;
                        local30 = Static513.anInt9310;
                        local32 = Static513.anInt9317 + Static513.anInt9316;
                        local34 = Static513.anInt9303;
                        if (local30 >= 0 && local30 - (super.anInt9302 << 12) < 0) {
                            @Pc(199) int local199;
                            if ((local199 = local32 - (super.anInt9306 << 12)) >= 0) {
                                local206 = (Static513.anInt9309 - local199) / Static513.anInt9309;
                                local34 += local206;
                                local32 += Static513.anInt9309 * local206;
                                local28 += local206;
                            }
                            @Pc(227) int local227;
                            if ((local227 = (local32 - Static513.anInt9309) / Static513.anInt9309) > local34) {
                                local34 = local227;
                            }
                            local64 = arg0[local16] - arg2;
                            local69 = -arg1[local16];
                            local75 = local64 + Static513.anInt9292 - local28;
                            if (local75 > 0) {
                                local28 += local75;
                                local34 += local75;
                                local30 += Static513.anInt9321 * local75;
                                local32 += Static513.anInt9309 * local75;
                            } else {
                                local69 -= local75;
                            }
                            if (local34 < local69) {
                                local34 = local69;
                            }
                            while (local34 < 0) {
                                local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                                if (local122 == 0) {
                                    local28++;
                                } else {
                                    local3[local28++] = this.anIntArray714[local122 & 0xFF];
                                }
                                local32 += Static513.anInt9309;
                                local34++;
                            }
                        }
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local16 = local11 + arg3;
                    if (local16 >= 0) {
                        if (local16 >= arg0.length) {
                            return;
                        }
                        local28 = Static513.anInt9292;
                        local30 = Static513.anInt9310;
                        local32 = Static513.anInt9317 + Static513.anInt9316;
                        local34 = Static513.anInt9303;
                        if (local30 >= 0 && local30 - (super.anInt9302 << 12) < 0) {
                            if (local32 < 0) {
                                local206 = (Static513.anInt9309 - local32 - 1) / Static513.anInt9309;
                                local34 += local206;
                                local32 += Static513.anInt9309 * local206;
                                local28 += local206;
                            }
                            @Pc(410) int local410;
                            if ((local410 = (local32 + 1 - (super.anInt9306 << 12) - Static513.anInt9309) / Static513.anInt9309) > local34) {
                                local34 = local410;
                            }
                            local64 = arg0[local16] - arg2;
                            local69 = -arg1[local16];
                            local75 = local64 + Static513.anInt9292 - local28;
                            if (local75 > 0) {
                                local28 += local75;
                                local34 += local75;
                                local30 += Static513.anInt9321 * local75;
                                local32 += Static513.anInt9309 * local75;
                            } else {
                                local69 -= local75;
                            }
                            if (local34 < local69) {
                                local34 = local69;
                            }
                            while (local34 < 0) {
                                local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                                if (local122 == 0) {
                                    local28++;
                                } else {
                                    local3[local28++] = this.anIntArray714[local122 & 0xFF];
                                }
                                local32 += Static513.anInt9309;
                                local34++;
                            }
                        }
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            }
        } else if (Static513.anInt9321 < 0) {
            if (Static513.anInt9309 == 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local16 = local11 + arg3;
                    if (local16 >= 0) {
                        if (local16 >= arg0.length) {
                            return;
                        }
                        local28 = Static513.anInt9292;
                        local30 = Static513.anInt9310 + Static513.anInt9318;
                        local32 = Static513.anInt9317;
                        local34 = Static513.anInt9303;
                        if (local32 >= 0 && local32 - (super.anInt9306 << 12) < 0) {
                            @Pc(567) int local567;
                            if ((local567 = local30 - (super.anInt9302 << 12)) >= 0) {
                                local206 = (Static513.anInt9321 - local567) / Static513.anInt9321;
                                local34 += local206;
                                local30 += Static513.anInt9321 * local206;
                                local28 += local206;
                            }
                            @Pc(595) int local595;
                            if ((local595 = (local30 - Static513.anInt9321) / Static513.anInt9321) > local34) {
                                local34 = local595;
                            }
                            local64 = arg0[local16] - arg2;
                            local69 = -arg1[local16];
                            local75 = local64 + Static513.anInt9292 - local28;
                            if (local75 > 0) {
                                local28 += local75;
                                local34 += local75;
                                local30 += Static513.anInt9321 * local75;
                                local32 += Static513.anInt9309 * local75;
                            } else {
                                local69 -= local75;
                            }
                            if (local34 < local69) {
                                local34 = local69;
                            }
                            while (local34 < 0) {
                                local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                                if (local122 == 0) {
                                    local28++;
                                } else {
                                    local3[local28++] = this.anIntArray714[local122 & 0xFF];
                                }
                                local30 += Static513.anInt9321;
                                local34++;
                            }
                        }
                    }
                    local11++;
                    Static513.anInt9317 += Static513.anInt9293;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else if (Static513.anInt9309 < 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local16 = local11 + arg3;
                    if (local16 >= 0) {
                        if (local16 >= arg0.length) {
                            return;
                        }
                        local28 = Static513.anInt9292;
                        local30 = Static513.anInt9310 + Static513.anInt9318;
                        local32 = Static513.anInt9317 + Static513.anInt9316;
                        local34 = Static513.anInt9303;
                        @Pc(739) int local739;
                        if ((local739 = local30 - (super.anInt9302 << 12)) >= 0) {
                            local206 = (Static513.anInt9321 - local739) / Static513.anInt9321;
                            local34 += local206;
                            local30 += Static513.anInt9321 * local206;
                            local32 += Static513.anInt9309 * local206;
                            local28 += local206;
                        }
                        @Pc(773) int local773;
                        if ((local773 = (local30 - Static513.anInt9321) / Static513.anInt9321) > local34) {
                            local34 = local773;
                        }
                        @Pc(785) int local785;
                        if ((local785 = local32 - (super.anInt9306 << 12)) >= 0) {
                            local206 = (Static513.anInt9309 - local785) / Static513.anInt9309;
                            local34 += local206;
                            local30 += Static513.anInt9321 * local206;
                            local32 += Static513.anInt9309 * local206;
                            local28 += local206;
                        }
                        @Pc(819) int local819;
                        if ((local819 = (local32 - Static513.anInt9309) / Static513.anInt9309) > local34) {
                            local34 = local819;
                        }
                        local64 = arg0[local16] - arg2;
                        local69 = -arg1[local16];
                        local75 = local64 + Static513.anInt9292 - local28;
                        if (local75 > 0) {
                            local28 += local75;
                            local34 += local75;
                            local30 += Static513.anInt9321 * local75;
                            local32 += Static513.anInt9309 * local75;
                        } else {
                            local69 -= local75;
                        }
                        if (local34 < local69) {
                            local34 = local69;
                        }
                        while (local34 < 0) {
                            local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                            if (local122 == 0) {
                                local28++;
                            } else {
                                local3[local28++] = this.anIntArray714[local122 & 0xFF];
                            }
                            local30 += Static513.anInt9321;
                            local32 += Static513.anInt9309;
                            local34++;
                        }
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9317 += Static513.anInt9293;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local16 = local11 + arg3;
                    if (local16 >= 0) {
                        if (local16 >= arg0.length) {
                            return;
                        }
                        local28 = Static513.anInt9292;
                        local30 = Static513.anInt9310 + Static513.anInt9318;
                        local32 = Static513.anInt9317 + Static513.anInt9316;
                        local34 = Static513.anInt9303;
                        @Pc(969) int local969;
                        if ((local969 = local30 - (super.anInt9302 << 12)) >= 0) {
                            local206 = (Static513.anInt9321 - local969) / Static513.anInt9321;
                            local34 += local206;
                            local30 += Static513.anInt9321 * local206;
                            local32 += Static513.anInt9309 * local206;
                            local28 += local206;
                        }
                        @Pc(1003) int local1003;
                        if ((local1003 = (local30 - Static513.anInt9321) / Static513.anInt9321) > local34) {
                            local34 = local1003;
                        }
                        if (local32 < 0) {
                            local206 = (Static513.anInt9309 - local32 - 1) / Static513.anInt9309;
                            local34 += local206;
                            local30 += Static513.anInt9321 * local206;
                            local32 += Static513.anInt9309 * local206;
                            local28 += local206;
                        }
                        @Pc(1051) int local1051;
                        if ((local1051 = (local32 + 1 - (super.anInt9306 << 12) - Static513.anInt9309) / Static513.anInt9309) > local34) {
                            local34 = local1051;
                        }
                        local64 = arg0[local16] - arg2;
                        local69 = -arg1[local16];
                        local75 = local64 + Static513.anInt9292 - local28;
                        if (local75 > 0) {
                            local28 += local75;
                            local34 += local75;
                            local30 += Static513.anInt9321 * local75;
                            local32 += Static513.anInt9309 * local75;
                        } else {
                            local69 -= local75;
                        }
                        if (local34 < local69) {
                            local34 = local69;
                        }
                        while (local34 < 0) {
                            local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                            if (local122 == 0) {
                                local28++;
                            } else {
                                local3[local28++] = this.anIntArray714[local122 & 0xFF];
                            }
                            local30 += Static513.anInt9321;
                            local32 += Static513.anInt9309;
                            local34++;
                        }
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9317 += Static513.anInt9293;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            }
        } else if (Static513.anInt9309 == 0) {
            local11 = Static513.anInt9297;
            while (local11 < 0) {
                local16 = local11 + arg3;
                if (local16 >= 0) {
                    if (local16 >= arg0.length) {
                        return;
                    }
                    local28 = Static513.anInt9292;
                    local30 = Static513.anInt9310 + Static513.anInt9318;
                    local32 = Static513.anInt9317;
                    local34 = Static513.anInt9303;
                    if (local32 >= 0 && local32 - (super.anInt9306 << 12) < 0) {
                        if (local30 < 0) {
                            local206 = (Static513.anInt9321 - local30 - 1) / Static513.anInt9321;
                            local34 += local206;
                            local30 += Static513.anInt9321 * local206;
                            local28 += local206;
                        }
                        @Pc(1244) int local1244;
                        if ((local1244 = (local30 + 1 - (super.anInt9302 << 12) - Static513.anInt9321) / Static513.anInt9321) > local34) {
                            local34 = local1244;
                        }
                        local64 = arg0[local16] - arg2;
                        local69 = -arg1[local16];
                        local75 = local64 + Static513.anInt9292 - local28;
                        if (local75 > 0) {
                            local28 += local75;
                            local34 += local75;
                            local30 += Static513.anInt9321 * local75;
                            local32 += Static513.anInt9309 * local75;
                        } else {
                            local69 -= local75;
                        }
                        if (local34 < local69) {
                            local34 = local69;
                        }
                        while (local34 < 0) {
                            local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                            if (local122 == 0) {
                                local28++;
                            } else {
                                local3[local28++] = this.anIntArray714[local122 & 0xFF];
                            }
                            local30 += Static513.anInt9321;
                            local34++;
                        }
                    }
                }
                local11++;
                Static513.anInt9310 += Static513.anInt9311;
                Static513.anInt9317 += Static513.anInt9293;
                Static513.anInt9292 += Static513.anInt9291;
            }
        } else if (Static513.anInt9309 < 0) {
            local11 = Static513.anInt9297;
            while (local11 < 0) {
                local16 = local11 + arg3;
                if (local16 >= 0) {
                    if (local16 >= arg0.length) {
                        return;
                    }
                    local28 = Static513.anInt9292;
                    local30 = Static513.anInt9310 + Static513.anInt9318;
                    local32 = Static513.anInt9317 + Static513.anInt9316;
                    local34 = Static513.anInt9303;
                    if (local30 < 0) {
                        local206 = (Static513.anInt9321 - local30 - 1) / Static513.anInt9321;
                        local34 += local206;
                        local30 += Static513.anInt9321 * local206;
                        local32 += Static513.anInt9309 * local206;
                        local28 += local206;
                    }
                    @Pc(1428) int local1428;
                    if ((local1428 = (local30 + 1 - (super.anInt9302 << 12) - Static513.anInt9321) / Static513.anInt9321) > local34) {
                        local34 = local1428;
                    }
                    @Pc(1440) int local1440;
                    if ((local1440 = local32 - (super.anInt9306 << 12)) >= 0) {
                        local206 = (Static513.anInt9309 - local1440) / Static513.anInt9309;
                        local34 += local206;
                        local30 += Static513.anInt9321 * local206;
                        local32 += Static513.anInt9309 * local206;
                        local28 += local206;
                    }
                    @Pc(1474) int local1474;
                    if ((local1474 = (local32 - Static513.anInt9309) / Static513.anInt9309) > local34) {
                        local34 = local1474;
                    }
                    local64 = arg0[local16] - arg2;
                    local69 = -arg1[local16];
                    local75 = local64 + Static513.anInt9292 - local28;
                    if (local75 > 0) {
                        local28 += local75;
                        local34 += local75;
                        local30 += Static513.anInt9321 * local75;
                        local32 += Static513.anInt9309 * local75;
                    } else {
                        local69 -= local75;
                    }
                    if (local34 < local69) {
                        local34 = local69;
                    }
                    while (local34 < 0) {
                        local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                        if (local122 == 0) {
                            local28++;
                        } else {
                            local3[local28++] = this.anIntArray714[local122 & 0xFF];
                        }
                        local30 += Static513.anInt9321;
                        local32 += Static513.anInt9309;
                        local34++;
                    }
                }
                local11++;
                Static513.anInt9310 += Static513.anInt9311;
                Static513.anInt9317 += Static513.anInt9293;
                Static513.anInt9292 += Static513.anInt9291;
            }
        } else {
            local11 = Static513.anInt9297;
            while (local11 < 0) {
                local16 = local11 + arg3;
                if (local16 >= 0) {
                    if (local16 >= arg0.length) {
                        return;
                    }
                    local28 = Static513.anInt9292;
                    local30 = Static513.anInt9310 + Static513.anInt9318;
                    local32 = Static513.anInt9317 + Static513.anInt9316;
                    local34 = Static513.anInt9303;
                    if (local30 < 0) {
                        local206 = (Static513.anInt9321 - local30 - 1) / Static513.anInt9321;
                        local34 += local206;
                        local30 += Static513.anInt9321 * local206;
                        local32 += Static513.anInt9309 * local206;
                        local28 += local206;
                    }
                    @Pc(1660) int local1660;
                    if ((local1660 = (local30 + 1 - (super.anInt9302 << 12) - Static513.anInt9321) / Static513.anInt9321) > local34) {
                        local34 = local1660;
                    }
                    if (local32 < 0) {
                        local206 = (Static513.anInt9309 - local32 - 1) / Static513.anInt9309;
                        local34 += local206;
                        local30 += Static513.anInt9321 * local206;
                        local32 += Static513.anInt9309 * local206;
                        local28 += local206;
                    }
                    @Pc(1708) int local1708;
                    if ((local1708 = (local32 + 1 - (super.anInt9306 << 12) - Static513.anInt9309) / Static513.anInt9309) > local34) {
                        local34 = local1708;
                    }
                    local64 = arg0[local16] - arg2;
                    local69 = -arg1[local16];
                    local75 = local64 + Static513.anInt9292 - local28;
                    if (local75 > 0) {
                        local28 += local75;
                        local34 += local75;
                        local30 += Static513.anInt9321 * local75;
                        local32 += Static513.anInt9309 * local75;
                    } else {
                        local69 -= local75;
                    }
                    if (local34 < local69) {
                        local34 = local69;
                    }
                    while (local34 < 0) {
                        local122 = this.aByteArray100[(local32 >> 12) * super.anInt9302 + (local30 >> 12)];
                        if (local122 == 0) {
                            local28++;
                        } else {
                            local3[local28++] = this.anIntArray714[local122 & 0xFF];
                        }
                        local30 += Static513.anInt9321;
                        local32 += Static513.anInt9309;
                        local34++;
                    }
                }
                local11++;
                Static513.anInt9310 += Static513.anInt9311;
                Static513.anInt9317 += Static513.anInt9293;
                Static513.anInt9292 += Static513.anInt9291;
            }
        }
    }

    @OriginalMember(owner = "client!te", name = "b", descriptor = "(II)V")
    @Override
    protected void method8209(@OriginalArg(0) int arg0) {
        @Pc(3) int[] local3 = super.toolkit.surfaceRaster;
        @Pc(963) int local963;
        @Pc(11) int local11;
        @Pc(14) int local14;
        @Pc(16) int local16;
        @Pc(18) int local18;
        @Pc(20) int local20;
        @Pc(57) int local57;
        @Pc(60) int local60;
        @Pc(241) byte local241;
        @Pc(270) int local270;
        @Pc(279) int local279;
        @Pc(283) int local283;
        @Pc(287) int local287;
        @Pc(359) int local359;
        if (Static513.anInt9321 == 0) {
            if (Static513.anInt9309 == 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local14 = Static513.anInt9292;
                    local16 = Static513.anInt9310;
                    local18 = Static513.anInt9317;
                    local20 = Static513.anInt9303;
                    if (local16 >= 0 && local18 >= 0 && local16 - (super.anInt9302 << 12) < 0 && local18 - (super.anInt9306 << 12) < 0) {
                        while (local20 < 0) {
                            local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                            local60 = local14++;
                            if (arg0 == 1) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local3[local60] = this.anIntArray714[local241 & 0xFF];
                                }
                            } else if (arg0 == 0) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                        local279 = Static513.anInt9313 >>> 24;
                                        local283 = 256 - local279;
                                        local287 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                                    } else if (Static513.anInt9304 == 255) {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local3[local60] = (local279 | local283 | local287) >>> 8;
                                    } else {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local270 = (local279 | local283 | local287) >>> 8;
                                        local359 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                    }
                                }
                            } else if (arg0 == 3) {
                                local241 = this.aByteArray100[local57];
                                local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                                local279 = Static513.anInt9313;
                                local283 = local270 + local279;
                                local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                                local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                                local359 = local283 - local359 | local359 - (local359 >>> 8);
                                if (local270 == 0 && Static513.anInt9304 != 255) {
                                    local270 = local359;
                                    local359 = local3[local60];
                                    local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                }
                                local3[local60] = local359;
                            } else if (arg0 == 2) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                                    local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                            local20++;
                        }
                    }
                    local11++;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else if (Static513.anInt9309 < 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local14 = Static513.anInt9292;
                    local16 = Static513.anInt9310;
                    local18 = Static513.anInt9317 + Static513.anInt9316;
                    local20 = Static513.anInt9303;
                    if (local16 >= 0 && local16 - (super.anInt9302 << 12) < 0) {
                        @Pc(956) int local956;
                        if ((local956 = local18 - (super.anInt9306 << 12)) >= 0) {
                            local963 = (Static513.anInt9309 - local956) / Static513.anInt9309;
                            local20 += local963;
                            local18 += Static513.anInt9309 * local963;
                            local14 += local963;
                        }
                        @Pc(984) int local984;
                        if ((local984 = (local18 - Static513.anInt9309) / Static513.anInt9309) > local20) {
                            local20 = local984;
                        }
                        while (local20 < 0) {
                            local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                            local60 = local14++;
                            if (arg0 == 1) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local3[local60] = this.anIntArray714[local241 & 0xFF];
                                }
                            } else if (arg0 == 0) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                        local279 = Static513.anInt9313 >>> 24;
                                        local283 = 256 - local279;
                                        local287 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                                    } else if (Static513.anInt9304 == 255) {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local3[local60] = (local279 | local283 | local287) >>> 8;
                                    } else {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local270 = (local279 | local283 | local287) >>> 8;
                                        local359 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                    }
                                }
                            } else if (arg0 == 3) {
                                local241 = this.aByteArray100[local57];
                                local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                                local279 = Static513.anInt9313;
                                local283 = local270 + local279;
                                local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                                local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                                local359 = local283 - local359 | local359 - (local359 >>> 8);
                                if (local270 == 0 && Static513.anInt9304 != 255) {
                                    local270 = local359;
                                    local359 = local3[local60];
                                    local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                }
                                local3[local60] = local359;
                            } else if (arg0 == 2) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                                    local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                            local18 += Static513.anInt9309;
                            local20++;
                        }
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local14 = Static513.anInt9292;
                    local16 = Static513.anInt9310;
                    local18 = Static513.anInt9317 + Static513.anInt9316;
                    local20 = Static513.anInt9303;
                    if (local16 >= 0 && local16 - (super.anInt9302 << 12) < 0) {
                        if (local18 < 0) {
                            local963 = (Static513.anInt9309 - local18 - 1) / Static513.anInt9309;
                            local20 += local963;
                            local18 += Static513.anInt9309 * local963;
                            local14 += local963;
                        }
                        @Pc(1937) int local1937;
                        if ((local1937 = (local18 + 1 - (super.anInt9306 << 12) - Static513.anInt9309) / Static513.anInt9309) > local20) {
                            local20 = local1937;
                        }
                        while (local20 < 0) {
                            local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                            local60 = local14++;
                            if (arg0 == 1) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local3[local60] = this.anIntArray714[local241 & 0xFF];
                                }
                            } else if (arg0 == 0) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                        local279 = Static513.anInt9313 >>> 24;
                                        local283 = 256 - local279;
                                        local287 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                                    } else if (Static513.anInt9304 == 255) {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local3[local60] = (local279 | local283 | local287) >>> 8;
                                    } else {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local270 = (local279 | local283 | local287) >>> 8;
                                        local359 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                    }
                                }
                            } else if (arg0 == 3) {
                                local241 = this.aByteArray100[local57];
                                local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                                local279 = Static513.anInt9313;
                                local283 = local270 + local279;
                                local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                                local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                                local359 = local283 - local359 | local359 - (local359 >>> 8);
                                if (local270 == 0 && Static513.anInt9304 != 255) {
                                    local270 = local359;
                                    local359 = local3[local60];
                                    local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                }
                                local3[local60] = local359;
                            } else if (arg0 == 2) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                                    local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                            local18 += Static513.anInt9309;
                            local20++;
                        }
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            }
        } else if (Static513.anInt9321 < 0) {
            if (Static513.anInt9309 == 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local14 = Static513.anInt9292;
                    local16 = Static513.anInt9310 + Static513.anInt9318;
                    local18 = Static513.anInt9317;
                    local20 = Static513.anInt9303;
                    if (local18 >= 0 && local18 - (super.anInt9306 << 12) < 0) {
                        @Pc(2864) int local2864;
                        if ((local2864 = local16 - (super.anInt9302 << 12)) >= 0) {
                            local963 = (Static513.anInt9321 - local2864) / Static513.anInt9321;
                            local20 += local963;
                            local16 += Static513.anInt9321 * local963;
                            local14 += local963;
                        }
                        @Pc(2892) int local2892;
                        if ((local2892 = (local16 - Static513.anInt9321) / Static513.anInt9321) > local20) {
                            local20 = local2892;
                        }
                        while (local20 < 0) {
                            local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                            local60 = local14++;
                            if (arg0 == 1) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local3[local60] = this.anIntArray714[local241 & 0xFF];
                                }
                            } else if (arg0 == 0) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                        local279 = Static513.anInt9313 >>> 24;
                                        local283 = 256 - local279;
                                        local287 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                                    } else if (Static513.anInt9304 == 255) {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local3[local60] = (local279 | local283 | local287) >>> 8;
                                    } else {
                                        local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                        local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                        local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                        local270 = (local279 | local283 | local287) >>> 8;
                                        local359 = local3[local60];
                                        local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                    }
                                }
                            } else if (arg0 == 3) {
                                local241 = this.aByteArray100[local57];
                                local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                                local279 = Static513.anInt9313;
                                local283 = local270 + local279;
                                local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                                local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                                local359 = local283 - local359 | local359 - (local359 >>> 8);
                                if (local270 == 0 && Static513.anInt9304 != 255) {
                                    local270 = local359;
                                    local359 = local3[local60];
                                    local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                }
                                local3[local60] = local359;
                            } else if (arg0 == 2) {
                                local241 = this.aByteArray100[local57];
                                if (local241 != 0) {
                                    local270 = this.anIntArray714[local241 & 0xFF];
                                    local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                                    local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                            local16 += Static513.anInt9321;
                            local20++;
                        }
                    }
                    local11++;
                    Static513.anInt9317 += Static513.anInt9293;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else if (Static513.anInt9309 < 0) {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local14 = Static513.anInt9292;
                    local16 = Static513.anInt9310 + Static513.anInt9318;
                    local18 = Static513.anInt9317 + Static513.anInt9316;
                    local20 = Static513.anInt9303;
                    @Pc(3806) int local3806;
                    if ((local3806 = local16 - (super.anInt9302 << 12)) >= 0) {
                        local963 = (Static513.anInt9321 - local3806) / Static513.anInt9321;
                        local20 += local963;
                        local16 += Static513.anInt9321 * local963;
                        local18 += Static513.anInt9309 * local963;
                        local14 += local963;
                    }
                    @Pc(3840) int local3840;
                    if ((local3840 = (local16 - Static513.anInt9321) / Static513.anInt9321) > local20) {
                        local20 = local3840;
                    }
                    @Pc(3852) int local3852;
                    if ((local3852 = local18 - (super.anInt9306 << 12)) >= 0) {
                        local963 = (Static513.anInt9309 - local3852) / Static513.anInt9309;
                        local20 += local963;
                        local16 += Static513.anInt9321 * local963;
                        local18 += Static513.anInt9309 * local963;
                        local14 += local963;
                    }
                    @Pc(3886) int local3886;
                    if ((local3886 = (local18 - Static513.anInt9309) / Static513.anInt9309) > local20) {
                        local20 = local3886;
                    }
                    while (local20 < 0) {
                        local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                        local60 = local14++;
                        if (arg0 == 1) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local3[local60] = this.anIntArray714[local241 & 0xFF];
                            }
                        } else if (arg0 == 0) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local270 = this.anIntArray714[local241 & 0xFF];
                                if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                    local279 = Static513.anInt9313 >>> 24;
                                    local283 = 256 - local279;
                                    local287 = local3[local60];
                                    local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                                } else if (Static513.anInt9304 == 255) {
                                    local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                    local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                    local3[local60] = (local279 | local283 | local287) >>> 8;
                                } else {
                                    local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                    local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                    local270 = (local279 | local283 | local287) >>> 8;
                                    local359 = local3[local60];
                                    local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                }
                            }
                        } else if (arg0 == 3) {
                            local241 = this.aByteArray100[local57];
                            local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                            local279 = Static513.anInt9313;
                            local283 = local270 + local279;
                            local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                            local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                            local359 = local283 - local359 | local359 - (local359 >>> 8);
                            if (local270 == 0 && Static513.anInt9304 != 255) {
                                local270 = local359;
                                local359 = local3[local60];
                                local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                            }
                            local3[local60] = local359;
                        } else if (arg0 == 2) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local270 = this.anIntArray714[local241 & 0xFF];
                                local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                                local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                                local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                        local16 += Static513.anInt9321;
                        local18 += Static513.anInt9309;
                        local20++;
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9317 += Static513.anInt9293;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            } else {
                local11 = Static513.anInt9297;
                while (local11 < 0) {
                    local14 = Static513.anInt9292;
                    local16 = Static513.anInt9310 + Static513.anInt9318;
                    local18 = Static513.anInt9317 + Static513.anInt9316;
                    local20 = Static513.anInt9303;
                    @Pc(4806) int local4806;
                    if ((local4806 = local16 - (super.anInt9302 << 12)) >= 0) {
                        local963 = (Static513.anInt9321 - local4806) / Static513.anInt9321;
                        local20 += local963;
                        local16 += Static513.anInt9321 * local963;
                        local18 += Static513.anInt9309 * local963;
                        local14 += local963;
                    }
                    @Pc(4840) int local4840;
                    if ((local4840 = (local16 - Static513.anInt9321) / Static513.anInt9321) > local20) {
                        local20 = local4840;
                    }
                    if (local18 < 0) {
                        local963 = (Static513.anInt9309 - local18 - 1) / Static513.anInt9309;
                        local20 += local963;
                        local16 += Static513.anInt9321 * local963;
                        local18 += Static513.anInt9309 * local963;
                        local14 += local963;
                    }
                    @Pc(4888) int local4888;
                    if ((local4888 = (local18 + 1 - (super.anInt9306 << 12) - Static513.anInt9309) / Static513.anInt9309) > local20) {
                        local20 = local4888;
                    }
                    while (local20 < 0) {
                        local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                        local60 = local14++;
                        if (arg0 == 1) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local3[local60] = this.anIntArray714[local241 & 0xFF];
                            }
                        } else if (arg0 == 0) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local270 = this.anIntArray714[local241 & 0xFF];
                                if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                    local279 = Static513.anInt9313 >>> 24;
                                    local283 = 256 - local279;
                                    local287 = local3[local60];
                                    local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                                } else if (Static513.anInt9304 == 255) {
                                    local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                    local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                    local3[local60] = (local279 | local283 | local287) >>> 8;
                                } else {
                                    local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                    local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                    local270 = (local279 | local283 | local287) >>> 8;
                                    local359 = local3[local60];
                                    local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                }
                            }
                        } else if (arg0 == 3) {
                            local241 = this.aByteArray100[local57];
                            local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                            local279 = Static513.anInt9313;
                            local283 = local270 + local279;
                            local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                            local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                            local359 = local283 - local359 | local359 - (local359 >>> 8);
                            if (local270 == 0 && Static513.anInt9304 != 255) {
                                local270 = local359;
                                local359 = local3[local60];
                                local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                            }
                            local3[local60] = local359;
                        } else if (arg0 == 2) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local270 = this.anIntArray714[local241 & 0xFF];
                                local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                                local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                                local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                        local16 += Static513.anInt9321;
                        local18 += Static513.anInt9309;
                        local20++;
                    }
                    local11++;
                    Static513.anInt9310 += Static513.anInt9311;
                    Static513.anInt9317 += Static513.anInt9293;
                    Static513.anInt9292 += Static513.anInt9291;
                }
            }
        } else if (Static513.anInt9309 == 0) {
            local11 = Static513.anInt9297;
            while (local11 < 0) {
                local14 = Static513.anInt9292;
                local16 = Static513.anInt9310 + Static513.anInt9318;
                local18 = Static513.anInt9317;
                local20 = Static513.anInt9303;
                if (local18 >= 0 && local18 - (super.anInt9306 << 12) < 0) {
                    if (local16 < 0) {
                        local963 = (Static513.anInt9321 - local16 - 1) / Static513.anInt9321;
                        local20 += local963;
                        local16 += Static513.anInt9321 * local963;
                        local14 += local963;
                    }
                    @Pc(5851) int local5851;
                    if ((local5851 = (local16 + 1 - (super.anInt9302 << 12) - Static513.anInt9321) / Static513.anInt9321) > local20) {
                        local20 = local5851;
                    }
                    while (local20 < 0) {
                        local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                        local60 = local14++;
                        if (arg0 == 1) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local3[local60] = this.anIntArray714[local241 & 0xFF];
                            }
                        } else if (arg0 == 0) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local270 = this.anIntArray714[local241 & 0xFF];
                                if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                    local279 = Static513.anInt9313 >>> 24;
                                    local283 = 256 - local279;
                                    local287 = local3[local60];
                                    local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                                } else if (Static513.anInt9304 == 255) {
                                    local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                    local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                    local3[local60] = (local279 | local283 | local287) >>> 8;
                                } else {
                                    local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                    local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                    local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                    local270 = (local279 | local283 | local287) >>> 8;
                                    local359 = local3[local60];
                                    local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                                }
                            }
                        } else if (arg0 == 3) {
                            local241 = this.aByteArray100[local57];
                            local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                            local279 = Static513.anInt9313;
                            local283 = local270 + local279;
                            local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                            local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                            local359 = local283 - local359 | local359 - (local359 >>> 8);
                            if (local270 == 0 && Static513.anInt9304 != 255) {
                                local270 = local359;
                                local359 = local3[local60];
                                local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                            }
                            local3[local60] = local359;
                        } else if (arg0 == 2) {
                            local241 = this.aByteArray100[local57];
                            if (local241 != 0) {
                                local270 = this.anIntArray714[local241 & 0xFF];
                                local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                                local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                                local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                        local16 += Static513.anInt9321;
                        local20++;
                    }
                }
                local11++;
                Static513.anInt9310 += Static513.anInt9311;
                Static513.anInt9317 += Static513.anInt9293;
                Static513.anInt9292 += Static513.anInt9291;
            }
        } else if (Static513.anInt9309 < 0) {
            for (local11 = Static513.anInt9297; local11 < 0; local11++) {
                local14 = Static513.anInt9292;
                local16 = Static513.anInt9310 + Static513.anInt9318;
                local18 = Static513.anInt9317 + Static513.anInt9316;
                local20 = Static513.anInt9303;
                if (local16 < 0) {
                    local963 = (Static513.anInt9321 - local16 - 1) / Static513.anInt9321;
                    local20 += local963;
                    local16 += Static513.anInt9321 * local963;
                    local18 += Static513.anInt9309 * local963;
                    local14 += local963;
                }
                @Pc(6805) int local6805;
                if ((local6805 = (local16 + 1 - (super.anInt9302 << 12) - Static513.anInt9321) / Static513.anInt9321) > local20) {
                    local20 = local6805;
                }
                @Pc(6817) int local6817;
                if ((local6817 = local18 - (super.anInt9306 << 12)) >= 0) {
                    local963 = (Static513.anInt9309 - local6817) / Static513.anInt9309;
                    local20 += local963;
                    local16 += Static513.anInt9321 * local963;
                    local18 += Static513.anInt9309 * local963;
                    local14 += local963;
                }
                @Pc(6851) int local6851;
                if ((local6851 = (local18 - Static513.anInt9309) / Static513.anInt9309) > local20) {
                    local20 = local6851;
                }
                while (local20 < 0) {
                    local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                    local60 = local14++;
                    if (arg0 == 1) {
                        local241 = this.aByteArray100[local57];
                        if (local241 != 0) {
                            local3[local60] = this.anIntArray714[local241 & 0xFF];
                        }
                    } else if (arg0 == 0) {
                        local241 = this.aByteArray100[local57];
                        if (local241 != 0) {
                            local270 = this.anIntArray714[local241 & 0xFF];
                            if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                local279 = Static513.anInt9313 >>> 24;
                                local283 = 256 - local279;
                                local287 = local3[local60];
                                local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                            } else if (Static513.anInt9304 == 255) {
                                local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                local3[local60] = (local279 | local283 | local287) >>> 8;
                            } else {
                                local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                local270 = (local279 | local283 | local287) >>> 8;
                                local359 = local3[local60];
                                local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                            }
                        }
                    } else if (arg0 == 3) {
                        local241 = this.aByteArray100[local57];
                        local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                        local279 = Static513.anInt9313;
                        local283 = local270 + local279;
                        local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                        local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                        local359 = local283 - local359 | local359 - (local359 >>> 8);
                        if (local270 == 0 && Static513.anInt9304 != 255) {
                            local270 = local359;
                            local359 = local3[local60];
                            local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                        }
                        local3[local60] = local359;
                    } else if (arg0 == 2) {
                        local241 = this.aByteArray100[local57];
                        if (local241 != 0) {
                            local270 = this.anIntArray714[local241 & 0xFF];
                            local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                            local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                            local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                    local16 += Static513.anInt9321;
                    local18 += Static513.anInt9309;
                    local20++;
                }
                Static513.anInt9310 += Static513.anInt9311;
                Static513.anInt9317 += Static513.anInt9293;
                Static513.anInt9292 += Static513.anInt9291;
            }
        } else {
            for (local11 = Static513.anInt9297; local11 < 0; local11++) {
                local14 = Static513.anInt9292;
                local16 = Static513.anInt9310 + Static513.anInt9318;
                local18 = Static513.anInt9317 + Static513.anInt9316;
                local20 = Static513.anInt9303;
                if (local16 < 0) {
                    local963 = (Static513.anInt9321 - local16 - 1) / Static513.anInt9321;
                    local20 += local963;
                    local16 += Static513.anInt9321 * local963;
                    local18 += Static513.anInt9309 * local963;
                    local14 += local963;
                }
                @Pc(7807) int local7807;
                if ((local7807 = (local16 + 1 - (super.anInt9302 << 12) - Static513.anInt9321) / Static513.anInt9321) > local20) {
                    local20 = local7807;
                }
                if (local18 < 0) {
                    local963 = (Static513.anInt9309 - local18 - 1) / Static513.anInt9309;
                    local20 += local963;
                    local16 += Static513.anInt9321 * local963;
                    local18 += Static513.anInt9309 * local963;
                    local14 += local963;
                }
                @Pc(7855) int local7855;
                if ((local7855 = (local18 + 1 - (super.anInt9306 << 12) - Static513.anInt9309) / Static513.anInt9309) > local20) {
                    local20 = local7855;
                }
                while (local20 < 0) {
                    local57 = (local18 >> 12) * super.anInt9302 + (local16 >> 12);
                    local60 = local14++;
                    if (arg0 == 1) {
                        local241 = this.aByteArray100[local57];
                        if (local241 != 0) {
                            local3[local60] = this.anIntArray714[local241 & 0xFF];
                        }
                    } else if (arg0 == 0) {
                        local241 = this.aByteArray100[local57];
                        if (local241 != 0) {
                            local270 = this.anIntArray714[local241 & 0xFF];
                            if ((Static513.anInt9313 & 0xFFFFFF) == 16777215) {
                                local279 = Static513.anInt9313 >>> 24;
                                local283 = 256 - local279;
                                local287 = local3[local60];
                                local3[local60] = ((local270 & 0xFF00FF) * local279 + (local287 & 0xFF00FF) * local283 & 0xFF00FF00) + ((local270 & 0xFF00) * local279 + (local287 & 0xFF00) * local283 & 0xFF0000) >> 8;
                            } else if (Static513.anInt9304 == 255) {
                                local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                local3[local60] = (local279 | local283 | local287) >>> 8;
                            } else {
                                local279 = (local270 & 0xFF0000) * Static513.anInt9319 & 0xFF000000;
                                local283 = (local270 & 0xFF00) * Static513.anInt9299 & 0xFF0000;
                                local287 = (local270 & 0xFF) * Static513.anInt9315 & 0xFF00;
                                local270 = (local279 | local283 | local287) >>> 8;
                                local359 = local3[local60];
                                local3[local60] = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                            }
                        }
                    } else if (arg0 == 3) {
                        local241 = this.aByteArray100[local57];
                        local270 = local241 > 0 ? this.anIntArray714[local241] : 0;
                        local279 = Static513.anInt9313;
                        local283 = local270 + local279;
                        local287 = (local270 & 0xFF00FF) + (local279 & 0xFF00FF);
                        local359 = (local287 & 0x1000100) + (local283 - local287 & 0x10000);
                        local359 = local283 - local359 | local359 - (local359 >>> 8);
                        if (local270 == 0 && Static513.anInt9304 != 255) {
                            local270 = local359;
                            local359 = local3[local60];
                            local359 = ((local270 & 0xFF00FF) * Static513.anInt9304 + (local359 & 0xFF00FF) * Static513.anInt9312 & 0xFF00FF00) + ((local270 & 0xFF00) * Static513.anInt9304 + (local359 & 0xFF00) * Static513.anInt9312 & 0xFF0000) >> 8;
                        }
                        local3[local60] = local359;
                    } else if (arg0 == 2) {
                        local241 = this.aByteArray100[local57];
                        if (local241 != 0) {
                            local270 = this.anIntArray714[local241 & 0xFF];
                            local279 = (local270 & 0xFF00FF) * Static513.anInt9304 & 0xFF00FF00;
                            local283 = (local270 & 0xFF00) * Static513.anInt9304 & 0xFF0000;
                            local3[local60++] = ((local279 | local283) >>> 8) + Static513.anInt9305;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                    local16 += Static513.anInt9321;
                    local18 += Static513.anInt9309;
                    local20++;
                }
                Static513.anInt9310 += Static513.anInt9311;
                Static513.anInt9317 += Static513.anInt9293;
                Static513.anInt9292 += Static513.anInt9291;
            }
        }
    }

    @OriginalMember(owner = "client!te", name = "a", descriptor = "(IIIIII)V")
    @Override
    public void copyRect(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour) {
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!te", name = "a", descriptor = "(III)V")
    @Override
    public void copyAlpha(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int channel) {
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!te", name = "a", descriptor = "(IIIIIIIII)V")
    @Override
    public void method8208(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
        if (arg3 <= 0 || arg4 <= 0) {
            return;
        }
        @Pc(9) int local9 = 0;
        @Pc(11) int local11 = 0;
        @Pc(20) int local20 = super.anInt9298 + super.anInt9302 + super.anInt9295;
        @Pc(29) int local29 = super.anInt9308 + super.anInt9306 + super.anInt9294;
        @Pc(35) int local35 = (local20 << 16) / arg3;
        @Pc(41) int local41 = (local29 << 16) / arg4;
        @Pc(55) int local55;
        if (super.anInt9298 > 0) {
            local55 = ((super.anInt9298 << 16) + local35 - 1) / local35;
            arg0 += local55;
            local9 = local55 * local35 - (super.anInt9298 << 16);
        }
        if (super.anInt9308 > 0) {
            local55 = ((super.anInt9308 << 16) + local41 - 1) / local41;
            arg1 += local55;
            local11 = local55 * local41 - (super.anInt9308 << 16);
        }
        if (super.anInt9302 < local20) {
            arg3 = ((super.anInt9302 << 16) + local35 - local9 - 1) / local35;
        }
        if (super.anInt9306 < local29) {
            arg4 = ((super.anInt9306 << 16) + local41 - local11 - 1) / local41;
        }
        local55 = arg0 + arg1 * super.toolkit.surfaceWidth;
        @Pc(147) int local147 = super.toolkit.surfaceWidth - arg3;
        if (arg1 + arg4 > super.toolkit.clipY2) {
            arg4 -= arg1 + arg4 - super.toolkit.clipY2;
        }
        @Pc(175) int local175;
        if (arg1 < super.toolkit.clipY1) {
            local175 = super.toolkit.clipY1 - arg1;
            arg4 -= local175;
            local55 += local175 * super.toolkit.surfaceWidth;
            local11 += local41 * local175;
        }
        if (arg0 + arg3 > super.toolkit.clipX2) {
            local175 = arg0 + arg3 - super.toolkit.clipX2;
            arg3 -= local175;
            local147 += local175;
        }
        if (arg0 < super.toolkit.clipX1) {
            local175 = super.toolkit.clipX1 - arg0;
            arg3 -= local175;
            local55 += local175;
            local9 += local35 * local175;
            local147 += local175;
        }
        @Pc(249) float[] local249 = super.toolkit.depthBuffer;
        @Pc(253) int[] local253 = super.toolkit.surfaceRaster;
        @Pc(262) int local262;
        @Pc(265) int local265;
        @Pc(273) int local273;
        @Pc(276) int local276;
        @Pc(353) int local353;
        @Pc(361) int local361;
        @Pc(364) int local364;
        @Pc(386) int local386;
        @Pc(402) int local402;
        @Pc(410) int local410;
        @Pc(589) int local589;
        @Pc(484) byte local484;
        @Pc(394) int local394;
        if (arg7 != 0) {
            @Pc(1318) byte local1318;
            @Pc(963) int local963;
            @Pc(971) int local971;
            @Pc(979) int local979;
            @Pc(991) int local991;
            if (arg7 == 1) {
                if (arg5 == 1) {
                    local262 = local9;
                    for (local265 = -arg4; local265 < 0; local265++) {
                        local273 = (local11 >> 16) * super.anInt9302;
                        for (local276 = -arg3; local276 < 0; local276++) {
                            if ((float) arg2 < local249[local55]) {
                                local484 = this.aByteArray100[(local9 >> 16) + local273];
                                if (local484 != 0) {
                                    local253[local55] = this.anIntArray714[local484 & 0xFF];
                                    local249[local55] = (float) arg2;
                                }
                            }
                            local9 += local35;
                            local55++;
                        }
                        local11 += local41;
                        local9 = local262;
                        local55 += local147;
                    }
                } else {
                    @Pc(815) byte local815;
                    if (arg5 == 0) {
                        local262 = local9;
                        if ((arg6 & 0xFFFFFF) == 16777215) {
                            local265 = arg6 >>> 24;
                            local273 = 256 - local265;
                            for (local276 = -arg4; local276 < 0; local276++) {
                                local353 = (local11 >> 16) * super.anInt9302;
                                for (local361 = -arg3; local361 < 0; local361++) {
                                    if ((float) arg2 < local249[local55]) {
                                        local815 = this.aByteArray100[(local9 >> 16) + local353];
                                        if (local815 != 0) {
                                            local386 = this.anIntArray714[local815 & 0xFF];
                                            local394 = local253[local55];
                                            local253[local55] = ((local386 & 0xFF00FF) * local265 + (local394 & 0xFF00FF) * local273 & 0xFF00FF00) + ((local386 & 0xFF00) * local265 + (local394 & 0xFF00) * local273 & 0xFF0000) >> 8;
                                            local249[local55] = (float) arg2;
                                        }
                                    }
                                    local9 += local35;
                                    local55++;
                                }
                                local11 += local41;
                                local9 = local262;
                                local55 += local147;
                            }
                        } else {
                            local265 = arg6 >> 16 & 0xFF;
                            local273 = arg6 >> 8 & 0xFF;
                            local276 = arg6 & 0xFF;
                            local353 = arg6 >>> 24;
                            local361 = 256 - local353;
                            for (local364 = -arg4; local364 < 0; local364++) {
                                local386 = (local11 >> 16) * super.anInt9302;
                                for (local394 = -arg3; local394 < 0; local394++) {
                                    if ((float) arg2 < local249[local55]) {
                                        @Pc(943) byte local943 = this.aByteArray100[(local9 >> 16) + local386];
                                        if (local943 != 0) {
                                            local410 = this.anIntArray714[local943 & 0xFF];
                                            if (local353 == 255) {
                                                local963 = (local410 & 0xFF0000) * local265 & 0xFF000000;
                                                local971 = (local410 & 0xFF00) * local273 & 0xFF0000;
                                                local979 = (local410 & 0xFF) * local276 & 0xFF00;
                                                local253[local55] = (local963 | local971 | local979) >>> 8;
                                                local249[local55] = (float) arg2;
                                            } else {
                                                local963 = (local410 & 0xFF0000) * local265 & 0xFF000000;
                                                local971 = (local410 & 0xFF00) * local273 & 0xFF0000;
                                                local979 = (local410 & 0xFF) * local276 & 0xFF00;
                                                local410 = (local963 | local971 | local979) >>> 8;
                                                local991 = local253[local55];
                                                local253[local55] = ((local410 & 0xFF00FF) * local353 + (local991 & 0xFF00FF) * local361 & 0xFF00FF00) + ((local410 & 0xFF00) * local353 + (local991 & 0xFF00) * local361 & 0xFF0000) >> 8;
                                                local249[local55] = (float) arg2;
                                            }
                                        }
                                    }
                                    local9 += local35;
                                    local55++;
                                }
                                local11 += local41;
                                local9 = local262;
                                local55 += local147;
                            }
                        }
                    } else if (arg5 == 3) {
                        local262 = local9;
                        local265 = arg6 >>> 24;
                        local273 = 256 - local265;
                        for (local276 = -arg4; local276 < 0; local276++) {
                            local353 = (local11 >> 16) * super.anInt9302;
                            for (local361 = -arg3; local361 < 0; local361++) {
                                if ((float) arg2 < local249[local55]) {
                                    local815 = this.aByteArray100[(local9 >> 16) + local353];
                                    local386 = local815 > 0 ? this.anIntArray714[local815] : 0;
                                    local394 = local386 + arg6;
                                    local402 = (local386 & 0xFF00FF) + (arg6 & 0xFF00FF);
                                    local410 = (local402 & 0x1000100) + (local394 - local402 & 0x10000);
                                    local410 = local394 - local410 | local410 - (local410 >>> 8);
                                    if (local386 == 0 && local265 != 255) {
                                        local386 = local410;
                                        local410 = local253[local55];
                                        local410 = ((local386 & 0xFF00FF) * local265 + (local410 & 0xFF00FF) * local273 & 0xFF00FF00) + ((local386 & 0xFF00) * local265 + (local410 & 0xFF00) * local273 & 0xFF0000) >> 8;
                                    }
                                    local253[local55] = local410;
                                    local249[local55] = (float) arg2;
                                }
                                local9 += local35;
                                local55++;
                            }
                            local11 += local41;
                            local9 = local262;
                            local55 += local147;
                        }
                    } else if (arg5 == 2) {
                        local262 = arg6 >>> 24;
                        local265 = 256 - local262;
                        local273 = (arg6 & 0xFF00FF) * local265 & 0xFF00FF00;
                        local276 = (arg6 & 0xFF00) * local265 & 0xFF0000;
                        local589 = (local273 | local276) >>> 8;
                        local353 = local9;
                        for (local361 = -arg4; local361 < 0; local361++) {
                            local364 = (local11 >> 16) * super.anInt9302;
                            for (local386 = -arg3; local386 < 0; local386++) {
                                if ((float) arg2 < local249[local55]) {
                                    local1318 = this.aByteArray100[(local9 >> 16) + local364];
                                    if (local1318 != 0) {
                                        local402 = this.anIntArray714[local1318 & 0xFF];
                                        local273 = (local402 & 0xFF00FF) * local262 & 0xFF00FF00;
                                        local276 = (local402 & 0xFF00) * local262 & 0xFF0000;
                                        local253[local55] = ((local273 | local276) >>> 8) + local589;
                                        local249[local55] = (float) arg2;
                                    }
                                }
                                local9 += local35;
                                local55++;
                            }
                            local11 += local41;
                            local9 = local353;
                            local55 += local147;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            } else if (arg7 != 2) {
                throw new IllegalArgumentException();
            } else if (arg5 == 1) {
                local262 = local9;
                for (local265 = -arg4; local265 < 0; local265++) {
                    local273 = (local11 >> 16) * super.anInt9302;
                    for (local276 = -arg3; local276 < 0; local276++) {
                        if ((float) arg2 < local249[local55]) {
                            local484 = this.aByteArray100[(local9 >> 16) + local273];
                            if (local484 != 0) {
                                local361 = this.anIntArray714[local484 & 0xFF];
                                local364 = local253[local55];
                                local386 = local361 + local364;
                                local394 = (local361 & 0xFF00FF) + (local364 & 0xFF00FF);
                                local364 = (local394 & 0x1000100) + (local386 - local394 & 0x10000);
                                local253[local55] = local386 - local364 | local364 - (local364 >>> 8);
                                local249[local55] = (float) arg2;
                            }
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local262;
                    local55 += local147;
                }
            } else if (arg5 == 0) {
                local262 = local9;
                local265 = arg6 >> 16 & 0xFF;
                local273 = arg6 >> 8 & 0xFF;
                local276 = arg6 & 0xFF;
                for (local353 = -arg4; local353 < 0; local353++) {
                    local361 = (local11 >> 16) * super.anInt9302;
                    for (local364 = -arg3; local364 < 0; local364++) {
                        if ((float) arg2 < local249[local55]) {
                            @Pc(1552) byte local1552 = this.aByteArray100[(local9 >> 16) + local361];
                            if (local1552 != 0) {
                                local394 = this.anIntArray714[local1552 & 0xFF];
                                local402 = (local394 & 0xFF0000) * local265 & 0xFF000000;
                                local410 = (local394 & 0xFF00) * local273 & 0xFF0000;
                                local963 = (local394 & 0xFF) * local276 & 0xFF00;
                                local394 = (local402 | local410 | local963) >>> 8;
                                local971 = local253[local55];
                                local979 = local394 + local971;
                                local991 = (local394 & 0xFF00FF) + (local971 & 0xFF00FF);
                                local971 = (local991 & 0x1000100) + (local979 - local991 & 0x10000);
                                local253[local55] = local979 - local971 | local971 - (local971 >>> 8);
                                local249[local55] = (float) arg2;
                            }
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local262;
                    local55 += local147;
                }
            } else if (arg5 == 3) {
                local262 = local9;
                for (local265 = -arg4; local265 < 0; local265++) {
                    local273 = (local11 >> 16) * super.anInt9302;
                    for (local276 = -arg3; local276 < 0; local276++) {
                        if ((float) arg2 < local249[local55]) {
                            local484 = this.aByteArray100[(local9 >> 16) + local273];
                            local361 = local484 > 0 ? this.anIntArray714[local484] : 0;
                            local364 = local361 + arg6;
                            local386 = (local361 & 0xFF00FF) + (arg6 & 0xFF00FF);
                            local394 = (local386 & 0x1000100) + (local364 - local386 & 0x10000);
                            local361 = local364 - local394 | local394 - (local394 >>> 8);
                            @Pc(1741) int local1741 = local253[local55];
                            local364 = local361 + local1741;
                            local386 = (local361 & 0xFF00FF) + (local1741 & 0xFF00FF);
                            @Pc(1763) int local1763 = (local386 & 0x1000100) + (local364 - local386 & 0x10000);
                            local253[local55] = local364 - local1763 | local1763 - (local1763 >>> 8);
                            local249[local55] = (float) arg2;
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local262;
                    local55 += local147;
                }
            } else if (arg5 == 2) {
                local262 = arg6 >>> 24;
                local265 = 256 - local262;
                local273 = (arg6 & 0xFF00FF) * local265 & 0xFF00FF00;
                local276 = (arg6 & 0xFF00) * local265 & 0xFF0000;
                local589 = (local273 | local276) >>> 8;
                local353 = local9;
                for (local361 = -arg4; local361 < 0; local361++) {
                    local364 = (local11 >> 16) * super.anInt9302;
                    for (local386 = -arg3; local386 < 0; local386++) {
                        if ((float) arg2 < local249[local55]) {
                            local1318 = this.aByteArray100[(local9 >> 16) + local364];
                            if (local1318 != 0) {
                                local402 = this.anIntArray714[local1318 & 0xFF];
                                local273 = (local402 & 0xFF00FF) * local262 & 0xFF00FF00;
                                local276 = (local402 & 0xFF00) * local262 & 0xFF0000;
                                @Pc(1902) int local1902 = ((local273 | local276) >>> 8) + local589;
                                local410 = local253[local55];
                                local963 = local1902 + local410;
                                local971 = (local1902 & 0xFF00FF) + (local410 & 0xFF00FF);
                                @Pc(1928) int local1928 = (local971 & 0x1000100) + (local963 - local971 & 0x10000);
                                local253[local55] = local963 - local1928 | local1928 - (local1928 >>> 8);
                                local249[local55] = (float) arg2;
                            }
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local353;
                    local55 += local147;
                }
            } else {
                throw new IllegalArgumentException();
            }
        } else if (arg5 == 1) {
            local262 = local9;
            for (local265 = -arg4; local265 < 0; local265++) {
                local273 = (local11 >> 16) * super.anInt9302;
                for (local276 = -arg3; local276 < 0; local276++) {
                    if ((float) arg2 < local249[local55]) {
                        local253[local55] = this.anIntArray714[this.aByteArray100[(local9 >> 16) + local273] & 0xFF];
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local262;
                local55 += local147;
            }
        } else if (arg5 == 0) {
            local262 = arg6 >> 16 & 0xFF;
            local265 = arg6 >> 8 & 0xFF;
            local273 = arg6 & 0xFF;
            local276 = local9;
            for (local353 = -arg4; local353 < 0; local353++) {
                local361 = (local11 >> 16) * super.anInt9302;
                for (local364 = -arg3; local364 < 0; local364++) {
                    if ((float) arg2 < local249[local55]) {
                        local386 = this.anIntArray714[this.aByteArray100[(local9 >> 16) + local361] & 0xFF];
                        local394 = (local386 & 0xFF0000) * local262 & 0xFF000000;
                        local402 = (local386 & 0xFF00) * local265 & 0xFF0000;
                        local410 = (local386 & 0xFF) * local273 & 0xFF00;
                        local253[local55] = (local394 | local402 | local410) >>> 8;
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local276;
                local55 += local147;
            }
        } else if (arg5 == 3) {
            local262 = local9;
            for (local265 = -arg4; local265 < 0; local265++) {
                local273 = (local11 >> 16) * super.anInt9302;
                for (local276 = -arg3; local276 < 0; local276++) {
                    if ((float) arg2 < local249[local55]) {
                        local484 = this.aByteArray100[(local9 >> 16) + local273];
                        local361 = local484 > 0 ? this.anIntArray714[local484] : 0;
                        local364 = local361 + arg6;
                        local386 = (local361 & 0xFF00FF) + (arg6 & 0xFF00FF);
                        local394 = (local386 & 0x1000100) + (local364 - local386 & 0x10000);
                        local253[local55] = local364 - local394 | local394 - (local394 >>> 8);
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local262;
                local55 += local147;
            }
        } else if (arg5 == 2) {
            local262 = arg6 >>> 24;
            local265 = 256 - local262;
            local273 = (arg6 & 0xFF00FF) * local265 & 0xFF00FF00;
            local276 = (arg6 & 0xFF00) * local265 & 0xFF0000;
            local589 = (local273 | local276) >>> 8;
            local353 = local9;
            for (local361 = -arg4; local361 < 0; local361++) {
                local364 = (local11 >> 16) * super.anInt9302;
                for (local386 = -arg3; local386 < 0; local386++) {
                    if ((float) arg2 < local249[local55]) {
                        local394 = this.anIntArray714[this.aByteArray100[(local9 >> 16) + local364] & 0xFF];
                        local273 = (local394 & 0xFF00FF) * local262 & 0xFF00FF00;
                        local276 = (local394 & 0xFF00) * local262 & 0xFF0000;
                        local253[local55] = ((local273 | local276) >>> 8) + local589;
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local353;
                local55 += local147;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!te", name = "b", descriptor = "(IIIIIIIII)V")
    @Override
    public void method8207(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
        if (arg3 <= 0 || arg4 <= 0) {
            return;
        }
        @Pc(9) int local9 = 0;
        @Pc(11) int local11 = 0;
        @Pc(20) int local20 = super.anInt9298 + super.anInt9302 + super.anInt9295;
        @Pc(29) int local29 = super.anInt9308 + super.anInt9306 + super.anInt9294;
        @Pc(35) int local35 = (local20 << 16) / arg3;
        @Pc(41) int local41 = (local29 << 16) / arg4;
        @Pc(55) int local55;
        if (super.anInt9298 > 0) {
            local55 = ((super.anInt9298 << 16) + local35 - 1) / local35;
            arg0 += local55;
            local9 = local55 * local35 - (super.anInt9298 << 16);
        }
        if (super.anInt9308 > 0) {
            local55 = ((super.anInt9308 << 16) + local41 - 1) / local41;
            arg1 += local55;
            local11 = local55 * local41 - (super.anInt9308 << 16);
        }
        if (super.anInt9302 < local20) {
            arg3 = ((super.anInt9302 << 16) + local35 - local9 - 1) / local35;
        }
        if (super.anInt9306 < local29) {
            arg4 = ((super.anInt9306 << 16) + local41 - local11 - 1) / local41;
        }
        local55 = arg0 + arg1 * super.toolkit.surfaceWidth;
        @Pc(147) int local147 = super.toolkit.surfaceWidth - arg3;
        if (arg1 + arg4 > super.toolkit.clipY2) {
            arg4 -= arg1 + arg4 - super.toolkit.clipY2;
        }
        @Pc(175) int local175;
        if (arg1 < super.toolkit.clipY1) {
            local175 = super.toolkit.clipY1 - arg1;
            arg4 -= local175;
            local55 += local175 * super.toolkit.surfaceWidth;
            local11 += local41 * local175;
        }
        if (arg0 + arg3 > super.toolkit.clipX2) {
            local175 = arg0 + arg3 - super.toolkit.clipX2;
            arg3 -= local175;
            local147 += local175;
        }
        if (arg0 < super.toolkit.clipX1) {
            local175 = super.toolkit.clipX1 - arg0;
            arg3 -= local175;
            local55 += local175;
            local9 += local35 * local175;
            local147 += local175;
        }
        @Pc(249) float[] local249 = super.toolkit.depthBuffer;
        @Pc(253) int[] local253 = super.toolkit.surfaceRaster;
        @Pc(262) int local262;
        @Pc(265) int local265;
        @Pc(273) int local273;
        @Pc(276) int local276;
        @Pc(353) int local353;
        @Pc(361) int local361;
        @Pc(364) int local364;
        @Pc(386) int local386;
        @Pc(402) int local402;
        @Pc(410) int local410;
        @Pc(589) int local589;
        @Pc(484) byte local484;
        @Pc(394) int local394;
        if (arg7 != 0) {
            @Pc(1318) byte local1318;
            @Pc(963) int local963;
            @Pc(971) int local971;
            @Pc(979) int local979;
            @Pc(991) int local991;
            if (arg7 == 1) {
                if (arg5 == 1) {
                    local262 = local9;
                    for (local265 = -arg4; local265 < 0; local265++) {
                        local273 = (local11 >> 16) * super.anInt9302;
                        for (local276 = -arg3; local276 < 0; local276++) {
                            if ((float) arg2 < local249[local55]) {
                                local484 = this.aByteArray100[(local9 >> 16) + local273];
                                if (local484 != 0) {
                                    local253[local55] = this.anIntArray714[local484 & 0xFF];
                                    local249[local55] = (float) arg2;
                                }
                            }
                            local9 += local35;
                            local55++;
                        }
                        local11 += local41;
                        local9 = local262;
                        local55 += local147;
                    }
                } else {
                    @Pc(815) byte local815;
                    if (arg5 == 0) {
                        local262 = local9;
                        if ((arg6 & 0xFFFFFF) == 16777215) {
                            local265 = arg6 >>> 24;
                            local273 = 256 - local265;
                            for (local276 = -arg4; local276 < 0; local276++) {
                                local353 = (local11 >> 16) * super.anInt9302;
                                for (local361 = -arg3; local361 < 0; local361++) {
                                    if ((float) arg2 < local249[local55]) {
                                        local815 = this.aByteArray100[(local9 >> 16) + local353];
                                        if (local815 != 0) {
                                            local386 = this.anIntArray714[local815 & 0xFF];
                                            local394 = local253[local55];
                                            local253[local55] = ((local386 & 0xFF00FF) * local265 + (local394 & 0xFF00FF) * local273 & 0xFF00FF00) + ((local386 & 0xFF00) * local265 + (local394 & 0xFF00) * local273 & 0xFF0000) >> 8;
                                            local249[local55] = (float) arg2;
                                        }
                                    }
                                    local9 += local35;
                                    local55++;
                                }
                                local11 += local41;
                                local9 = local262;
                                local55 += local147;
                            }
                        } else {
                            local265 = arg6 >> 16 & 0xFF;
                            local273 = arg6 >> 8 & 0xFF;
                            local276 = arg6 & 0xFF;
                            local353 = arg6 >>> 24;
                            local361 = 256 - local353;
                            for (local364 = -arg4; local364 < 0; local364++) {
                                local386 = (local11 >> 16) * super.anInt9302;
                                for (local394 = -arg3; local394 < 0; local394++) {
                                    if ((float) arg2 < local249[local55]) {
                                        @Pc(943) byte local943 = this.aByteArray100[(local9 >> 16) + local386];
                                        if (local943 != 0) {
                                            local410 = this.anIntArray714[local943 & 0xFF];
                                            if (local353 == 255) {
                                                local963 = (local410 & 0xFF0000) * local265 & 0xFF000000;
                                                local971 = (local410 & 0xFF00) * local273 & 0xFF0000;
                                                local979 = (local410 & 0xFF) * local276 & 0xFF00;
                                                local253[local55] = (local963 | local971 | local979) >>> 8;
                                                local249[local55] = (float) arg2;
                                            } else {
                                                local963 = (local410 & 0xFF0000) * local265 & 0xFF000000;
                                                local971 = (local410 & 0xFF00) * local273 & 0xFF0000;
                                                local979 = (local410 & 0xFF) * local276 & 0xFF00;
                                                local410 = (local963 | local971 | local979) >>> 8;
                                                local991 = local253[local55];
                                                local253[local55] = ((local410 & 0xFF00FF) * local353 + (local991 & 0xFF00FF) * local361 & 0xFF00FF00) + ((local410 & 0xFF00) * local353 + (local991 & 0xFF00) * local361 & 0xFF0000) >> 8;
                                                local249[local55] = (float) arg2;
                                            }
                                        }
                                    }
                                    local9 += local35;
                                    local55++;
                                }
                                local11 += local41;
                                local9 = local262;
                                local55 += local147;
                            }
                        }
                    } else if (arg5 == 3) {
                        local262 = local9;
                        local265 = arg6 >>> 24;
                        local273 = 256 - local265;
                        for (local276 = -arg4; local276 < 0; local276++) {
                            local353 = (local11 >> 16) * super.anInt9302;
                            for (local361 = -arg3; local361 < 0; local361++) {
                                if ((float) arg2 < local249[local55]) {
                                    local815 = this.aByteArray100[(local9 >> 16) + local353];
                                    local386 = local815 > 0 ? this.anIntArray714[local815] : 0;
                                    local394 = local386 + arg6;
                                    local402 = (local386 & 0xFF00FF) + (arg6 & 0xFF00FF);
                                    local410 = (local402 & 0x1000100) + (local394 - local402 & 0x10000);
                                    local410 = local394 - local410 | local410 - (local410 >>> 8);
                                    if (local386 == 0 && local265 != 255) {
                                        local386 = local410;
                                        local410 = local253[local55];
                                        local410 = ((local386 & 0xFF00FF) * local265 + (local410 & 0xFF00FF) * local273 & 0xFF00FF00) + ((local386 & 0xFF00) * local265 + (local410 & 0xFF00) * local273 & 0xFF0000) >> 8;
                                    }
                                    local253[local55] = local410;
                                    local249[local55] = (float) arg2;
                                }
                                local9 += local35;
                                local55++;
                            }
                            local11 += local41;
                            local9 = local262;
                            local55 += local147;
                        }
                    } else if (arg5 == 2) {
                        local262 = arg6 >>> 24;
                        local265 = 256 - local262;
                        local273 = (arg6 & 0xFF00FF) * local265 & 0xFF00FF00;
                        local276 = (arg6 & 0xFF00) * local265 & 0xFF0000;
                        local589 = (local273 | local276) >>> 8;
                        local353 = local9;
                        for (local361 = -arg4; local361 < 0; local361++) {
                            local364 = (local11 >> 16) * super.anInt9302;
                            for (local386 = -arg3; local386 < 0; local386++) {
                                if ((float) arg2 < local249[local55]) {
                                    local1318 = this.aByteArray100[(local9 >> 16) + local364];
                                    if (local1318 != 0) {
                                        local402 = this.anIntArray714[local1318 & 0xFF];
                                        local273 = (local402 & 0xFF00FF) * local262 & 0xFF00FF00;
                                        local276 = (local402 & 0xFF00) * local262 & 0xFF0000;
                                        local253[local55] = ((local273 | local276) >>> 8) + local589;
                                        local249[local55] = (float) arg2;
                                    }
                                }
                                local9 += local35;
                                local55++;
                            }
                            local11 += local41;
                            local9 = local353;
                            local55 += local147;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            } else if (arg7 != 2) {
                throw new IllegalArgumentException();
            } else if (arg5 == 1) {
                local262 = local9;
                for (local265 = -arg4; local265 < 0; local265++) {
                    local273 = (local11 >> 16) * super.anInt9302;
                    for (local276 = -arg3; local276 < 0; local276++) {
                        if ((float) arg2 < local249[local55]) {
                            local484 = this.aByteArray100[(local9 >> 16) + local273];
                            if (local484 != 0) {
                                local361 = this.anIntArray714[local484 & 0xFF];
                                local364 = local253[local55];
                                local386 = local361 + local364;
                                local394 = (local361 & 0xFF00FF) + (local364 & 0xFF00FF);
                                local364 = (local394 & 0x1000100) + (local386 - local394 & 0x10000);
                                local253[local55] = local386 - local364 | local364 - (local364 >>> 8);
                                local249[local55] = (float) arg2;
                            }
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local262;
                    local55 += local147;
                }
            } else if (arg5 == 0) {
                local262 = local9;
                local265 = arg6 >> 16 & 0xFF;
                local273 = arg6 >> 8 & 0xFF;
                local276 = arg6 & 0xFF;
                for (local353 = -arg4; local353 < 0; local353++) {
                    local361 = (local11 >> 16) * super.anInt9302;
                    for (local364 = -arg3; local364 < 0; local364++) {
                        if ((float) arg2 < local249[local55]) {
                            @Pc(1552) byte local1552 = this.aByteArray100[(local9 >> 16) + local361];
                            if (local1552 != 0) {
                                local394 = this.anIntArray714[local1552 & 0xFF];
                                local402 = (local394 & 0xFF0000) * local265 & 0xFF000000;
                                local410 = (local394 & 0xFF00) * local273 & 0xFF0000;
                                local963 = (local394 & 0xFF) * local276 & 0xFF00;
                                local394 = (local402 | local410 | local963) >>> 8;
                                local971 = local253[local55];
                                local979 = local394 + local971;
                                local991 = (local394 & 0xFF00FF) + (local971 & 0xFF00FF);
                                local971 = (local991 & 0x1000100) + (local979 - local991 & 0x10000);
                                local253[local55] = local979 - local971 | local971 - (local971 >>> 8);
                                local249[local55] = (float) arg2;
                            }
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local262;
                    local55 += local147;
                }
            } else if (arg5 == 3) {
                local262 = local9;
                for (local265 = -arg4; local265 < 0; local265++) {
                    local273 = (local11 >> 16) * super.anInt9302;
                    for (local276 = -arg3; local276 < 0; local276++) {
                        if ((float) arg2 < local249[local55]) {
                            local484 = this.aByteArray100[(local9 >> 16) + local273];
                            local361 = local484 > 0 ? this.anIntArray714[local484] : 0;
                            local364 = local361 + arg6;
                            local386 = (local361 & 0xFF00FF) + (arg6 & 0xFF00FF);
                            local394 = (local386 & 0x1000100) + (local364 - local386 & 0x10000);
                            local361 = local364 - local394 | local394 - (local394 >>> 8);
                            @Pc(1741) int local1741 = local253[local55];
                            local364 = local361 + local1741;
                            local386 = (local361 & 0xFF00FF) + (local1741 & 0xFF00FF);
                            @Pc(1763) int local1763 = (local386 & 0x1000100) + (local364 - local386 & 0x10000);
                            local253[local55] = local364 - local1763 | local1763 - (local1763 >>> 8);
                            local249[local55] = (float) arg2;
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local262;
                    local55 += local147;
                }
            } else if (arg5 == 2) {
                local262 = arg6 >>> 24;
                local265 = 256 - local262;
                local273 = (arg6 & 0xFF00FF) * local265 & 0xFF00FF00;
                local276 = (arg6 & 0xFF00) * local265 & 0xFF0000;
                local589 = (local273 | local276) >>> 8;
                local353 = local9;
                for (local361 = -arg4; local361 < 0; local361++) {
                    local364 = (local11 >> 16) * super.anInt9302;
                    for (local386 = -arg3; local386 < 0; local386++) {
                        if ((float) arg2 < local249[local55]) {
                            local1318 = this.aByteArray100[(local9 >> 16) + local364];
                            if (local1318 != 0) {
                                local402 = this.anIntArray714[local1318 & 0xFF];
                                local273 = (local402 & 0xFF00FF) * local262 & 0xFF00FF00;
                                local276 = (local402 & 0xFF00) * local262 & 0xFF0000;
                                @Pc(1902) int local1902 = ((local273 | local276) >>> 8) + local589;
                                local410 = local253[local55];
                                local963 = local1902 + local410;
                                local971 = (local1902 & 0xFF00FF) + (local410 & 0xFF00FF);
                                @Pc(1928) int local1928 = (local971 & 0x1000100) + (local963 - local971 & 0x10000);
                                local253[local55] = local963 - local1928 | local1928 - (local1928 >>> 8);
                                local249[local55] = (float) arg2;
                            }
                        }
                        local9 += local35;
                        local55++;
                    }
                    local11 += local41;
                    local9 = local353;
                    local55 += local147;
                }
            } else {
                throw new IllegalArgumentException();
            }
        } else if (arg5 == 1) {
            local262 = local9;
            for (local265 = -arg4; local265 < 0; local265++) {
                local273 = (local11 >> 16) * super.anInt9302;
                for (local276 = -arg3; local276 < 0; local276++) {
                    if ((float) arg2 < local249[local55]) {
                        local253[local55] = this.anIntArray714[this.aByteArray100[(local9 >> 16) + local273] & 0xFF];
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local262;
                local55 += local147;
            }
        } else if (arg5 == 0) {
            local262 = arg6 >> 16 & 0xFF;
            local265 = arg6 >> 8 & 0xFF;
            local273 = arg6 & 0xFF;
            local276 = local9;
            for (local353 = -arg4; local353 < 0; local353++) {
                local361 = (local11 >> 16) * super.anInt9302;
                for (local364 = -arg3; local364 < 0; local364++) {
                    if ((float) arg2 < local249[local55]) {
                        local386 = this.anIntArray714[this.aByteArray100[(local9 >> 16) + local361] & 0xFF];
                        local394 = (local386 & 0xFF0000) * local262 & 0xFF000000;
                        local402 = (local386 & 0xFF00) * local265 & 0xFF0000;
                        local410 = (local386 & 0xFF) * local273 & 0xFF00;
                        local253[local55] = (local394 | local402 | local410) >>> 8;
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local276;
                local55 += local147;
            }
        } else if (arg5 == 3) {
            local262 = local9;
            for (local265 = -arg4; local265 < 0; local265++) {
                local273 = (local11 >> 16) * super.anInt9302;
                for (local276 = -arg3; local276 < 0; local276++) {
                    if ((float) arg2 < local249[local55]) {
                        local484 = this.aByteArray100[(local9 >> 16) + local273];
                        local361 = local484 > 0 ? this.anIntArray714[local484] : 0;
                        local364 = local361 + arg6;
                        local386 = (local361 & 0xFF00FF) + (arg6 & 0xFF00FF);
                        local394 = (local386 & 0x1000100) + (local364 - local386 & 0x10000);
                        local253[local55] = local364 - local394 | local394 - (local394 >>> 8);
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local262;
                local55 += local147;
            }
        } else if (arg5 == 2) {
            local262 = arg6 >>> 24;
            local265 = 256 - local262;
            local273 = (arg6 & 0xFF00FF) * local265 & 0xFF00FF00;
            local276 = (arg6 & 0xFF00) * local265 & 0xFF0000;
            local589 = (local273 | local276) >>> 8;
            local353 = local9;
            for (local361 = -arg4; local361 < 0; local361++) {
                local364 = (local11 >> 16) * super.anInt9302;
                for (local386 = -arg3; local386 < 0; local386++) {
                    if ((float) arg2 < local249[local55]) {
                        local394 = this.anIntArray714[this.aByteArray100[(local9 >> 16) + local364] & 0xFF];
                        local273 = (local394 & 0xFF00FF) * local262 & 0xFF00FF00;
                        local276 = (local394 & 0xFF00) * local262 & 0xFF0000;
                        local253[local55] = ((local273 | local276) >>> 8) + local589;
                        local249[local55] = (float) arg2;
                    }
                    local9 += local35;
                    local55++;
                }
                local11 += local41;
                local9 = local353;
                local55 += local147;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!te", name = "a", descriptor = "(IILclient!aa;II)V")
    @Override
    public void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) ClippingMask mask, @OriginalArg(3) int maskX, @OriginalArg(4) int maskY) {
        if (super.toolkit.stopped()) {
            throw new IllegalStateException();
        }
        x += super.anInt9298;
        y += super.anInt9308;
        @Pc(20) int local20 = 0;
        @Pc(24) int local24 = super.toolkit.surfaceWidth;
        @Pc(27) int local27 = super.anInt9302;
        @Pc(30) int local30 = super.anInt9306;
        @Pc(34) int local34 = local24 - local27;
        @Pc(36) int local36 = 0;
        @Pc(42) int local42 = x + y * local24;
        @Pc(53) int local53;
        if (y < super.toolkit.clipY1) {
            local53 = super.toolkit.clipY1 - y;
            local30 -= local53;
            y = super.toolkit.clipY1;
            local20 = local53 * local27;
            local42 += local53 * local24;
        }
        if (y + local30 > super.toolkit.clipY2) {
            local30 -= y + local30 - super.toolkit.clipY2;
        }
        if (x < super.toolkit.clipX1) {
            local53 = super.toolkit.clipX1 - x;
            local27 -= local53;
            x = super.toolkit.clipX1;
            local20 += local53;
            local42 += local53;
            local36 = local53;
            local34 += local53;
        }
        if (x + local27 > super.toolkit.clipX2) {
            local53 = x + local27 - super.toolkit.clipX2;
            local27 -= local53;
            local36 += local53;
            local34 += local53;
        }
        if (local27 <= 0 || local30 <= 0) {
            return;
        }
        @Pc(163) JavaClippingMask local163 = (JavaClippingMask) mask;
        @Pc(166) int[] local166 = local163.lineOffsets;
        @Pc(169) int[] local169 = local163.lineWidths;
        @Pc(173) int[] local173 = super.toolkit.surfaceRaster;
        @Pc(175) int local175 = y;
        if (maskY > y) {
            local175 = maskY;
            local42 += (maskY - y) * local24;
            local20 += (maskY - y) * super.anInt9302;
        }
        @Pc(215) int local215 = maskY + local166.length < y + local30 ? maskY + local166.length : y + local30;
        for (@Pc(217) int local217 = local175; local217 < local215; local217++) {
            @Pc(226) int local226 = local166[local217 - maskY] + maskX;
            @Pc(232) int local232 = local169[local217 - maskY];
            @Pc(234) int local234 = local27;
            @Pc(241) int local241;
            if (x > local226) {
                local241 = x - local226;
                if (local241 >= local232) {
                    local20 += local27 + local36;
                    local42 += local27 + local34;
                    continue;
                }
                local232 -= local241;
            } else {
                local241 = local226 - x;
                if (local241 >= local27) {
                    local20 += local27 + local36;
                    local42 += local27 + local34;
                    continue;
                }
                local20 += local241;
                local234 = local27 - local241;
                local42 += local241;
            }
            local241 = 0;
            if (local234 < local232) {
                local232 = local234;
            } else {
                local241 = local234 - local232;
            }
            for (@Pc(309) int local309 = -local232; local309 < 0; local309++) {
                @Pc(316) byte local316 = this.aByteArray100[local20++];
                if (local316 == 0) {
                    local42++;
                } else {
                    local173[local42++] = this.anIntArray714[local316 & 0xFF];
                }
            }
            local20 += local241 + local36;
            local42 += local241 + local34;
        }
    }

    @OriginalMember(owner = "client!te", name = "a", descriptor = "(IIIIIIII)V")
    @Override
    protected void renderImpl(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode) {
        if (super.toolkit.stopped()) {
            throw new IllegalStateException();
        } else if (width > 0 && height > 0) {
            @Pc(18) int local18 = 0;
            @Pc(20) int local20 = 0;
            @Pc(24) int local24 = super.toolkit.surfaceWidth;
            @Pc(33) int local33 = super.anInt9298 + super.anInt9302 + super.anInt9295;
            @Pc(42) int local42 = super.anInt9308 + super.anInt9306 + super.anInt9294;
            @Pc(48) int local48 = (local33 << 16) / width;
            @Pc(54) int local54 = (local42 << 16) / height;
            @Pc(68) int local68;
            if (super.anInt9298 > 0) {
                local68 = ((super.anInt9298 << 16) + local48 - 1) / local48;
                x += local68;
                local18 = local68 * local48 - (super.anInt9298 << 16);
            }
            if (super.anInt9308 > 0) {
                local68 = ((super.anInt9308 << 16) + local54 - 1) / local54;
                y += local68;
                local20 = local68 * local54 - (super.anInt9308 << 16);
            }
            if (super.anInt9302 < local33) {
                width = ((super.anInt9302 << 16) + local48 - local18 - 1) / local48;
            }
            if (super.anInt9306 < local42) {
                height = ((super.anInt9306 << 16) + local54 - local20 - 1) / local54;
            }
            local68 = x + y * local24;
            @Pc(156) int local156 = local24 - width;
            if (y + height > super.toolkit.clipY2) {
                height -= y + height - super.toolkit.clipY2;
            }
            @Pc(184) int local184;
            if (y < super.toolkit.clipY1) {
                local184 = super.toolkit.clipY1 - y;
                height -= local184;
                local68 += local184 * local24;
                local20 += local54 * local184;
            }
            if (x + width > super.toolkit.clipX2) {
                local184 = x + width - super.toolkit.clipX2;
                width -= local184;
                local156 += local184;
            }
            if (x < super.toolkit.clipX1) {
                local184 = super.toolkit.clipX1 - x;
                width -= local184;
                local68 += local184;
                local18 += local48 * local184;
                local156 += local184;
            }
            @Pc(256) int[] local256 = super.toolkit.surfaceRaster;
            @Pc(265) int local265;
            @Pc(268) int local268;
            @Pc(276) int local276;
            @Pc(279) int local279;
            @Pc(342) int local342;
            @Pc(350) int local350;
            @Pc(353) int local353;
            @Pc(368) int local368;
            @Pc(384) int local384;
            @Pc(392) int local392;
            @Pc(554) int local554;
            @Pc(454) byte local454;
            @Pc(376) int local376;
            if (mode != 0) {
                @Pc(1217) byte local1217;
                @Pc(888) int local888;
                @Pc(896) int local896;
                @Pc(904) int local904;
                @Pc(916) int local916;
                if (mode == 1) {
                    if (op == 1) {
                        local265 = local18;
                        for (local268 = -height; local268 < 0; local268++) {
                            local276 = (local20 >> 16) * super.anInt9302;
                            for (local279 = -width; local279 < 0; local279++) {
                                local454 = this.aByteArray100[(local18 >> 16) + local276];
                                if (local454 == 0) {
                                    local68++;
                                } else {
                                    local256[local68++] = this.anIntArray714[local454 & 0xFF];
                                }
                                local18 += local48;
                            }
                            local20 += local54;
                            local18 = local265;
                            local68 += local156;
                        }
                    } else {
                        @Pc(750) byte local750;
                        if (op == 0) {
                            local265 = local18;
                            if ((colour & 0xFFFFFF) == 16777215) {
                                local268 = colour >>> 24;
                                local276 = 256 - local268;
                                for (local279 = -height; local279 < 0; local279++) {
                                    local342 = (local20 >> 16) * super.anInt9302;
                                    for (local350 = -width; local350 < 0; local350++) {
                                        local750 = this.aByteArray100[(local18 >> 16) + local342];
                                        if (local750 == 0) {
                                            local68++;
                                        } else {
                                            local368 = this.anIntArray714[local750 & 0xFF];
                                            local376 = local256[local68];
                                            local256[local68++] = ((local368 & 0xFF00FF) * local268 + (local376 & 0xFF00FF) * local276 & 0xFF00FF00) + ((local368 & 0xFF00) * local268 + (local376 & 0xFF00) * local276 & 0xFF0000) >> 8;
                                        }
                                        local18 += local48;
                                    }
                                    local20 += local54;
                                    local18 = local265;
                                    local68 += local156;
                                }
                            } else {
                                local268 = colour >> 16 & 0xFF;
                                local276 = colour >> 8 & 0xFF;
                                local279 = colour & 0xFF;
                                local342 = colour >>> 24;
                                local350 = 256 - local342;
                                for (local353 = -height; local353 < 0; local353++) {
                                    local368 = (local20 >> 16) * super.anInt9302;
                                    for (local376 = -width; local376 < 0; local376++) {
                                        @Pc(868) byte local868 = this.aByteArray100[(local18 >> 16) + local368];
                                        if (local868 == 0) {
                                            local68++;
                                        } else {
                                            local392 = this.anIntArray714[local868 & 0xFF];
                                            if (local342 == 255) {
                                                local888 = (local392 & 0xFF0000) * local268 & 0xFF000000;
                                                local896 = (local392 & 0xFF00) * local276 & 0xFF0000;
                                                local904 = (local392 & 0xFF) * local279 & 0xFF00;
                                                local256[local68++] = (local888 | local896 | local904) >>> 8;
                                            } else {
                                                local888 = (local392 & 0xFF0000) * local268 & 0xFF000000;
                                                local896 = (local392 & 0xFF00) * local276 & 0xFF0000;
                                                local904 = (local392 & 0xFF) * local279 & 0xFF00;
                                                local392 = (local888 | local896 | local904) >>> 8;
                                                local916 = local256[local68];
                                                local256[local68++] = ((local392 & 0xFF00FF) * local342 + (local916 & 0xFF00FF) * local350 & 0xFF00FF00) + ((local392 & 0xFF00) * local342 + (local916 & 0xFF00) * local350 & 0xFF0000) >> 8;
                                            }
                                        }
                                        local18 += local48;
                                    }
                                    local20 += local54;
                                    local18 = local265;
                                    local68 += local156;
                                }
                            }
                        } else if (op == 3) {
                            local265 = local18;
                            local268 = colour >>> 24;
                            local276 = 256 - local268;
                            for (local279 = -height; local279 < 0; local279++) {
                                local342 = (local20 >> 16) * super.anInt9302;
                                for (local350 = -width; local350 < 0; local350++) {
                                    local750 = this.aByteArray100[(local18 >> 16) + local342];
                                    local368 = local750 > 0 ? this.anIntArray714[local750] : 0;
                                    local376 = local368 + colour;
                                    local384 = (local368 & 0xFF00FF) + (colour & 0xFF00FF);
                                    local392 = (local384 & 0x1000100) + (local376 - local384 & 0x10000);
                                    local392 = local376 - local392 | local392 - (local392 >>> 8);
                                    if (local368 == 0 && local268 != 255) {
                                        local368 = local392;
                                        local392 = local256[local68];
                                        local392 = ((local368 & 0xFF00FF) * local268 + (local392 & 0xFF00FF) * local276 & 0xFF00FF00) + ((local368 & 0xFF00) * local268 + (local392 & 0xFF00) * local276 & 0xFF0000) >> 8;
                                    }
                                    local256[local68++] = local392;
                                    local18 += local48;
                                }
                                local20 += local54;
                                local18 = local265;
                                local68 += local156;
                            }
                        } else if (op == 2) {
                            local265 = colour >>> 24;
                            local268 = 256 - local265;
                            local276 = (colour & 0xFF00FF) * local268 & 0xFF00FF00;
                            local279 = (colour & 0xFF00) * local268 & 0xFF0000;
                            local554 = (local276 | local279) >>> 8;
                            local342 = local18;
                            for (local350 = -height; local350 < 0; local350++) {
                                local353 = (local20 >> 16) * super.anInt9302;
                                for (local368 = -width; local368 < 0; local368++) {
                                    local1217 = this.aByteArray100[(local18 >> 16) + local353];
                                    if (local1217 == 0) {
                                        local68++;
                                    } else {
                                        local384 = this.anIntArray714[local1217 & 0xFF];
                                        local276 = (local384 & 0xFF00FF) * local265 & 0xFF00FF00;
                                        local279 = (local384 & 0xFF00) * local265 & 0xFF0000;
                                        local256[local68++] = ((local276 | local279) >>> 8) + local554;
                                    }
                                    local18 += local48;
                                }
                                local20 += local54;
                                local18 = local342;
                                local68 += local156;
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                } else if (mode != 2) {
                    throw new IllegalArgumentException();
                } else if (op == 1) {
                    local265 = local18;
                    for (local268 = -height; local268 < 0; local268++) {
                        local276 = (local20 >> 16) * super.anInt9302;
                        for (local279 = -width; local279 < 0; local279++) {
                            local454 = this.aByteArray100[(local18 >> 16) + local276];
                            if (local454 == 0) {
                                local68++;
                            } else {
                                local350 = this.anIntArray714[local454 & 0xFF];
                                local353 = local256[local68];
                                local368 = local350 + local353;
                                local376 = (local350 & 0xFF00FF) + (local353 & 0xFF00FF);
                                local353 = (local376 & 0x1000100) + (local368 - local376 & 0x10000);
                                local256[local68++] = local368 - local353 | local353 - (local353 >>> 8);
                            }
                            local18 += local48;
                        }
                        local20 += local54;
                        local18 = local265;
                        local68 += local156;
                    }
                } else if (op == 0) {
                    local265 = local18;
                    local268 = colour >> 16 & 0xFF;
                    local276 = colour >> 8 & 0xFF;
                    local279 = colour & 0xFF;
                    for (local342 = -height; local342 < 0; local342++) {
                        local350 = (local20 >> 16) * super.anInt9302;
                        for (local353 = -width; local353 < 0; local353++) {
                            @Pc(1431) byte local1431 = this.aByteArray100[(local18 >> 16) + local350];
                            if (local1431 == 0) {
                                local68++;
                            } else {
                                local376 = this.anIntArray714[local1431 & 0xFF];
                                local384 = (local376 & 0xFF0000) * local268 & 0xFF000000;
                                local392 = (local376 & 0xFF00) * local276 & 0xFF0000;
                                local888 = (local376 & 0xFF) * local279 & 0xFF00;
                                local376 = (local384 | local392 | local888) >>> 8;
                                local896 = local256[local68];
                                local904 = local376 + local896;
                                local916 = (local376 & 0xFF00FF) + (local896 & 0xFF00FF);
                                local896 = (local916 & 0x1000100) + (local904 - local916 & 0x10000);
                                local256[local68++] = local904 - local896 | local896 - (local896 >>> 8);
                            }
                            local18 += local48;
                        }
                        local20 += local54;
                        local18 = local265;
                        local68 += local156;
                    }
                } else if (op == 3) {
                    local265 = local18;
                    for (local268 = -height; local268 < 0; local268++) {
                        local276 = (local20 >> 16) * super.anInt9302;
                        for (local279 = -width; local279 < 0; local279++) {
                            local454 = this.aByteArray100[(local18 >> 16) + local276];
                            local350 = local454 > 0 ? this.anIntArray714[local454] : 0;
                            local353 = local350 + colour;
                            local368 = (local350 & 0xFF00FF) + (colour & 0xFF00FF);
                            local376 = (local368 & 0x1000100) + (local353 - local368 & 0x10000);
                            local350 = local353 - local376 | local376 - (local376 >>> 8);
                            @Pc(1610) int local1610 = local256[local68];
                            local353 = local350 + local1610;
                            local368 = (local350 & 0xFF00FF) + (local1610 & 0xFF00FF);
                            @Pc(1632) int local1632 = (local368 & 0x1000100) + (local353 - local368 & 0x10000);
                            local256[local68++] = local353 - local1632 | local1632 - (local1632 >>> 8);
                            local18 += local48;
                        }
                        local20 += local54;
                        local18 = local265;
                        local68 += local156;
                    }
                } else if (op == 2) {
                    local265 = colour >>> 24;
                    local268 = 256 - local265;
                    local276 = (colour & 0xFF00FF) * local268 & 0xFF00FF00;
                    local279 = (colour & 0xFF00) * local268 & 0xFF0000;
                    local554 = (local276 | local279) >>> 8;
                    local342 = local18;
                    for (local350 = -height; local350 < 0; local350++) {
                        local353 = (local20 >> 16) * super.anInt9302;
                        for (local368 = -width; local368 < 0; local368++) {
                            local1217 = this.aByteArray100[(local18 >> 16) + local353];
                            if (local1217 == 0) {
                                local68++;
                            } else {
                                local384 = this.anIntArray714[local1217 & 0xFF];
                                local276 = (local384 & 0xFF00FF) * local265 & 0xFF00FF00;
                                local279 = (local384 & 0xFF00) * local265 & 0xFF0000;
                                @Pc(1759) int local1759 = ((local276 | local279) >>> 8) + local554;
                                local392 = local256[local68];
                                local888 = local1759 + local392;
                                local896 = (local1759 & 0xFF00FF) + (local392 & 0xFF00FF);
                                @Pc(1785) int local1785 = (local896 & 0x1000100) + (local888 - local896 & 0x10000);
                                local256[local68++] = local888 - local1785 | local1785 - (local1785 >>> 8);
                            }
                            local18 += local48;
                        }
                        local20 += local54;
                        local18 = local342;
                        local68 += local156;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } else if (op == 1) {
                local265 = local18;
                for (local268 = -height; local268 < 0; local268++) {
                    local276 = (local20 >> 16) * super.anInt9302;
                    for (local279 = -width; local279 < 0; local279++) {
                        local256[local68++] = this.anIntArray714[this.aByteArray100[(local18 >> 16) + local276] & 0xFF];
                        local18 += local48;
                    }
                    local20 += local54;
                    local18 = local265;
                    local68 += local156;
                }
            } else if (op == 0) {
                local265 = colour >> 16 & 0xFF;
                local268 = colour >> 8 & 0xFF;
                local276 = colour & 0xFF;
                local279 = local18;
                for (local342 = -height; local342 < 0; local342++) {
                    local350 = (local20 >> 16) * super.anInt9302;
                    for (local353 = -width; local353 < 0; local353++) {
                        local368 = this.anIntArray714[this.aByteArray100[(local18 >> 16) + local350] & 0xFF];
                        local376 = (local368 & 0xFF0000) * local265 & 0xFF000000;
                        local384 = (local368 & 0xFF00) * local268 & 0xFF0000;
                        local392 = (local368 & 0xFF) * local276 & 0xFF00;
                        local256[local68++] = (local376 | local384 | local392) >>> 8;
                        local18 += local48;
                    }
                    local20 += local54;
                    local18 = local279;
                    local68 += local156;
                }
            } else if (op == 3) {
                local265 = local18;
                for (local268 = -height; local268 < 0; local268++) {
                    local276 = (local20 >> 16) * super.anInt9302;
                    for (local279 = -width; local279 < 0; local279++) {
                        local454 = this.aByteArray100[(local18 >> 16) + local276];
                        local350 = local454 > 0 ? this.anIntArray714[local454] : 0;
                        local353 = local350 + colour;
                        local368 = (local350 & 0xFF00FF) + (colour & 0xFF00FF);
                        local376 = (local368 & 0x1000100) + (local353 - local368 & 0x10000);
                        local256[local68++] = local353 - local376 | local376 - (local376 >>> 8);
                        local18 += local48;
                    }
                    local20 += local54;
                    local18 = local265;
                    local68 += local156;
                }
            } else if (op == 2) {
                local265 = colour >>> 24;
                local268 = 256 - local265;
                local276 = (colour & 0xFF00FF) * local268 & 0xFF00FF00;
                local279 = (colour & 0xFF00) * local268 & 0xFF0000;
                local554 = (local276 | local279) >>> 8;
                local342 = local18;
                for (local350 = -height; local350 < 0; local350++) {
                    local353 = (local20 >> 16) * super.anInt9302;
                    for (local368 = -width; local368 < 0; local368++) {
                        local376 = this.anIntArray714[this.aByteArray100[(local18 >> 16) + local353] & 0xFF];
                        local276 = (local376 & 0xFF00FF) * local265 & 0xFF00FF00;
                        local279 = (local376 & 0xFF00) * local265 & 0xFF0000;
                        local256[local68++] = ((local276 | local279) >>> 8) + local554;
                        local18 += local48;
                    }
                    local20 += local54;
                    local18 = local342;
                    local68 += local156;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
