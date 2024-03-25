import com.jagex.SignLink;
import com.jagex.core.io.Packet;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.config.flotype.FloorOverlayTypeList;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayTypeList;
import com.jagex.game.runetek6.config.fonttype.FontTypeList;
import com.jagex.game.runetek6.config.hitmarktype.HitmarkTypeList;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.lighttype.LightTypeList;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.meltype.MapElementTypeList;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.questtype.QuestTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.skyboxspheretype.SkyBoxSphereTypeList;
import com.jagex.game.runetek6.config.skyboxtype.SkyBoxTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.game.runetek6.config.structtype.StructTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingTypeList;
import com.jagex.game.runetek6.config.vartype.clan.VarClanTypeList;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static664 {

    @OriginalMember(owner = "client!vaa", name = "a", descriptor = "(ILclient!fk;)[I")
    public static int[] method8652(@OriginalArg(1) ClientMessage arg0) {
        @Pc(8) Packet local8 = new Packet(518);
        @Pc(11) int[] local11 = new int[4];
        for (@Pc(13) int local13 = 0; local13 < 4; local13++) {
            local11[local13] = (int) (Math.random() * 9.9999999E7D);
        }
        local8.p1(10);
        local8.p4(local11[0]);
        local8.p4(local11[1]);
        local8.p4(local11[2]);
        local8.p4(local11[3]);
        for (@Pc(70) int local70 = 0; local70 < 10; local70++) {
            local8.p4((int) (Math.random() * 9.9999999E7D));
        }
        local8.p2((int) (Math.random() * 9.9999999E7D));
        local8.rsaenc(Static374.LOGIN_RSA_MODULUS, Static262.LOGIN_RSA_EXPONENT);
        arg0.bitPacket.pdata(local8.pos, local8.data, 0);
        return local11;
    }

    @OriginalMember(owner = "client!vaa", name = "a", descriptor = "(IZLjava/lang/String;ZLclient!vq;)V")
    public static void method8655(@OriginalArg(1) boolean arg0, @OriginalArg(2) String arg1, @OriginalArg(3) boolean arg2, @OriginalArg(4) SignLink arg3) {
        Static259.method3693(arg1, "openjs", arg3, arg0, arg2);
    }

    @OriginalMember(owner = "client!vaa", name = "a", descriptor = "(ILjava/lang/String;)I")
    public static int method8658(@OriginalArg(1) String arg0) {
        if (arg0 == null) {
            return -1;
        }
        for (@Pc(10) int local10 = 0; local10 < FriendsList.count; local10++) {
            if (arg0.equalsIgnoreCase(FriendsList.names[local10])) {
                return local10;
            }
        }
        return -1;
    }

    @OriginalMember(owner = "client!vaa", name = "a", descriptor = "(I)V")
    public static void cacheRemoveSoftReferences() {
        FloorOverlayTypeList.instance.cacheRemoveSoftReferences();
        FloorUnderlayTypeList.instance.cacheRemoveSoftReferences();
        IDKTypeList.instance.cacheRemoveSoftReferences();
        LocTypeList.instance.cacheRemoveSoftReferences();
        NPCTypeList.instance.cacheRemoveSoftReferences();
        ObjTypeList.instance.cacheRemoveSoftReferences();
        SeqTypeList.instance.cacheRemoveSoftReferences();
        SpotAnimationTypeList.instance.cacheRemoveSoftReferences();
        VarBitTypeListClient.instance.cacheRemoveSoftReferences();
        VarPlayerTypeListClient.instance.cacheRemoveSoftReferences();
        VarClanSettingTypeList.instance.cacheRemoveSoftReferences();
        VarClanTypeList.instance.cacheRemoveSoftReferences();
        BASTypeList.instance.cacheRemoveSoftReferences();
        MSITypeList.instance.cacheRemoveSoftReferences();
        MapElementTypeList.instance.cacheRemoveSoftReferences();
        QuestTypeList.instance.cacheRemoveSoftReferences();
        ParamTypeList.instance.cacheRemoveSoftReferences();
        SkyBoxTypeList.instance.cacheRemoveSoftReferences();
        SkyBoxSphereTypeList.instance.cacheRemoveSoftReferences();
        LightTypeList.instance.cacheRemoveSoftReferences();
        CursorTypeList.instance.cacheRemoveSoftReferences();
        StructTypeList.instance.cacheRemoveSoftReferences();
        HitmarkTypeList.instance.cacheRemoveSoftReferences();
        PlayerModel.cacheRemoveSoftReferences();
        Component.cacheRemoveSoftReferences();
        FontTypeList.cacheRemoveSoftReferences();
        PlayerEntity.cacheRemoveSoftReferences();
        ShadowList.cacheRemoveSoftReferences();
        Sprites.hitbarCache.removeSoftReferences();
        Sprites.timerbarCache.removeSoftReferences();
        Sprites.mobilisingArmiesCache.removeSoftReferences();
        MiniMenu.questCache.removeSoftReferences();
        ScriptRunner.A_WEIGHTED_CACHE___156.removeSoftReferences();
    }
}
