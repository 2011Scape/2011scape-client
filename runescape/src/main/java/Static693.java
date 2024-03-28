import com.jagex.Client;
import com.jagex.core.io.Packet;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static693 {

    @OriginalMember(owner = "client!vu", name = "i", descriptor = "[Lclient!s;")
    public static Ground[] underwaterGround;

    @OriginalMember(owner = "client!vu", name = "e", descriptor = "I")
    public static int anInt10382 = -1;

    @OriginalMember(owner = "client!vu", name = "a", descriptor = "([[BBLclient!taa;)V")
    public static void decodeDynamicArea(@OriginalArg(0) byte[][] data, @OriginalArg(2) MapRegion region) {
        for (@Pc(5) int level = 0; level < region.levels; level++) {
            Static557.method7331();

            for (@Pc(10) int zoneX = 0; zoneX < Static720.mapWidth >> 3; zoneX++) {
                for (@Pc(13) int zoneZ = 0; zoneZ < Static501.mapLength >> 3; zoneZ++) {
                    @Pc(22) int pointer = Static623.zonePointers[level][zoneX][zoneZ];
                    if (pointer == -1) {
                        continue;
                    }

                    @Pc(32) int pointerLevel = pointer >> 24 & 0x3;
                    if (region.underwater && pointerLevel != 0) {
                        continue;
                    }

                    @Pc(48) int pointerRotation = (pointer >> 1) & 0x3;
                    @Pc(54) int pointerX = (pointer >> 14) & 0x3FF;
                    @Pc(60) int pointerY = (pointer >> 3) & 0x7FF;
                    @Pc(70) int pointerZone = (pointerY / 8) + ((pointerX / 8) << 8);
                    for (@Pc(72) int zone = 0; zone < Static89.zoneIds.length; zone++) {
                        if (pointerZone == Static89.zoneIds[zone] && data[zone] != null) {
                            @Pc(91) Packet packet = new Packet(data[zone]);
                            region.decodeZone(zoneX * 8, zoneZ * 8, level, pointerX, pointerY, pointerLevel, pointerRotation, packet, Client.collisionMaps);
                            region.decodeEnvironment(zoneX * 8, Toolkit.active, pointerY, packet, level, pointerX, pointerRotation, pointerLevel, zoneZ * 8);
                            break;
                        }
                    }
                }
            }
        }

        for (@Pc(10) int local10 = 0; local10 < region.levels; local10++) {
            Static557.method7331();
            for (@Pc(13) int local13 = 0; local13 < Static720.mapWidth >> 3; local13++) {
                for (@Pc(22) int local22 = 0; local22 < Static501.mapLength >> 3; local22++) {
                    @Pc(32) int local32 = Static623.zonePointers[local10][local13][local22];

                    if (local32 == -1) {
                        region.setTileHeights(local13 * 8, local22 * 8, local10, 8, 8);
                    }
                }
            }
        }
    }

}
