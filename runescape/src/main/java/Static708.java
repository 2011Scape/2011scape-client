import com.jagex.Client;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.core.util.JavaScript;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static708 {

    @OriginalMember(owner = "client!wga", name = "d", descriptor = "[I")
    public static final int[] anIntArray862 = new int[1];

    @OriginalMember(owner = "client!wga", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void updateSiteSettings(@OriginalArg(1) String arg0) {
        Client.settings = arg0;
        if (GameShell.loaderApplet == null) {
            return;
        }
        try {
            @Pc(15) String local15 = GameShell.loaderApplet.getParameter("cookieprefix");
            @Pc(28) String local28 = GameShell.loaderApplet.getParameter("cookiehost");
            @Pc(47) String local47 = local15 + "settings=" + arg0 + "; version=1; path=/; domain=" + local28;
            if (arg0.length() == 0) {
                local47 = local47 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
            } else {
                local47 = local47 + "; Expires=" + debugconsole.method8846(SystemTimer.safetime() + TimeUtils.MILLISECONDS_PER_THREE_YEARS) + "; Max-Age=" + 94608000L;
            }
            JavaScript.eval("document.cookie=\"" + local47 + "\"", GameShell.loaderApplet);
        } catch (@Pc(104) Throwable local104) {
        }
    }

    @OriginalMember(owner = "client!wga", name = "a", descriptor = "(IIII)V")
    public static void resetTileFlags(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        Static280.tileFlags = new byte[4][arg0][arg1];
    }
}
