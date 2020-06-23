public class JarUtilityRead {
    public static void main(String[] args) {
        // Create a JAR input stream object
        JarInputStream jis = new JarInputStream(new FileInputStream("jartest.jar"));
        // Get the manifest file from the JAR file. Will return null if
        // there is no manifest file in the JAR file.
        Manifest manifest = jis.getManifest();
        if (manifest != null) {
            // Get the attributes from main section
            Attributes mainAttributes = manifest.getMainAttributes();
            String mainClass = mainAttributes.getValue("Main-Class");
            // Get the attributes from individual section
        }
    }
}