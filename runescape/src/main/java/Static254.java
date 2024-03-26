import com.jagex.Client;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static254 {

    @OriginalMember(owner = "client!hr", name = "i", descriptor = "I")
    public static int anInt4115;

    @OriginalMember(owner = "client!hr", name = "d", descriptor = "(I)[Lclient!hja;")
    public static LoginProt[] method3604() {
        return new LoginProt[]{LoginProt.A_LOGIN_PROT___53, LoginProt.INIT_JS5REMOTE_CONNECTION, LoginProt.A_LOGIN_PROT___55, LoginProt.A_LOGIN_PROT___56, LoginProt.A_LOGIN_PROT___57, LoginProt.A_LOGIN_PROT___58, LoginProt.A_LOGIN_PROT___59, LoginProt.A_LOGIN_PROT___60, LoginProt.GAMELOGIN_CONTINUE, LoginProt.A_LOGIN_PROT___62, LoginProt.A_LOGIN_PROT___63, LoginProt.A_LOGIN_PROT___64, LoginProt.A_LOGIN_PROT___65};
    }

    @OriginalMember(owner = "client!hr", name = "c", descriptor = "(I)V")
    public static void method3605() {
        js5.CONFIG.discardunpacked = 1;
        if (MainLogicManager.step == 15) {
            Static187.method2842();
        }
        Static408.method5632();
        Static694.anInt10405 = 0;
        Static618.anInt9449 = 0;
        ObjType.shadowCount = 0;
        Static373.anInt5903 = 0;
        ConnectionManager.LOBBY.close();
        Static50.aBoolean565 = true;
        GameShell.focus = true;
        Static230.method3374();
        for (@Pc(8628) int local8628 = 0; local8628 < Static527.hintArrows.length; local8628++) {
            Static527.hintArrows[local8628] = null;
        }
        InterfaceManager.targetMode = false;
        SoundManager.reset();
        Camera.yawOffset = (int) (Math.random() * 120.0D) - 60;
        Static288.anInt4621 = (int) (Math.random() * 80.0D) - 40;
        Static145.anInt2561 = (int) (Math.random() * 110.0D) - 55;
        Camera.scaleOffset = (int) (Math.random() * 30.0D) - 20;
        Static508.anInt7627 = (int) (Math.random() * 100.0D) - 50;
        Camera.playerCameraYaw = (float) ((int) (Math.random() * 160.0D) - 80 & 0x3FFF);
        Static439.method5954();
        for (@Pc(8697) int local8697 = 0; local8697 < 2048; local8697++) {
            PlayerList.highResolutionPlayers[local8697] = null;
        }
        NPCList.localNpcCount = 0;
        NPCList.newNpcCount = 0;
        NPCList.local.clear();
        Static505.projectiles.clear();
        Static346.A_HASH_TABLE___29.clear();
        Static422.textCoords.clear();
        Static497.objStacks.clear();
        Static159.changes = new Deque();
        Static227.customisations = new Deque();
        TimedVarDomain.instance.reset();
        DelayedStateChange.clear();
        Camera.moveToX = 0;
        Camera.lookY = 0;
        Camera.lookZ = 0;
        Camera.lookX = 0;
        Camera.lookStep = 0;
        Camera.moveToRate = 0;
        Camera.moveToY = 0;
        Camera.lookSpeed = 0;
        Camera.moveToZ = 0;
        Camera.moveToStep = 0;
        for (@Pc(8765) int local8765 = 0; local8765 < Static511.varcs.length; local8765++) {
            if (!Static118.permVarcs[local8765]) {
                Static511.varcs[local8765] = -1;
            }
        }
        if (InterfaceManager.topLevelInterface != -1) {
            InterfaceManager.discard(InterfaceManager.topLevelInterface);
        }
        for (@Pc(8803) SubInterface local8803 = (SubInterface) InterfaceManager.subInterfaces.first(); local8803 != null; local8803 = (SubInterface) InterfaceManager.subInterfaces.next()) {
            if (!local8803.isLinked()) {
                local8803 = (SubInterface) InterfaceManager.subInterfaces.first();
                if (local8803 == null) {
                    break;
                }
            }
            InterfaceManager.closeSubInterface(false, true, local8803);
        }
        InterfaceManager.topLevelInterface = -1;
        InterfaceManager.subInterfaces = new IterableHashTable(8);
        InterfaceList.reset();
        InterfaceManager.dialog = null;
        for (@Pc(8849) int local8849 = 0; local8849 < 8; local8849++) {
            MiniMenu.playerOps[local8849] = null;
            Static601.playerOpsReducedPriority[local8849] = false;
            Static147.playerOpCursors[local8849] = -1;
        }
        Static576.method7614();
        Static426.aBoolean72 = true;
        for (@Pc(8877) int local8877 = 0; local8877 < 100; local8877++) {
            InterfaceManager.dirtyRectangles[local8877] = true;
        }
        for (@Pc(8893) int local8893 = 0; local8893 < 6; local8893++) {
            Static105.aClass171Array1[local8893] = new Class171();
        }
        for (@Pc(8911) int local8911 = 0; local8911 < 25; local8911++) {
            Static581.anIntArray688[local8911] = 0;
            Static498.anIntArray604[local8911] = 0;
            Static237.anIntArray518[local8911] = 0;
        }
        InterfaceManager.loginOpened();
        Static273.aBoolean339 = true;
        Client.clientpalette = LocType.clientpalette = NPCType.clientpalette = ObjType.clientpalette = new short[256];
        Static331.walkText = LocalisedText.WALKHERE.localise(Client.language);
        ClientOptions.instance.update(ClientOptions.instance.removeRoofs.getValue(), ClientOptions.instance.removeRoofsOverride);
        ClientOptions.instance.update(ClientOptions.instance.animateBackgroundDefault.getValue(), ClientOptions.instance.animateBackground);
        Static334.anInt5456 = 0;
        Static533.method7119();
        Protocol.sendWindowStatus();
        Static211.aClass2_Sub12_3 = null;
        Static675.aLong307 = 0L;
        js5.CONFIG.discardunpacked = 2;
    }

    @OriginalMember(owner = "client!hr", name = "b", descriptor = "(I)V")
    public static void method3606() {
        if (!Static15.aBoolean17) {
            Static273.aBoolean339 = true;
            Static15.aBoolean17 = true;
            Static552.aFloat207 += (24.0F - Static552.aFloat207) / 2.0F;
        }
    }
}
