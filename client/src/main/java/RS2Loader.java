import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.jagex.ClientConfig;
import com.jagex.Parameters;
import com.jagex.awt.CloseWindowListener;
import com.jagex.game.runetek6.client.GameShell;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jagex.Messages.JAWT_FAILED;
import static com.jagex.awt.Dimensions.MINIMUM_SIZE;
import static com.jagex.awt.Dimensions.PREFERRED_SIZE;

public final class RS2Loader implements AppletStub {

    public static void main(String[] args) {
        try {
            var parsed = new ApplicationArgs();

            var jcommander = JCommander.newBuilder()
                .programName("client")
                .addObject(parsed)
                .build();

            jcommander.parse(args);

            if (parsed.help()) {
                jcommander.usage();
                return;
            }

            // Enable debug logging if --debug is passed
            if (parsed.isDebug()) {
                enableDebugLogging();
            }

            var documentBase = new URL(parsed.getDocumentBase());
            var parameters = Parameters.createDefault();
            var application = new RS2Loader(documentBase, parameters);
            application.start();
        } catch (ParameterException ex) {
            System.out.println(ex.getMessage());
            System.out.println();
            ex.getJCommander().usage();
            System.exit(1);
        } catch (Throwable t) {
            System.out.println("Failed to start client:");
            t.printStackTrace();
            System.exit(1);
        }
    }

    private final URL documentBase;

    private final Map<String, String> parameters;

    public RS2Loader(URL documentBase, Map<String, String> parameters) {
        this.documentBase = documentBase;
        this.parameters = parameters;
    }

    private void start() throws IOException {
        setJs5PublicKey();
        setLoginPublicKey();
        tryLoadJawt();

        var applet = new Applet();
        applet.setStub(this);
        applet.setBackground(Color.BLACK);

        applet.setMinimumSize(MINIMUM_SIZE);
        applet.setPreferredSize(MINIMUM_SIZE);
        applet.setSize(MINIMUM_SIZE);

        GameShell.provideLoaderApplet(applet);

        var client = new client();
        client.init();
        client.start();

        var images = Stream.of("icon25.png", "icon52.png")
            .map(file -> Toolkit.getDefaultToolkit().getImage(getClass().getResource(file)))
            .collect(Collectors.toList());

        var frame = new Frame("2011Scape");
        frame.setIconImages(images);

        frame.add(applet);
        frame.addWindowListener(new CloseWindowListener());
        frame.pack();

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.toFront();

        frame.setMinimumSize(frame.getSize());
        frame.setPreferredSize(PREFERRED_SIZE);
        frame.setSize(PREFERRED_SIZE);
    }

    private void setJs5PublicKey() throws IOException {
        Static442.JS5_RSA_EXPONENT = ClientConfig.RSA_EXPONENT;
        Static670.JS5_RSA_MODULUS = ClientConfig.JS5_MODULUS;
    }

    private void setLoginPublicKey() throws IOException {
        ClientConfig.RSA_EXPONENT = ClientConfig.RSA_EXPONENT;
        ClientConfig.LOGIN_MODULUS = ClientConfig.LOGIN_MODULUS;
    }

    private static void enableDebugLogging() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.FINE);

        // Add a ConsoleHandler to display debug messages
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        rootLogger.addHandler(consoleHandler);

        System.out.println("Debug mode enabled. Detailed logs will be visible.");
    }

    private void tryLoadJawt() {
        try {
            System.loadLibrary("jawt");
        } catch (Throwable t) {
            var os = System.getProperty("os.name");

            if (os.toLowerCase().contains("windows")) {
                System.err.println(JAWT_FAILED);
                t.printStackTrace();
            }
        }
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        return documentBase;
    }

    @Override
    public URL getCodeBase() {
        return documentBase;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(int width, int height) {
        /* empty */
    }
}
