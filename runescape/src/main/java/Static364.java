import com.jagex.Constants;
import com.jagex.SignLink;
import com.jagex.core.io.Packet;
import com.jagex.core.util.JavaScript;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public final class Static364 {

    @OriginalMember(owner = "client!lia", name = "r", descriptor = "Lclient!rt;")
    public static Class327 aClass327_4;

    @OriginalMember(owner = "client!lia", name = "p", descriptor = "D")
    public static double aDouble17;

    @OriginalMember(owner = "client!lia", name = "b", descriptor = "[Z")
    public static final boolean[] aBooleanArray18 = new boolean[100];

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(Z)Lclient!fu;")
    public static Node_Sub20 method5248() {
        if (Static30.A_DEQUE___31 == null || Static444.aClass191_1 == null) {
            return null;
        }
        for (@Pc(17) Node_Sub20 local17 = (Node_Sub20) Static444.aClass191_1.next(); local17 != null; local17 = (Node_Sub20) Static444.aClass191_1.next()) {
            @Pc(30) Class105 local30 = Static30.aClass246_3.method5584(local17.anInt3131);
            if (local30 != null && local30.aBoolean217 && local30.method2425(Static30.anVarDomain_3)) {
                return local17;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(IFFILclient!tk;[BFIBFIIIF)V")
    public static void method5251(@OriginalArg(1) float arg0, @OriginalArg(2) float arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Class59 arg3, @OriginalArg(5) byte[] arg4, @OriginalArg(6) float arg5, @OriginalArg(9) float arg6, @OriginalArg(12) int arg7, @OriginalArg(13) float arg8) {
        @Pc(17) float[] local17 = new float[16384];
        @Pc(22) int local22;
        @Pc(48) int local48;
        for (@Pc(19) int local19 = 0; local19 < 8; local19++) {
            local22 = arg7;
            arg3.method1509(arg0 / (float) 128, arg8 * 127.0F, local17, 0, arg6 / (float) 16, arg2, arg1 / (float) 128);
            for (local48 = 0; local48 < 16384; local48++) {
                arg4[local22] = (byte) (int) ((float) arg4[local22] + local17[local48]);
                local22++;
            }
            arg1 *= 2.0F;
            arg0 *= 2.0F;
            arg6 *= 2.0F;
            arg8 *= arg5;
        }
        local22 = arg7;
        for (local48 = 0; local48 < 16384; local48++) {
            arg4[local22] = (byte) (arg4[local22] + 127);
            local22++;
        }
    }

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(B)V")
    public static void method5253() {
        if (Static135.anInt8223 == 0 || Static135.anInt8223 == 10) {
            return;
        }
        try {
            @Pc(25) short local25;
            if (Static76.anInt1601 == 0) {
                local25 = 250;
            } else {
                local25 = 2000;
            }
            if (Static299.anInt4825 != 2 || Static135.anInt8223 != 20 && Static169.anInt2855 != 42) {
                Static330.anInt5434++;
            }
            if (Static311.aBoolean384 && Static135.anInt8223 >= 6) {
                local25 = 6000;
            }
            if (local25 < Static330.anInt5434) {
                Static524.aClass153_3.method3274();
                if (Static76.anInt1601 >= 3) {
                    Static135.anInt8223 = 0;
                    Static342.method4464(-5);
                    return;
                }
                if (Static299.anInt4825 == 2) {
                    client.gameConnection.rotateMethods();
                } else {
                    Static660.aConnectionInfo_4.rotateMethods();
                }
                Static135.anInt8223 = 1;
                Static330.anInt5434 = 0;
                Static76.anInt1601++;
            }
            if (Static135.anInt8223 == 1) {
                if (Static299.anInt4825 == 2) {
                    Static524.aClass153_3.aSignedResource_1 = client.gameConnection.openSocket(SignLink.instance);
                } else {
                    Static524.aClass153_3.aSignedResource_1 = Static660.aConnectionInfo_4.openSocket(SignLink.instance);
                }
                Static135.anInt8223 = 2;
            }
            @Pc(186) Node_Sub19 local186;
            @Pc(203) int local203;
            @Pc(250) int local250;
            if (Static135.anInt8223 == 2) {
                if (Static524.aClass153_3.aSignedResource_1.status == 2) {
                    throw new IOException();
                }
                if (Static524.aClass153_3.aSignedResource_1.status != 1) {
                    return;
                }
                Static524.aClass153_3.aClass348_1 = Static99.method1975((Socket) Static524.aClass153_3.aSignedResource_1.result);
                Static524.aClass153_3.aSignedResource_1 = null;
                Static524.aClass153_3.method3272();
                local186 = Static273.method3962();
                if (Static311.aBoolean384) {
                    local186.aClass2_Sub21_Sub2_1.p1(LoginProt.A_LOGIN_PROT___64.opcode);
                    local186.aClass2_Sub21_Sub2_1.p2(0);
                    local203 = local186.aClass2_Sub21_Sub2_1.pos;
                    local186.aClass2_Sub21_Sub2_1.p4(667);
                    if (Static299.anInt4825 == 2) {
                        local186.aClass2_Sub21_Sub2_1.p1(Static283.step == 14 ? 1 : 0);
                    }
                    @Pc(229) Packet local229 = Static570.method7552();
                    local229.p1(Static129.anInt2409);
                    local229.p2((int) (Math.random() * 9.9999999E7D));
                    local229.p1(Static51.anInt1052);
                    local229.p4(Static323.anInt5121);
                    for (local250 = 0; local250 < 6; local250++) {
                        local229.p4((int) (Math.random() * 9.9999999E7D));
                    }
                    local229.p8(Static571.aLong269);
                    local229.p1(Static392.aModeGame_4.id);
                    local229.p1((int) (Math.random() * 9.9999999E7D));
                    local229.rsaenc(Static374.LOGIN_RSA_MODULUS, Static262.LOGIN_RSA_EXPONENT);
                    local186.aClass2_Sub21_Sub2_1.pdata(local229.pos, local229.data, 0);
                    local186.aClass2_Sub21_Sub2_1.psize2(local186.aClass2_Sub21_Sub2_1.pos - local203);
                } else {
                    local186.aClass2_Sub21_Sub2_1.p1(LoginProt.A_LOGIN_PROT___53.opcode);
                }
                Static524.aClass153_3.method3275(local186);
                Static524.aClass153_3.method3273();
                Static135.anInt8223 = 3;
            }
            @Pc(360) int local360;
            if (Static135.anInt8223 == 3) {
                if (!Static524.aClass153_3.aClass348_1.method7932(1)) {
                    return;
                }
                Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 1, 0);
                local360 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF;
                if (local360 != 0) {
                    Static135.anInt8223 = 0;
                    Static342.method4464(local360);
                    Static524.aClass153_3.method3274();
                    Static564.method7465();
                    return;
                }
                if (Static311.aBoolean384) {
                    Static135.anInt8223 = 4;
                } else {
                    Static135.anInt8223 = 8;
                }
            }
            if (Static135.anInt8223 == 4) {
                if (!Static524.aClass153_3.aClass348_1.method7932(2)) {
                    return;
                }
                Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 2, 0);
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = Static524.aClass153_3.aClass2_Sub21_Sub2_2.g2();
                Static135.anInt8223 = 5;
            }
            if (Static135.anInt8223 == 5) {
                if (!Static524.aClass153_3.aClass348_1.method7932(Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos)) {
                    return;
                }
                Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos, 0);
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.tinydec(Static219.anIntArray287);
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                @Pc(465) String local465 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.gjstr2();
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                @Pc(473) String local473 = "opensn";
                if (!Static98.aBoolean191 || Static36.method980(SignLink.instance, local465, local473, 1).status == 2) {
                    Static259.method3693(local465, local473, SignLink.instance, Static400.instance.aClass57_Sub29_1.method7915() == 1, true);
                }
                Static135.anInt8223 = 6;
            }
            if (Static135.anInt8223 == 6) {
                if (!Static524.aClass153_3.aClass348_1.method7932(1)) {
                    return;
                }
                Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 1, 0);
                if ((Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF) == 1) {
                    Static135.anInt8223 = 7;
                }
            }
            if (Static135.anInt8223 == 7) {
                if (!Static524.aClass153_3.aClass348_1.method7932(16)) {
                    return;
                }
                Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 16, 0);
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 16;
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.tinydec(Static219.anIntArray287);
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                Static449.aString75 = Static319.aString51 = Static287.method4154(Static524.aClass153_3.aClass2_Sub21_Sub2_2.g8());
                Static430.aLong209 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.g8();
                Static135.anInt8223 = 8;
            }
            @Pc(618) Node_Sub21_Sub2 local618;
            if (Static135.anInt8223 == 8) {
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                Static524.aClass153_3.method3272();
                local186 = Static273.method3962();
                local618 = local186.aClass2_Sub21_Sub2_1;
                @Pc(646) int local646;
                @Pc(672) Packet local672;
                @Pc(627) LoginProt local627;
                if (Static299.anInt4825 == 2) {
                    if (Static311.aBoolean384) {
                        local627 = LoginProt.A_LOGIN_PROT___65;
                    } else {
                        local627 = LoginProt.A_LOGIN_PROT___55;
                    }
                    local618.p1(local627.opcode);
                    local618.p2(0);
                    local250 = local618.pos;
                    local646 = local618.pos;
                    if (!Static311.aBoolean384) {
                        local618.p4(667);
                        local618.p1(Static283.step == 14 ? 1 : 0);
                        local646 = local618.pos;
                        local672 = Static659.method8608();
                        local618.pdata(local672.pos, local672.data, 0);
                        local646 = local618.pos;
                        local618.pjstr(Static449.aString75);
                    }
                    local618.p1(Static470.anInt7113);
                    local618.p1(Static36.method978(3));
                    local618.p2(Static680.anInt10289);
                    local618.p2(Static380.anInt5979);
                    local618.p1(Static400.instance.aClass57_Sub13_1.method4373());
                    Static176.method6690(local618);
                    local618.pjstr(Static150.aString26);
                    local618.p4(Static323.anInt5121);
                    local672 = Static400.instance.method5110();
                    local618.p1(local672.pos);
                    local618.pdata(local672.pos, local672.data, 0);
                    Static503.aBoolean578 = true;
                    @Pc(748) Packet local748 = new Packet(Static292.aClass2_Sub43_2.method6745());
                    Static292.aClass2_Sub43_2.method6742(local748);
                    local618.pdata(local748.data.length, local748.data, 0);
                    local618.p4(Static334.anInt5456);
                    local618.p8(Static416.aLong208);
                    local618.p1(Static389.aString64 == null ? 0 : 1);
                    if (Static389.aString64 != null) {
                        local618.pjstr(Static389.aString64);
                    }
                    local618.p1(Static183.method2796("jagtheora") ? 1 : 0);
                    local618.p1(Static98.aBoolean191 ? 1 : 0);
                    local618.p1(Static416.aBoolean473 ? 1 : 0);
                    Static169.method2647(local618);
                    local618.tinyenc(Static219.anIntArray287, local646, local618.pos);
                    local618.psize2(local618.pos - local250);
                } else {
                    if (Static311.aBoolean384) {
                        local627 = LoginProt.A_LOGIN_PROT___65;
                    } else {
                        local627 = LoginProt.A_LOGIN_PROT___57;
                    }
                    local618.p1(local627.opcode);
                    local618.p2(0);
                    local250 = local618.pos;
                    local646 = local618.pos;
                    if (!Static311.aBoolean384) {
                        local618.p4(667);
                        local672 = Static659.method8608();
                        local618.pdata(local672.pos, local672.data, 0);
                        local646 = local618.pos;
                        local618.pjstr(Static449.aString75);
                    }
                    local618.p1(Static392.aModeGame_4.id);
                    local618.p1(Static51.anInt1052);
                    Static176.method6690(local618);
                    local618.pjstr(Static150.aString26);
                    local618.p4(Static323.anInt5121);
                    Static169.method2647(local618);
                    local618.tinyenc(Static219.anIntArray287, local646, local618.pos);
                    local618.psize2(local618.pos - local250);
                }
                Static524.aClass153_3.method3275(local186);
                Static524.aClass153_3.method3273();
                Static524.aClass153_3.aClass186_1 = new Class186(Static219.anIntArray287);
                for (@Pc(938) int local938 = 0; local938 < 4; local938++) {
                    Static219.anIntArray287[local938] += 50;
                }
                Static524.aClass153_3.aClass2_Sub21_Sub2_2.method7415(Static219.anIntArray287);
                Static219.anIntArray287 = null;
                Static135.anInt8223 = 9;
            }
            if (Static135.anInt8223 == 9) {
                if (!Static524.aClass153_3.aClass348_1.method7932(1)) {
                    return;
                }
                Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 1, 0);
                local360 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF;
                if (local360 == 21) {
                    Static135.anInt8223 = 12;
                } else if (local360 == 29 || local360 == 45) {
                    Static135.anInt8223 = 18;
                    Static79.anInt1634 = local360;
                } else if (local360 == 1) {
                    Static135.anInt8223 = 10;
                    Static342.method4464(local360);
                    return;
                } else if (local360 == 2) {
                    Static135.anInt8223 = 13;
                } else if (local360 == 15) {
                    Static135.anInt8223 = 19;
                    Static524.aClass153_3.anInt3648 = -2;
                } else if (local360 == 23 && Static76.anInt1601 < 3) {
                    Static330.anInt5434 = 0;
                    Static135.anInt8223 = 1;
                    Static76.anInt1601++;
                    Static524.aClass153_3.aClass348_1.method7926();
                    Static524.aClass153_3.aClass348_1 = null;
                    return;
                } else if (local360 == 42) {
                    Static135.anInt8223 = 20;
                    Static342.method4464(local360);
                    return;
                } else if (!Static561.aBoolean640 || Static311.aBoolean384 || Static129.anInt2409 == -1 || local360 != 35) {
                    Static135.anInt8223 = 0;
                    Static342.method4464(local360);
                    Static524.aClass153_3.aClass348_1.method7926();
                    Static524.aClass153_3.aClass348_1 = null;
                    Static564.method7465();
                    return;
                } else {
                    Static311.aBoolean384 = true;
                    Static135.anInt8223 = 1;
                    Static330.anInt5434 = 0;
                    Static524.aClass153_3.aClass348_1.method7926();
                    Static524.aClass153_3.aClass348_1 = null;
                    return;
                }
            }
            if (Static135.anInt8223 == 11) {
                Static524.aClass153_3.method3272();
                local186 = Static273.method3962();
                local618 = local186.aClass2_Sub21_Sub2_1;
                local618.method7422(Static524.aClass153_3.aClass186_1);
                local618.method7418(LoginProt.A_LOGIN_PROT___61.opcode);
                Static524.aClass153_3.method3275(local186);
                Static524.aClass153_3.method3273();
                Static135.anInt8223 = 9;
            } else if (Static135.anInt8223 == 12) {
                if (Static524.aClass153_3.aClass348_1.method7932(1)) {
                    Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 1, 0);
                    local360 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF;
                    Static135.anInt8223 = 0;
                    Static118.anInt2292 = local360 * 50;
                    Static342.method4464(21);
                    Static524.aClass153_3.aClass348_1.method7926();
                    Static524.aClass153_3.aClass348_1 = null;
                    Static564.method7465();
                }
            } else if (Static135.anInt8223 == 20) {
                if (Static524.aClass153_3.aClass348_1.method7932(2)) {
                    Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 2, 0);
                    Static660.anInt9837 = (Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[1] & 0xFF) + ((Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF) << 8);
                    Static135.anInt8223 = 9;
                }
            } else if (Static135.anInt8223 == 18) {
                if (Static79.anInt1634 == 29) {
                    if (!Static524.aClass153_3.aClass348_1.method7932(1)) {
                        return;
                    }
                    Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 1, 0);
                    Static329.anInt1749 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF;
                } else if (Static79.anInt1634 == 45) {
                    if (!Static524.aClass153_3.aClass348_1.method7932(3)) {
                        return;
                    }
                    Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 3, 0);
                    Static356.anInt5780 = (Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[2] & 0xFF) + ((Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[1] & 0xFF) << 8);
                    Static329.anInt1749 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF;
                } else {
                    throw new IllegalStateException("Login step 18 not valid for pendingResponse=" + Static79.anInt1634);
                }
                Static135.anInt8223 = 0;
                Static342.method4464(Static79.anInt1634);
                Static524.aClass153_3.aClass348_1.method7926();
                Static524.aClass153_3.aClass348_1 = null;
                Static564.method7465();
            } else if (Static135.anInt8223 != 13) {
                @Pc(1435) Node_Sub21_Sub2 local1435;
                if (Static135.anInt8223 == 14) {
                    local1435 = Static524.aClass153_3.aClass2_Sub21_Sub2_2;
                    if (Static299.anInt4825 == 2) {
                        if (!Static524.aClass153_3.aClass348_1.method7932(Static94.anInt1961)) {
                            return;
                        }
                        Static524.aClass153_3.aClass348_1.method7929(local1435.data, Static94.anInt1961, 0);
                        local1435.pos = 0;
                        Static608.anInt9290 = local1435.g1();
                        Static38.anInt928 = local1435.g1();
                        Static389.aBoolean459 = local1435.g1() == 1;
                        Static34.aBoolean62 = local1435.g1() == 1;
                        Static298.aBoolean369 = local1435.g1() == 1;
                        Static617.aBoolean724 = local1435.g1() == 1;
                        Static312.anInt5000 = local1435.g2();
                        Static126.aBoolean200 = local1435.g1() == 1;
                        Static106.anInt2153 = local1435.g3s();
                        Static174.aBoolean249 = local1435.g1() == 1;
                        Static416.aString71 = local1435.gjstr();
                        Static354.aLocTypeList_4.setAllowMembers(Static174.aBoolean249);
                        Static419.aObjTypeList_1.setAllowMembers(Static174.aBoolean249);
                        Static690.aNPCTypeList_2.setAllowMembers(Static174.aBoolean249);
                    } else if (Static524.aClass153_3.aClass348_1.method7932(Static94.anInt1961)) {
                        Static524.aClass153_3.aClass348_1.method7929(local1435.data, Static94.anInt1961, 0);
                        local1435.pos = 0;
                        Static608.anInt9290 = local1435.g1();
                        Static38.anInt928 = local1435.g1();
                        Static389.aBoolean459 = local1435.g1() == 1;
                        Static34.aBoolean62 = local1435.g1() == 1;
                        Static298.aBoolean369 = local1435.g1() == 1;
                        Static416.aLong207 = local1435.g8();
                        Static94.aLong70 = Static416.aLong207 - SystemTimer.safetime() - local1435.g5();
                        local203 = local1435.g1();
                        Static126.aBoolean200 = (local203 & 0x1) != 0;
                        Static425.aBoolean482 = (local203 & 0x2) != 0;
                        Static435.anInt6594 = local1435.g4();
                        Static684.aBoolean775 = local1435.g1() == 1;
                        Static134.anInt10326 = local1435.g4();
                        Static677.anInt10234 = local1435.g2();
                        Static476.anInt7175 = local1435.g2();
                        Static323.anInt5118 = local1435.g2();
                        Static392.anInt6141 = local1435.g4();
                        Static439.aSignedResource_4 = SignLink.instance.lookupHostname(Static392.anInt6141);
                        Static335.anInt5462 = local1435.g1();
                        Static626.anInt9473 = local1435.g2();
                        Static636.anInt9527 = local1435.g2();
                        Static420.aBoolean479 = local1435.g1() == 1;
                        Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aString9 = Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aString8 = Constants.playerDisplayName = local1435.gjstr2();
                        Static639.anInt9571 = local1435.g1();
                        Static438.anInt6640 = local1435.g4();
                        Static587.aBoolean663 = local1435.g1() == 1;
                        Static668.aConnectionInfo_5 = new ConnectionInfo();
                        Static668.aConnectionInfo_5.id = local1435.g2();
                        if (Static668.aConnectionInfo_5.id == 65535) {
                            Static668.aConnectionInfo_5.id = -1;
                        }
                        Static668.aConnectionInfo_5.address = local1435.gjstr2();
                        if (Static446.aClass355_5 != Static2.aClass355_1) {
                            Static668.aConnectionInfo_5.defaultPort = Static668.aConnectionInfo_5.id + 40000;
                            Static668.aConnectionInfo_5.alternatePort = Static668.aConnectionInfo_5.id + 50000;
                        }
                        if (Static16.aClass355_2 != Static2.aClass355_1 && (Static2.aClass355_1 != Static713.aClass355_8 || Static608.anInt9290 < 2) && client.gameConnection.equalTo(Static527.aConnectionInfo_3)) {
                            Static152.method9273();
                        }
                    } else {
                        return;
                    }
                    if (Static389.aBoolean459 && !Static298.aBoolean369 || Static126.aBoolean200) {
                        try {
                            JavaScript.call("zap", GameShell.loaderApplet);
                        } catch (@Pc(1850) Throwable local1850) {
                            if (Static305.aBoolean372) {
                                try {
                                    GameShell.loaderApplet.getAppletContext().showDocument(new URL(GameShell.loaderApplet.getCodeBase(), "blank.ws"), "tbi");
                                } catch (@Pc(1868) Exception local1868) {
                                }
                            }
                        }
                    } else {
                        try {
                            JavaScript.call("unzap", GameShell.loaderApplet);
                        } catch (@Pc(1879) Throwable local1879) {
                        }
                    }
                    if (Static2.aClass355_1 == Static446.aClass355_5) {
                        try {
                            JavaScript.call("loggedin", GameShell.loaderApplet);
                        } catch (@Pc(1892) Throwable local1892) {
                        }
                    }
                    if (Static299.anInt4825 != 2) {
                        Static135.anInt8223 = 0;
                        Static342.method4464(2);
                        Static249.method3538();
                        Static81.method1586(7);
                        Static524.aClass153_3.aClass225_93 = null;
                        return;
                    }
                    Static135.anInt8223 = 16;
                }
                if (Static135.anInt8223 == 16) {
                    if (!Static524.aClass153_3.aClass348_1.method7932(3)) {
                        return;
                    }
                    Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 3, 0);
                    Static135.anInt8223 = 17;
                }
                if (Static135.anInt8223 == 17) {
                    local1435 = Static524.aClass153_3.aClass2_Sub21_Sub2_2;
                    local1435.pos = 0;
                    if (local1435.method7413()) {
                        if (!Static524.aClass153_3.aClass348_1.method7932(1)) {
                            return;
                        }
                        Static524.aClass153_3.aClass348_1.method7929(local1435.data, 1, 3);
                    }
                    Static524.aClass153_3.aClass225_93 = Static585.method7677()[local1435.method7421()];
                    Static524.aClass153_3.anInt3648 = local1435.g2();
                    Static135.anInt8223 = 15;
                }
                if (Static135.anInt8223 == 15) {
                    if (Static524.aClass153_3.aClass348_1.method7932(Static524.aClass153_3.anInt3648)) {
                        Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, Static524.aClass153_3.anInt3648, 0);
                        Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                        local360 = Static524.aClass153_3.anInt3648;
                        Static135.anInt8223 = 0;
                        Static342.method4464(2);
                        Static254.method3605();
                        Static168.method2633(Static524.aClass153_3.aClass2_Sub21_Sub2_2);
                        Static62.anInt1465 = -1;
                        if (Static524.aClass153_3.aClass225_93 == Static291.aClass225_123) {
                            Static466.method6325();
                        } else {
                            Static434.method5855();
                        }
                        if (Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos != local360) {
                            throw new RuntimeException("lswp pos:" + Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos + " psize:" + local360);
                        }
                        Static524.aClass153_3.aClass225_93 = null;
                    }
                } else if (Static135.anInt8223 == 19) {
                    if (Static524.aClass153_3.anInt3648 == -2) {
                        if (!Static524.aClass153_3.aClass348_1.method7932(2)) {
                            return;
                        }
                        Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 2, 0);
                        Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                        Static524.aClass153_3.anInt3648 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.g2();
                    }
                    if (Static524.aClass153_3.aClass348_1.method7932(Static524.aClass153_3.anInt3648)) {
                        Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, Static524.aClass153_3.anInt3648, 0);
                        Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos = 0;
                        Static135.anInt8223 = 0;
                        local360 = Static524.aClass153_3.anInt3648;
                        Static342.method4464(15);
                        Static94.method1841();
                        Static168.method2633(Static524.aClass153_3.aClass2_Sub21_Sub2_2);
                        if (local360 != Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos) {
                            throw new RuntimeException("lswpr pos:" + Static524.aClass153_3.aClass2_Sub21_Sub2_2.pos + " psize:" + local360);
                        }
                        Static524.aClass153_3.aClass225_93 = null;
                    }
                }
            } else if (Static524.aClass153_3.aClass348_1.method7932(1)) {
                Static524.aClass153_3.aClass348_1.method7929(Static524.aClass153_3.aClass2_Sub21_Sub2_2.data, 1, 0);
                Static94.anInt1961 = Static524.aClass153_3.aClass2_Sub21_Sub2_2.data[0] & 0xFF;
                Static135.anInt8223 = 14;
            }
        } catch (@Pc(2184) IOException local2184) {
            Static524.aClass153_3.method3274();
            if (Static76.anInt1601 < 3) {
                if (Static299.anInt4825 == 2) {
                    client.gameConnection.rotateMethods();
                } else {
                    Static660.aConnectionInfo_4.rotateMethods();
                }
                Static135.anInt8223 = 1;
                Static76.anInt1601++;
                Static330.anInt5434 = 0;
            } else {
                Static135.anInt8223 = 0;
                Static342.method4464(-4);
                Static564.method7465();
            }
        }
    }
}
