import com.jagex.core.constants.MainLogicStep;
import com.jagex.core.util.JagException;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

public final class Static236 {

    @OriginalMember(owner = "client!hfa", name = "s", descriptor = "I")
    public static int anInt3893;

    @OriginalMember(owner = "client!hfa", name = "a", descriptor = "(Lclient!gw;I)Z")
    public static boolean readPacket(@OriginalArg(0) ServerConnection connection) {
        try {
            return ServerConnectionReader.decodeServerProt(connection);
        } catch (@Pc(15) IOException local15) {
            if (MainLogicManager.step == MainLogicStep.STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME) {
                connection.connection = null;
                return false;
            } else {
                ConnectionManager.disconnect();
                return true;
            }
        } catch (@Pc(29) Exception local29) {
            @Pc(106) String local106 = "T2 - " + (connection.currentProt == null ? -1 : connection.currentProt.getOpcode()) + "," + (connection.penultimateProt == null ? -1 : connection.penultimateProt.getOpcode()) + "," + (connection.antepenultimateProt == null ? -1 : connection.antepenultimateProt.getOpcode()) + " - " + connection.currentPacketSize + "," + (WorldMap.areaBaseX + PlayerEntity.self.pathX[0]) + "," + (WorldMap.areaBaseZ + PlayerEntity.self.pathZ[0]) + " - ";
            for (@Pc(108) int local108 = 0; connection.currentPacketSize > local108 && local108 < 50; local108++) {
                local106 = local106 + connection.bitPacket.data[local108] + ",";
            }
            JagException.sendTrace(local29, local106);
            LoginManager.logout(false);
            return true;
        }
    }

}
