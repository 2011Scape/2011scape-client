import com.beust.jcommander.Parameter;
import com.jagex.ClientConfig;

public final class ApplicationArgs {

    @Parameter(
        names = "--base",
        description = "The URL of the document in which this applet is embedded"
    )
    private String documentBase = ClientConfig.HOST_ADDRESS;

    public String getDocumentBase() {
        return documentBase;
    }

    @Parameter(
        names = "--help",
        help = true,
        description = "print this help message to the output stream"
    )
    private boolean help = false;

    public boolean help() {
        return help;
    }

    @Parameter(
        names = "--debug",
        description = "Enable debug mode for troubleshooting"
    )
    private boolean debug = false;

    public boolean isDebug() {
        return debug;
    }
}
